package models;

import java.util.ArrayList;
import java.util.List;

import abstracts.PersistanceModel;
import interfaces.IOrderListener;
import interfaces.IPayment;
import interfaces.IShipping;
import persistance.PersistanceFacade;

public class Basket extends PersistanceModel {

    List<BasketItem> items = new ArrayList<>(0);
    List<IOrderListener> listeners = new ArrayList<>(0);
    final String OPEN = "open";
    final String ORDERED = "ordered";
    final String RETURNED = "returned";

    public Basket(User user) {
        super();
        setValue("user_id", user.getId());
        setValue("state", OPEN);
    }

    @Override
    public String[] getAttributes() {
        return new String[] { "id", "user_id", "items", "state" };
    }

    public void addToBasket(BasketItem item) {

        if (items.isEmpty()) {
            setValue("items", item.toString());
        } else {
            setValue("items", getValue("items") + "#" + item.toString());
        }
        items.add(item);
    }

    public void addToBasket(Product p, int count) {
        addToBasket(new BasketItem(p, count));
    }

    public List<BasketItem> getItems() {
        return items;
    }

    public void addOrderListener(IOrderListener listener) {
        listeners.add(listener);
    }

    public void finalize(IPayment payment, IShipping shipping) {
        setValue("state", ORDERED);
        this.save();
        for (IOrderListener listener : listeners) {
            listener.OnOrder(this);
        }
    }

    public static List<Basket> getAll(User user) {
        return PersistanceFacade.getInstance().search(Basket.class, "user_id", user.getId());
    }
}
