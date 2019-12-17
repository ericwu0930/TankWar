package com.eric.tank;

public class FireClassOne implements FireBehaviour{

    @Override
    public void fire(Tank t) {
        int positionX = 0;
        int positionY = 0;
        switch (t.getDir()) {
            case LEFT:
                positionX = t.getX();
                positionY = t.getY() + Tank.getHEIGHT() / 2 - Bullet.getHEIGHT() / 4;
                break;
            case RIGHT:
                positionX = t.getX() + Tank.getWIDTH();
                positionY = t.getY() + Tank.getHEIGHT() / 2 - Bullet.getHEIGHT() / 4;
                break;
            case UP:
                positionX = t.getX() + Tank.getWIDTH() / 2 - Bullet.getWIDTH() / 2;
                positionY = t.getY() ;
                break;
            case DOWN:
                positionX = t.getX() + Tank.getWIDTH() / 2 - Bullet.getWIDTH() / 2;
                positionY = t.getY() + Tank.getHEIGHT();
                break;
        }
        new Bullet(positionX,positionY,t.getDir(),true,t.getTf(),t.getGroup());
    }
}
