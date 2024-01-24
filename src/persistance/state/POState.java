package persistance.state;

import abstracts.PersistanceModel;
import interfaces.IPersistance;

public class POState implements IPersistance {
    protected PersistanceModel pm;

    public POState(PersistanceModel persistanceModel) {
        this.pm = persistanceModel;
    }

    public void save() {

    }

    public void rollback() {

    }

    public void commit() {

    }

    public void delete() {

    }
}
