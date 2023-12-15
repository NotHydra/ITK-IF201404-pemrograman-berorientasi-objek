public class Mahasiswa {
    private String nama;
    private float ipk;

    public Mahasiswa(String nama, float ipk) {
        this.nama = nama;
        this.ipk = ipk;
    };

    public void tampilkanNama() {
        System.out.println(this.nama);
    };

    public void tampilkanIPK() {
        System.out.println(this.ipk);
    };
}
