package enums;

public enum SesiEnum {
    SATU("1"),
    DUA("2"),
    TIGA("3"),
    EMPAT("4");

    public final String value;

    private SesiEnum(String value) {
        this.value = value;
    }

    public static SesiEnum valueToEnum(String value) {
        for (SesiEnum sesi : SesiEnum.values()) {
            if (sesi.value.equals(value)) {
                return sesi;
            }
        }

        throw new IllegalArgumentException("SesiEnum value is invalid ");
    }
}
