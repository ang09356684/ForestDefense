/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;

import static util.Global.MY_RATIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import util.DelayCounter;
import util.Global;

/**
 *
 * @author User
 */
public class MoneyInfo {
    private int x;
    private int y;
    private int width;
    private int height;
    BufferedImage img;
    private int cx;
    private int picNum;
    private DelayCounter delay;
    
    private int currentMoney;
    private int defaultMoney;
    
    public MoneyInfo(int x, int y, int width, int height, int defaultMoney){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.defaultMoney = defaultMoney;
    	this.currentMoney = this.defaultMoney;
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.MONEY));
        delay = new DelayCounter(2);
    }
    
    public void resetPosition() { //商店場景專用
        this.x = (int)(15*MY_RATIO);
        this.y = (int)(3.75*MY_RATIO);
    }
    
    public void updatePic() {
        if(delay.update()){
            cx = 68*(++picNum %6);  
        }
    }
    
    public void update(int enemyCarriedMoney) {
    	currentMoney += enemyCarriedMoney;
    }
    
    public void cost(int price) {
    	currentMoney -= price;
    }
    
    public void recorde() {
    	Global.exp += currentMoney; //在商店可以使用的錢
    	Global.score += currentMoney;  //破關的分數
    }
    
    public void reset() {
        this.currentMoney = 0;
    }
    
    public String getCurrentExp() {
    	return "您在本關得到的獎勵 : " + currentMoney;
    }
    
    public void paint(Graphics g) {
        updatePic();
        Font font = new Font("微軟正黑體", 1, (int)(7.5*MY_RATIO));
        g.setFont(font);
        g.setColor(new Color(255,255,255));
        g.drawString(String.valueOf(currentMoney), x+(int)(20*MY_RATIO), y+(int)(10*MY_RATIO)); 
        g.drawImage(img, x, y, x+width, y+height, cx , 0,
                cx +68, 0 + 69, null);//畫圖範圍與實際影響範圍不同
    }
}
