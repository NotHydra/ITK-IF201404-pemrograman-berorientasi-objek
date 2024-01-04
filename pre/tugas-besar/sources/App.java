import controllers.MainController;
import services.RuanganService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        RuanganService ruanganService = new RuanganService();
        System.out.println(ruanganService.getOne(1));
    };
}
