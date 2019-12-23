package com.eric.tank;

import com.eric.tank.strategy.FireBehaviour;

import java.awt.*;
import java.util.Random;

public class Tank extends GameObjects{
    private int x, y;
    private int oldX,oldY;
    private Direction dir = Direction.DOWN;
    private boolean live = true;
    private Random random = new Random();
    Rectangle rect = new Rectangle();
    private long liveTime;
    private FireBehaviour fire = null;

    public Group getGroup() {
        return group;
    }

    private Group group = Group.BAD;

    GameModel gm;

    private static final int SPEED = 5;
    private boolean moving = true;
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

    public Tank(int x, int y, Direction dir, GameModel gm,Group group ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

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

    public Rectangle getRect() {
        return rect;
    }

    public void move() {
        if (!moving)
            return;
        oldX=x;
        oldY=y;
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

    public void paint(Graphics g) {
        if (!live) {
            gm.remove(this);
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

    public GameModel getGameModel() {
        return gm;
    }

    public void fire() {
        fire.fire(this);
    }

    public void die() {
        live = false;
    }

    //TODO:反方向
    public void stop(){
        x=oldX;
        y=oldY;
    }
}
