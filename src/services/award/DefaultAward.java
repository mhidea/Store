package services.award;

import interfaces.IAwardPolicy;
import models.Basket;

public class DefaultAward implements IAwardPolicy {
    private final int defaultAward = 5;

    @Override
    public int getPoints(Basket basket) {
        return defaultAward;
    }

}
