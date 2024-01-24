package services.payment;

import interfaces.IPayment;

public class CashPayment implements IPayment {

    @Override
    public void setAmount() {
        throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
    }

    @Override
    public double getAmount() {
        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }

    @Override
    public String getName() {
        return "Cache";
    }

}
