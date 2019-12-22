package factory;

import com.eric.tank.Direction;
import com.eric.tank.Group;
import com.eric.tank.TankFrame;

public class PixelStyleFactory extends AbstractFactory {
    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new PixelStyleExplode(x,y,tf);
    }

    @Override
    public BaseTank createTank(int x,int y,Direction dir,TankFrame tf,Group group) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return new PixelStyleTank(x,y,dir,tf,group);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Direction dir, boolean live, TankFrame tf, Group group) {
        return new PixelStyleBullet(x,y,dir,live,tf,group);
    }
}
