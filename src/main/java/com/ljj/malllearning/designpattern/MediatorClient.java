package com.ljj.malllearning.designpattern;

/**
 * @author ljj
 * @date 2021/1/11
 */
public class MediatorClient {
    public static void main(String[] args) {

        Mediator mediator = new Mediator();
        LandLord landLord = new LandLord(mediator);
        landLord.setPrice(1000);

        Tenant tenant = new Tenant(mediator);
        tenant.setPrice(1200);

        mediator.setLandLord(landLord);
        mediator.setTenant(tenant);
        tenant.rent();

    }
}
