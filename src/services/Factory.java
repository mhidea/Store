package services;

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
        return getAdapter(IAwardPolicy.class);
    }
}
