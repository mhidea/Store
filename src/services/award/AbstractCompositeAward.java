package services.award;

import java.util.Collection;

import interfaces.IAwardPolicy;

public abstract class AbstractCompositeAward implements IAwardPolicy {
    protected Collection<IAwardPolicy> polices;

    public void addAward(IAwardPolicy awardPolicy) {
        polices.add(awardPolicy);
    }
}
