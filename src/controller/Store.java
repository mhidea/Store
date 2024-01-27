package controller;

import catalogs.PaymentMethods;
import catalogs.ProductsCatalog;
import catalogs.ShippingMethods;
import models.Basket;
import models.User;
import services.ServiceFactory;

/**
 * Store
 * This is the main controller of application.
 */
public class Store {
    private static Store mStore;
    String[] paymentMethods;
    String[] shippingMethods;
    ProductsCatalog productsCatalog;

    private Store() {
        productsCatalog = new ProductsCatalog();
        PaymentMethods m = ServiceFactory.getInstance().getPaymentMethods();
        paymentMethods = (String[]) m.getNames().toArray();
        ShippingMethods sh = ServiceFactory.getInstance().getShippingMethods();
        shippingMethods = (String[]) sh.getNames().toArray();

        System.out.println("List of current payment methods:");

        System.out.println("List of current shipping methods:");

    }

    public static Store getInstance() {
        if (mStore == null) {
            mStore = new Store();
        }
        return mStore;
    }

    public String[] getPaymentMethods() {
        return paymentMethods;
    }

    public String[] getShippingMethods() {
        return shippingMethods;
    }

    public Basket createNewBAsket(User user) {
        return new Basket(user);
    }
}
