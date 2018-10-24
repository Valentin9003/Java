package p08_petClinics.io.interfaces;

public interface Writer {

    <T> void write(T line);

    <T> void writeLine(T line);
}
