package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import enums.AgamaEnum;
import enums.GolonganDarahEnum;
import enums.JenisKelaminEnum;
import enums.SesiEnum;
import models.DosenModel;
import models.JurusanModel;
import models.KelasModel;
import models.MahasiswaModel;
import models.MataKuliahModel;
import models.PendidikanModel;
import models.ProgramStudiModel;
import models.RuanganModel;
import models.TahunAjaranModel;
import models.TahunMasukModel;
import models.TempatLahirModel;
import services.DosenService;
import services.JurusanService;
import services.KelasService;
import services.MahasiswaService;
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
	private static final Map<String, Integer> count = new HashMap<>();

	public static void start() {
		count.put("jurusan", 0);
		count.put("programStudi", 0);
		count.put("pendidikan", 0);
		count.put("tempatLahir", 0);
		count.put("tahunAjaran", 0);
		count.put("tahunMasuk", 0);
		count.put("ruangan", 0);
		count.put("mataKuliah", 0);
		count.put("dosen", 0);
		count.put("mahasiswa", 0);
		count.put("kelas", 0);

		// jurusan();
		// pendidikan();
		// tempatLahir();
		// tahunAjaran();
		// tahunMasuk();
		// ruangan();
		// mataKuliah();
		// dosen();
		// mahasiswa();
		kelas();
	}

	private static void increment(String key) {
		count.put(key, count.getOrDefault(key, 0) + 1);

		System.out.println(""
				+ "J : " + count.get("jurusan") + " | "
				+ "PS : " + count.get("programStudi") + " | "
				+ "P : " + count.get("pendidikan") + " | "
				+ "TL : " + count.get("tempatLahir") + " | "
				+ "TA : " + count.get("tahunAjaran") + " | "
				+ "TM : " + count.get("tahunMasuk") + " | "
				+ "R : " + count.get("ruangan") + " | "
				+ "MK : " + count.get("mataKuliah") + " | "
				+ "D : " + count.get("dosen") + " | "
				+ "M : " + count.get("mahasiswa") + " | "
				+ "K : " + count.get("kelas"));
	}

	private static final ArrayList<JurusanModel> jurusan = new ArrayList<JurusanModel>();
	private static final ArrayList<ProgramStudiModel> programStudi = new ArrayList<ProgramStudiModel>();

	private static void jurusan() {
		final JurusanService jurusanService = new JurusanService();
		final ProgramStudiService programStudiService = new ProgramStudiService();

		int jurusanIndex = 0;
		int programStudiIndex = 0;
		for (Object[] jurusanRaw : Raw.getJurusan()) {
			increment("jurusan");
			jurusanIndex++;

			for (Object[] programStudiRaw : (Object[][]) jurusanRaw[2]) {
				increment("programStudi");
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

		programStudiService.clear();
		programStudiService.add(programStudi.toArray(new ProgramStudiModel[0]));
	}

	private static final ArrayList<PendidikanModel> pendidikan = new ArrayList<PendidikanModel>();

	private static void pendidikan() {
		final PendidikanService pendidikanService = new PendidikanService();

		int pendidikanIndex = 0;
		for (String[] pendidikanRaw : Raw.getPendidikan()) {
			increment("pendidikan");
			pendidikanIndex++;

			pendidikan.add(new PendidikanModel(
					pendidikanIndex,
					pendidikanRaw[0],
					pendidikanRaw[1]));
		}

		pendidikanService.clear();
		pendidikanService.add(pendidikan.toArray(new PendidikanModel[0]));
	}

	private static final ArrayList<TempatLahirModel> tempatLahir = new ArrayList<TempatLahirModel>();

	private static void tempatLahir() {
		final TempatLahirService tempatLahirService = new TempatLahirService();

		int tempatLahirIndex = 0;
		for (String tempatLahirRaw : Raw.getTempatLahir()) {
			increment("tempatLahir");
			tempatLahirIndex++;

			tempatLahir.add(new TempatLahirModel(
					tempatLahirIndex,
					tempatLahirRaw));
		}

		tempatLahirService.clear();
		tempatLahirService.add(tempatLahir.toArray(new TempatLahirModel[0]));
	}

	private static final ArrayList<TahunAjaranModel> tahunAjaran = new ArrayList<TahunAjaranModel>();

	private static void tahunAjaran() {
		final TahunAjaranService tahunAjaranService = new TahunAjaranService();

		int tahunAjaranIndex = 0;
		for (String tahunAjaranRaw : Raw.getTahunAjaran()) {
			tahunAjaranIndex++;

			increment("tahunAjaran");
			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Ganjil"));

			increment("tahunAjaran");
			tahunAjaran.add(new TahunAjaranModel(
					tahunAjaranIndex,
					tahunAjaranRaw + " Genap"));
		}

		tahunAjaranService.clear();
		tahunAjaranService.add(tahunAjaran.toArray(new TahunAjaranModel[0]));
	}

	private static final ArrayList<TahunMasukModel> tahunMasuk = new ArrayList<TahunMasukModel>();

	private static void tahunMasuk() {
		final TahunMasukService tahunMasukService = new TahunMasukService();

		int tahunMasukIndex = 0;
		for (String tahunMasukRaw : Raw.getTahunMasuk()) {
			increment("tahunMasuk");
			tahunMasukIndex++;

			tahunMasuk.add(new TahunMasukModel(
					tahunMasukIndex,
					tahunMasukRaw));
		}

		tahunMasukService.clear();
		tahunMasukService.add(tahunMasuk.toArray(new TahunMasukModel[0]));
	}

	private static final ArrayList<RuanganModel> ruangan = new ArrayList<RuanganModel>();

	private static void ruangan() {
		final RuanganService ruanganService = new RuanganService();

		int ruanganIndex = 0;
		for (String ruanganRaw : Raw.getRuangan()) {
			for (int firstIndex = 1; firstIndex <= 3; firstIndex++) {
				for (int thirdIndex = 1; thirdIndex <= 7; thirdIndex++) {
					increment("ruangan");
					ruanganIndex++;

					ruangan.add(new RuanganModel(
							ruanganIndex,
							ruanganRaw + firstIndex + "0" + thirdIndex));
				}
			}
		}

		ruanganService.clear();
		ruanganService.add(ruangan.toArray(new RuanganModel[0]));
	}

	private static final ArrayList<MataKuliahModel> mataKuliah = new ArrayList<MataKuliahModel>();

	private static void mataKuliah() {
		final MataKuliahService mataKuliahService = new MataKuliahService();

		int mataKuliahIndex = 0;
		for (Object[] mataKuliahRaw : Raw.getMataKuliah()) {
			increment("mataKuliah");
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
	};

	private static final ArrayList<DosenModel> dosen = new ArrayList<DosenModel>();

	private static void dosen() {
		final DosenService dosenService = new DosenService();
		final TempatLahirService tempatLahirService = new TempatLahirService();
		final PendidikanService pendidikanService = new PendidikanService();
		final ProgramStudiService programStudiService = new ProgramStudiService();

		final Integer[] idTempatLahir = tempatLahirService.getId();
		final Integer[] idPendidikan = pendidikanService.getId();
		final Integer[] idProgramStudi = programStudiService.getId();

		final Map<String, Integer> baseCount = new HashMap<>();

		for (int dosenIndex = 1; dosenIndex <= 50; dosenIndex++) {
			increment("dosen");

			final Integer tempatLahir = Randomizer.pickArray(idTempatLahir);
			final String tanggalLahir = Randomizer.date("1965-01-01", "2000-12-31");
			final JenisKelaminEnum jenisKelamin = Randomizer.pickEnum(JenisKelaminEnum.class);
			final GolonganDarahEnum golonganDarah = Randomizer.pickEnum(GolonganDarahEnum.class);
			final AgamaEnum agama = Randomizer.pickEnum(AgamaEnum.class);
			final Integer pendidikan = Randomizer.pickArray(idPendidikan);
			final Integer programStudi = Randomizer.pickArray(idProgramStudi);

			final String base = ""
					+ Format.zfill(tempatLahir.toString(), '0', 2)
					+ Format.zfill(String.valueOf(programStudiService.getOne(programStudi).getIdJurusan()), '0', 2)
					+ Format.zfill(programStudi.toString(), '0', 2)
					+ tanggalLahir.substring(2, 4)
					+ tanggalLahir.substring(5, 7)
					+ tanggalLahir.substring(8, 10);

			baseCount.put(base, baseCount.getOrDefault(base, 0) + 1);

			final String nik = base + Format.zfill(String.valueOf(baseCount.get(base)), '0', 4);
			final String nama = Randomizer.pickArray(Raw.getNama());

			dosen.add(new DosenModel(
					dosenIndex,
					nik,
					Format.reverse(nik),
					nama,
					""
							+ Pattern
									.compile("[^a-z]")
									.matcher(nama.toLowerCase())
									.replaceAll("")
							+ tanggalLahir.substring(2, 4)
							+ "@gmail.com",
					tanggalLahir.substring(2, 4) + tanggalLahir.substring(5, 7) + tanggalLahir.substring(8, 10),
					""
							+ "Jl. " + tempatLahirService.getOne(tempatLahir).getTempatLahir() + " "
							+ "No. " + tanggalLahir.substring(2, 4) + " "
							+ "RT. " + tanggalLahir.substring(5, 7),
					tempatLahir,
					tanggalLahir,
					jenisKelamin,
					golonganDarah,
					agama,
					"+628" + Format.reverse(base),
					pendidikan,
					programStudi,
					true,
					null));
		}

		dosenService.clear();
		dosenService.add(dosen.toArray(new DosenModel[0]));
	};

	private static final ArrayList<MahasiswaModel> mahasiswa = new ArrayList<MahasiswaModel>();

	private static void mahasiswa() {
		final MahasiswaService mahasiswaService = new MahasiswaService();
		final TempatLahirService tempatLahirService = new TempatLahirService();
		final TahunAjaranService tahunAjaranService = new TahunAjaranService();
		final TahunMasukService tahunMasukService = new TahunMasukService();
		final ProgramStudiService programStudiService = new ProgramStudiService();
		final DosenService dosenService = new DosenService();

		final Integer[] idTempatLahir = tempatLahirService.getId();
		final Integer[] idTahunAjaran = tahunAjaranService.getId();
		final Integer[] idTahunMasuk = tahunMasukService.getId();
		final Integer[] idProgramStudi = programStudiService.getId();
		final Integer[] idDosenWali = dosenService.getId();

		final Map<String, Integer> baseCount = new HashMap<>();

		for (int mahasiswaIndex = 1; mahasiswaIndex <= 1000; mahasiswaIndex++) {
			increment("mahasiswa");

			final Integer tempatLahir = Randomizer.pickArray(idTempatLahir);
			final String tanggalLahir = Randomizer.date("2001-01-01", "2006-12-31");
			final JenisKelaminEnum jenisKelamin = Randomizer.pickEnum(JenisKelaminEnum.class);
			final GolonganDarahEnum golonganDarah = Randomizer.pickEnum(GolonganDarahEnum.class);
			final AgamaEnum agama = Randomizer.pickEnum(AgamaEnum.class);
			final Integer tahunAjaran = Randomizer.pickArray(idTahunAjaran);
			final Integer tahunMasuk = Randomizer.pickArray(idTahunMasuk);
			final Integer programStudi = Randomizer.pickArray(idProgramStudi);
			final Integer dosenWali = Randomizer.pickArray(idDosenWali);

			final String base = ""
					+ Format.zfill(tempatLahir.toString(), '0', 2)
					+ Format.zfill(String.valueOf(programStudiService.getOne(programStudi).getIdJurusan()), '0', 2)
					+ Format.zfill(programStudi.toString(), '0', 2)
					+ tanggalLahir.substring(2, 4)
					+ tanggalLahir.substring(5, 7)
					+ tanggalLahir.substring(8, 10);

			baseCount.put(base, baseCount.getOrDefault(base, 0) + 1);

			final String nik = base + Format.zfill(String.valueOf(baseCount.get(base)), '0', 4);
			final String nama = Randomizer.pickArray(Raw.getNama());

			mahasiswa.add(new MahasiswaModel(
					mahasiswaIndex,
					nik,
					Format.reverse(nik),
					nama,
					""
							+ Pattern
									.compile("[^a-z]")
									.matcher(nama.toLowerCase())
									.replaceAll("")
							+ tanggalLahir.substring(2, 4)
							+ "@gmail.com",
					tanggalLahir.substring(2, 4) + tanggalLahir.substring(5, 7) + tanggalLahir.substring(8, 10),
					""
							+ "Jl. " + tempatLahirService.getOne(tempatLahir).getTempatLahir() + " "
							+ "No. " + tanggalLahir.substring(2, 4) + " "
							+ "RT. " + tanggalLahir.substring(5, 7),
					tempatLahir,
					tanggalLahir,
					jenisKelamin,
					golonganDarah,
					agama,
					"+628" + Format.reverse(base),
					tahunAjaran,
					tahunMasuk,
					programStudi,
					dosenWali,
					true,
					null));
		}

		mahasiswaService.clear();
		mahasiswaService.add(mahasiswa.toArray(new MahasiswaModel[0]));
	};

	private static final ArrayList<KelasModel> kelas = new ArrayList<KelasModel>();

	private static void kelas() {
		final KelasService kelasService = new KelasService();
		final DosenService dosenService = new DosenService();
		final MataKuliahService mataKuliahService = new MataKuliahService();
		final RuanganService ruanganService = new RuanganService();
		final TahunAjaranService tahunAjaranService = new TahunAjaranService();

		final Integer[] idDosen = dosenService.getId();
		final Integer[] idMataKuliah = mataKuliahService.getId();
		final Integer[] idRuangan = ruanganService.getId();
		final Integer[] idTahunAjaran = tahunAjaranService.getId();

		for (int kelasIndex = 1; kelasIndex <= 100; kelasIndex++) {
			increment("kelas");

			final Integer dosen = Randomizer.pickArray(idDosen);
			final Integer mataKuliah = Randomizer.pickArray(idMataKuliah);
			final Integer ruangan = Randomizer.pickArray(idRuangan);
			final SesiEnum sesi = Randomizer.pickEnum(SesiEnum.class);
			final Integer tahunAjaran = Randomizer.pickArray(idTahunAjaran);

			kelas.add(new KelasModel(
					kelasIndex,
					dosen,
					mataKuliah,
					Randomizer.character(),
					ruangan,
					sesi,
					tahunAjaranService.getOne(tahunAjaran).getTahunAjaran()));
		}

		kelasService.clear();
		kelasService.add(kelas.toArray(new KelasModel[0]));
	};

}
