package interfaces;

import java.util.Date;

import enums.JenisKelaminEnum;

public interface DosenInterface {
    public String getNIK();

    public String getNIP();

    public String getNama();

    public String getEmail();

    public String getPassword();

    public String getAlamat();

    public int getIdTempatLahir();

    public Date getTanggalLahir();

    public JenisKelaminEnum getJenisKelamin();

    public String getGolonganDarah();

    public String getAgama();

    public String getNomorTelepon();

    public int getIdPendidikan();

    public int getIdProgramStudi();

    public boolean getAktif();

    public String getKeterangan();
}
