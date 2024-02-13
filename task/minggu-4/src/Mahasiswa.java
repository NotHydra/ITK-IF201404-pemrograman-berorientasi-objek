public class Mahasiswa {
    private final String nama;
    private final float ipk;

    public Mahasiswa(String nama, float ipk) {
        this.nama = nama;
        this.ipk = ipk;
    }

    public String tampilkanNama() {
        return this.nama;
    }

    public float tampilkanIpk() {
        return this.ipk;
    }

    public String toString() {
        return ""  
            + "Mahasiswa(" 
                + "Nama=\"" + this.nama + "\", "
                + "IPK=" + this.ipk
            + ")";
    }
}
