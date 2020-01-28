/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Graphics;

/**
 *
 * @author user
 */
public abstract class GameObject {
    public int x;
    public int y;
    public int width;
    public int height;
    
    public GameObject(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }    
    
    // Bound start
    public int getLeft(){
        return this.x;
    }
    
    public int getRight(){
        return this.x + width;
    }
    
    public int getTop(){
        return this.y;
    }
    public int getBottom(){
        return this.y+ height;
    }    
    
    public boolean isCollision(GameObject obj){ // Movable → GameObject
        if(getLeft() > obj.getRight()) 
            return false;
        if(getRight() < obj.getLeft())
            return false;
        if(getTop() > obj.getBottom())
            return false;
        if(getBottom() < obj.getTop())
            return false;
        return true;
    }
    
    public abstract void paint(Graphics g);
}
