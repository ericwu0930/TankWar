package com.eric.tank;

import factory.BaseTank;

public class FireClassTwo implements FireBehaviour {

    @Override
    public void fire(BaseTank t) {
        Direction dirs[]=Direction.values();
        for(Direction i:dirs){
            t.getTf().factory.createBullet(t.getX()+Tank.getWIDTH()/2,t.getY()+Tank.getHEIGHT()/2,i,true,t.getTf(),t.getGroup());
        }
    }
}
