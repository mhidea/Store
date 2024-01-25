package interfaces;

public interface IPayment {

    public void setAmount();

    public double getAmount();

    /**
     * Returns the full name of payment method.
     * 
     * @return name of payment method.
     */
    public String getName();

}
