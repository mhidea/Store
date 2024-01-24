package persistance;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import abstracts.PersistanceModel;
import helper.ConfigManager;
import interfaces.IDriver;
import interfaces.IMapper;
import persistance.mappers.FileMapper;

@SuppressWarnings("unchecked")
public class PersistanceFacade {
    HashMap<Class<?>, Class<?>> mappers = new HashMap<>();
    private static PersistanceFacade persistanceFacade;

    private PersistanceFacade() {
        ConfigManager.getInstance().mappers().forEach((arg0, arg1) -> {

            try {
                mappers.put(Class.forName(arg0),
                        Class.forName(arg1));
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (SecurityException e) {
                e.printStackTrace();
            }

        });
        ;
    }

    public static PersistanceFacade getInstance() {
        if (persistanceFacade == null) {
            persistanceFacade = new PersistanceFacade();
        }
        return persistanceFacade;
    }

    public <T extends PersistanceModel, A> T getItem(String id, Class<T> c) {
        T m = null;
        try {
            IMapper<A, T> mp = (IMapper<A, T>) mappers.get(c).getConstructor(new Class[] { c.getClass() })
                    .newInstance(c);
            IDriver<A> d = mp.getDriver();
            m = mp.getModel(d.findById(id));
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return m;
    }

    public <T extends PersistanceModel, A> T save(T model) {
        IMapper<A, T> mp;
        try {
            new FileMapper<>(model.getClass());
            Class<IMapper<A, T>> cm = (Class<IMapper<A, T>>) mappers.get(model.getClass());
            mp = cm.getConstructor(new Class[] { model.getClass().getClass() })
                    .newInstance(model.getClass());
            IDriver<A> driver = mp.getDriver();
            if (model.getId() == null) {
                String id = driver.insert(mp.getData(model));
                model.setID(id);
            } else {
                driver.update(model.getId(), mp.getData(model));
            }

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }
        return model;
    }

    public <T extends PersistanceModel, A> List<T> search(Class<T> c, String attribute, String value) {
        List<T> list = new ArrayList<T>(0);
        try {
            IMapper<A, T> mp = (IMapper<A, T>) mappers.get(c).getConstructor(new Class[] { c.getClass() })
                    .newInstance(c);
            IDriver<A> d = mp.getDriver();
            for (A o : d.findAll((String) mp.search(attribute, value))) {
                list.add((T) mp.getModel(o));
            }

        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException e) {
            e.printStackTrace();
        }

        return list;
    }
}
