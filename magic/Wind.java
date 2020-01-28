/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import enemy.Enemy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import util.DelayCounter;
import util.Global;

/**
 *
 * @author user
 */
public class Wind extends Magic{
    BufferedImage img;
    private MagicRange mr;
    private MusicPlay windSound;
    
    public Wind(int width, int height, int speed, int power) {
        super(0, 0, width, height, speed, (int)Math.round((power/4)*Global.MY_RATIO), 30, "");//效果圖用null會報錯
        //(x, y, width, height, speed, power, duration, effectImgPath)
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Skills.WIND));
        mr = new MagicRange((int)(72* Global.MY_RATIO), (int)(120* Global.MY_RATIO), (int)(248* Global.MY_RATIO), (int)(36* Global.MY_RATIO), 0);
        windSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Magic.WIND));        
    }
    
    @Override
    public void updatePic() {
        this.x += this.getSpeed();
        cx = 192* (picNum %5);
        cy = 192* (picNum/6);    
    }
    
    @Override
    public int getNum(){
        return 30;
    }    
    
    @Override
    public MagicRange getRange() {
        return mr;
    }
    
    @Override
    public void effectEnd(Enemy e) {
    }

    @Override
    public void effect(Enemy e) {
        e.setX(e.getX() + this.getPower());
        e.setCurrentHp(e.getCurrentHp() - this.getPower()/10);
        e.refreshLifeBar();
    }
    
     @Override
    public void paint(Graphics g) {
        //位置應該是拖拉後的位置
        g.drawImage(img, x, y, x+width, y+height, cx , cy,
                cx +192, cy + 192, null);//畫圖範圍與實際影響範圍不同
    }

    @Override
    public void playSound() {
        windSound.play();
    }
}
