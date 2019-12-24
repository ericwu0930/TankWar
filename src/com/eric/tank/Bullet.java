package com.eric.tank;

import java.awt.*;

public class Bullet extends GameObjects{
    private static final int SPEED=20;
    private static final ResourceMgr res=ResourceMgr.INSTANCE;
    private int WIDTH=res.bulletD.getWidth();
    private int HEIGHT=res.bulletD.getHeight();

    public Rectangle getRect() {
        return rect;
    }

    public Group getGroup() {
        return group;
    }

    public Bullet() {
    }

    private Group group=Group.BAD;

    Rectangle rect=new Rectangle();

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    private boolean live=true;


    private Direction dir;

    public Bullet(int x, int y, Direction dir,boolean live,Group group) {
        this.x=x;
        this.y=y;

        this.dir = dir;
        this.live= live;
        this.group=group;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;

        GameModel.getINSTANCE().add(this);
    }

    public void paint(Graphics g){
        if(!live) {
            GameModel.getINSTANCE().remove(this);
        }else{
            switch(dir){
                case LEFT:
                    g.drawImage(res.bulletL,x,y,null);
                    break;
                case RIGHT:
                    g.drawImage(res.bulletR,x,y,null);
                    break;
                case UP:
                    g.drawImage(res.bulletU,x,y,null);
                    break;
                case DOWN:
                    g.drawImage(res.bulletD,x,y,null);
                    break;
            }
            move();
        }
    }

    public void move(){
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
        rect.x=x;
        rect.y=y;
        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT){
            live=false;
        }
    }

    public void die() {
        this.live=false;
    }
}
