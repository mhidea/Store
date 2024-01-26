package services.award;

import interfaces.IAwardPolicy;
import models.Basket;

public class AwardByTotal implements IAwardPolicy {

    @Override
    public int getPoints(Basket basket) {
        return basket.getTotal() / 100;
    }

}
