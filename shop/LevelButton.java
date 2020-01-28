package shop;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import util.Global;

	public abstract class LevelButton extends ClickableShopObject{
		protected int lv;
		protected int price;


		public LevelButton(int x, int y, int width, int height, int lv, int price) {
			super(x, y, width, height);
			this.lv = lv;
			this.price = price;
		}
		
		public abstract boolean checkLevel();	

		public abstract void updateLevel();
		
		public boolean checkExp() {
			if( Global.exp >= this.price ) {
				return true;
			}
			return false;
		}
		
		public int getPrice() {
			return price;
		}

	}
