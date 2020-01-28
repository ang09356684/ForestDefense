package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;

public class WindButton extends LevelButton {

	private BufferedImage img;
	
	public WindButton(int x, int y, int width, int height, int lv, int price) {
		super(x, y, width, height, lv, price);
		
		ImageResourceController irc = ImageResourceController.getInstance();
		img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.WIND_LV2));
	}

	@Override
	public boolean checkLevel() {
		if( Global.windLevel == this.lv-1) {
			return true;
		}
		return false;
	}

	@Override
	public void updateLevel() {
		Global.windLevel += 1;
                Global.windPower += 5;
		//System.out.println("wind upgrade ->" + lv);
		
		Global.exp -= this.price;
		//System.out.println(Global.exp);

	}
	
	@Override
	public void paint(Graphics g) {
		if(Global.windLevel >= super.lv ) {
			g.drawImage(img, x, y, width, height, null);
		}
	}

}
