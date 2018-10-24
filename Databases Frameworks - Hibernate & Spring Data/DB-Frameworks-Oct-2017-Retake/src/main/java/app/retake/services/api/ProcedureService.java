package app.retake.services.api;

import app.retake.domain.dto.ProcedureWrapperXMLExportDTO;
import app.retake.domain.dto.ProcedureXMLImportDTO;

import java.text.ParseException;

public interface ProcedureService {

    void create(ProcedureXMLImportDTO dto);

    ProcedureWrapperXMLExportDTO exportProcedures();
}
