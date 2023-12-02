package interfaces;

/**
 * IBankGateway
 * Interface representing any banks that system is connected to.
 */
public interface IBankGateway extends IPayment {

    /**
     * Call this method to contact the bank gateway for a payment with
     * {@code amount }
     * 
     * @param amount payment amount
     */

    public void requestTransaction(Double amount);

    /**
     * Returns the full name of bank.
     * 
     * @return name of bank
     */
    public String getName();
}
