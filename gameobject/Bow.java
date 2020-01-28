/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import util.DelayCounter;

/**
 *
 * @author User
 */
public class Bow extends Movable{
    private BufferedImage img;            
    private double angle;
    private DelayCounter delayCounter;
    public Bow(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Bow.BOW));
    }

    public void changeAngle(int x, int y){ // 傳入滑鼠座標 
        int mouseX = x;
        int mouseY = y;
        angle =  Math.atan2(mouseY - getCenterY() , mouseX - getCenterX());
        //angle是弧
        
   }
    
    public double getAngle(){
        return this.angle;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getCenterX(){
        return this.x + width/2;
    }
    
    
    public int getY(){
        return this.y;
    }
    
    public int getCenterY(){
        return this.y+height/2;
    }
    
    //rad = 旋轉後的弧 要取得旋轉後的新位置
    public static int getRotationX(double rad, int x, int y) {
        int rx = (int) (x * Math.cos(rad) - y * Math.sin(rad));
        return rx;
    }
   
    public int getRotationY(double rad, int x, int y){
        int ry = (int) (x * Math.sin(rad) + y * Math.cos(rad));
        return ry;
    }
    
    //讓該物件class管理自己的圖像
    @Override
    public void paint(Graphics g){ //有傳進來時
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.rotate(this.angle, getCenterX(), getCenterY());
        g2d.drawImage(img, x, y, width, height, null);
       //在旋轉後的的位置上畫新的圖
        //似乎沒有到正中心點
    }
    @Override
    public boolean move() {
        return true;
    }


    
}
