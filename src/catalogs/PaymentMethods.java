package catalogs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import interfaces.IPayment;

/**
 * Banks
 * Catalog of available banks that can be used for payments.
 */
public class PaymentMethods {

    private HashMap<String, IPayment> mBankGateways = new HashMap<>();

    public PaymentMethods(ArrayList<IPayment> iPayments) {
        mBankGateways.clear();
        for (IPayment iPayment : iPayments) {
            mBankGateways.put(iPayment.getName(), iPayment);
        }
    }

    public Iterator<String> getNames() {
        return mBankGateways.keySet().iterator();
    }
}
