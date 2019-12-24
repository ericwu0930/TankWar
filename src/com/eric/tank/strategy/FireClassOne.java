package com.eric.tank;

public class FireClassOne implements FireBehaviour{

    @Override
    public void fire(Tank t) {
        int positionX = 0;
        int positionY = 0;
        Bullet tmpB=new Bullet();
        switch (t.getDir()) {
            case LEFT:
                positionX = t.getX();
                positionY = t.getY() + t.getHEIGHT() / 2 - tmpB.getHEIGHT() / 4;
                break;
            case RIGHT:
                positionX = t.getX() + t.getWIDTH();
                positionY = t.getY() + t.getHEIGHT() / 2 - tmpB.getHEIGHT() / 4;
                break;
            case UP:
                positionX = t.getX() + t.getWIDTH() / 2 - tmpB.getWIDTH() / 2;
                positionY = t.getY() ;
                break;
            case DOWN:
                positionX = t.getX() + t.getWIDTH() / 2 - tmpB.getWIDTH() / 2;
                positionY = t.getY() + t.getHEIGHT();
                break;
        }
        new Bullet(positionX,positionY,t.getDir(),true,t.getTf(),t.getGroup());
    }
}
