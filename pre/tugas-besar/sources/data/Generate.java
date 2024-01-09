package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.JenisKelaminEnum;
import models.DosenModel;
import models.JurusanModel;
import models.MataKuliahModel;
import models.PendidikanModel;
import models.ProgramStudiModel;
import models.RuanganModel;
import models.TahunAjaranModel;
import models.TahunMasukModel;
import models.TempatLahirModel;
import services.DosenService;
import services.JurusanService;
import services.MataKuliahService;
import services.PendidikanService;
import services.ProgramStudiService;
import services.RuanganService;
import services.TahunAjaranService;
import services.TahunMasukService;
import services.TempatLahirService;
import utilities.Format;
import utilities.Randomizer;

public class Generate {
	public static void start() {
		// jurusan();
		// pendidikan();
		// tempatLahir();
		// tahunAjaran();
		// tahunMasuk();
		// ruangan();
		// mataKuliah();
		dosen();
	}

	private static final ArrayList<JurusanModel> jurusan = new ArrayList<JurusanModel>();
	private static final ArrayList<ProgramStudiModel> programStudi = new ArrayList<ProgramStudiModel>();

	public static void jurusan() {
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

	private static final ArrayList<PendidikanModel> pendidikan = new ArrayList<PendidikanModel>();

	public static void pendidikan() {
		final PendidikanService pendidikanService = new PendidikanService();

		int pendidikanIndex = 0;
		for (String[] pendidikanRaw : Raw.getPendidikan()) {
			pendidikanIndex++;

			pendidikan.add(new PendidikanModel(
					pendidikanIndex,
					pendidikanRaw[0],
					pendidikanRaw[1]));
		}

		pendidikanService.clear();
		pendidikanService.add(pendidikan.toArray(new PendidikanModel[0]));
		pendidikanService.display();
	}

	private static final ArrayList<TempatLahirModel> tempatLahir = new ArrayList<TempatLahirModel>();

	public static void tempatLahir() {
		final TempatLahirService tempatLahirService = new TempatLahirService();

		int tempatLahirIndex = 0;
		for (String tempatLahirRaw : Raw.getTempatLahir()) {
			tempatLahirIndex++;

			tempatLahir.add(new TempatLahirModel(
					tempatLahirIndex,
					tempatLahirRaw));
		}

		tempatLahirService.clear();
		tempatLahirService.add(tempatLahir.toArray(new TempatLahirModel[0]));
		tempatLahirService.display();
	}

	private static final ArrayList<TahunAjaranModel> tahunAjaran = new ArrayList<TahunAjaranModel>();

	public static void tahunAjaran() {
		final TahunAjaranService tahunAjaranService = new TahunAjaranService();

		int tahunAjaranIndex = 0;
		for (String tahunAjaranRaw : Raw.getTahunAjaran()) {
			tahunAjaranIndex++;

			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Ganjil"));

			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Genap"));
		}

		tahunAjaranService.clear();
		tahunAjaranService.add(tahunAjaran.toArray(new TahunAjaranModel[0]));
		tahunAjaranService.display();
	}

	private static final ArrayList<TahunMasukModel> tahunMasuk = new ArrayList<TahunMasukModel>();

	public static void tahunMasuk() {
		final TahunMasukService tahunMasukService = new TahunMasukService();

		int tahunMasukIndex = 0;
		for (String tahunMasukRaw : Raw.getTahunMasuk()) {
			tahunMasukIndex++;

			tahunMasuk.add(new TahunMasukModel(
					tahunMasukIndex,
					tahunMasukRaw));
		}

		tahunMasukService.clear();
		tahunMasukService.add(tahunMasuk.toArray(new TahunMasukModel[0]));
		tahunMasukService.display();
	}

	private static final ArrayList<RuanganModel> ruangan = new ArrayList<RuanganModel>();

	public static void ruangan() {
		final RuanganService ruanganService = new RuanganService();

		int ruanganIndex = 0;
		for (String ruanganRaw : Raw.getRuangan()) {
			for (int firstIndex = 1; firstIndex <= 3; firstIndex++) {
				for (int thirdIndex = 1; thirdIndex <= 7; thirdIndex++) {
					ruanganIndex++;

					ruangan.add(new RuanganModel(
							ruanganIndex,
							ruanganRaw + firstIndex + "0" + thirdIndex));
				}
			}
		}

		ruanganService.clear();
		ruanganService.add(ruangan.toArray(new RuanganModel[0]));
		ruanganService.display();
	}

	private static final ArrayList<MataKuliahModel> mataKuliah = new ArrayList<MataKuliahModel>();

	public static void mataKuliah() {
		final MataKuliahService mataKuliahService = new MataKuliahService();

		int mataKuliahIndex = 0;
		for (Object[] mataKuliahRaw : Raw.getMataKuliah()) {
			mataKuliahIndex++;

			mataKuliah.add(new MataKuliahModel(
					mataKuliahIndex,
					(String) mataKuliahRaw[0],
					(String) mataKuliahRaw[1],
					(String) mataKuliahRaw[2],
					(int) mataKuliahRaw[3]));
		}

		mataKuliahService.clear();
		mataKuliahService.add(mataKuliah.toArray(new MataKuliahModel[0]));
		mataKuliahService.display();
	};

	private static final ArrayList<DosenModel> dosen = new ArrayList<DosenModel>();

	public static void dosen() {
		final DosenService dosenService = new DosenService();
		final TempatLahirService tempatLahirService = new TempatLahirService();
		final PendidikanService pendidikanService = new PendidikanService();
		final ProgramStudiService programStudiService = new ProgramStudiService();

		final Integer[] idTempatLahir = tempatLahirService.getId();
		final Integer[] idPendidikan = pendidikanService.getId();
		final Integer[] idProgramStudi = programStudiService.getId();

		final Map<String, Integer> nikCount = new HashMap<>();

		for (int i = 1; i <= 50; i++) {
			final Integer tempatLahir = Randomizer.pickArray(idTempatLahir);
			final String tanggalLahir = Randomizer.date("1965-01-01", "2000-01-01");
			final JenisKelaminEnum jenisKelamin = Randomizer.pickEnum(JenisKelaminEnum.class);
			final GolonganDarahEnum golonganDarah = Randomizer.pickEnum(GolonganDarahEnum.class);
			final AgamaEnum agama = Randomizer.pickEnum(AgamaEnum.class);
			final Integer pendidikan = Randomizer.pickArray(idPendidikan);
			final Integer programStudi = Randomizer.pickArray(idProgramStudi);

			final String baseNIK = ""
					+ Format.zfill(tempatLahir.toString(), '0', 2)
					+ Format.zfill(String.valueOf(programStudiService.getOne(programStudi).getIdJurusan()), '0', 2)
					+ Format.zfill(programStudi.toString(), '0', 2)
					+ tanggalLahir.substring(2, 4)
					+ tanggalLahir.substring(5, 7)
					+ tanggalLahir.substring(8, 10);

			nikCount.put(baseNIK, nikCount.getOrDefault(baseNIK, 0) + 1);

			final String extendNIK = Format.zfill(String.valueOf(nikCount.get(baseNIK)), '0', 4);

			dosen.add(new DosenModel(
					i,
					baseNIK + extendNIK,
					Format.reverse(baseNIK + extendNIK),
					"Nama " + i,
					"Email " + i,
					"Password " + i,
					"Alamat " + i,
					tempatLahir,
					tanggalLahir,
					jenisKelamin,
					golonganDarah,
					agama,
					"Nomor Telepon " + i,
					pendidikan,
					programStudi,
					true,
					null));
		}

		dosenService.clear();
		dosenService.add(dosen.toArray(new DosenModel[0]));
		dosenService.display();
	};

}
