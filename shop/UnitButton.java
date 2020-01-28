package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;

public class UnitButton extends LevelButton{
	private BufferedImage img;

	public UnitButton(int x, int y, int width, int height, int lv, int price) {
		super(x, y, width, height, lv , price);
		
		ImageResourceController irc = ImageResourceController.getInstance();
		img = irc.getImage(PathBuilder.getImg(ImagePath.ShopBtn.UNIT_LV1));

	}
	
	//改Global管理
	//如果global裡面的弓箭技能等級是這個按鈕的等級-1 可以升級
	@Override
	public boolean checkLevel() {
		if( Global.unitLevel == this.lv-1) {
			return true;
		}
		return false;
	}

	@Override
	public void updateLevel() {
		Global.unitLevel += 1;
		//System.out.println("unit upgrade ->" + lv);
		
		Global.exp -= this.price;
		//System.out.println(Global.exp);
	}

	@Override
	public void paint(Graphics g) {
		if(Global.unitLevel >= this.lv ) {
			g.drawImage(img, x, y, width, height, null);
		}
	}

}

