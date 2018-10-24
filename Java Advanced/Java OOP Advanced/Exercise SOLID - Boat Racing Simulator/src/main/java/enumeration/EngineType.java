package enumeration;

public enum EngineType
{
    JET,
    STERNDRIVE;

    @Override
    public String toString() {
        return String.valueOf(this.name().charAt(0)).toUpperCase() + this.name().substring(1).toLowerCase();
    }
}
