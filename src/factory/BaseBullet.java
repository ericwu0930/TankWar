package factory;

import com.eric.tank.Tank;

import java.awt.*;

public abstract class BaseBullet {
    public abstract void paint (Graphics g);

    public abstract void collideWith(BaseTank tank);
}
