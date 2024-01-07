package interfaces;

import models.DosenExtendModel;
import models.MataKuliahModel;
import models.RuanganModel;

public interface KelasExtendInterface {
    public DosenExtendModel getDosenExtend();

    public MataKuliahModel getMataKuliahExtend();

    public RuanganModel getRuanganExtend();
}
