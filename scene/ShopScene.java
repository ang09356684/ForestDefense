package scene;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import controllers.SceneController;
import gameobject.ButtonRec;
import gameobject.MoneyInfo;
import io.CommandSolver;
import io.CommandSolver.MouseCommandListener;
import shop.ArrowButton;
import shop.ClickableShopObject;
import shop.FireButton;
import shop.IceButton;
import shop.UnitButton;
import shop.WindButton;
import util.Global;
import static util.Global.BTN_WIDTH;
import static util.Global.MY_RATIO;

public class ShopScene extends Scene {
    private CommandSolver.MouseCommandListener mouseCommandListener;
    private BufferedImage img;
    private MusicPlay bgm;
    private MusicPlay levelSound;
    
    //arrow Button
    private ArrowButton arrowLv2;
    private ArrowButton arrowLv3;
    //magic Button
    private FireButton fireLv2;
    private WindButton windLv2;
    private IceButton iceLv2;
    private FireButton fireLv3;
    private WindButton windLv3;
    private IceButton iceLv3;
    //unit Button
    private UnitButton unitLv2;
    private UnitButton unitLv3;
    
    private ButtonRec nextButton; //換關卡
    private MoneyInfo money; 
    private float nowsize;
                
	public ShopScene(SceneController sceneController) {
            super(sceneController);
            nowsize = Global.MY_RATIO;
            mouseCommandListener = new CommandSolver.MouseCommandListener(){
            
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {

                if(state == CommandSolver.MouseState.PRESSED){
                    if(e.getButton() == MouseEvent.BUTTON1){
                    	//System.out.println( e.getX()+" , "+e.getY() );

                        if (nextButton.isCollision(e.getX(), e.getY())) {
                            nextButton.click(e.getX(), e.getY());
                        }
                    	
                    	//arrowLv2.checkLevel(); -> arrowLv1 in ArrayList<arrowButton>
                    	//arrowLv2.checkExp(); -> exp - arrowLv2.def > 0
                    	//if true 
                    	//buy(arrowLv2); -> arrowBtnList.add(arrowLv2)
                        if(arrowLv2.isCollision(e.getX(), e.getY())){
                        	if ( arrowLv2.checkLevel() && arrowLv2.checkExp()) {  
                                    levelSound.play();
                                    arrowLv2.updateLevel();
                                    money.cost(arrowLv2.getPrice());
                        	}  
                        }
                        
                        if(arrowLv3.isCollision(e.getX(), e.getY())){                     
                        	if ( arrowLv3.checkLevel() && arrowLv3.checkExp() ) { 
                                    levelSound.play();
                                    arrowLv3.updateLevel();
                                    money.cost(arrowLv3.getPrice());
                        	}  
                        }
                        
                        //magic
                        if(fireLv2.isCollision(e.getX(), e.getY())){                     
                        	if ( fireLv2.checkLevel() && fireLv2.checkExp() ) { 
                                    levelSound.play();
                                    fireLv2.updateLevel();
                        		money.cost(fireLv2.getPrice());
                        	}  
                        }
                        if(windLv2.isCollision(e.getX(), e.getY())){                     
                        	if ( windLv2.checkLevel() && windLv2.checkExp() ) {
                                levelSound.play();
                        		windLv2.updateLevel();
                        		money.cost(windLv2.getPrice());
                        	}  
                        }
                        if(iceLv2.isCollision(e.getX(), e.getY())){                     
                        	if ( iceLv2.checkLevel() && iceLv2.checkExp() ) {
                                levelSound.play();
                        		iceLv2.updateLevel();
                        		money.cost(iceLv2.getPrice());
                        	}  
                        }           
                        if(fireLv3.isCollision(e.getX(), e.getY())){                     
                        	if ( fireLv3.checkLevel() && fireLv3.checkExp() ) {
                        		levelSound.play();
                        		fireLv3.updateLevel();
                        		money.cost(fireLv3.getPrice());
                        	}  
                        }
                        if(windLv3.isCollision(e.getX(), e.getY())){                     
                        	if ( windLv3.checkLevel() && windLv3.checkExp() ) { 
                        		levelSound.play();
                        		windLv3.updateLevel();
                        		money.cost(windLv3.getPrice());
                        	} 
                        }
                        if(iceLv3.isCollision(e.getX(), e.getY())){                     
                        	if ( iceLv3.checkLevel() && iceLv3.checkExp() ) { 
                        		levelSound.play();
                        		iceLv3.updateLevel();
                        		money.cost(iceLv3.getPrice());
                        	}  
                        }
                        
                        //unit
                        if(unitLv2.isCollision(e.getX(), e.getY())){
                        	if ( unitLv2.checkLevel() && unitLv2.checkExp()) { 
                        		levelSound.play();
                        		unitLv2.updateLevel();
                        		money.cost(unitLv2.getPrice());
                        	}  
                        }
                        if(unitLv3.isCollision(e.getX(), e.getY())){                     
                        	if ( unitLv3.checkLevel() && unitLv3.checkExp() ) { 
                        		levelSound.play();
                        		unitLv3.updateLevel();
                        		money.cost(unitLv3.getPrice());
                        	}  
                        }

                    }
                }                

             }
         };
    }

	


	@Override
	public void sceneBegin() {
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.SHOPSENCE));
        bgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.STORE));
        bgm.loop();        
        levelSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Level.LEVEL_UP)); 
		//banner 1280 * 120
    
	    //default arrow btn (x,y,w,h,lv,def)
        
        //lv 1 y = 120
        //lv 2 y = 270+2
        //lv 3 y = 520+2

        //arrow x =300	    
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
		g.drawImage(img, 0, 0,(int)(320*MY_RATIO),(int)(192*MY_RATIO),null); //畫背景

		arrowLv2.paint(g);
		arrowLv3.paint(g);

		fireLv2.paint(g);
		windLv2.paint(g);
		iceLv2.paint(g);
		fireLv3.paint(g);
		windLv3.paint(g);
		iceLv3.paint(g);		
		
		unitLv2.paint(g);
		unitLv3.paint(g);		
		money.paint(g);
	}
    
    public void reset(){
        arrowLv2 = new ArrowButton((int)(75*MY_RATIO),(int)(68*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),2,Global.ARROW_TWO_PRICE );
        arrowLv3 = new ArrowButton((int)(75*MY_RATIO),(int)(130.5*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),3,Global.ARROW_THREE_PRICE); 

        //fire x = 490
        fireLv2 = new FireButton((int)(122.5*MY_RATIO),(int)(68*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),2,Global.FIRE_TWO_PRICE); 
        fireLv3 = new FireButton((int)(122.5*MY_RATIO),(int)(130.5*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),3,Global.FIRE_THREE_PRICE); 

        //wind x = 680
        windLv2 = new WindButton((int)(170*MY_RATIO),(int)(68*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),2,Global.WIND_TWO_PRICE);
        windLv3 = new WindButton((int)(170*MY_RATIO),(int)(130.5*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),3,Global.WIND_THREE_PRICE); 

        //ice x = 870
        iceLv2 = new IceButton((int)(217.5*MY_RATIO),(int)(68*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),2,Global.ICE_TWO_PRICE);
        iceLv3 = new IceButton((int)(217.5*MY_RATIO),(int)(130.5*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),3,Global.ICE_THREE_PRICE);

        //unit x = 1060
        unitLv2 = new UnitButton((int)(265*MY_RATIO),(int)(68*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),2,Global.UNIT_TWO_PRICE);
        unitLv3 = new UnitButton((int)(265*MY_RATIO),(int)(130.5*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),(int)(BTN_WIDTH*MY_RATIO),3,Global.UNIT_THREE_PRICE);	    
        nextButton = new ButtonRec((int)(250*MY_RATIO),0,(int)(70*MY_RATIO),(int)(40*MY_RATIO)); //點 banner 整備室會進戰鬥	    
        nextButton.setButtonListener(new ButtonRec.ButtonListener() {
            @Override
            public void onClick(int x, int y) {
                sceneController.changeScene(new BattleScene(sceneController));
            }
            @Override
            public void hover(int x, int y) {
            }
        });        
        money = new MoneyInfo((int)(15*MY_RATIO), (int)(3.75*MY_RATIO), (int)(17*MY_RATIO), (int)(17.25*MY_RATIO),  Global.exp );
        
    }

    @Override
    public MouseCommandListener getMouseCommandListener(){return mouseCommandListener;}
	
}
