package catalogs;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import interfaces.IPayment;

/**
 * Banks
 * Catalog of available banks that can be used for payments.
 */
public class PaymentMethods {

    private LinkedHashMap<String, IPayment> mBankGateways = new LinkedHashMap<>();

    public PaymentMethods(ArrayList<IPayment> iPayments) {
        mBankGateways.clear();
        for (IPayment iPayment : iPayments) {
            mBankGateways.put(iPayment.getName(), iPayment);
        }
    }

    public Iterator<String> getNames() {
        return mBankGateways.keySet().iterator();
    }

    public IPayment getMethod(String name) {
        return mBankGateways.get(name);
    }
}
