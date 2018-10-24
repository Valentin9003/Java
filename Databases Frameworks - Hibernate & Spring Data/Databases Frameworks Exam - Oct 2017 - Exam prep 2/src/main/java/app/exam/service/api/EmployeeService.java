package app.exam.service.api;

import app.exam.domain.dto.json.EmployeeJSONImportDTO;
import app.exam.domain.entities.Employee;

public interface EmployeeService {

    void create(EmployeeJSONImportDTO importDTO);

    void createMany(EmployeeJSONImportDTO[] importDTO);

    Employee oneByName (String name);
}
