package services;

import java.util.ArrayList;

import catalogs.PaymentMethods;
import catalogs.ShippingMethods;
import helper.ConfigManager;
import interfaces.IPayment;
import interfaces.IShipping;

public class ServiceFactory extends AbstractFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory() {
        super();
    }

    public static ServiceFactory getInstance() {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactory();
        }
        return serviceFactory;
    }

    public PaymentMethods getPaymentMethods() {
        ArrayList<String> names = ConfigManager.getInstance().interfaces(IPayment.class.getName());
        ArrayList<IPayment> iPayments = new ArrayList<>(0);
        for (String name : names) {
            IPayment i;
            try {
                i = (IPayment) getAdapter(Class.forName(name));
                iPayments.add(i);
            } catch (ClassNotFoundException e) {

                e.printStackTrace();
            }
        }

        PaymentMethods paymentMethods = new PaymentMethods(iPayments);
        return paymentMethods;
    }

    public ShippingMethods getShippingMethods() {
        ArrayList<String> names = ConfigManager.getInstance().interfaces(IShipping.class.getName());
        ArrayList<IShipping> isl = new ArrayList<>(0);
        for (String name : names) {
            IShipping i;
            try {
                i = (IShipping) getAdapter(Class.forName(name));
                isl.add(i);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ShippingMethods shippingMethods = new ShippingMethods(isl);
        return shippingMethods;
    }

}
