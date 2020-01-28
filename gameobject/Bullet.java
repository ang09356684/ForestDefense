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
import util.Global;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Bullet extends Movable{
    private BufferedImage img;   
    private int cx;
    private int picNum;
  
    
    public Bullet(int x, int y, int width, int height, int speed) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.OurUnit.BULLET));   
    }

    @Override
    public boolean move() {
       this.x += super.speed;
       ++picNum;
       cx = 40*(picNum %4);
       if(x > Global.PANEL_X * Global.MY_RATIO){
           return false;
       }
       return true;
    }

    @Override
    public void paint(Graphics g) {
    g.drawImage(img, x, y, x+width, y+height, cx , 0,
                cx +40, 0 + 37, null);//畫圖範圍與實際影響範圍不同
    
    }
    
}
