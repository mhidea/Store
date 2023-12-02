package helper;

import java.util.List;

import interfaces.IStorageAdapter;

public class DbStorageAdapter implements IStorageAdapter {

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub

    }

    @Override
    public void saveAll(String content) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveAll'");
    }

    @Override
    public void save(int id, String data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public List loadAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'loadAll'");
    }

    @Override
    public String load(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }

}
