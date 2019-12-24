package test;

import com.eric.tank.GameModel;
import com.eric.tank.PropertyMgr;
import org.junit.Test;

public class PropertiesTest {
    @Test
    public void loadTest(){
        String[] strArray=PropertyMgr.get("collidors").split(",");
        //for(String i:strArray)
          //  Class.forName(i).getDeclaredConstructor(GameModel.class).newInstance();
    }
}
