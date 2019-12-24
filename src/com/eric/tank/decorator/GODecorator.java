package com.eric.tank.decorator;

import com.eric.tank.GameObjects;

import java.awt.*;

public abstract class GODecorator extends GameObjects {
    GameObjects go;

    public GODecorator(GameObjects go) {
        this.go = go;
    }


    @Override
    public void paint(Graphics g) {
        go.paint(g);
    }
}
