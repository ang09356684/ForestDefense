package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;

public class IceButton extends LevelButton {

	private BufferedImage img;
	
	public IceButton(int x, int y, int width, int height, int lv, int price) {
		super(x, y, width, height, lv, price);
		
		ImageResourceController irc = ImageResourceController.getInstance();
		img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.ICE_LV2));
	}

	@Override
	public boolean checkLevel() {
		if( Global.iceLevel == this.lv-1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void updateLevel() {
		Global.iceLevel += 1;
        Global.icePower += 15;
		//System.out.println("ice upgrade ->" + lv);
		
		Global.exp -= this.price;
		//System.out.println(Global.exp);

	}

	@Override
	public void paint(Graphics g) {
		if(Global.iceLevel >= super.lv ) {
			g.drawImage(img, x, y, width, height, null);
		}
	}


}
