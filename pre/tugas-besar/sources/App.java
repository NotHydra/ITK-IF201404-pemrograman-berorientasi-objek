import controllers.MainController;
import services.MahasiswaService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        MahasiswaService mahasiswaService = new MahasiswaService();
        System.out.println(mahasiswaService.getOne(1));
    };
}
