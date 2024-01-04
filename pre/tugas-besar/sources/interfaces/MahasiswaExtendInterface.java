package interfaces;

import models.TempatLahirModel;
import models.TahunAjaranModel;
import models.TahunMasukModel;
import models.ProgramStudiExtendModel;

public interface MahasiswaExtendInterface {
    public TempatLahirModel getTempatLahirExtend();

    public TahunAjaranModel getTahunAjaranExtend();

    public TahunMasukModel getTahunMasukExtend();

    public ProgramStudiExtendModel getProgramStudiExtend();
}
