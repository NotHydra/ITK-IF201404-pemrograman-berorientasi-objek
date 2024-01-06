package interfaces;

import java.util.Date;

import enums.JenisKelaminEnum;
import enums.GolonganDarahEnum;
import enums.AgamaEnum;

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

    public GolonganDarahEnum getGolonganDarah();

    public AgamaEnum getAgama();

    public String getNomorTelepon();

    public int getIdPendidikan();

    public int getIdProgramStudi();

    public boolean getAktif();

    public String getKeterangan();
}
