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
public class EffectObject extends GameObject {
    public EffectObject(int x, int y, int width, int height){
        super(x, y, width, height);
    }
    
    @Override
    public void paint(Graphics g) {
        //g.drawImage(img, x, y, null);
    }    

}
