package util;

import static util.Global.MY_RATIO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class StageCounter {
	
	private int stage;
	
	public StageCounter() {
		stage = Global.stage;
	}
	
	public void update() {
		Global.stage += 1;
	}
	
	public void paint(Graphics g) {
		Color color = new Color(255,255,255);
		Font font = g.getFont().deriveFont((float)(5*MY_RATIO)); 
		g.setFont(font);
		g.setColor(color);
			
		g.drawString( "WAVE："+String.valueOf(stage), (int)(7.5*MY_RATIO), (int)(25*MY_RATIO)); 
	}
	
}

