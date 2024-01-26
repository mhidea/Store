package models;

import abstracts.PersistanceModel;
import interfaces.IBackupAble;
import interfaces.IMapper;
import interfaces.IPayment;
import persistance.mappers.ProxyBackupMapper;

public class Payment extends PersistanceModel implements IBackupAble {

    public Payment() {
        super();
    }

    public Payment(String id) throws Exception {
        super(id);
    }

    public Payment(Basket basket, IPayment paymentMethod) {
        super();
        setValue("basket_id", basket.getId());
        setValue("amount", basket.getTotal() + "");
        setValue("class", paymentMethod.getClass().getName());
        setValue("state", "opened");

    }

    @Override
    public String[] getAttributes() {
        return new String[] { "id", "class", "basket_id", "amount", "state" };
    }

    @Override
    public IMapper<?, ?> getMapper() {
        return new ProxyBackupMapper<>(this.getClass());
    }

}
