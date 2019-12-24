package com.eric.tank;

import java.awt.*;

public class Brick extends GameObjects {
    int w,h;
    public Rectangle rect;
    public Brick(int x,int y,int w,int h){
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;

        this.rect=new Rectangle(x,y,w,h);
    }


    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void paint(Graphics g) {
        Color c=g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x,y,w,h);
        g.setColor(c);
    }

    @Override
    public int getWIDTH() {
        return w;
    }

    @Override
    public int getHEIGHT() {
        return h;
    }
}
