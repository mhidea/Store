package models;

import abstracts.PersistanceModel;
import interfaces.IBackupAble;
import interfaces.IMapper;
import interfaces.IShipping;
import persistance.mappers.ProxyBackupMapper;

public class Shipping extends PersistanceModel implements IBackupAble {

    public Shipping() {
        super();
    }

    public Shipping(String id) throws Exception {
        super(id);
    }

    public Shipping(Basket basket, IShipping shippingMethod) {
        super();
        setValue("basket_id", basket.getId());
        setValue("class", shippingMethod.getClass().getName());
        setValue("state", "opened");
    }

    @Override
    public String[] getAttributes() {
        return new String[] { "id", "class", "basket_id", "state" };
    }

    @Override
    public IMapper<?, ?> getMapper() {
        return new ProxyBackupMapper<>(this.getClass());
    }
}
