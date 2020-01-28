package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;

public class FireButton extends LevelButton {
	private BufferedImage img;
	
	public FireButton(int x, int y, int width, int height, int lv, int price) {
		super(x, y, width, height, lv, price);
		
		ImageResourceController irc = ImageResourceController.getInstance();
		img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.FIRE_LV2));
	}

	@Override
	public boolean checkLevel() {
		if( Global.fireLevel == this.lv-1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void updateLevel() {
		Global.fireLevel += 1;
        Global.firePower += 4;
		//System.out.println("fire upgrade ->" + lv);
		
		Global.exp -= this.price;
		//System.out.println(Global.exp);

	}

	@Override
	public void paint(Graphics g) {
		if(Global.fireLevel >= super.lv ) {
			g.drawImage(img, x, y, width, height, null);
		}
	}





}
