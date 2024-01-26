package models;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import abstracts.PersistanceModel;
import interfaces.IOrderListener;
import interfaces.IPayment;
import interfaces.IShipping;
import persistance.PersistanceFacade;
import services.Factory;

public class Basket extends PersistanceModel {

    List<BasketItem> items = new ArrayList<>(0);
    List<IOrderListener> listeners = new ArrayList<>(0);
    final String OPEN = "open";
    final String ORDERED = "ordered";
    final String RETURNED = "returned";
    Payment payment = null;
    Shipping shipping = null;

    public Basket() {
        super();
    }

    public Basket(String id) throws Exception {
        super(id);
    }

    public Basket(User user) {
        super();
        setValue("user_id", user.getId());
        setValue("state", OPEN);
    }

    @Override
    public String[] getAttributes() {
        return new String[] { "id", "user_id", "items", "state", "shipping_id", "payment_id" };
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

    public void finalize(IPayment paymentMethod, IShipping shippingMethod) {
        if (getValue("state").equals(ORDERED)) {
            return;
        }
        int points = Factory.getInstance().getAwardPolicy().getPoints(this);
        try {
            User user = new User(getValue("user_id"));
            user.setValue("score", "" + (Integer.parseInt(user.getScore()) + points));
            user.save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        setValue("state", ORDERED);
        payment = new Payment(this, paymentMethod);
        shipping = new Shipping(this, shippingMethod);
        this.save();
        for (IOrderListener listener : listeners) {
            listener.OnOrder(this);
        }
    }

    public int getTotal() {
        return items.stream().reduce(0, new BiFunction<Integer, BasketItem, Integer>() {
            @Override
            public Integer apply(Integer sum, BasketItem item) {
                Product p;
                try {
                    p = new Product(item.getProductId());
                    int c = Integer.parseInt(item.getCount());
                    int pr = Integer.parseInt(p.getPrice());
                    return sum + (c * pr);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return sum;
            }
        }, Integer::sum);
    }

    public static List<Basket> getAll(User user) {
        return PersistanceFacade.getInstance().search(Basket.class, "user_id", user.getId());
    }

    @Override
    public void setObjects() {
        String _id = getValue("shipping_id");
        try {
            if (_id != null) {
                payment = new Payment(_id);
            }
            _id = getValue("payment_id");
            if (_id != null) {
                shipping = new Shipping(_id);
            }
        } catch (Exception e) {
        }
        String[] is = getValue("items").split("#");
        items.clear();
        for (String string : is) {
            addToBasket(new BasketItem(string));
        }
    }

    @Override
    public void saveObjects() {
        if (shipping != null) {
            shipping.save();
            setValue("shipping_id", shipping.getId());
        }
        if (payment != null) {
            payment.save();
            setValue("payment_id", payment.getId());
        }
    }

}
