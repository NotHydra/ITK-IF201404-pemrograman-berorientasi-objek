import controllers.MainController;

import services.MataKuliahService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        MataKuliahService mataKuliahService = new MataKuliahService();
        System.out.println(mataKuliahService.getOne(1));
    };
}
