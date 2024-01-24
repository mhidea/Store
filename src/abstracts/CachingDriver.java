package abstracts;

import java.util.HashMap;

import interfaces.IDriver;

public abstract class CachingDriver<T> implements IDriver<T> {
    private HashMap<String, T> cache = new HashMap<>();

    @Override
    public final void delete(String id) {
        cache.remove(id);
        deleteFromSource(id);
    }

    public abstract void deleteFromSource(String id);

    @Override
    public final T findById(String id) {
        if (cache.containsKey(id)) {
            return cache.get(id);
        }
        return findFromSource(id);
    }

    public abstract T findFromSource(String id);

    @Override
    public final String insert(T data) {
        String id = insertToSource(data);
        cache.put(id, data);
        return id;
    }

    public abstract String insertToSource(T data);

    @Override
    public final void update(String id, T data) {
        updateToSource(id, data);
        cache.put(id, data);
    }

    public abstract void updateToSource(String id, T data);
}
