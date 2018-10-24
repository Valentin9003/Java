package models.appenders;

import interfaces.Appender;
import interfaces.Layout;
import io.impl.ConsoleWriter;
import io.interfaces.Writer;
import models.enums.ReportLevel;

public class ConsoleAppender implements Appender {
    /**responsible for appending the messages somewhere (e.g. Console, File, etc.)*/

    private final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;

    private ReportLevel reportLevel;
    private Layout layout;
    private Writer writer;
    private int appendedMessagesCount;

    public ConsoleAppender(Layout layout) {
        this.layout = layout;
        this.reportLevel = DEFAULT_REPORT_LEVEL;
        this.writer = new ConsoleWriter();
    }

    @Override
    public void append(ReportLevel level, String date, String message) {
        if (level.ordinal() >= this.reportLevel.ordinal()) {
            String formattedLog = this.layout.format(level, date, message);

            this.writer.writeLine(formattedLog);
            this.appendedMessagesCount++;
        }
    }

    @Override
    public void setReportLevel(ReportLevel level) {
        this.reportLevel = level;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d",
                this.getClass().getSimpleName(),
                this.layout.getClass().getSimpleName(),
                this.reportLevel.name(),
                this.appendedMessagesCount);
    }
}
