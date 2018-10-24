package app.exam.domain.dto.json;

import app.exam.domain.entities.Position;
import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EmployeeJSONImportDTO  {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    @Expose
    private String name;

    @Min(15)
    @Max(80)
    @NotNull
    @Expose
    private Integer age;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 30)
    @Expose
    private String position;

    public EmployeeJSONImportDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
