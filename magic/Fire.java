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


public class Fire extends Magic {

    BufferedImage img;
    private MagicRange mr;
    private MusicPlay fireSound;


    public Fire(int width, int height, int speed, int power) {
        super(0, 0, width, height, speed, power, 16, PathBuilder.getImg(ImagePath.Skills.FIRE_EFFECT));
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Skills.FIRE));
        mr = new MagicRange((int)(72* Global.MY_RATIO), (int)(120* Global.MY_RATIO), (int)(36* Global.MY_RATIO), (int)(36* Global.MY_RATIO), 1);
        fireSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Magic.FIRE));
    }

    @Override
    public void updatePic() {
        cx = 128 * (picNum % 4);
        cy = 128 * (picNum / 4);
    }

    @Override
    public int getNum() {
        return 16;
    }

    @Override
    public MagicRange getRange() {
        return mr;
    }

    @Override
    public void effectEnd(Enemy e){
    }
    
    @Override
    public void effect(Enemy e){
        e.setCurrentHp(e.getCurrentHp() - this.getPower());
        e.refreshLifeBar();
    }
    
    @Override
    public void paint(Graphics g) {
        //位置應該是拖拉後的位置
        g.drawImage(img, x, y, x + width, y + height, cx, cy,
                cx + 128, cy + 128, null);
    }

    @Override
    public void playSound() {
        fireSound.play();
    }
}
