import core.Engine;
import interfaces.Runnable;
import io.impl.ConsoleReader;
import io.impl.ConsoleWriter;
import io.interfaces.Reader;
import io.interfaces.Writer;
import models.Blob;
import observers.Subject;
import repositories.impl.BlobRepoImpl;
import repositories.interfaces.Repository;

public class Main {
    public static void main(String[] args) {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Repository<Blob> repository = new BlobRepoImpl();
        Subject subject = new Subject();

        Runnable engine = new Engine(reader, writer, repository, subject);
        engine.run();
    }
}
