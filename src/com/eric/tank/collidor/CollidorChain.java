package com.eric.tank.collidor;

import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;
import com.eric.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

public class CollidorChain implements Collidor {
    private List<Collidor> collidors=new LinkedList<>();

    public CollidorChain() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String[] strArray=PropertyMgr.get("collidors").split(",");
        for(String i:strArray){
            add((Collidor) Class.forName(i).getDeclaredConstructor().newInstance());
        }
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
