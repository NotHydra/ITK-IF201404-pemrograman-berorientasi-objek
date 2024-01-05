import controllers.MainController;
import services.DosenService;
import models.DosenExtendModel;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                DosenService dosenService = new DosenService();

                // for (DosenExtendModel dosen : dosenService.getExtend()) {
                // System.out.println(dosen);
                // }

                System.out.println(dosenService.getOneExtend(22));
        };
}
