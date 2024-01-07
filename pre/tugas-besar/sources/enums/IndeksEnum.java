package enums;

public enum IndeksEnum {
    A("A", 4),
    AB("AB", 3.5f),
    B("B", 3),
    BC("BC", 2.5f),
    C("C", 2),
    D("D", 1),
    E("E", 0),
    NONE(null, 0);

    public final String value;
    public final float point;

    private IndeksEnum(String value, float point) {
        this.value = value;
        this.point = point;
    }

    public static IndeksEnum valueToEnum(String value) {
        if (value != null) {
            for (IndeksEnum indeks : IndeksEnum.values()) {
                if (indeks.value.equals(value)) {
                    return indeks;
                }
            }

            throw new IllegalArgumentException("IndeksEnum value is invalid ");
        }

        return null;
    }
}
