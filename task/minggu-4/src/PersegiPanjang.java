public class PersegiPanjang {
    private double panjang;
    private double lebar;

    public PersegiPanjang() {
        this.panjang = 5;
        this.lebar = 10;
    }

    public PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double getPanjang() {
        return this.panjang;
    }

    public void setPanjang(double sisi) {
        this.panjang = sisi;
    }

    public double getLebar() {
        return this.lebar;
    }

    public void setLebar(double sisi) {
        this.lebar = sisi;
    }

    public double getLuas() {
        return this.panjang * this.lebar;
    }

    public double getKeliling() {
        return 2 * (this.panjang + this.lebar);
    }

    public String toString() {
        return ""
            + "PersegiPanjang("
                + "Panjang=" + this.panjang + ", "
                + "Lebar=" + this.lebar + ","
                + "Luas=" + this.getLuas() + ","
                + "Keliling=" + this.getKeliling()
            + ")";
    }
}
