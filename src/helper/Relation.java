package helper;

import abstracts.PersistanceModel;

public class Relation {
    private String foreignKey;
    private Class<? extends PersistanceModel> cls;

    public Relation(String foreignKey, Class<? extends PersistanceModel> cls) {
        this.foreignKey = foreignKey;
        this.cls = cls;
    }

    public String getForeignKey() {
        return foreignKey;
    }

    public void setForeignKey(String foreignKey) {
        this.foreignKey = foreignKey;
    }

    public Class<? extends PersistanceModel> getCls() {
        return cls;
    }

    public void setCls(Class<? extends PersistanceModel> cls) {
        this.cls = cls;
    }

}
