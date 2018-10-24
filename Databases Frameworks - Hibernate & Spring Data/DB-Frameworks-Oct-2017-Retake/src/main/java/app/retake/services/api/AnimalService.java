package app.retake.services.api;

import app.retake.domain.dto.AnimalJSONImportDTO;
import app.retake.domain.dto.AnimalsJSONExportDTO;
import app.retake.domain.models.Animal;
import org.springframework.data.repository.query.Param;

import java.text.ParseException;
import java.util.List;

public interface AnimalService {

    void create(AnimalJSONImportDTO dto);

    List<AnimalsJSONExportDTO> findByOwnerPhoneNumber(String phoneNumber);

    Animal getByPassportSerialNumber(String passportSerialNumber);

}
