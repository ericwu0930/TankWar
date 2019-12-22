package com.eric.tank;

import factory.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;

public class TankFrame extends Frame {
    public List<BaseBullet> bullets=new LinkedList<>();
    public List<BaseTank> tanks=new LinkedList<>();
    public List<BaseExplode> explodes=new LinkedList<>();
    public AbstractFactory factory=(AbstractFactory) Class.forName(PropertyMgr.get("theme")).newInstance();
    public static final int GAME_WIDTH=1000,GAME_HEIGHT=900;
    BaseTank myTank=factory.createTank(GAME_WIDTH/2,GAME_HEIGHT/2,Direction.DOWN,this,Group.GOOD);



    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if(offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
        for(int i=0;i<bullets.size();++i){
            bullets.get(i).paint(g);
        }
        for(int i=0;i<tanks.size();++i){
            tanks.get(i).paint(g);
        }
        for(int i=0;i<bullets.size();i++){
            for(int j=0;j<tanks.size();j++){
                bullets.get(i).collideWith(tanks.get(j));
            }
        }
        for(int i=0;i<explodes.size();++i){
            explodes.get(i).paint(g);
        }
        System.out.println(bullets.size());
    }

    public TankFrame() throws HeadlessException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        setSize(GAME_WIDTH,GAME_HEIGHT);
        setResizable(false);
        setTitle("tank war");;
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        addKeyListener(new MyKeyListener());

    }

    class MyKeyListener extends KeyAdapter{
        boolean bL;
        boolean bU;
        boolean bR;
        boolean bD;

        @Override
        public void keyReleased(KeyEvent e) {
            int key=e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=false;
                    break;
                case KeyEvent.VK_UP:
                    bU=false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=false;
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int key=e.getKeyCode();
            switch(key){
                case KeyEvent.VK_LEFT:
                    bL=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR=true;
                    break;
                case KeyEvent.VK_UP:
                    bU=true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD=true;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
            }
            setMainTankDir();
        }

        public void setMainTankDir(){
            if(!bL && !bU && !bR && !bD)
                myTank.setMoving(false);
            else{
                myTank.setMoving(true);
                if(bL) myTank.setDir(Direction.LEFT);
                if(bR) myTank.setDir(Direction.RIGHT);
                if(bU) myTank.setDir(Direction.UP);
                if(bD) myTank.setDir(Direction.DOWN);
            }
        }
    }
}
