package models;

import abstracts.Model;

public class BasketItem extends Model {

    public BasketItem(Product p, int count) {
        super();
        setValue("product_id", p.getId());
        setValue("count", count + "");
    }

    public BasketItem(String data) {
        super();
        String[] sd = data.split("@");
        setValue("product_id", sd[0]);
        setValue("count", sd[1]);
    }

    @Override
    public String[] getAttributes() {
        return new String[] { "product_id", "count" };
    }

    public String getProductId() {
        return getValue("product_id");
    }

    public String getCount() {
        return getValue("count");
    }

    @Override
    public String toString() {
        return getProductId() + "@" + getCount();
    }
}
