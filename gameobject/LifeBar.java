package gameobject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import util.Global;

public class LifeBar {

	private int x;
	private int y;
	private int width;
	private int height;
	
	private int currentHp;
	private int defaultHp;
	
	public LifeBar(int x, int y, int currentHp, int defaultHp) {		
		this.x = x;
		this.y = y;
		this.width = (int)((40/4) * Global.MY_RATIO);
		this.height = (int)((10/4) * Global.MY_RATIO);
		this.currentHp = currentHp;
		this.defaultHp = defaultHp;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int w) {
		this.width = w;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int h) {
		this.height = h;
	}
	public int getBlood() { //get currentHp
		return currentHp;
	}
	public void setBlood(int currentHp) { //set currentHp 
		this.currentHp = currentHp;
	}
	
 
    public void paint(Graphics g) {
	    Graphics2D g2 = (Graphics2D) g;
	    Rectangle2D r2 = new Rectangle2D.Double(x,y-height,width,height);
		g2.setColor(new Color(255,255,255));
		g2.draw(r2);
		Rectangle2D r = new Rectangle2D.Double(x,y-height, (((double)currentHp / (double)defaultHp))*width ,height);
		g2.setColor(new Color(205,0,0));
		g2.fill(r);
    }
}
