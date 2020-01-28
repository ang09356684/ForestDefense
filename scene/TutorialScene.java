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
import enemy.Enemy;
import enemy.EnemyFactory;
import gameobject.Arrow;
import gameobject.Bow;
import gameobject.Bullet;
import gameobject.ButtonRec;
import gameobject.Cannon;
import gameobject.EffectObject;
import enemy.Enemy;
import enemy.EnemyFactory;
import gameobject.BackStory;
import gameobject.Circle;
import gameobject.TextArea;
import io.CommandSolver;

import static util.Global.MY_RATIO;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import magic.Fire;
import magic.Ice;
import magic.Magic;
import magic.MagicRange;
import magic.Wind;
import util.DelayCounter;
import util.Global;
import util.Timer;
import util.WallHpCounter;


public class TutorialScene extends Scene{

    private CommandSolver.KeyCommandListener keyCommandListener;
    private CommandSolver.MouseCommandListener mouseCommandListener;
    
    private BackStory backStory;
    
    private Bow bow;
    private ArrayList<Arrow> arrows;
    private int mx;
    private int my;
    private EnemyFactory ef;
    private DelayCounter enemyCounter;
    private ArrayList<Enemy> enemyList;
    private BufferedImage img;
    private BufferedImage skillBar;
    
    
    private Cannon cannon;
    private BufferedImage cannonButtonImg;
    private ButtonRec cannonButton;
    
    private Point magicPoint;
    private Point unitPoint;
    
    private BufferedImage iceButtonImg;
    private ButtonRec iceButton;
    private BufferedImage windButtonImg;
    private ButtonRec windButton;
    private BufferedImage fireButtonImg;

    private ButtonRec fireButton;
    private Magic currentMagic;
    private int courretStep;
    private TextArea stepText ;
    private TextArea infoText;
    private BufferedImage textBoard;
    private BufferedImage mouse;
    private BufferedImage next;    
    private ButtonRec nextButton;
    private int step;
    private BufferedImage fence;
    
    private ButtonRec storyButton;
    private MusicPlay tutorialBgm;
    private Circle circle;
    private MusicPlay arrowSound;
    
    public TutorialScene(SceneController sceneController) {
        super(sceneController);
        mouseCommandListener = new CommandSolver.MouseCommandListener() {
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
                if (state == CommandSolver.MouseState.MOVED) {
                    bow.changeAngle(e.getX(), e.getY());
                    circle.changeAngle(e.getX(),e.getY());
                    mx = e.getX();
                    my = e.getY();
                }
                if (state == CommandSolver.MouseState.PRESSED) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        if(arrows.size()<1){
                        Arrow arrow = new Arrow(bow.getCenterX(), bow.getCenterY(), (int)(27.5 * Global.MY_RATIO), (int)(2.75 * Global.MY_RATIO), (int)Math.round(4.5* Global.MY_RATIO), e.getX(), e.getY());
                        arrows.add(arrow);
                        arrowSound.play(); 
                        }
                    }
                    if(step == 0){
                        if (storyButton.isCollision(e.getX(), e.getY())) {
                            storyButton.click(e.getX(), e.getY());
                        }
                    }
                    if (nextButton.isCollision(e.getX(), e.getY())) {
                        nextButton.click(e.getX(), e.getY());
                    }
                    //1-left, 2-wheel, 3-right
                    if (e.getButton() == MouseEvent.BUTTON3) {
                        //magic without setting effect range
                        if (iceButton.isCollision(e.getX(), e.getY())) {
                            iceButton.click(e.getX(), e.getY());
                        }
                    }
                }
                // use limit range magic
                if (state == CommandSolver.MouseState.DRAGGED) {
                    
                    if (currentMagic != null) {
                        if (currentMagic.getRange() != null) {
                            magicPoint = currentMagic.getRange().check(e.getX(), e.getY());
                        }
                        return;// 已經有一個當前在執行的 就不給點
                    }
                    
                    if (windButton.isCollision(e.getX(), e.getY())) {
                        currentMagic = new Wind((int)(36* Global.MY_RATIO), (int)(30* Global.MY_RATIO), (int)Math.round(1.25* Global.MY_RATIO), Global.windPower);//width,height,speed,power 
                        //將高度縮小以免碰到目標走道 上下的敵方
                    }

                    if (fireButton.isCollision(e.getX(), e.getY())) {
                        currentMagic = new Fire((int)(36* Global.MY_RATIO),(int)(30* Global.MY_RATIO), 0, Global.firePower);//width,height,speed,power
                    }
                    
                    
                    if(cannon != null){
                        if(cannon.getRange()!= null){
                            unitPoint = cannon.getRange().check(e.getX(), e.getY());
                        }
                    }
                    
                    if(cannonButton.isCollision(e.getX(), e.getY())){
                        cannon = new Cannon((int)(72* Global.MY_RATIO),(int)(48* Global.MY_RATIO), (int)(248* Global.MY_RATIO), (int)(108* Global.MY_RATIO),(int)Math.round(0.5* Global.MY_RATIO));
                    }
                }

                if (state == CommandSolver.MouseState.RELEASED) {
                    if (e.getButton() == MouseEvent.BUTTON3 && currentMagic != null && !currentMagic.isReady()) {
                        //現在有new出magic 但isReady = false(尚未設置施放座標)
                    	currentMagic.updatePos(magicPoint);
                        currentMagic.setReady(true);
                        currentMagic.playSound();
                    }
                    
                    if(e.getButton() == MouseEvent.BUTTON3 && cannon != null && !cannon.isReady()){
                        cannon.updatePos(unitPoint);
                        cannon.setReady(true);
                    }
                }
            }
        };
    }

    @Override
    public void sceneBegin() {        
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.BATTLESENCE));
        backStory = new BackStory();
        storyButton = new ButtonRec((int)(87.5* Global.MY_RATIO),0,(int)(175* Global.MY_RATIO),(int)(175* Global.MY_RATIO));
        tutorialBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.TUTORIAL));
        tutorialBgm.loop();
        arrowSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Attack.ARROW)); 
        storyButton.setButtonListener(new ButtonRec.ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                step++;
            }
            @Override
            public void hover(int x, int y) {
            }
        });        
        
        
        
        fence = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.FENCE));
        textBoard = irc.getImage(PathBuilder.getImg(ImagePath.Toturial.TEXTBOARD));
        mouse = irc.getImage(PathBuilder.getImg(ImagePath.Toturial.MOUSE));
        next = irc.getImage(PathBuilder.getImg(ImagePath.Toturial.NEXT));  
        nextButton = new ButtonRec((int)(237.5* Global.MY_RATIO), (int)(6.25* Global.MY_RATIO), (int)(70.25* Global.MY_RATIO), (int)(46.25* Global.MY_RATIO));
        bow = new Bow((int)(12.5* Global.MY_RATIO), (int)(95* Global.MY_RATIO), (int)(29* Global.MY_RATIO), (int)(22* Global.MY_RATIO), 0);
        circle = new Circle((int)(6.25* Global.MY_RATIO),(int)(86.25* Global.MY_RATIO),(int)(42.75* Global.MY_RATIO),(int)(42.75* Global.MY_RATIO),0);
        ef = new EnemyFactory();
        enemyCounter = new DelayCounter(4);
        enemyList = new ArrayList<>();
        arrows = new ArrayList<>();

        
        // teachSkill 
        skillBar = irc.getImage(PathBuilder.getImg(ImagePath.Skills.BAR));        
        iceButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.ICEBUTTON));
        windButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.WINDBUTTON));
        fireButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.FIREBUTTON));
        iceButton = new ButtonRec((int)(213.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        windButton = new ButtonRec((int)(243.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        fireButton = new ButtonRec((int)(273.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        
        cannonButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.OurUnit.CANNONBUTTON));
        cannonButton = new ButtonRec((int)(50* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));

        
        
        iceButton.setButtonListener(new ButtonRec.ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                if (currentMagic == null) {
                    currentMagic = new Ice((int)(72* Global.MY_RATIO), (int)(48* Global.MY_RATIO),(int)(248* Global.MY_RATIO), (int)(128* Global.MY_RATIO), 0, 30);//effect range
                }
            }
            @Override
            public void hover(int x, int y) {
            }
        });
        
        nextButton.setButtonListener(new ButtonRec.ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                step++;
                if(step > 3){
                    //sceneEnd(); title 可以Bgm = null 這邊不行?
                    tutorialBgm.stop();
                    sceneController.changeScene(new BattleScene(sceneController));
                }
            }
            @Override
            public void hover(int x, int y) {
            }
        });
        
    }
    
    @Override
    public void sceneUpdate() {
        if(step == 1){                       
            stepText = new TextArea((int)(225*MY_RATIO),(int)(62.5*MY_RATIO),(int)(7.5*MY_RATIO),"移動滑鼠瞄準");//(x,y,size,str)
            stepText.addContent("點擊左鍵發射弓箭").setInterval((int)(5*MY_RATIO));
            stepText.changeToBlod();
            backStory = null;
            storyButton = null;
        }else if(step == 2) {
            stepText = new TextArea((int)(225*MY_RATIO),(int)(55*MY_RATIO),(int)(5.75*MY_RATIO),"在下方技能欄位按下右鍵");//(x,y,size,str)
            stepText.addContent("冰 點擊釋放").setInterval((int)(3.25*MY_RATIO));
            stepText.addContent("       (全場-冰凍 無傷害)");
            stepText.addContent("風 右鍵拖曳 選擇範圍");
            stepText.addContent("       (單列-吹飛 少量傷害)");
            stepText.addContent("火 右鍵拖曳 選擇範圍");
            stepText.addContent("       (單格-灼燒 持續傷害)");
            stepText.changeToBlod();
        }else if(step == 3){
            stepText = new TextArea((int)(215*MY_RATIO),(int)(55*MY_RATIO),(int)(6.25*MY_RATIO),"在左下方援軍欄位按下右鍵");
            stepText.addContent("右鍵拖曳 選擇攻擊位置").changeToBlod().setInterval((int)(5*MY_RATIO));
            infoText = new TextArea((int)(225*MY_RATIO),(int)(85*MY_RATIO),(int)(6.25*MY_RATIO),"             最新戰報");
            infoText.addContent("前方發現敵方斥候部隊").setInterval((int)(2.5*MY_RATIO));
            infoText.addContent("請務必殲滅 準備迎擊").changeToBlod();
        }
    if(step >0){    
        if (currentMagic != null && currentMagic.isReady()) {
            currentMagic.updateNum();
            currentMagic.update();
        }
        
        if(cannon != null && cannon.isReady()){
            cannon.update();
        }
        

        for (int i = 0; i < arrows.size(); i++) {
            if (!arrows.get(i).move()) {
                arrows.remove(i);
            }
        }
        //step 1?
        if (enemyList.size() < 1 && enemyCounter.update() && (Math.random() > 0.5)) {
            Enemy newEnemy = ef.generateEnemy();
            enemyList.add(newEnemy);
        }
        for (int i = 0; i < enemyList.size(); i++) {
            Enemy tmp = enemyList.get(i);
            
                if (currentMagic != null) {
                    currentMagic.magicEffect(tmp);
                }

                if (!tmp.checkMagicDamage()) { 
                    enemyList.remove(i--);
                    continue;
                }
          
            
            if (!tmp.move()) {
                if ( tmp.attackWall() ) {
                    
                }
            }

            for (int j = 0; j < arrows.size(); j++) {
                if (tmp.isCollision(arrows.get(j))) {
                    arrows.remove(j);
                    tmp.moveBack();
                    if (!tmp.damage()) {
                        enemyList.remove(i);
                    }
                    break;
                }
            }
            
            //bullets
            if( cannon != null) {
                for (int j = 0; j < cannon.getBulletsSize(); j++) {	            
                    if( tmp.isCollision( cannon.getBullets().get(j))) {
                        cannon.getBullets().remove(j--);
                        if( !tmp.damage() ) { 
                            enemyList.remove(i--); //enemy 沒血 -> 消失
                        }
                        break;
                    }
                }
            }
        }
                
        if (currentMagic != null && currentMagic.isMagicDone()) {
            //magic 效果結束
            currentMagic = null;
        }
    }    
}

    @Override
    public void sceneEnd() { // 無法停止?
        tutorialBgm = null;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, (int)(Global.PANEL_X*Global.MY_RATIO), (int)(Global.PANEL_Y*Global.MY_RATIO), null);//畫背景
        if(step == 0){
            backStory.paint(g);
        }
        if(step >=1){
            g.drawImage(fence, (int)(7.5* Global.MY_RATIO), (int)(56.25* Global.MY_RATIO), (int)(67.25* Global.MY_RATIO), (int)(103.75* Global.MY_RATIO), null);//畫背景          
            g.drawImage(textBoard, (int)(175* Global.MY_RATIO), (int)(18.75* Global.MY_RATIO), (int)(125.5* Global.MY_RATIO), (int)(145.5* Global.MY_RATIO), null);
            g.drawImage(next,(int)(237.5* Global.MY_RATIO),(int)(6.25* Global.MY_RATIO),(int)(70.25* Global.MY_RATIO),(int)(46.25* Global.MY_RATIO),null);
            g.drawImage(mouse, (int)(180* Global.MY_RATIO), (int)(50* Global.MY_RATIO), (int)(46* Global.MY_RATIO),(int)(44.75* Global.MY_RATIO),null);
            circle.paint(g);
            stepText.paint(g);
            if(step>=3){ // 為了讓單位在弓箭下方 敵方在文字上面
                if(cannon != null){
                    if(cannon.isReady()){
                        cannon.paint(g);
                    }else if(cannon.getRange() != null){
                        cannon.getRange().paint(g);
                    }
                }
                infoText.paint(g);
            }
            bow.paint(g);
            for (int i = 0; i < arrows.size(); i++) {
                arrows.get(i).paint(g);
            }       
            
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).paint(g);
            }
        }    
    /////////// teach skill step2
        if(step >=2){
            g.drawImage(skillBar, (int)(3.25* Global.MY_RATIO), (int)(158* Global.MY_RATIO), (int)(310.25* Global.MY_RATIO),(int)(32* Global.MY_RATIO),null);
            g.drawImage(iceButtonImg, (int)(213.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
            g.drawImage(windButtonImg, (int)(243.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
            g.drawImage(fireButtonImg, (int)(273.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
            if (currentMagic != null) {
                if (currentMagic.isReady() && currentMagic.checkAnima()) {
                    currentMagic.paint(g);
                } else if (currentMagic.getRange() != null) {
                    currentMagic.getRange().paint(g);
                }
            }
        }
        if(step >= 3){
            g.drawImage(cannonButtonImg,(int)(50* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
        }
        
    }
    
    
    public CommandSolver.KeyCommandListener getKeyCommandListener() {
        return keyCommandListener;
    }
    public CommandSolver.MouseCommandListener getMouseCommandListener() {
        return mouseCommandListener;
    }   
}
