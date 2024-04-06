package global.extend;


import providers.Logger;
import providers.Database;

import global.base.BaseModel;
import global.base.BaseService;

public abstract class ExtendService<ModelType extends BaseModel, ModelExtendType extends ModelType> extends BaseService<ModelType> {
    protected ExtendService(Logger logger, Database database, String table) {
        super(logger, database, table);
    }

    public void displayExtend() {
        this.logger.debug("Display Extend");

        try {
            for (ModelExtendType model : this.findExtend()) {
                System.out.println(model);
                System.out.println();
            }
        }
        catch (Exception e) {
            this.logger.error("Failed to display extend: " + e.getMessage());
        }
    }

    public abstract ModelExtendType[] findExtend();

    public abstract ModelExtendType findIdExtend(int id);
}
