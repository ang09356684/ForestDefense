package enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import gameobject.LifeBar;

public class Rockman extends Enemy{
    private BufferedImage img;
    
	public Rockman(int x, int y, int width, int height, int speed, int hp, int atk, int money) {
		super(x, y, width, height, speed, hp, atk, money);
		super.lifebar =  new LifeBar( x, y, super.currentHp, super.hp) ;
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Enemy.ROCKMAN));
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(img, x, y, width, height, null);
        if(effectImg != null){
            g.drawImage(effectImg, x, y, width, height, null);
        }
    }    
}
