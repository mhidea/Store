package persistance.mappers;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import abstracts.PersistanceModel;
import interfaces.IMapper;
import persistance.drivers.FileDriver;

public class FileMapper<M extends PersistanceModel> implements IMapper<String, M> {
    Class<M> class1 = null;

    public FileMapper(Class<M> class1) {
        this.class1 = class1;
    }

    @Override
    public String getDestination() {
        return class1.getName().replace("models.", "");
    }

    @SuppressWarnings("unchecked")
    @Override
    public FileDriver getDriver() {
        return new FileDriver(getDestination());
    }

    @Override
    public String getData(M model) {
        List<String> ls = new ArrayList<>();
        for (String key : model.getMap().keySet()) {
            if (key != model.getIdName()) {
                ls.add(model.getValue(key));
            }
        }
        return String.join(",", ls);
    }

    @Override
    public M getModel(String data) {
        if (data == null) {
            return null;
        }
        try {
            M t = class1.getConstructor().newInstance();
            String[] vs = data.split(",");
            t.setValues(vs);
            return t;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String search(String attribute, String value) {

        return "\\d*," + value + ",.*";

    }

}
