import controllers.MainController;
import services.TahunMasukService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        TahunMasukService tahunMasukService = new TahunMasukService();
        System.out.println(tahunMasukService.getOne(1));
    };
}
