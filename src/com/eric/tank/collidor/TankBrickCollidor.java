package com.eric.tank.collidor;

import com.eric.tank.Brick;
import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;
import com.eric.tank.Tank;

public class TankBrickCollidor implements Collidor {

    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        if(o1 instanceof Tank &&o2 instanceof Brick){
            Tank t=(Tank)o1;
            Brick b=(Brick)o2;
            if(t==GameModel.getINSTANCE().getMyTank())
                return false;
            if(t.getRect().intersects(b.getRect())){
                t.back();
            }
        }else if(o1 instanceof Brick&&o2 instanceof Tank)
            collide(o2,o1);
        return false;
    }
}
