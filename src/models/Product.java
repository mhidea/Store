package models;

import abstracts.PersistanceModel;

public class Product extends PersistanceModel {

    public Product() {
        super();
    }

    public Product(String id) throws Exception {
        super(id);
    }

    @Override
    public String[] getAttributes() {
        return new String[] { "id", "name", "price", "count" };
    }

    public void setName(String name) {
        this.setValue("name", name);
    }

    public void setPrice(int price) {
        this.setValue("price", price + "");
    }

    public void setCount(int count) {
        this.setValue("count", count + "");
    }

}
