package services.award;

import models.Basket;

public class MinAward extends AbstractCompositeAward {
    public MinAward() {
        polices.add(new DefaultAward());
        polices.add(new AwardByCount());
        polices.add(new AwardByTotal());
    }

    @Override
    public int getPoints(Basket basket) {
        return polices.stream().reduce(0, (a, b) -> Math.min(a, b.getPoints(basket)), null);
    }
}
