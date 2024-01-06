package interfaces;

import models.TempatLahirModel;
import models.TahunAjaranModel;
import models.TahunMasukModel;
import models.DosenWaliExtendModel;
import models.ProgramStudiExtendModel;

public interface MahasiswaExtendInterface {
    public TempatLahirModel getTempatLahirExtend();

    public TahunAjaranModel getTahunAjaranExtend();

    public TahunMasukModel getTahunMasukExtend();

    public ProgramStudiExtendModel getProgramStudiExtend();

    public DosenWaliExtendModel getDosenWaliExtend();

}
