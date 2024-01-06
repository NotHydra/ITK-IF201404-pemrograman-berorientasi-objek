import controllers.MainController;
import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.JenisKelaminEnum;
import models.DosenModel;
import utilities.Format;
import services.DosenService;
import services.MahasiswaService;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                DosenService dosenService = new DosenService();

                dosenService.add(new DosenModel("NIK 1", "NIP 1", "Nama 1", "Email 1", "Password 1", "Alamat 1", 1,
                                "2024-01-01", JenisKelaminEnum.LAKILAKI, GolonganDarahEnum.ABPLUS, AgamaEnum.ISLAM,
                                "Nomor Telepon 1", 1, 1, true,
                                null));

                for (DosenModel dosen : dosenService.getExtend()) {
                        System.out.println(Format.pretty(dosen.toString()));
                }
        };
}
