package enums;

public enum IndeksEnum {
    A("A"),
    AB("AB"),
    B("B"),
    BC("BC"),
    C("C"),
    D("D"),
    E("E");

    public final String value;

    private IndeksEnum(String value) {
        this.value = value;
    }

    public static IndeksEnum valueToEnum(String value) {
        for (IndeksEnum indeks : IndeksEnum.values()) {
            if (indeks.value.equals(value)) {
                return indeks;
            }
        }

        throw new IllegalArgumentException("IndeksEnum value is invalid ");
    }
}
