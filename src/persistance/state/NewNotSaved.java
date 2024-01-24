package persistance.state;

import abstracts.PersistanceModel;
import persistance.PersistanceFacade;

public class NewNotSaved extends POState {

    public NewNotSaved(PersistanceModel persistanceModel) {
        super(persistanceModel);
    }

    @Override
    public void save() {
        this.pm = PersistanceFacade.getInstance().save(this.pm);
        pm.setState(new OldClean(pm));
    }
}
