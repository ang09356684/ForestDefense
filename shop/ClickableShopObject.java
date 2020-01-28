package shop;


import java.awt.Graphics;

import gameobject.GameObject;
import gameobject.ButtonRec.ButtonListener;

//Clickable items
public abstract class ClickableShopObject extends GameObject{
	

	public ClickableShopObject(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	private ButtonListener buttonListener;

    public boolean isCollision(int x, int y) {
        if (x < super.x || x > super.x + super.width) {
            return false;
        }
        if (y < super.y || y > super.y + super.height) {
            return false;
        }
        return true;
    }
    
	@Override
	public abstract void paint(Graphics g); 
	
	
}
