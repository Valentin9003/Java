package models.appenders;

import interfaces.Appender;
import interfaces.File;
import interfaces.Layout;
import models.enums.ReportLevel;
import models.files.LogFile;

public class FileAppender implements Appender {

    private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private ReportLevel reportLevel;
    private Layout layout;
    private File file;
    private int appendedMessagesCount;

    public FileAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
        this.file = new LogFile();
    }

    @Override
    public void append(ReportLevel level, String date, String message) {
        if (level.ordinal() >= this.reportLevel.ordinal()) {
            String formattedLog = this.layout.format(level, date, message);

            if (this.file == null) {
                throw new IllegalStateException("Cannot write a log when custom File class is null.");
            }

            this.file.write(formattedLog);
            this.appendedMessagesCount++;
        }
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        this.reportLevel = level;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d, File size: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.appendedMessagesCount,
                this.file.getSize());
    }
}
