import controllers.MainController;
import models.MahasiswaModel;
import services.MahasiswaService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        MahasiswaService mahasiswaService = new MahasiswaService();

        mahasiswaService.change(1,
                new MahasiswaModel("NIK 3", "NIM 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1,
                        "2024-01-02", "Laki-Laki",
                        "B+", "Katolik", "Nomor Telepon 3",
                        1, 1, 1, 1, true, "Keterangan 3"));

        for (MahasiswaModel mahasiswa : mahasiswaService.get()) {
            System.out.println(mahasiswa);
        }
    };
}
