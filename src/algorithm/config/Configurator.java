package algorithm.config;

import algorithm.config.bounds.IBranching;
import algorithm.config.bounds.ILBound;
import algorithm.config.bounds.IUBound;

public class Configurator {
    private ILBound lBound;
    private IUBound[] uBound;
    private IBranching branching;

    public Configurator(ILBound lBound, IUBound[] uBound, IBranching branching)
    {
        this.lBound = lBound;
        this.uBound = uBound;
        this.branching = branching;
    }

    public ILBound getlBound() {
        return lBound;
    }

    public IUBound[] getuBound() {
        return uBound;
    }

    public IBranching getBranching() {
        return branching;
    }
}
