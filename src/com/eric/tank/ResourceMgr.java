package com.eric.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public enum ResourceMgr {
    INSTANCE;

    public BufferedImage goodTankL1, goodTankU1, goodTankR1, goodTankD1,goodTankL2, goodTankU2, goodTankR2, goodTankD2;
    public BufferedImage badTankL, badTankU, badTankR, badTankD;
    public BufferedImage bulletL,bulletU,bulletR,bulletD;
    public BufferedImage[] explodes=new BufferedImage[16];
    private ResourceMgr() {
        try {
            //TODO:坦克动态
            goodTankU1= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL1= ImageUtil.rotateImage(goodTankU1,-90);
            goodTankR1= ImageUtil.rotateImage(goodTankU1,90);
            goodTankD1= ImageUtil.rotateImage(goodTankU1,180);

            goodTankU2= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank2.png"));
            goodTankL2= ImageUtil.rotateImage(goodTankU2,-90);
            goodTankR2= ImageUtil.rotateImage(goodTankU2,90);
            goodTankD2= ImageUtil.rotateImage(goodTankU2,180);

            badTankU= ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL= ImageUtil.rotateImage(badTankU,-90);
            badTankR= ImageUtil.rotateImage(badTankU,90);
            badTankD= ImageUtil.rotateImage(badTankU,180);

            bulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));

            for(int i=0;i<16;++i){
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
