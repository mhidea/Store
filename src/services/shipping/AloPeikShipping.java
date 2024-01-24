package services.shipping;

import java.sql.Date;

import interfaces.IShipping;

public class AloPeikShipping implements IShipping {

    @Override
    public double getCost() {

        return 0;
    }

    @Override
    public Date getEndDate() {

        return null;
    }

    @Override
    public Date getStartDate() {

        return null;
    }

    @Override
    public void setStartDate(Date date) {

    }

    @Override
    public String getName() {
        return "aloPeik";
    }

}
