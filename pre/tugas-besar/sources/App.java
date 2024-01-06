import controllers.MainController;

import services.MahasiswaService;

import models.MahasiswaExtendModel;

public class App {
        public static void main(String[] args) {
                // try {
                // MainController.initialize(args);
                // } catch (Exception e) {
                // e.printStackTrace();
                // }

                MahasiswaService mahasiswaService = new MahasiswaService();

                for (MahasiswaExtendModel mahasiswa : mahasiswaService.getExtend()) {
                        System.out.println(mahasiswa);
                }
        };
}
