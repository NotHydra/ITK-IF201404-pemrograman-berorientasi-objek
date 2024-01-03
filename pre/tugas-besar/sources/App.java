import models.JurusanModel;
import services.JurusanService;

public class App {
    public static void main(String[] args) {
        // try {
        // MainController.initialize(args);
        // } catch (Exception e) {
        // e.printStackTrace();
        // }

        JurusanService jurusanService = new JurusanService();

        jurusanService.add(new JurusanModel("Jurusan 2", "Deskripsi 2"));
        jurusanService.change(2, new JurusanModel("Jurusan 3", "Deskripsi 3"));
        jurusanService.remove(2);

        System.out.println(jurusanService.getOne(1));
        for (JurusanModel jurusan : jurusanService.get()) {
            System.out.println(jurusan);
        }

    };
}
