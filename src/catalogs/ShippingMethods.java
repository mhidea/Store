package catalogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import interfaces.IShipping;

/**
 * Shippings
 * Catalog of available Shipping methods.
 */
public class ShippingMethods {

    private LinkedHashMap<String, IShipping> mShippings = new LinkedHashMap<>();

    public ShippingMethods(ArrayList<IShipping> isl) {
        mShippings.clear();
        for (IShipping iShipping : isl) {
            mShippings.put(iShipping.getName(), iShipping);
        }
    }

    public Iterator<String> getNames() {
        return mShippings.keySet().iterator();
    }

    public IShipping getMethod(String name) {
        return mShippings.get(name);
    }

}
