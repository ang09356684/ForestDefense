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
import io.CommandSolver;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import util.Global;
import static util.Global.MY_RATIO;

/**
 *
 * @author user
 */
public class GameOver extends Scene{
    private CommandSolver.MouseCommandListener mouseCommandListener;
    private CommandSolver.KeyCommandListener keyCommandListener;    
    private BufferedImage img;
    private MusicPlay bgm;
    private ButtonRec button;
    private float nowsize;
    
    public GameOver(SceneController sceneController) {
        super(sceneController);
        nowsize = Global.MY_RATIO;
        mouseCommandListener = new CommandSolver.MouseCommandListener(){
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
                if(state == CommandSolver.MouseState.PRESSED){
                    if(button.isCollision(e.getX(), e.getY())){
                        button.click(e.getX(), e.getY());
                    }
                }
            }
        };        
    }

    @Override
    public void sceneBegin() {
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.GAME_OVER));
        bgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.GAMEOVER));
        bgm.loop();
        reset();
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
        bgm.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, (int)(320*MY_RATIO),(int)(192*MY_RATIO), null);//畫背景
    }
    
    public void reset(){
        button = new ButtonRec(0,0,(int)(320*MY_RATIO),(int)(192*MY_RATIO));    
        button.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 sceneEnd();
                 sceneController.changeScene(new TitleScene(sceneController));              
            }
            @Override
            public void hover(int x, int y) {//還沒決定是否要選取特效
                //System.out.println(x + " " +y);
            }
        }
        ); 
    }
            
    @Override
    public CommandSolver.KeyCommandListener getKeyCommandListener(){return keyCommandListener;}
    @Override
    public CommandSolver.MouseCommandListener getMouseCommandListener(){return mouseCommandListener;}    
}
