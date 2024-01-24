package interfaces;

import abstracts.PersistanceModel;

public interface IMapper<T, M extends PersistanceModel> {

    public String getDestination();

    public T getData(M model);

    public T search(String attribute, String value);

    public <A extends IDriver<T>> A getDriver();

    public M getModel(T object);

}
