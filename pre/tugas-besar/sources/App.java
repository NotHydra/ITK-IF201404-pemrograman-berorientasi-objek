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
        dosenService.add(
                new DosenModel("NIK 2", "NIP 2", "Nama 2", "Email 2", "Password 2", "Alamat 2", 1, "2024-01-01",
                        "Perempuan",
                        "O+", "Buddha", "Nomor Telepon 2", 1, 1, true, null));

        for (DosenModel dosen : dosenService.get()) {
            System.out.println(dosen.getKeterangan() == null);
        }
    };
}
