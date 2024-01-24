package abstracts;

import interfaces.IPersistance;
import persistance.PersistanceFacade;
import persistance.state.NewNotSaved;
import persistance.state.OldClean;
import persistance.state.OldDirty;
import persistance.state.POState;

public abstract class PersistanceModel extends Model implements IPersistance {

    private POState state;
    public boolean lazy_load = false;

    protected PersistanceModel() {
        super();
        this.setState(new NewNotSaved(this));
    }

    protected PersistanceModel(String id) throws Exception {
        super();
        PersistanceModel m = PersistanceFacade.getInstance().getItem(id, this.getClass());
        if (m != null) {
            setValues(m.getMap());
            setState(new OldClean(this));
            m = null;
        } else {
            throw new Exception("NOT FOUND");
        }

    }

    @Override
    public void setValue(String attributeName, String value) {
        String old = getValue(attributeName);

        if (old != value) {
            this.map.put(attributeName, value);
            if (!(this.state instanceof NewNotSaved)) {
                setState(new OldDirty(this));
            }
        }
    }

    @Override
    public void setValues(String[] values) {
        super.setValues(values);
        this.setState(new OldDirty(this));
    }

    public void setID(String id) {
        map.put(getIdName(), id);
    }

    public String getId() {
        return map.get(getIdName());
    }

    @Override
    public String getIdName() {
        return getAttributes()[0];
    }

    public void setState(POState s) {
        this.state = s;
    }

    public void save() {
        this.state.save();
    }

    public void rollback() {
        this.state.rollback();
    }

    public void commit() {
        this.state.commit();
    }

    public void delete() {
        this.state.delete();
    }
}
