package enums;

public enum GolonganDarahEnum {
    ABPLUS("AB+"),
    ABMINUS("AB-"),
    APLUS("A+"),
    AMINUS("A-"),
    BPLUS("B+"),
    BMINUS("B-"),
    OPLUS("O+"),
    OMINUS("O-");

    public final String value;

    private GolonganDarahEnum(String value) {
        this.value = value;
    }

    public static GolonganDarahEnum valueToEnum(String value) {
        for (GolonganDarahEnum golonganDarah : GolonganDarahEnum.values()) {
            if (golonganDarah.value.equals(value)) {
                return golonganDarah;
            }
        }

        throw new IllegalArgumentException("GolonganDarahEnum value is invalid ");
    }
}
