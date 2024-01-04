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

        // System.out.println(mahasiswaService.getOne(1));

        mahasiswaService
                .add(new MahasiswaModel("NIK 2", "NIM 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1,
                        "03-01-2024", "Wanita",
                        "AB-", "Kristen", "Nomor Telepon 2",
                        1, 1, 1, 1, false, "Keterangan 2"));

        for (MahasiswaModel mahasiswa : mahasiswaService.get()) {
            System.out.println(mahasiswa);
        }
    };
}
