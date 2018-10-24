package app.retake.domain.dto;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "procedures")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProcedureWrapperXMLExportDTO {

    @XmlElement(name = "procedure")
    @XmlElementWrapper
    private List<ProcedureXMLExportDTO> procedures;

    public ProcedureWrapperXMLExportDTO() {
        this.procedures = new ArrayList<>();
    }

    public ProcedureWrapperXMLExportDTO(List<ProcedureXMLExportDTO> procedures) {
        this.procedures = procedures;
    }

    public List<ProcedureXMLExportDTO> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<ProcedureXMLExportDTO> procedures) {
        this.procedures = procedures;
    }
}
