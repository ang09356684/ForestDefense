/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import util.Global;

/**
 *
 * @author user
 */
public abstract class Movable extends GameObject{
   public int speed;
    public Movable(int x, int y, int width, int height, int speed){
        super(x,y,width,height);
        this.speed = speed;
    }
    
    public final void setSpeed(int speed){
        this.speed = speed * Global.SPEED;
    }
    
    public int getSpeed(){
        return this.speed;
    }
    
    public abstract boolean move(); 
}
