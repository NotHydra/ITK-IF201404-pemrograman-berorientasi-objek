package interfaces;

import enums.SesiEnum;

public interface KelasInterface {
    public int getIdDosen();

    public int getIdMataKuliah();

    public char getTipeKelas();

    public int getIdRuangan();

    public SesiEnum getSesi();

    public String getTahunAjaran();
}
