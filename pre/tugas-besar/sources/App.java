import controllers.MainController;
import services.ProgramStudiService;
import models.ProgramStudiExtendModel;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ProgramStudiService programStudiService = new ProgramStudiService();
        for (ProgramStudiExtendModel programStudi : programStudiService.getExtend()) {
            System.out.println(programStudi);
        }
    };
}
