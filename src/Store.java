import catalogs.Payments;
import catalogs.Shippings;
import services.external.Factory;

/**
 * Store
 * This is the main controller of application.
 */
public class Store {
    private static Store mStore;

    private Store() {
        Factory.getMelatBank();
        Factory.getPost();
        new Payments();
        new Shippings();
    }

    public static Store getInstance() {
        if (mStore == null) {
            mStore = new Store();
        }
        return mStore;
    }
}
