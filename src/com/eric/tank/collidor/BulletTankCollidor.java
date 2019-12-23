package com.eric.tank.collidor;

import com.eric.tank.*;

import java.awt.*;

public class BulletTankCollidor implements Collidor {
    GameModel gm=null;

    public BulletTankCollidor(GameModel gm) {
        this.gm = gm;
    }

    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        if(o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b=(Bullet) o1;
            Tank t=(Tank) o2;
            Rectangle rect1=b.getRect();
            Rectangle rect2=t.getRect();
            if(t.getGroup()==b.getGroup())
                return false;
            if(rect1.intersects(rect2)){
                b.die();
                t.die();
                gm.add(new Explode(t.getX()+Tank.getWIDTH()/2-Explode.WIDTH/2,t.getY()+Tank.getHEIGHT()/2-Explode.HEIGHT/2,gm));
                return true;
            }
        }else if(o1 instanceof Tank&&o2 instanceof Bullet){
            collide(o2,o1);
        }
        return false;
    }
}
