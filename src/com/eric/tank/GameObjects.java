package com.eric.tank;

import java.awt.*;

public abstract class GameObjects {
    protected int x,y;
    public abstract void paint(Graphics g);


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public abstract int getWIDTH();

    public abstract int getHEIGHT();
}
