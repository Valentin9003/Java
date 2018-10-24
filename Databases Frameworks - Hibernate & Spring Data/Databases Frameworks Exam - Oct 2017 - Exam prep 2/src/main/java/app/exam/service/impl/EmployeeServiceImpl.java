package app.exam.service.impl;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;
import app.exam.domain.entities.Position;
import app.exam.parser.interfaces.ModelParser;
import app.exam.repository.EmployeeRepository;
import app.exam.repository.PositionRepository;
import app.exam.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PositionRepository positionRepository;
    private final ModelParser modelParser;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               PositionRepository positionRepository,
                               ModelParser modelParser) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.modelParser = modelParser;
    }

    @Override
    public void create(EmployeeJSONImportDTO importDTO) {
        Employee employee = this.modelParser.convert(importDTO, Employee.class);

        Position position = this.positionRepository.findByName(importDTO.getPosition());
        if (position == null) {
            position = new Position(importDTO.getPosition());
            this.positionRepository.save(position);
        }
        employee.setPosition(position);
        this.employeeRepository.saveAndFlush(employee);
    }

    @Override
    public void createMany(EmployeeJSONImportDTO[] importDTO) {

    }

    @Override
    public Employee oneByName(String name) {
        return this.employeeRepository.findByName(name);
    }
}
