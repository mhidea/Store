import catalogs.PaymentMethods;
import catalogs.ShippingMethods;
import services.ServiceFactory;

/**
 * Store
 * This is the main controller of application.
 */
public class Store {
    private static Store mStore;

    private Store() {
        PaymentMethods m = ServiceFactory.getInstance().getPaymentMethods();
        ShippingMethods sh = ServiceFactory.getInstance().getShippingMethods();
        System.out.println("List of current payment methods:");
        m.getNames().forEachRemaining(name -> {
            System.out.println("  " + name);
        });
        System.out.println("List of current shipping methods:");
        sh.getNames().forEachRemaining(name -> {
            System.out.println("  " + name);
        });
    }

    public static Store getInstance() {
        if (mStore == null) {
            mStore = new Store();
        }
        return mStore;
    }
}
