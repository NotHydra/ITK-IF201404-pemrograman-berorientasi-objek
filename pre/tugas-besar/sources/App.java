import controllers.MainController;
import enums.JenisKelaminEnum;
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
                System.out.println(Format.pretty(dosenService.getOne(22).toString()));
        };
}
