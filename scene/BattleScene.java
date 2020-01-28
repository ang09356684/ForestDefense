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
import enemy.SoldiersFactory;
import forestdefense1.GameJpanel;
import gameobject.Arrow;
import gameobject.Bow;
import gameobject.ButtonRec;
import gameobject.EffectObject;

import gameobject.Cannon;
import gameobject.Circle;
import gameobject.LifeBar;

import gameobject.MoneyInfo;
import gameobject.TextArea;
import io.CommandSolver;
import io.CommandSolver.KeyCommandListener;
import io.CommandSolver.MouseCommandListener;

import static util.Global.ENEMY_LEFT;
import static util.Global.MY_RATIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


import magic.Fire;
import magic.Ice;
import magic.Magic;
import magic.MagicRange;
import magic.Wind;
import util.DelayCounter;
//import util.ExpCounter;
import util.Global;
import util.StageCounter;
import util.Timer;
import util.WallHpCounter;

/**
 *
 * @author user
 */
public class BattleScene extends Scene {

    private CommandSolver.KeyCommandListener keyCommandListener;
    private CommandSolver.MouseCommandListener mouseCommandListener;
    
    //arrow & bow--------------------------------------------------
    private Bow bow;
    private ArrayList<Arrow> arrows;
    private int mx;
    private int my;
    
    //enemy---------------------------------------------------------
    private EnemyFactory ef; 
    private DelayCounter enemyCounter;
    private ArrayList<Enemy> enemyList;
    private SoldiersFactory sf;
    private ArrayList<Enemy> soldiersList;
    private DelayCounter factoryCounter;
    
    private BufferedImage img; //battle scene Img
    private BufferedImage skillBar; //skill bar Img
    
    //資訊欄文字------------------------------------------------------
    private Timer timer;
    private WallHpCounter wallHpCounter;
    //private ExpCounter expCounter;
    private StageCounter stageCounter;
    private MoneyInfo money;
    private TextArea clearText;
    private TextArea nextInfo;
    
    //magic button
    private Point point;
    private BufferedImage iceButtonImg;
    private ButtonRec iceButton;
    private BufferedImage windButtonImg;
    private ButtonRec windButton;
    private BufferedImage fireButtonImg;
    private ButtonRec fireButton;
    private Magic currentMagic;
    private Magic ice; 
    private Magic wind;
    private Magic fire;
    private MagicRange windRange;
    private MagicRange fireRange;
    
    //canno button
    private Cannon cannon;
    private BufferedImage cannonButtonImg;
    private ButtonRec cannonButton;
    private Point unitPoint;

    private BufferedImage fence;
    private BufferedImage stageClearImg;
    private boolean clear;
    private ButtonRec nextButton;
    private ButtonRec cheatButton;
    private BufferedImage cheatImg;
    private MusicPlay battleBgm;
    private MusicPlay stageBgm;
    private MusicPlay clearBgm;
    private Circle circle;
    
    private boolean checkdel;
    private MusicPlay arrowSound;
    

    

//Battle Scene=======================================================================    
    public BattleScene(SceneController sceneController) {
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

                if(state == CommandSolver.MouseState.PRESSED){
                    if(e.getButton() == MouseEvent.BUTTON1){
                    	//checkLevel -> if arrows.length < arrowLevel -> allow new Arrow 
	                    if( arrows.size() < Global.arrowLevel ) {
	                        Arrow arrow = new Arrow(bow.getCenterX(), bow.getCenterY(), (int)(27.5 * Global.MY_RATIO), (int)(2.75 * Global.MY_RATIO), (int)(Math.round(4.5* Global.MY_RATIO)), e.getX(), e.getY());
	                    	arrows.add(arrow);
                                arrowSound.play(); 
	                    }
                        if(cheatButton.isCollision(e.getX(), e.getY())){
                            cheatButton.click(e.getX(), e.getY());
                        }
                        if(clear == true){
                            if(nextButton.isCollision(e.getX(), e.getY())){
                                nextButton.click(e.getX(), e.getY());
                            }
                        }
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
                            point = currentMagic.getRange().check(e.getX(), e.getY());
                        }
                        return;// 已經有一個當前在執行的 就不給點
                    }
                    
                    if (windButton.isCollision(e.getX(), e.getY())) {
                        currentMagic = new Wind((int)(36* Global.MY_RATIO),(int)(30* Global.MY_RATIO),(int)(Math.round(1.25* Global.MY_RATIO)),Global.windPower);//width,height,speed,power 
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
                        currentMagic.updatePos(point);
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

//Scene Begin=======================================================================
    @Override
    public void sceneBegin() {
    	ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.BATTLESENCE));
        fence = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.FENCE));
        cheatImg = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.SKIP));
        skillBar = irc.getImage(PathBuilder.getImg(ImagePath.Skills.BAR));
        iceButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.ICEBUTTON));
        windButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.WINDBUTTON));
        fireButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.Skills.FIREBUTTON));
        stageClearImg = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.STAGE_CLEAR));
        playStageMusic(Global.stage);
        arrowSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Attack.ARROW));    
        
        //new GameObject--------------------------------------------------------------
        iceButton = new ButtonRec((int)(213.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        windButton = new ButtonRec((int)(243.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        fireButton = new ButtonRec((int)(273.5* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        cheatButton = new ButtonRec((int)(300* Global.MY_RATIO),(int)(7.5* Global.MY_RATIO),(int)(12.5* Global.MY_RATIO),(int)(12.5* Global.MY_RATIO));
        bow = new Bow((int)(12.5* Global.MY_RATIO), (int)(95* Global.MY_RATIO), (int)(29* Global.MY_RATIO), (int)(22* Global.MY_RATIO), 0);
        circle = new Circle((int)(6.25* Global.MY_RATIO),(int)(86.25* Global.MY_RATIO),(int)(42.75* Global.MY_RATIO),(int)(42.75* Global.MY_RATIO),0);

        cannonButtonImg = irc.getImage(PathBuilder.getImg(ImagePath.OurUnit.CANNONBUTTON));
        cannonButton = new ButtonRec((int)(50* Global.MY_RATIO), (int)(161* Global.MY_RATIO), (int)(25* Global.MY_RATIO), (int)(25* Global.MY_RATIO));
        
        money = new MoneyInfo((int)(250*MY_RATIO), (int)(3.75*MY_RATIO), (int)(17*MY_RATIO), (int)(17.25*MY_RATIO), 0);

//factory
        ef = new EnemyFactory();      
        sf = new SoldiersFactory(Global.stage);  
        factoryCounter = new DelayCounter(8); //不知道為什麼設8剛好 我猜是兩個delay會干擾
        enemyCounter = new DelayCounter(4);
        enemyList = new ArrayList<>();
        soldiersList = new ArrayList<>();
        arrows = new ArrayList<>();
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
        //跳關用
        cheatButton.setButtonListener(new ButtonRec.ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                Global.tmpExp = money.getCurrentExp();
                Global.tmpWallHp = wallHpCounter.getCurrentWallHp();
                money.recorde();
                wallHpCounter.recorde();
                Global.stage += 1;
                stageBgm.stop();
                playClearMusic();
                sceneEnd();
            }
            @Override
            public void hover(int x, int y) {
            }
        });  
        
        //資訊欄初始設定--------------------------------------------------------------
        timer = new Timer(Global.DEFAULT_REMAINING_TIME); //關卡時間
        wallHpCounter = new WallHpCounter(Global.DEFAULT_WALL_HP);
        stageCounter = new StageCounter();
    }

    
//Scene Update=======================================================================   
    int currentUpdate = 30;
    public void sceneUpdate() {
        checkdel = false;
        if(clear == true){
            //關卡結束後不更新
            return;
        }
        if (currentMagic != null && currentMagic.isReady()) {
            currentMagic.updateNum();
            currentMagic.update();
        }

        if(cannon != null && cannon.isReady()){
            cannon.update();
        }

        //gen enemy--------------------------------------------------------------
        if ( timer.getTime() == currentUpdate ) { 
    		soldiersList = sf.getSoldiers();
    		for(Enemy e:soldiersList) { 
    			enemyList.add(e);
    		}                         
    		currentUpdate -= 10; //立刻改掉 避免狂刷30次       
    	}
    	else {
	    	if ( enemyList.size() < 4  && enemyCounter.update() && (Math.random() > 0.5 ) ) {  
		       	Enemy newEnemy = ef.generateEnemy();
	    		enemyList.add(newEnemy);    		
	    	}
    	}


        //arrow move--------------------------------------------------------------
        for (int i = 0; i < arrows.size(); i++) {
            if (!arrows.get(i).move()) {
                arrows.remove(i--);
            }
        }

        //enemy move--------------------------------------------------------------    
        for (int i = 0; i < enemyList.size() ; i++) { //error
            Enemy tmp = enemyList.get(i);

            if (currentMagic != null) {
                currentMagic.magicEffect(tmp);
            }

            if (!tmp.checkMagicDamage()) { 
                enemyList.remove(i--);
                money.update(tmp.getMoney());
                continue;
            }
            
            if (!tmp.move()) {
            	if ( tmp.attackWall() ) { //其實就是delaycounter             		
                    if ( !wallHpCounter.update( tmp.getAtk() ) ) { //耐久低於0 
//                    	wallHpCounter.reset();
//                    	timer.reset();
                        System.out.println(timer.getTime());
                        stageBgm.stop();                        
                    	sceneController.changeScene(new GameOver(sceneController));
                    }
            		
            	}
            }

            for (int j = 0; j < arrows.size(); j++) {
                if (tmp.isCollision(arrows.get(j))) {
                    arrows.remove(j--);
                    tmp.moveBack();
                    
                    if( !tmp.damage() ) { 
                        money.update(tmp.getMoney());
                    	enemyList.remove(i--); //enemy 沒血 -> 消失
                        checkdel = true;
                    }
                    break;
                }
            }
            
            if(checkdel){
                continue;
            }
            if( cannon != null) {
                for (int j = 0; j < cannon.getBulletsSize(); j++) {	            
                    if( tmp.isCollision( cannon.getBullets().get(j))) {
                        cannon.getBullets().remove(j--);
                        if( !tmp.damage() ) { 
                            money.update(tmp.getMoney());
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
        
      //破關-------------------------------------------------------------------
        if ( !timer.update() ) { 
        	//儲存耐久和經驗到global
        	//Global.tmpExp = expCounter.getCurrentExp();//破關文字在此處
            Global.tmpExp = money.getCurrentExp();
            Global.tmpWallHp = wallHpCounter.getCurrentWallHp();
        	//expCounter.recorde();
            money.recorde();
            wallHpCounter.recorde();
            Global.stage += 1;
            //end 不要放音樂
            stageBgm.stop();
            playClearMusic();
            System.out.println("##");
            sceneEnd();
                
        }
    }

    
//Scene End======================================================================= 
    @Override
    public void sceneEnd() {        
        ImageResourceController irc = ImageResourceController.getInstance();
    	stageClearImg = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.STAGE_CLEAR));
        clearText = new TextArea((int)(118.75*MY_RATIO),(int)(56.25*MY_RATIO),(int)(7.5*MY_RATIO),Global.tmpExp);
        clearText.addContent(Global.tmpWallHp).setInterval((int)(6.25*MY_RATIO)).changeToBlod();
        nextInfo = nextInfo(Global.stage);
        nextButton = new ButtonRec((int)(68.75*MY_RATIO), (int)(6.25*MY_RATIO), (int)(190*MY_RATIO), (int)(152*MY_RATIO)); //範圍大 點擊就會進入商店
        cannon = null;
        nextButton.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {                
                clearBgm.stop();
                //clearBgm = null;
                if(Global.stage > 5){
                    sceneController.changeScene(new WinScene(sceneController));
                }else{
                    sceneController.changeScene(new ShopScene(sceneController));
                }
            }

            @Override
            public void hover(int x, int y) {
            }
        }
        );

        //enemyList = null; 
        clear = true;        
    }

//paint=======================================================================    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0,(int)(Global.PANEL_X*Global.MY_RATIO), (int)(Global.PANEL_Y*Global.MY_RATIO), null);//畫背景
        g.drawImage(fence, (int)(7.5* MY_RATIO), (int)(56.25* MY_RATIO), (int)(67.25* MY_RATIO), (int)(103.75* MY_RATIO), null);//畫背景          
        g.drawImage(skillBar, (int)(3.25* Global.MY_RATIO), (int)(158* Global.MY_RATIO), (int)(310.25* Global.MY_RATIO),(int)(32* Global.MY_RATIO),null);
        g.drawImage(iceButtonImg, (int)(213.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
        g.drawImage(windButtonImg, (int)(243.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
        g.drawImage(fireButtonImg, (int)(273.5* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
        g.drawImage(cheatImg, (int)(300*MY_RATIO), (int)(7.5*MY_RATIO), (int)(12.5*MY_RATIO), (int)(12.5*MY_RATIO), null);
        g.drawImage(cannonButtonImg,(int)(50* Global.MY_RATIO),(int)(161* Global.MY_RATIO),(int)(25* Global.MY_RATIO),(int)(25* Global.MY_RATIO), null);
        circle.paint(g);
        if(cannon != null){
            if(cannon.isReady()){
                cannon.paint(g);
            }else if(cannon.getRange() != null){
                cannon.getRange().paint(g);
            }
        }
        
        if(clear == true){
            g.drawImage(stageClearImg, (int)(68.75*MY_RATIO), (int)(6.25*MY_RATIO), (int)(190*MY_RATIO), (int)(152*MY_RATIO), null);
            clearText.paint(g);
            nextInfo.paint(g);
        }else{            
            for (int i = 0; i < enemyList.size(); i++) {
                enemyList.get(i).paint(g);
            }
            
            
            //畫資訊欄文字--------------------------------------------
            timer.paint(g);
            wallHpCounter.paint(g);
            //expCounter.paint(g);
            money.paint(g);
            stageCounter.paint(g);

            //paint enemy--------------------------------------------
            for (int i = 0; i < enemyList.size(); i++) { 
                Enemy tmpEnemy = enemyList.get(i);
                tmpEnemy.paint(g);
            }

            if (Global.IS_DEBUG) {
                g.drawOval(bow.getCenterX(), bow.getCenterY(), 5, 5);
                g.drawLine(bow.getCenterX(), bow.getCenterY(), mx, my);
                double angle = Math.atan2(my - bow.getCenterY(), mx - bow.getCenterX()); // mouse - arrow center
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.rotate(angle, bow.getCenterX(), bow.getCenterY()); //隨滑鼠設定旋轉
                g2d.drawRect(bow.getCenterX(), bow.getCenterY(), 110, 11);
            }
            bow.paint(g);
            for (int i = 0; i < arrows.size(); i++) {
                arrows.get(i).paint(g);
            }

            if (currentMagic != null) {
                if (currentMagic.isReady() && currentMagic.checkAnima()) {
                    currentMagic.paint(g);
                } else if (currentMagic.getRange() != null) {
                    currentMagic.getRange().paint(g);
                }
            }
        }    
    }
    
    private TextArea nextInfo(int x){
        TextArea info;
        switch(x){
            case 2: 
                info = new TextArea((int)(118.75*MY_RATIO),(int)(100*MY_RATIO),(int)(7.5*MY_RATIO),"             最新戰報");
                info.addContent("敵方前鋒部隊已經到達");
                info.addContent("並組成軍團陣型向森林進攻").changeToBlod().setInterval((int)(5*MY_RATIO));
                return info;
                
            case 3: 
                info = new TextArea((int)(118.75*MY_RATIO),(int)(93.75*MY_RATIO),(int)(7*MY_RATIO),"               最新戰報");
                info.addContent("怪物軍招募了地下世界的罪犯");
                info.addContent("投入這場侵略戰爭");
                info.addContent("他們擁有高速突擊的能力");
                info.addContent("務必優先迎擊").changeToBlod().setInterval((int)(3.75*MY_RATIO));
                return info;
                
            case 4: 
                info = new TextArea((int)(118.75*MY_RATIO),(int)(100*MY_RATIO),(int)(7.5*MY_RATIO),"             最新戰報");
                info.addContent("半獸人的主力部隊出現");
                info.addContent("陣型更進一步的強化").changeToBlod().setInterval((int)(5*MY_RATIO));
                return info;
                
            case 5: 
                info = new TextArea((int)(118.75*MY_RATIO),(int)(100*MY_RATIO),(int)(7.5*MY_RATIO),"             最新戰報");
                info.addContent("  最精銳的半獸人");
                info.addContent("發起了最後一波的攻擊");
                info.addContent(" 殲滅他們 守護家園").changeToBlod().setInterval((int)(5*MY_RATIO));
                return info;
        }
        info = new TextArea((int)(118.75*MY_RATIO),(int)(100*MY_RATIO),(int)(7.5*MY_RATIO),"             無戰報").changeToBlod();
        return info;
    }
    
    public void playStageMusic(int stage){
        if(stage == 1 || stage == 2){
            stageBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.BATTLE_WAVE1_2));            
        }else if(stage == 3 || stage == 4){
            stageBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.BATTLE_WAVE3_4));
        }else{
            stageBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.BATTLE_WAVE_5));
        }
        stageBgm.loop();
    }
    
    public void playClearMusic(){
        clearBgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.STAGE_CLEAR));
        clearBgm.loop();
    }
     
    public KeyCommandListener getKeyCommandListener() {
        return keyCommandListener;
    }

    public MouseCommandListener getMouseCommandListener() {
        return mouseCommandListener;
    }
}
