/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import gameobject.LifeBar;
import gameobject.Movable;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import magic.Magic;
import static util.Global.ENEMY_LEFT;
import static util.Global.MY_RATIO;

public abstract class Enemy extends Movable{ 

    protected int atk;
    protected int money;
    protected int hp; //初始值
    protected int currentHp; //戰鬥開始後會逐漸減少   
    protected LifeBar lifebar;
    protected BufferedImage effectImg;   
    private int originalSpeed;
    
    private int coolDown;

    public Enemy(int x, int y, int width, int height, int speed, int hp, int atk, int money){
    	super(x, y, width, height, speed);
    	originalSpeed = super.getSpeed();
    	this.atk = atk;
    	this.money = money;
    	this.hp = hp;
    	this.currentHp = hp;    	
    	coolDown = 0;
    }

	public void setFormation(int x, int y) {
    	this.x = x;
    	this.y = y;
    }
    
    public void resetSpeed(){
        this.speed = originalSpeed;
    }
  
    @Override
    public boolean move() { //ver2
    	if( this.x > ENEMY_LEFT*MY_RATIO ) { //還沒碰到牆要前進
    		this.x -= super.speed;
    		this.lifebar.setX(x);
    		this.lifebar.setY(y); 
    		return true;
    	}
    	else {  //前進碰到或超出牆 退回牆前
        	this.x = ((int)(ENEMY_LEFT*MY_RATIO))-1;
            return false;
    	}
    }  
    
    public boolean attackWall() { //其實就是delaycounter 初始是0所以第一次碰到牆會立刻扣
    	coolDown -= 1;	
    	if( coolDown <= 0 ) {
    		coolDown = 30;
    		return true;
    	}
    	return false;
    }

    
    public boolean damage() { 
    	this.currentHp -= 50;
        this.lifebar.setBlood(currentHp);  
    	if(this.currentHp<=0) { 
    		return false;     		
    	}    	
    	return true;
    }

    public boolean checkMagicDamage() {//check hp
        if (this.currentHp <= 0) {
            return false;
        }
        return true;
    }

    public boolean moveBack() {
        this.x += super.speed;
        return true;
    }
    
    public void setMagicEffectImg(BufferedImage img){
        effectImg = img;
    }
    
    public void refreshLifeBar(){
        lifebar.setBlood(currentHp);
    }

    private boolean magicEffect(Magic magic) {
        return true;
    }
    

    public void setLifeBar(LifeBar lifebar) {
        this.lifebar = lifebar;
    }
    
    public int getCurrentHp() {
    	return currentHp;
    }
    
    public void setCurrentHp(int currentHp) {
    	this.currentHp = currentHp;
    }

    @Override
    public void paint(Graphics g) {
        this.lifebar.paint(g);
    }

	public int getAtk() {
		return atk;
	}

	public int getMoney() {
		return money;
	}

	public int getHp() {
		return hp;
	}

}
