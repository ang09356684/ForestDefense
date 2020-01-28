package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;


public class ArrowButton extends LevelButton{
	private BufferedImage img;

	public ArrowButton(int x, int y, int width, int height, int lv, int price) {
		super(x, y, width, height, lv , price);
		
		ImageResourceController irc = ImageResourceController.getInstance();
		switch(lv) {
		case 1:
		    img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.ARROW_LV1));
		break;
		case 2:
		    img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.ARROW_LV2));
		break;
		case 3:
		    img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.ARROW_LV3));
		break;
		}
	}
	
	//改Global管理
	//如果global裡面的弓箭技能等級是這個按鈕的等級-1 可以升級
	@Override
	public boolean checkLevel() {
		if( Global.arrowLevel == this.lv-1) {
			return true;
		}
		return false;
	}

	@Override
	public void updateLevel() {
		Global.arrowLevel += 1;
		//System.out.println("arrow upgrade ->" + lv);
		
		Global.exp -= this.price;
		//System.out.println(Global.exp);
	}

	@Override
	public void paint(Graphics g) {
		if(Global.arrowLevel >= this.lv ) {
			g.drawImage(img, x, y, width, height, null);
		}
	}


}
