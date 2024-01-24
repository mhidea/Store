package interfaces;

import java.sql.Date;

/**
 * IShipping
 * interface representing any shipping method that system is connected to.
 */
public interface IShipping {
    /**
     * Returns cost of this shipping method.
     * 
     * @return const of shipping
     */
    public double getCost();

    /**
     * Sets the start {@code Date} of shipping method.
     * 
     * @param date
     */
    public void setStartDate(Date date);

    /**
     * Returns the date at which the item is delivered.
     * 
     * @return delivered date.
     */

    /**
     * Returns the start date of delivery process.
     * 
     * @return start date
     */
    public Date getStartDate();

    /**
     * Returns the end date of delivery process.
     * 
     * @return end date
     */
    public Date getEndDate();

    public String getName();
}
