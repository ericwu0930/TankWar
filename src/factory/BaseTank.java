package factory;


import com.eric.tank.Direction;
import com.eric.tank.Group;
import com.eric.tank.TankFrame;

import java.awt.*;

public abstract class BaseTank {
    public abstract void paint(Graphics g);

    public abstract Group getGroup();

    public abstract Rectangle getRect();

    public abstract void die();

    public abstract int getX();

    public abstract int getY();

    public abstract void fire();

    public abstract void setMoving(boolean b);

    public abstract void setDir(Direction left);

    public abstract Direction getDir();

    public abstract TankFrame getTf();
}
