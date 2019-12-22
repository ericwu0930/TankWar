package factory;

import com.eric.tank.Direction;
import com.eric.tank.Group;
import com.eric.tank.TankFrame;

public abstract class AbstractFactory {

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);

    public abstract BaseTank createTank(int x, int y, Direction dir, TankFrame tf, Group group) throws IllegalAccessException, InstantiationException, ClassNotFoundException;

    public abstract BaseBullet createBullet(int x, int y, Direction dir, boolean live, TankFrame tf, Group group);
}
