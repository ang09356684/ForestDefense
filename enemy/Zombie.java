package enemy;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import controllers.ImagePath;
import gameobject.LifeBar;

public class Zombie extends Enemy {
    private BufferedImage img;
    
	public Zombie(int x, int y, int width, int height, int speed, int hp, int atk, int money) {
		super(x, y, width, height, speed, hp, atk, money);		
		super.lifebar =  new LifeBar( x, y, super.currentHp, super.hp) ;
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Enemy.ZOMBIE));

	}
    
	@Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(img, x, y, width, height,null);

        if(effectImg != null){
            g.drawImage(effectImg, x, y, width, height, null);
        }
    }
}
