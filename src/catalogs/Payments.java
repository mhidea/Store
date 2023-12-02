package catalogs;

import java.util.ArrayList;

import helper.ConfigManager;
import interfaces.IBankGateway;
import interfaces.IPayment;

/**
 * Banks
 * Catalog of available banks that can be used for payments.
 */
public class Payments {
    IPayment[] mBankGateways = new IPayment[0];

    public Payments() {
        ArrayList<String> names = ConfigManager.getInstance().interfaces(IPayment.class.getName());
        names.forEach(name -> {
            try {
                Class a = Class.forName(name);
                IPayment i = (IPayment) a.getConstructor().newInstance();
                System.out.println(name + " instantiated");
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

    }
}
