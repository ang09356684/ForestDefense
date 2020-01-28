/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import controllers.SceneController;
import gameobject.ButtonRec;
import gameobject.ButtonRec.ButtonListener;
import io.CommandSolver;
import io.CommandSolver.KeyCommandListener;
import io.CommandSolver.MouseCommandListener;
import io.CommandSolver.MouseState;
import util.Global;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author user
 */
public class TitleScene extends Scene {
    private KeyCommandListener keyCommandListener;
    private MouseCommandListener mouseCommandListener;
    private ButtonRec button1;
    private ButtonRec button2;
    private ButtonRec button3;
    private BufferedImage img;
    private MusicPlay titleBgm;
    private float nowsize;
    public TitleScene(SceneController sceneController) {
        super(sceneController);
        nowsize = Global.MY_RATIO;
        mouseCommandListener = new MouseCommandListener(){
            @Override
            public void mouseTrig(MouseEvent e, MouseState state, long trigTime) {
                if(state == MouseState.PRESSED){
                    if(button1.isCollision(e.getX(), e.getY())){
                        button1.click(e.getX(), e.getY());
                    }
                    if(button2.isCollision(e.getX(), e.getY())){
                        button2.click(e.getX(), e.getY());
                    }
                    if(button3.isCollision(e.getX(), e.getY())){
                        button3.click(e.getX(), e.getY());
                    }                    
                }
                if(state == MouseState.MOVED){
                    if(button1.isCollision(e.getX(), e.getY())){
                        button1.hover(e.getX(), e.getY());
                    }
                    if(button2.isCollision(e.getX(), e.getY())){
                        button2.hover(e.getX(), e.getY());
                    }
                    if(button3.isCollision(e.getX(), e.getY())){
                        button3.hover(e.getX(), e.getY());
                    }
                }
            }
        };
    }

    @Override
    public void sceneBegin() {
//暫時先設置title前兩個功能
        reset();
        titleBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.TITLE));
        titleBgm.loop();
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.TITLESENCE));

    }

    @Override
    public void sceneUpdate() {
        if(nowsize != Global.MY_RATIO){
            nowsize = Global.MY_RATIO;
            reset();
        }
    }

    @Override
    public void sceneEnd() {
        titleBgm.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, (int)(Global.PANEL_X * Global.MY_RATIO) ,(int)(Global.PANEL_Y * Global.MY_RATIO), null);//畫背景

    }
    
    public void reset(){
        button1 = new ButtonRec((int)(131.25*Global.MY_RATIO),(int)(105*Global.MY_RATIO),(int)(61.25*Global.MY_RATIO),(int)(10*Global.MY_RATIO));
        button2 = new ButtonRec((int)(141.25*Global.MY_RATIO),(int)(123.25*Global.MY_RATIO),(int)(40.75*Global.MY_RATIO),(int)(10*Global.MY_RATIO)); 
        button3 = new ButtonRec((int)(145.5*Global.MY_RATIO),(int)(141.5*Global.MY_RATIO),(int)(32.75*Global.MY_RATIO),(int)(10*Global.MY_RATIO)); 
                //button setting
        button1.setButtonListener(new ButtonListener(){
            
            @Override            
            public void onClick(int x, int y) {
                //System.out.println(x + " " +y);
                 sceneEnd();
                 sceneController.changeScene(new TutorialScene(sceneController));
                // 切換到教學模式 場景                
            }

            @Override
            public void hover(int x, int y) {//還沒決定是否要選取特效
            }
        }
        );

        button2.setButtonListener(new ButtonListener(){
            @Override
            public void onClick(int x, int y) {
                // 切換到戰鬥模式 場景
                sceneEnd();
                sceneController.changeScene(new BattleScene(sceneController));
            }

            @Override
            public void hover(int x, int y) {//還沒決定是否要選取特效
            }
        }
        );
        
        button3.setButtonListener(new ButtonListener(){
            @Override
            public void onClick(int x, int y) {
                // 切換到上次存檔 場景
            	// 先切到shop
                sceneEnd(); 
                sceneController.changeScene(new RankScene(sceneController));
            }

            @Override
            public void hover(int x, int y) {
            }
        }
        ); 
    }
    @Override
    public KeyCommandListener getKeyCommandListener(){return keyCommandListener;}
    @Override
    public MouseCommandListener getMouseCommandListener(){return mouseCommandListener;}
}
