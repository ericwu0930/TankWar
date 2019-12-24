package com.eric.tank.collidor;

import com.eric.tank.Brick;
import com.eric.tank.Bullet;
import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;

public class BulletBrickCollidor implements Collidor {


    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        if(o1 instanceof Brick&&o2 instanceof Bullet){
            Brick b1=(Brick) o1;
            Bullet b2=(Bullet) o2;
            if (b1.getRect().intersects(b2.getRect())){
                b2.die();
            }
        }else if(o2 instanceof Brick&&o1 instanceof Bullet)
            collide(o2,o1);
        return false;
    }
}
