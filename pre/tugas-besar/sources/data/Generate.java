package data;

import java.util.ArrayList;

import models.JurusanModel;
import models.ProgramStudiModel;
import services.JurusanService;
import services.ProgramStudiService;

public class Generate {
	private static final ArrayList<JurusanModel> jurusan = new ArrayList<JurusanModel>();
	private static final ArrayList<ProgramStudiModel> programStudi = new ArrayList<ProgramStudiModel>();

	public static void start() {
		final JurusanService jurusanService = new JurusanService();
		final ProgramStudiService programStudiService = new ProgramStudiService();

		int jurusanIndex = 0;
		int programStudiIndex = 0;
		for (Object[] jurusanRaw : Raw.getJurusan()) {
			jurusanIndex++;

			for (Object[] programStudiRaw : (Object[][]) jurusanRaw[2]) {
				programStudiIndex++;

				programStudi.add(
						new ProgramStudiModel(
								programStudiIndex,
								jurusanIndex,
								(String) programStudiRaw[0],
								(String) programStudiRaw[1]));
			}

			jurusan.add(new JurusanModel(
					jurusanIndex,
					(String) jurusanRaw[0],
					(String) jurusanRaw[1]));
		}

		jurusanService.clear();
		jurusanService.add(jurusan.toArray(new JurusanModel[0]));
		jurusanService.display();

		programStudiService.clear();
		programStudiService.add(programStudi.toArray(new ProgramStudiModel[0]));
		programStudiService.displayExtend();
	}
}
