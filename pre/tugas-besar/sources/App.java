import controllers.MainController;
import models.ProgramStudiModel;
import services.ProgramStudiService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ProgramStudiService programStudiService = new ProgramStudiService();
        for (ProgramStudiModel programStudi : programStudiService.getExtend()) {
            System.out.println(programStudi);
        }

        System.out.println(programStudiService.getOneExtend(1));
    };
}
