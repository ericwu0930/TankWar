package com.eric.tank;

import java.io.IOException;

public class Main  {
    public static void main(String[] args) throws InterruptedException, IOException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        TankFrame tf=new TankFrame();

        int initTankCount= Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //初始化敌方坦克
        for(int i=0;i<initTankCount;i++){
            tf.tanks.add(new Tank(50+i*30,200,Direction.DOWN,tf,Group.BAD));
        }
        while(true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
