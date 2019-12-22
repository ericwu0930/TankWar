package factory;

import com.eric.tank.*;

public class DefaultFactory extends AbstractFactory {
    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x,y,tf);
    }

    @Override
    public BaseTank createTank(int x, int y, Direction dir, TankFrame tf, Group group) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return new Tank(x,y,dir,tf,group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction dir, boolean live, TankFrame tf, Group group) {
        return new Bullet(x,y,dir,live,tf,group);
    }
}
