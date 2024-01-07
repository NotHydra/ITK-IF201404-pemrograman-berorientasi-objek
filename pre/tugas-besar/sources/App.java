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
                // for (MahasiswaKelasModel mahasiswaKelas : mahasiswaKelasService.getExtend())
                // {
                // System.out.println(Format.pretty(mahasiswaKelas.toString()));
                // }
                System.out.println(Format.pretty(mahasiswaKelasService.getOneExtend(1).toString()));
        };
}
