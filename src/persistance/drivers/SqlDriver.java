package persistance.drivers;

import interfaces.IDriver;

public class SqlDriver implements IDriver<String> {

    @Override
    public String getDestination() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDestination'");
    }

    @Override
    public String findById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public String[] findAll(String search) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public String insert(String data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void update(String id, String data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
