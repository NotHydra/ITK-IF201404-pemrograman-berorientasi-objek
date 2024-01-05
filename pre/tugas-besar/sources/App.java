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

                dosenService.change(1, new DosenModel("NIK 3", "NIP 3", "Nama 3", "Email 3", "Password 3", "Alamat 3",
                                1, "2024-01-01", "Perempuan", "O+", "Islam", "Nomor Telepon 3", 1, 1, true,
                                "Keterangan 3"));

                for (DosenModel dosen : dosenService.get()) {
                        System.out.println(dosen);
                }
        };
}
