package services;

import java.util.LinkedHashMap;

import helper.ConfigManager;

public abstract class AbstractFactory {
    public <T> T getAdapter(Class<T> class1) {
        T o = null;
        LinkedHashMap<String, String> crs = ConfigManager.getInstance().credentials(class1.getName());
        try {
            if (crs != null) {
                Class<?>[] types = new Class[crs.values().size()];
                for (int i = 0; i < types.length; i++) {
                    types[i] = String.class;
                }
                o = (T) class1.getConstructor(types).newInstance(crs.values().toArray());
            } else {
                o = (T) class1.getConstructor().newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

}
