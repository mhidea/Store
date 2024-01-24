package services.award;

import models.Basket;

public class MaxAward extends AbstractCompositeAward {
    public MaxAward() {
        polices.add(new DefaultAward());
        polices.add(new AwardByCount());
        polices.add(new AwardByTotal());

    }

    @Override
    public int getPoints(Basket basket) {
        return polices.stream().reduce(0, (a, b) -> Math.max(a, b.getPoints(basket)), null);
    }
}
