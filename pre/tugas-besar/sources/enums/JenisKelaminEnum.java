package enums;

public enum JenisKelaminEnum {
    LAKILAKI("Laki-Laki"),
    PEREMPUAN("Perempuan");

    public final String value;

    JenisKelaminEnum(String value) {
        this.value = value;
    }

    public static JenisKelaminEnum valueToEnum(String value) {
        for (JenisKelaminEnum jenisKelamin : JenisKelaminEnum.values()) {
            if (jenisKelamin.value.equals(value)) {
                return jenisKelamin;
            }
        }

        throw new IllegalArgumentException("JenisKelaminEnum value is invalid ");
    }
}
