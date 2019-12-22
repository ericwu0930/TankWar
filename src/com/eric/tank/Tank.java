package com.eric.tank;

import com.eric.tank.Direction;
import factory.BaseTank;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Random;

public class Tank extends BaseTank {
    private int x, y;
    private Direction dir = Direction.DOWN;
    private boolean live = true;
    private Random random = new Random();
    private Rectangle rect = new Rectangle();
    private long liveTime;
    private FireBehaviour fire = null;

    public Group getGroup() {
        return group;
    }

    private Group group = Group.BAD;

    private static final int SPEED = 5;
    private boolean moving = true;
    private TankFrame tf = null;
    private static ResourceMgr res = ResourceMgr.INSTANCE;
    private final static int WIDTH = res.goodTankU1.getWidth();
    private final static int HEIGHT = res.goodTankU1.getHeight();


    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Tank(int x, int y, Direction dir, TankFrame tf,Group group ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tf = tf;

        rect.x=this.x;
        rect.y=this.y;
        rect.height=this.HEIGHT;
        rect.width=this.WIDTH;

        if(group==Group.GOOD){
            fire=(FireBehaviour) Class.forName(PropertyMgr.get("goodFS")).newInstance();

        }else{
            fire=(FireBehaviour) Class.forName(PropertyMgr.get("badFS")).newInstance();
        }
    }


    public void setDir(Direction dir) {
        this.dir = dir;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void move() {
        if (!moving)
            return;
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }

        if (group == Group.BAD && random.nextInt(10) > 8)
            this.fire();
        if (group == Group.BAD && random.nextInt(100) > 90)
            randomDir();
        boundCheck();
        rect.x = x;
        rect.y = y;
    }

    private void boundCheck() {
        if (this.x < 0) x = 0;
        if (this.y < 30) y = 30;
        if (this.x > TankFrame.GAME_WIDTH - Tank.getWIDTH()) x = TankFrame.GAME_WIDTH - Tank.getWIDTH();
        if (this.y > TankFrame.GAME_HEIGHT - Tank.getHEIGHT()) y = TankFrame.GAME_HEIGHT - Tank.getHEIGHT();
    }

    private void randomDir() {
        this.dir = Direction.values()[random.nextInt(4)]; //values返回一个数组
    }

    @Override
    public Rectangle getRect() {
        return rect;
    }

    @Override
    public void paint(Graphics g) {
        if (!live) {
            tf.tanks.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                if (group == Group.GOOD) {
                    if (System.currentTimeMillis() - liveTime <= 2000) {
                        g.drawImage(res.goodTankL1, x, y, null);
                    } else {
                        g.drawImage(res.goodTankL2, x, y, null);
                        if (System.currentTimeMillis() - liveTime >= 4000)
                            liveTime = System.currentTimeMillis();
                    }
                } else {
                    g.drawImage(res.badTankL, x, y, null);
                }
                break;
            case RIGHT:
                if (group == Group.GOOD) {
                    if (System.currentTimeMillis() - liveTime <= 2000) {
                        g.drawImage(res.goodTankR1, x, y, null);
                    } else {
                        g.drawImage(res.goodTankR2, x, y, null);
                        if (System.currentTimeMillis() - liveTime >= 4000)
                            liveTime = System.currentTimeMillis();
                    }
                } else {
                    g.drawImage(res.badTankR, x, y, null);
                }
                break;
            case UP:
                if (group == Group.GOOD) {
                    if (System.currentTimeMillis() - liveTime <= 2000) {
                        g.drawImage(res.goodTankU1, x, y, null);
                    } else {
                        g.drawImage(res.goodTankU2, x, y, null);
                        if (System.currentTimeMillis() - liveTime >= 4000)
                            liveTime = System.currentTimeMillis();
                    }
                } else {
                    g.drawImage(res.badTankU, x, y, null);
                }
                break;
            case DOWN:
                if (group == Group.GOOD) {
                    if (System.currentTimeMillis() - liveTime <= 2000) {
                        g.drawImage(res.goodTankD1, x, y, null);
                    } else {
                        g.drawImage(res.goodTankD2, x, y, null);
                        if (System.currentTimeMillis() - liveTime >= 4000)
                            liveTime = System.currentTimeMillis();
                    }
                } else {
                    g.drawImage(res.badTankD, x, y, null);
                }
                break;
        }
        move();
    }

    public Direction getDir() {
        return dir;
    }

    public boolean isLive() {
        return live;
    }

    public TankFrame getTf() {
        return tf;
    }

    public void fire() {
        fire.fire(this);
    }

    public void die() {
        live = false;
    }
}
