import controllers.MainController;
import models.ProgramStudiModel;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ProgramStudiModel programStudiModel = new ProgramStudiModel(1, "Program Studi 2", "Deskripsi 2");
        System.out.println(programStudiModel);
    };
}
