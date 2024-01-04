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
                .add(new MahasiswaModel[] {
                        new MahasiswaModel("NIK 2", "NIM 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1,
                                "2024-01-03", "Wanita",
                                "AB-", "Kristen", "Nomor Telepon 2",
                                1, 1, 1, 1, false, "Keterangan 2"),
                        new MahasiswaModel("NIK 3", "NIM 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1,
                                "2024-01-02", "Laki-Laki",
                                "B+", "Katolik", "Nomor Telepon 3",
                                1, 1, 1, 1, true, "Keterangan 3") });

        for (MahasiswaModel mahasiswa : mahasiswaService.get()) {
            System.out.println(mahasiswa);
        }
    };
}
