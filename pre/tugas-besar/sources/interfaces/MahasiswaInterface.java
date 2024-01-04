package interfaces;

import java.util.Date;

public interface MahasiswaInterface {
    public String getNIK();

    public String getNIM();

    public String getNama();

    public String getEmail();

    public String getPassword();

    public String getAlamat();

    public int getIdTempatLahir();

    public Date getTanggalLahir();

    public String getJenisKelamin();

    public String getGolonganDarah();

    public String getAgama();

    public String getNomorTelepon();

    public int getIdTahunAjaran();

    public int getIdTahunMasuk();

    public int getIdProgramStudi();

    public int getIdDosenWali();

    public boolean getAktif();

    public String getKeterangan();
}
