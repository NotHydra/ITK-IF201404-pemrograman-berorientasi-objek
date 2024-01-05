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
        System.out.println(dosenService.getOne(1));
    };
}
