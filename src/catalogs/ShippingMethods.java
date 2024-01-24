package catalogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import interfaces.IShipping;

/**
 * Shippings
 * Catalog of available Shipping methods.
 */
public class ShippingMethods {

    private HashMap<String, IShipping> mShippings = new HashMap<>();

    public ShippingMethods(ArrayList<IShipping> isl) {
        mShippings.clear();
        for (IShipping iShipping : isl) {
            mShippings.put(iShipping.getName(), iShipping);
        }
    }

    public Iterator<String> getNames() {
        return mShippings.keySet().iterator();
    }

}
