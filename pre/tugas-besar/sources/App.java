import controllers.MainController;
import enums.IndeksEnum;
import models.MahasiswaKelasModel;
import services.MahasiswaKelasService;
import utilities.Format;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                MahasiswaKelasService mahasiswaKelasService = new MahasiswaKelasService();

                mahasiswaKelasService.add(new MahasiswaKelasModel(1, 21, IndeksEnum.A));

                for (MahasiswaKelasModel mahasiswaKelas : mahasiswaKelasService.get()) {
                        System.out.println(Format.pretty(mahasiswaKelas.toString()));
                }
                // System.out.println(Format.pretty(mahasiswaKelasService.getOne(1).toString()));
        };
}
