package enums;

public enum AgamaEnum {
    ISLAM("Islam"),
    KRISTEN("Kristen"),
    KATOLIK("Katolik"),
    HINDU("Hindu"),
    BUDDHA("Buddha"),
    KHONGHUCU("Khonghucu");

    public final String value;

    private AgamaEnum(String value) {
        this.value = value;
    }

    public static AgamaEnum valueToEnum(String value) {
        for (AgamaEnum agama : AgamaEnum.values()) {
            if (agama.value.equals(value)) {
                return agama;
            }
        }

        throw new IllegalArgumentException("AgamaEnum value is invalid ");
    }
}
