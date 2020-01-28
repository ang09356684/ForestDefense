/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import util.Global;

/**
 *
 * @author User
 */
public class Arrow extends Movable {

    private BufferedImage img;
    private double angle;
    private double cx; //涉及旋轉角度 先用float 或 double 避免在轉換時有累進誤差
    private double cy;
    private MusicPlay arrowSound;
    
    public Arrow(int x, int y, int width, int height, int speed, int mouseX, int mouseY) {
        super(x, y, width, height, speed);
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Bow.ARROW));
        cx = this.x;
        cy = this.y;
        angle = Math.atan2(mouseY - y, mouseX - x);
        //arrowSound = new MusicPlay(PathBuilder.getMusic(MusicPath.Attack.ARROW));  
       // arrowSound.play();
    }

    @Override
    public boolean move() {
        cx += speed * Math.cos(angle); // 每次的位移
        this.x = (int)(cx* Math.cos(angle));// 將cx轉換為原本的x
        cy += speed * Math.sin(angle);
        this.y = (int)(cy* Math.cos(angle));
        if (cx >= Global.PANEL_X * Global.MY_RATIO || cy >= Global.PANEL_Y * Global.MY_RATIO || cx <0 || cy <0) {
            return false;
        }
        return true;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.rotate(this.angle, cx, cy); //隨滑鼠設定旋轉
        g2d.drawImage(img, (int) cx, (int) cy, width, height, null);

        if (Global.IS_DEBUG) {
            g2d.drawRect((int) cx, (int) cy, 110, 11);
        }

    }

}
