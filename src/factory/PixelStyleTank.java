package factory;

import com.eric.tank.*;

import java.awt.*;
import java.util.Random;

public class PixelStyleTank extends BaseTank {
    private int x, y;
    private Direction dir = Direction.DOWN;
    private boolean live = true;
    private Random random = new Random();
    private Rectangle rect = new Rectangle();

    @Override
    public Rectangle getRect() {
        return rect;
    }

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

    public PixelStyleTank(int x, int y, Direction dir, TankFrame tf,Group group ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
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
    public void paint(Graphics g) {
        if (!live) {
            tf.tanks.remove(this);
            return;
        }
        switch (dir) {
            case LEFT:
                g.drawImage(res.pixelTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(res.pixelTankR,x,y,null);
                break;
            case UP:
                g.drawImage(res.pixelTankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(res.pixelTankD,x,y,null);
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
