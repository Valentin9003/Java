package core.commands;

import annotations.Inject;
import interfaces.Executable;
import io.interfaces.Writer;
import models.Blob;
import repositories.interfaces.Repository;

public class StatusCommand implements Executable {

    @Inject
    private Repository<Blob> repository;

    @Inject
    private Writer writer;

    @Override
    public void execute() {
        this.repository
                .findAll()
                .forEach(blob -> this.writer.writeLine(blob.toString()));
    }
}
