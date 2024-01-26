package services;

import java.lang.reflect.InvocationTargetException;

import helper.ConfigManager;
import interfaces.IAwardPolicy;

public class Factory extends AbstractFactory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getInstance() {
        if (factory == null) {
            factory = new Factory();
        }
        return factory;
    }

    public IAwardPolicy getAwardPolicy() {
        String name = ConfigManager.getInstance().interfaces(IAwardPolicy.class.getName()).get(0);
        try {
            return (IAwardPolicy) Class.forName(name).getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
