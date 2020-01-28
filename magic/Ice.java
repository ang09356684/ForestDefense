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
public class Ice extends Magic {

    BufferedImage img;
    private MusicPlay iceSound;
    
    public Ice(int x, int y, int width, int height, int speed, int power) {
        super(x, y, width, height, speed, power, power, PathBuilder.getImg(ImagePath.Skills.ICE_EFFECT));
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Skills.ICE));
        setReady(true);
        iceSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Magic.ICE));
        iceSound.play();
    }

    @Override
    public void updatePic() {
        cx = 193 * (picNum % 4);//0~3
        cy = 189 * (picNum / 4);//0~3   
    }

    @Override
    public int getNum() {
        return 15;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, (int)(124* Global.MY_RATIO), (int)(54* Global.MY_RATIO),  (int)(224* Global.MY_RATIO) , (int)(154* Global.MY_RATIO), cx, cy,
                cx + 193, cy + 189, null);//畫圖範圍與實際影響範圍不同
    }
    
    @Override
    public void effectEnd(Enemy e){
        e.resetSpeed();
    }
    
    @Override
    public void effect(Enemy e){
        e.setSpeed(0);
    }

    @Override
    public void playSound() {

    }
}
