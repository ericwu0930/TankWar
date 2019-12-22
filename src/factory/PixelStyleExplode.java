package factory;

import com.eric.tank.ResourceMgr;
import com.eric.tank.TankFrame;

import java.awt.*;

public class PixelStyleExplode extends BaseExplode {
    public static ResourceMgr res=ResourceMgr.INSTANCE;
    public static int WIDTH=res.explodes[0].getWidth();
    public static int HEIGHT=res.explodes[0].getHeight();
    private int x,y;
    private int step=0;
    TankFrame tf=null;

    public PixelStyleExplode(int x, int y,TankFrame tf ) {
        this.x = x;
        this.y = y;
        this.step = step;
        this.tf=tf;
    }

    public void paint(Graphics g){
        Color c=g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*step,10*step);
        step++;
        g.setColor(c);
        if(step>=15)
            tf.explodes.remove(this);
    }
}
