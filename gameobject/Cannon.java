/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import magic.MagicRange;
import util.DelayCounter;
import util.Global;
import static util.Global.ENEMY_LEFT;
import static util.Global.unitLevel;
import static util.Global.MY_RATIO;

/**
 *
 * @author user
 */
public class Cannon extends Movable{
    private BufferedImage img;   
    private Bullet bullet;
    private ArrayList<Bullet> bullets;
    private MagicRange range;
    private boolean isReady;
    private DelayCounter delay;
    private double count;
    private boolean hasBullet;
    private MusicPlay bulletSound;  
    public Cannon(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.OurUnit.CANNON));
        bullets = new ArrayList<>();
        range = new MagicRange((int)(40 *MY_RATIO), (int)(120 *MY_RATIO),(int)(30 *MY_RATIO) , (int)(25 *MY_RATIO), 0); 
        delay = new DelayCounter(15);
        bulletSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Attack.BULLET));       
    }
    
    public void update(){
        if(move()){            
            if( bullets.size() < Global.unitLevel) {//升級可改此處?  
                if(delay.update()){
                    Bullet bullet =  new Bullet(this.x +(int)(25*MY_RATIO),this.y+(int)(7.5*MY_RATIO), (int)(9.75*MY_RATIO), (int)(9.25*MY_RATIO) ,10); 
                    bullets.add(bullet);
                    bulletSound.play();
                }
            }
            for(int i = 0; i < bullets.size();i++){
                if(!bullets.get(i).move()){
                   bullets.remove(i);
                }
            }
        }
    }
    
    @Override
    public boolean move() {
        if(this.x < (ENEMY_LEFT*MY_RATIO)-(int)(43.75*MY_RATIO) ) {
            this.x += super.speed;
            return false;
        }
        return true;
    }
    
    public ArrayList<Bullet> getBullets(){
    	return this.bullets;
    }
    
    public void setReady(boolean value) {
        isReady = value; //更新完釋放座標 設為true
    }

    public boolean isReady() {
        return isReady;
    }
    
    public boolean hasBullet(){
        return hasBullet;
    }
    
    public void updatePos(Point point) {
        this.x = point.x-(int)(25*MY_RATIO)  ;
        this.y = point.y+(int)(7.5*MY_RATIO);//校正位置
    }
    
    public MagicRange getRange() {
        return range;
    }
    
    @Override
    public void paint(Graphics g) {
        g.drawImage(img,x,y,(int)(28.75*MY_RATIO),(int)(19*MY_RATIO),null);
        for(int i = 0; i < bullets.size();i++){
               bullets.get(i).paint(g);
        }
    }
    
//////////debug    
    public int getBulletsSize() {
    	return bullets.size();
    }
    
}
