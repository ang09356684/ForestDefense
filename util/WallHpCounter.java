package util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import static util.Global.MY_RATIO;


public class WallHpCounter {
	//血量條----------------------------------------------------------------
	private class WallBar {
		private int x;
		private int y;
		private int width;
		private int height;
		private int currentHp;
		private int defaultHp;
		
		public WallBar (int currentHp, int defaultHp) {		
			this.x = (int)(7.5*MY_RATIO);
			this.y = (int)(17.5*MY_RATIO);
			this.width = (int)(50*MY_RATIO);
			this.height = (int)(10*MY_RATIO);
			this.currentHp = currentHp;
			this.defaultHp = defaultHp;
		}

		public int getCurrentHp() {
			return currentHp;
		}
		
		public void setCurrentHp(int currentHp) {
			this.currentHp = currentHp;
		}
		
	    public void paint(Graphics g) {
		    Graphics2D g2 = (Graphics2D) g;
		    Rectangle2D r2 = new Rectangle2D.Double(x,y-height,width,height);
			g2.setColor(new Color(255,255,255));
			g2.draw(r2);
			Rectangle2D r = new Rectangle2D.Double(x,y-height, (((double)currentHp / (double)defaultHp))*width ,height);
			g2.setColor(new Color(255,127,0)); //currentHp
			g2.fill(r);
	    }
	}
	
	//文字--------------------------------------------------------------------
    private Color color = new Color(255,255,255);
    private int currentWallHp;
    private int defaultWallHp;
    private DelayCounter dCounter;
    private WallBar wallBar;
    
    public WallHpCounter(int defaultWallHp) {
    	this.defaultWallHp = defaultWallHp; //固定值
    	this.currentWallHp = defaultWallHp; //會減少
    	dCounter = new DelayCounter(30);
    	wallBar = new WallBar( currentWallHp, defaultWallHp );
    }
    
    public boolean update(int atk) {
    	currentWallHp -= atk;
    	wallBar.setCurrentHp(currentWallHp);
    	if( currentWallHp <= 0) {
    		return false;
    	}
    	return true;
    }
    
    public void recorde() {
    	Global.wallHp += currentWallHp;
    	reset();
    }
    
    public void reset() {
    	this.currentWallHp = defaultWallHp;
    }
    
    public String getCurrentWallHp() {
    	return "您在本關剩餘的生命 : " + currentWallHp;
    }
    
    public void paint(Graphics g) {	
        Font font = g.getFont().deriveFont((float)(5*MY_RATIO)); 
        g.setFont(font);
        g.setColor(color);
    	g.drawString( String.valueOf(currentWallHp), (int)(60*MY_RATIO), (int)(15.75*MY_RATIO)); //倒數時間
    	wallBar.paint(g);
    }
    
}
