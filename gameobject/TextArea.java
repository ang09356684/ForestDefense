/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.MONOSPACED;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class TextArea {
    private int x;
    private int y;
    private ArrayList<String> contents;
    private int size;
    private int type;
    private int interval;
    private Color color;
    
    public TextArea(int x, int y, int size, String content){
        this.x = x;
        this.y = y;        
        this.size = size;
        contents = new ArrayList<>();
        contents.add(content);
        type = 0;
        color = new Color(0,0,0);
    }
    public TextArea(int x, int y, int size){
        this.x = x;
        this.y = y;        
        this.size = size;
        contents = new ArrayList<>();
        type = 0;
        color = new Color(0,0,0);
    }    
    public TextArea resetContent(int index, String content){
        contents.set(index, content);
        return this;
    }
    public TextArea addContent(String content){
        contents.add(content);//nextLine
        return this;
    }
    
    public TextArea setInterval(int interval){ // 每行間格
        this.interval = interval;
        return this;
    }

    public TextArea changeToBlod(){
        type = 1;
        return this;
    }
    
    public TextArea changeToPLAIN(){
        type = 0;
        return this;
    }
    
    public TextArea changeColorToBlue(){
        this.color = new Color(78,94,119);
        return this;
    }
    
    public TextArea changeColorToWhite(){
        this.color = new Color(255,255,255);
        return this;
    }
    
    public TextArea changeColorToBlack(){
        this.color = new Color(0,0,0);
        return this;
    }
    
    public TextArea changeColorToRed(){
        this.color = new Color(224,34,34);
        return this;
    }
    
    public void resetX(int x){
        this.x = x;
    }
    
    public void resetY(int y){
        this.y = y;
    }
    public void paint(Graphics g) {
        Font font = new Font("微軟正黑體", type, size);
        g.setFont(font);
        g.setColor(color);
        for(int i = 0; i <contents.size();i++){
            g.drawString(contents.get(i), x, y+(size*i+i*interval));
        }    
    }
}
