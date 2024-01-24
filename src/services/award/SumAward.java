package services.award;

import models.Basket;

public class SumAward extends AbstractCompositeAward {

    public SumAward() {
        polices.add(new DefaultAward());
        polices.add(new AwardByCount());
        polices.add(new AwardByTotal());
    }

    @Override
    public int getPoints(Basket basket) {
        Integer sum = 0;
        sum = polices.stream().reduce(sum, (a, b) -> a += b.getPoints(basket), null);
        return sum;
    }
}
