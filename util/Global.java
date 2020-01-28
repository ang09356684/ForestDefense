/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author user
 */
public class Global {
    //Panel
	public static final int PANEL_X = 320;
	public static final int PANEL_Y = 192;
	public static float MY_RATIO = 4; //4 是原本的size
	
    public static final int UPDATE_TIMES_PER_SEC = 30;
    public static final int MILLISEC_PER_UPDATE = 1000/UPDATE_TIMES_PER_SEC;
    
    public static final int FRAME = 30;
    public static final int MILLISEC_PER_FRAME = 1000/FRAME;
    
    public static final int SPEED = 60;
    public static final int DELAY = UPDATE_TIMES_PER_SEC/15;
    public static final int MAGIC_MOVE_SPEED = 5;

    
//Enemy
    //移動邊界
    public static final int ENEMY_RIGHT = 320;
    public static final int ENEMY_LEFT = 72;
    public static final int ENEMY_UP = 48;
    public static final int ENEMY_DOWN = 156;

    public static final int ENEMY_WIDTH = 36;     //圖片寬度 & 碰撞範圍


    //敵方初始血量 還沒寫讀檔
    public static final int DEFAULT_BLOOD_ZOMBIE = 100; //lv1-2
    public static final int DEFAULT_BLOOD_MUMMY = 150; //lv1-3
    public static final int DEFAULT_BLOOD_ROCKMAN = 200; //lv2-4
    public static final int DEFAULT_BLOOD_KILLER = 50; //lv3-5
    public static final int DEFAULT_BLOOD_GHOST = 200; //lv4-5
    public static final int DEFAULT_BLOOD_MONSTER = 300; //lv5

//Enemy
    //arrow
    public static final boolean IS_DEBUG = false;//開啟輔助線 以及弓箭物件框
    public static void log(String str){
        if(IS_DEBUG){
            System.out.println(str);
        }
    } 
    
//資訊欄
    public static int stage = 1; 
    public static int exp = 1000; // 總money 商店使用
    public static int score = 0; // 總 money 不會被商店使用
    public static int wallHp = 0; // 總wallHp 
    //Battle Scene 每一關給的值
    public static final int DEFAULT_REMAINING_TIME = 30;
    public static final int DEFAULT_WALL_HP = 100;

    
//ShopScene
    //btn default
    public static final int DEFAULT_ARROW_LEVEL = 1;
    public static int arrowLevel = 1;
    public static final int DEFAULT_FIRE_LEVEL = 1;
    public static int fireLevel = 1;
    public static int firePower = 4;
    public static final int DEFAULT_WIND_LEVEL = 1;
    public static int windLevel = 1;
    public static int windPower =10;
    public static final int DEFAULT_ICE_LEVEL = 1;
    public static int iceLevel = 1;
    public static int icePower = 30;
    public static final int DEFAULT_UNIT_LEVEL = 1;
    public static int unitLevel = 1;

    //升級價格
    public static final int ARROW_TWO_PRICE = 300;
    public static final int ARROW_THREE_PRICE = 500;
    
    public static final int FIRE_TWO_PRICE = 200;
    public static final int WIND_TWO_PRICE = 200;
    public static final int ICE_TWO_PRICE = 200;
    public static final int FIRE_THREE_PRICE = 500;
    public static final int WIND_THREE_PRICE = 500;
    public static final int ICE_THREE_PRICE = 500;
    
    public static final int UNIT_ONE_PRICE = 1;
    public static final int UNIT_TWO_PRICE = 300;
    public static final int UNIT_THREE_PRICE = 500;
    
    public static final int BTN_WIDTH = 25;
    
//換關文字
    public static String tmpWallHp = "";
    public static String tmpExp = "";
    public static String userName = "";


    public static void resetGame() { // stage > 5 -> reset 
        //info
    	stage = 1;
        exp = 0;
        score = 0; 
        wallHp = 0;        
        //shop
        arrowLevel = 1;
        fireLevel = 1;
        windLevel = 1;    
        iceLevel = 1;
        unitLevel = 1;
    }
    
}
