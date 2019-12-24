package com.eric.tank.decorator;

import com.eric.tank.GameModel;
import com.eric.tank.GameObjects;

import java.awt.*;

import static java.awt.image.ImageObserver.HEIGHT;

public class RectDecorator extends GODecorator {
    public RectDecorator(GameObjects go) {
        super(go);
        GameModel.getINSTANCE().add(this);
    }

    @Override
    public int getWIDTH() {
        return go.getWIDTH();
    }

    @Override
    public int getHEIGHT() {
        return go.getHEIGHT();
    }

    @Override
    public void paint(Graphics g) {
//        super.paint(g);
        Color c=g.getColor();
        g.setColor(Color.YELLOW);
        g.drawRect(go.getX(),go.getY(),go.getWIDTH(),go.getHEIGHT());
        g.setColor(c);
    }
}
