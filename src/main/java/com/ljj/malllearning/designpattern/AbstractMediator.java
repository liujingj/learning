package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public abstract class AbstractMediator {
    //房东
    protected LandLord landLord;
    //租客
    protected Tenant tenant;

    public LandLord getLandLord() {
        return landLord;
    }

    public void setLandLord(LandLord landLord) {
        this.landLord = landLord;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public abstract void execute();
}
