import controllers.MainController;
import models.KelasExtendModel;
import services.KelasService;
import utilities.Format;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                KelasService kelasService = new KelasService();
                for (KelasExtendModel kelas : kelasService.getExtend()) {
                        System.out.println(Format.pretty(kelas.toString()));
                }
        };
}
