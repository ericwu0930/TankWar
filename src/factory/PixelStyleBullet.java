package factory;

import com.eric.tank.*;

import java.awt.*;

public class PixelStyleBullet extends BaseBullet {
    private static final int SPEED=20;
    private static final int WIDTH=10;
    private static final int HEIGHT=10;
    private Group group=Group.BAD;

    Rectangle rect=new Rectangle();

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    private boolean live=true;
    private TankFrame tf=null;

    private int x,y;
    private Direction dir;

    public PixelStyleBullet(int x, int y, Direction dir,boolean live, TankFrame tf,Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.live= live;
        this.tf=tf;
        this.group=group;

        rect.x=this.x;
        rect.y=this.y;
        rect.width=WIDTH;
        rect.height=HEIGHT;

        tf.bullets.add(this);
    }

    @Override
    public void paint(Graphics g){
        if(!live) {
            tf.bullets.remove(this);
        }else{
            Color c=g.getColor();
            g.setColor(Color.WHITE);
            g.fillRect(x,y,WIDTH,HEIGHT);
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
    //TODO:坦克之间可以碾压
    public void collideWith(BaseTank tank) {
        if(this.group== tank.getGroup()) return;
        Rectangle rect1=this.rect;
        Rectangle rect2=tank.getRect();
        if(rect1.intersects(rect2)){
            tank.die();
            this.die();
            tf.explodes.add(tf.factory.createExplode(tank.getX()+Tank.getWIDTH()/2-Explode.WIDTH/2,tank.getY()+Tank.getHEIGHT()/2-Explode.HEIGHT/2,tf));
        }
    }

    private void die() {
        this.live=false;
    }
}
