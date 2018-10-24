package interfaces;

import models.enums.ReportLevel;

public interface Appender {

    void append(ReportLevel level, String date, String message);

    void setReportLevel(ReportLevel level);
}
