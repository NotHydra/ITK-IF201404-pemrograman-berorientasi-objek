import controllers.MainController;
import services.TahunAjaranService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        TahunAjaranService tahunAjaranService = new TahunAjaranService();
        System.out.println(tahunAjaranService.getOne(1));
    };
}
