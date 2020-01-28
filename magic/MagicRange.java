/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magic;

import gameobject.GameObject;
import util.Global;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author user
 */
public class MagicRange extends GameObject{
private int type;
    public MagicRange(int x, int y, int width, int height, int type) {
        super(x, y, width, height);
        this.type = type;
    }
    
    public Point check(int x, int y){
        if(type == 1){
            this.x = x;
        }
        if(y < (int)(84* Global.MY_RATIO)){
            this.y = (int)(49* Global.MY_RATIO); //192 第一條範圍起點+4 避免上下接觸
        }else if(y > (int)(84* Global.MY_RATIO) && y <= (int)(120* Global.MY_RATIO)){
            this.y = (int)(85* Global.MY_RATIO);//336 第二條範圍起點+4 
        }else{
            this.y = (int)(121* Global.MY_RATIO);//480 第三條範圍起點+4 
        }
        Point point = new Point(this.x,this.y);
        return point;
    }
    
    @Override
    public void paint(Graphics g) {
        Color color = new Color(255, 102, 105, 100);
        //(R,G,B,Alpha Channel)  Alpha 0 = transparent, 225 = no transparent
        g.setColor(color);
        g.fillRoundRect(x, y, width, height, 10, 10);
        
    }
    
}
