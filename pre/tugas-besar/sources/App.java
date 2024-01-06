import controllers.MainController;
import enums.SesiEnum;
import models.KelasModel;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                KelasModel kelasModel = new KelasModel(1, 1, 'A', 1, SesiEnum.SATU, "2023");
                System.out.println(kelasModel);
        };
}
