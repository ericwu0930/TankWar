package com.eric.tank;

import factory.BaseExplode;

import java.awt.*;

public class Explode extends BaseExplode {
    public static ResourceMgr res=ResourceMgr.INSTANCE;
    public static int WIDTH=res.explodes[0].getWidth();
    public static int HEIGHT=res.explodes[0].getHeight();
    private int x,y;
    private int step=0;
    TankFrame tf=null;

    public Explode(int x, int y,TankFrame tf ) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.tf=tf;
    }
    @Override
    public void paint(Graphics g){
        g.drawImage(res.explodes[step++],x,y,null);
        if(step>=res.explodes.length)
            tf.explodes.remove(this);
    }
}
