package services.payment;

import interfaces.IBankGateway;

public class MelatGateway implements IBankGateway {

    @Override
    public void requestTransaction(Double amount) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'requestTransaction'");
    }

    @Override
    public String getName() {

        return "Melli Bank";
    }

    @Override
    public void setAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
    }

    @Override
    public double getAmount() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }
}
