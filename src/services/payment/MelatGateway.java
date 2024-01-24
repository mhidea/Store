package services.payment;

import interfaces.IBankGateway;

public class MelatGateway implements IBankGateway {

    public MelatGateway(String token) {
        super();
    }

    @Override
    public void requestTransaction(Double amount) {

        throw new UnsupportedOperationException("Unimplemented method 'requestTransaction'");
    }

    @Override
    public String getName() {

        return "Melli Bank";
    }

    @Override
    public void setAmount() {

        throw new UnsupportedOperationException("Unimplemented method 'setAmount'");
    }

    @Override
    public double getAmount() {

        throw new UnsupportedOperationException("Unimplemented method 'getAmount'");
    }
}
