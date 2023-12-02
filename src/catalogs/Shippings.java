package catalogs;

import java.util.ArrayList;

import helper.ConfigManager;
import interfaces.IShipping;

/**
 * Shippings
 * Catalog of available Shipping methods.
 */
public class Shippings {
    IShipping[] mShippings = new IShipping[0];

    public Shippings() {
        ArrayList<String> names = ConfigManager.getInstance().interfaces(IShipping.class.getName());
        names.forEach(name -> {
            try {
                Class a = Class.forName(name);
                IShipping i = (IShipping) a.getConstructor().newInstance(mShippings);
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }
}
