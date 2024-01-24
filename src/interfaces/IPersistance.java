package interfaces;

public interface IPersistance {

    public void save();

    public void rollback();

    public void commit();

    public void delete();

}
