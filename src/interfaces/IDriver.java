package interfaces;

public interface IDriver<T> {

    public String getDestination();

    public T findById(String id);

    public T[] findAll(String search);

    public String insert(T data);

    public void delete(String id);

    public void update(String id, T data);

}
