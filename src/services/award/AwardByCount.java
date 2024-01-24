package services.award;

import interfaces.IAwardPolicy;
import models.Basket;

public class AwardByCount implements IAwardPolicy {
    private final int perItem = 1;

    @Override
    public int getPoints(Basket basket) {
        return basket.getItems().size() * perItem;
    }

}
