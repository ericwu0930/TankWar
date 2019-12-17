package test;

import org.junit.Test;

import java.awt.image.BufferedImage;
import java.io.File;

public class ImageTest {
    @Test
    public void test(){
        BufferedImage image = null;
        File f=new File(ImageTest.class.getClassLoader().getResource("images/").getPath());
        System.out.println(f);
    }
}
