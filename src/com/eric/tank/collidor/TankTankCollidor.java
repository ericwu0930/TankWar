package com.eric.tank.collidor;

import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;
import com.eric.tank.Tank;
import com.eric.tank.collidor.Collidor;

public class TankTankCollidor implements Collidor {
    GameModel gm=null;
    public TankTankCollidor(GameModel gm) {
        this.gm=gm;
    }

    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        if(o1 instanceof Tank &&o2 instanceof Tank){
            Tank t1=(Tank) o1;
            Tank t2=(Tank) o2;
            if(t1.getRect().intersects(t2.getRect())){
                t1.stop();
                t2.stop();
            }
        }
        return false;
    }
}
