import controllers.MainController;
import models.DosenModel;
import services.DosenService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        DosenService dosenService = new DosenService();
        dosenService.add(new DosenModel[] {
                new DosenModel("NIK 2", "NIP 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 2", 1, 1, true, null),
                new DosenModel("NIK 3", "NIP 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 3", 1, 1, true, null),
                new DosenModel("NIK 2", "NIP 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 2", 1, 1, true, "Keterangan 2"),
                new DosenModel("NIK 3", "NIP 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 3", 1, 1, true, "Keterangan 3"),
                new DosenModel("NIK 2", "NIP 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 2", 1, 1, true, ""),
                new DosenModel("NIK 3", "NIP 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 3", 1, 1, true, ""),
                new DosenModel("NIK 2", "NIP 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 2", 1, 1, true, "      "),
                new DosenModel("NIK 3", "NIP 3", "Nama 3", "Email 3", "Password 3", "Alamat 3", 1, "2024-01-01",
                        "Perempuan", "O-", "Islam", "Nomor Telepon 3", 1, 1, true, "      ")
        });

        for (DosenModel dosen : dosenService.get()) {
            System.out.println(dosen);
        }
    };
}
