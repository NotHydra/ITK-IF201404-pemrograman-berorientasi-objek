import controllers.MainController;
import models.ProgramStudiExtendModel;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        ProgramStudiExtendModel programStudiExtendModel = new ProgramStudiExtendModel(
                1,
                1,
                "Program Studi 2",
                "Deskripsi 2",
                "Jurusan 1",
                "Deskripsi 1");
        System.out.println(programStudiExtendModel.getJurusanExtend().getJurusan());
    };
}
