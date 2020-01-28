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
public class ButtonRec extends GameObject {

    public ButtonRec(int x, int y, int width, int height) {
        super(x, y, width, height);
    }
    public interface ButtonListener {
        public void onClick(int x, int y);
        public void hover(int x, int y);
    }

    private ButtonListener buttonListener;
    public void setButtonListener(ButtonListener buttonListener) {
        this.buttonListener = buttonListener;
    }

    public boolean isCollision(int x, int y) {
        if (x < this.x || x > this.x + this.width) {
            return false;
        }
        if (y < this.y || y > this.y + this.height) {
            return false;
        }
        return true;
    }

    public void click(int x, int y) {
        if (buttonListener == null) {
            return;
        }
        buttonListener.onClick(x, y);
    }

    public void hover(int x, int y) {
        if (buttonListener == null) {
            return;
        }
        buttonListener.hover(x, y);
    }

    @Override
    public void paint(Graphics g) {
        g.drawRect(x, y, width, height);
    }    
}
