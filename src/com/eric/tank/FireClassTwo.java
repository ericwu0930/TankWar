package com.eric.tank;

public class FireClassTwo implements FireBehaviour {

    @Override
    public void fire(Tank t) {
        Direction dirs[]=Direction.values();
        for(Direction i:dirs){
            new Bullet(t.getX()+Tank.getWIDTH()/2,t.getY()+Tank.getHEIGHT()/2,i,true,t.getTf(),t.getGroup());
        }
    }
}
