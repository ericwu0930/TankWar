package com.eric.tank;

import java.awt.*;

public class Explode extends GameObjects{
    public static ResourceMgr res=ResourceMgr.INSTANCE;
    private int WIDTH=res.explodes[0].getWidth();
    private int HEIGHT=res.explodes[0].getHeight();

    public Explode() {
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    private int step=0;

    public Explode(int x, int y ) {
        this.x=x;
        this.y=y;
        this.step = step;
        GameModel.getINSTANCE().add(this);
    }

    public void paint(Graphics g){
        g.drawImage(res.explodes[step++],x,y,null);
        if(step>=res.explodes.length)
            GameModel.getINSTANCE().remove(this);
    }
}
