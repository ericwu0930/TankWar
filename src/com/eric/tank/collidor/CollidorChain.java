package com.eric.tank.collidor;

import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;

import java.util.LinkedList;
import java.util.List;

public class CollidorChain implements Collidor {
    private List<Collidor> collidors=new LinkedList<>();
    private GameModel gm;

    public CollidorChain(GameModel gm){
        add(new BulletTankCollidor(gm));
        add(new TankTankCollidor(gm));

        this.gm=gm;
    }

    public void add(Collidor c){
        collidors.add(c);
    }
    @Override
    public boolean collide(GameObjects o1, GameObjects o2) {
        for(int i=0;i<collidors.size();++i){
            if(collidors.get(i).collide(o1,o2))
                return true;
        }
        return false;
    }
}
