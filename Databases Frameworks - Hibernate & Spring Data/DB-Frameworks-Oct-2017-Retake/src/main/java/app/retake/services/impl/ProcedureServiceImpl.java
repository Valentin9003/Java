package app.retake.services.impl;

import app.retake.domain.dto.ProcedureAnimalAidXMLExportDTO;
import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;
import app.retake.domain.models.*;
import app.retake.parser.interfaces.ModelParser;
import app.retake.repositories.ProcedureRepository;
import app.retake.services.api.AnimalAidService;
import app.retake.services.api.AnimalService;
import app.retake.services.api.ProcedureService;
import app.retake.services.api.VetService;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProcedureServiceImpl implements ProcedureService {

    private final ProcedureRepository procedureRepository;
    private final ModelParser modelParser;
    private final VetService vetService;
    private final AnimalService animalService;
    private  final AnimalAidService animalAidService;

    @Autowired
    public ProcedureServiceImpl(ProcedureRepository procedureRepository,
                                ModelParser modelParser,
                                VetService vetService,
                                AnimalService animalService,
                                AnimalAidService animalAidService) {
        this.procedureRepository = procedureRepository;
        this.modelParser = modelParser;
        this.vetService = vetService;
        this.animalService = animalService;
        this.animalAidService = animalAidService;
    }

    @Override
    public void create(ProcedureXMLImportDTO dto) {
        Animal animal = this.animalService.getByPassportSerialNumber(dto.getAnimal());
        Vet vet = this.vetService.getByName(dto.getVet());

        if (animal != null && vet != null) {

            Set<AnimalAid> animalAids = dto.getAnimalAids()
                    .stream()
                    .map(animalAidDto -> {
                        AnimalAid animalAid = this.animalAidService.getByName(animalAidDto.getName());
                        if (animalAid == null) {
                            throw new IllegalArgumentException();
                        }
                        return animalAid;
                    }).collect(Collectors.toSet());

            Procedure procedure = new Procedure();
            procedure.setAnimal(animal);
            procedure.setVet(vet);
            procedure.setDate(dto.getDate());
            procedure.setServices(animalAids);

            this.procedureRepository.saveAndFlush(procedure);
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public ProcedureWrapperXMLExportDTO exportProcedures() {
        List<Procedure> procedures = this.procedureRepository.findAll();

        List<ProcedureXMLExportDTO> exportDTOS = procedures.stream()
                .map(p -> {
                    Passport passport = p.getAnimal().getPassport();

                    List<ProcedureAnimalAidXMLExportDTO> animalAids = p.getServices()
                            .stream()
                            .map(ai -> new ProcedureAnimalAidXMLExportDTO(ai.getName(), ai.getPrice()))
                            .collect(Collectors.toList());

                    ProcedureXMLExportDTO dto = new ProcedureXMLExportDTO(
                                    passport.getSerialNumber(),
                                    passport.getOwnerPhoneNumber(),
                                    animalAids);
                    return dto;
                }).collect(Collectors.toList());

        return new ProcedureWrapperXMLExportDTO(exportDTOS);
    }
}

