package persistance.state;

import abstracts.PersistanceModel;
import persistance.PersistanceFacade;

public class OldDirty extends POState {

    public OldDirty(PersistanceModel persistanceModel) {
        super(persistanceModel);
    }

    @Override
    public void save() {
        PersistanceFacade.getInstance().save(this.pm);
        this.pm.setState(new OldClean(pm));
    }

    @Override
    public void rollback() {
        PersistanceModel pmm = PersistanceFacade.getInstance().getItem(this.pm.getId(), this.pm.getClass());
        this.pm.setValues(pmm.getMap());
        this.pm.setState(new OldClean(this.pm));
    }
}
