package persistance.mappers;

import abstracts.PersistanceModel;
import interfaces.IDriver;
import interfaces.IMapper;

public class ProxyBackupMapper<M extends PersistanceModel> implements IMapper<String, M> {
    Class<M> class1 = null;
    SocketMapper<M> socketMapper;
    BackUpFileMapper<M> fileMapper;

    public ProxyBackupMapper(Class<M> class1) {
        this.class1 = class1;
        socketMapper = new SocketMapper<>(class1);
        fileMapper = new BackUpFileMapper<>(class1);
    }

    @Override
    public String getDestination() {

        throw new UnsupportedOperationException("Unimplemented method 'getDestination'");
    }

    @Override
    public String getData(M model) {
        return fileMapper.getData(model);
    }

    @Override
    public String search(String attribute, String value) {
        return fileMapper.search(attribute, value);
    }

    @Override
    public M getModel(String object) {
        return (M) fileMapper.getModel(object);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <A extends IDriver<String>> A getDriver() {
        A id = (A) socketMapper.getDriver();
        if (id != null) {
            return id;
        }
        return (A) fileMapper.getDriver();
    }

}
