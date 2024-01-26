package persistance.mappers;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

import abstracts.PersistanceModel;
import interfaces.IMapper;
import persistance.drivers.SqlDriver;

public class SqlMapper<M extends PersistanceModel> implements IMapper<ResultSet, M> {

    Class<M> class1 = null;

    public SqlMapper(Class<M> class1) {
        this.class1 = class1;
    }

    @Override
    public String getDestination() {
        return class1.getName().replace("models.", "");
    }

    @Override
    public ResultSet getData(M model) {
        return null;
    }

    @Override
    public ResultSet search(String attribute, String value) {
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public SqlDriver getDriver() {
        return new SqlDriver(getDestination());
    }

    @Override
    public M getModel(ResultSet object) {
        M m = null;
        try {
            m = class1.getConstructor().newInstance();
            String[] attrs = m.getAttributes();
            for (String key : attrs) {
                m.setValue(key, object.getString(key));
            }
            m.setObjects();
        } catch (SQLException | InstantiationException | IllegalAccessException | IllegalArgumentException
                | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return m;
    }

}
