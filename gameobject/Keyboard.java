/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import io.CommandSolver;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import scene.TutorialScene;

/**
 *
 * @author user
 */
public class Keyboard {
    private CommandSolver.MouseCommandListener mouseCommandListener;
    private String name;
    
    private ButtonRec q;
    private ButtonRec w;
    private ButtonRec ee;
    private ButtonRec r;
    private ButtonRec t;
    private ButtonRec y;
    private ButtonRec u;
    private ButtonRec i;
    private ButtonRec o;
    private ButtonRec p;
    private ButtonRec backspace;
    
    private ButtonRec a;
    private ButtonRec s;
    private ButtonRec d;
    private ButtonRec f;
    private ButtonRec g;
    private ButtonRec h;
    private ButtonRec j;
    private ButtonRec k;
    private ButtonRec l;
    private ButtonRec colon;
    private ButtonRec enter;
    
    private ButtonRec z;
    private ButtonRec x;
    private ButtonRec c;
    private ButtonRec v;
    private ButtonRec b;
    private ButtonRec n;
    private ButtonRec m;
    private ButtonRec comma;
    private ButtonRec dot;
    private ButtonRec question;
    
    private BufferedImage img;
    private boolean checkName;
    public Keyboard(){
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.KEYBOARD));
        checkName = false;
        
        q = new ButtonRec(2,5,62,55);
        w = new ButtonRec(64,5,62,55);
        ee = new ButtonRec(126,5,62,55);
        r = new ButtonRec(188,5,62,55);
        t = new ButtonRec(250,5,62,55);
        y = new ButtonRec(312,5,62,55);
        u = new ButtonRec(374,5,62,55);
        i = new ButtonRec(436,5,62,55);
        o = new ButtonRec(498,5,62,55);
        p = new ButtonRec(560,5,62,55);
        backspace = new ButtonRec(622,5,124,55);
        
        a = new ButtonRec(20,60,62,55);
        s = new ButtonRec(82,60,62,55);
        d = new ButtonRec(142,60,62,55);
        f = new ButtonRec(204,60,62,55);
        g = new ButtonRec(268,60,62,55);
        h = new ButtonRec(330,60,62,55);
        j = new ButtonRec(392,60,62,55);
        k = new ButtonRec(454,60,62,55);
        l = new ButtonRec(516,60,62,55);
        colon = new ButtonRec(578,60,62,55);
        enter = new ButtonRec(640,60,106,55);
        
        z = new ButtonRec(64,115,62,55);
        x = new ButtonRec(126,115,62,55);
        c = new ButtonRec(188,115,62,55);
        v = new ButtonRec(250,115,62,55);
        b = new ButtonRec(312,115,62,55);
        n = new ButtonRec(374,115,62,55);
        m = new ButtonRec(436,115,62,55);
        comma = new ButtonRec(498,115,62,55);
        dot = new ButtonRec(560,115,62,55);
        question = new ButtonRec(622,115,62,55);
        
        mouseCommandListener = new CommandSolver.MouseCommandListener(){
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
                if(state == CommandSolver.MouseState.PRESSED){
                    if(q.isCollision(e.getX(), e.getY())){
                        q.click(e.getX(), e.getY());
                    }
                    if(w.isCollision(e.getX(), e.getY())){
                        w.click(e.getX(), e.getY());
                    }
                    if(ee.isCollision(e.getX(), e.getY())){
                        ee.click(e.getX(), e.getY());
                    }
                    if(r.isCollision(e.getX(), e.getY())){
                        r.click(e.getX(), e.getY());
                    }
                    if(t.isCollision(e.getX(), e.getY())){
                        t.click(e.getX(), e.getY());
                    }
                    if(y.isCollision(e.getX(), e.getY())){
                        y.click(e.getX(), e.getY());
                    }
                    if(u.isCollision(e.getX(), e.getY())){
                        u.click(e.getX(), e.getY());
                    }
                    if(i.isCollision(e.getX(), e.getY())){
                        i.click(e.getX(), e.getY());
                    }
                    if(o.isCollision(e.getX(), e.getY())){
                        o.click(e.getX(), e.getY());
                    }
                    if(p.isCollision(e.getX(), e.getY())){
                        p.click(e.getX(), e.getY());
                    }
                    if(backspace.isCollision(e.getX(), e.getY())){
                        backspace.click(e.getX(), e.getY());
                    }
                    if(a.isCollision(e.getX(), e.getY())){
                        a.click(e.getX(), e.getY());
                    }
                    if(s.isCollision(e.getX(), e.getY())){
                        s.click(e.getX(), e.getY());
                    }
                    if(d.isCollision(e.getX(), e.getY())){
                        d.click(e.getX(), e.getY());
                    }
                    if(f.isCollision(e.getX(), e.getY())){
                        f.click(e.getX(), e.getY());
                    }
                    if(g.isCollision(e.getX(), e.getY())){
                        g.click(e.getX(), e.getY());
                    }
                    if(h.isCollision(e.getX(), e.getY())){
                        h.click(e.getX(), e.getY());
                    }
                    if(j.isCollision(e.getX(), e.getY())){
                        j.click(e.getX(), e.getY());
                    }
                    if(k.isCollision(e.getX(), e.getY())){
                        k.click(e.getX(), e.getY());
                    }
                    if(l.isCollision(e.getX(), e.getY())){
                        l.click(e.getX(), e.getY());
                    }
                    if(colon.isCollision(e.getX(), e.getY())){
                        colon.click(e.getX(), e.getY());
                    }
                    if(enter.isCollision(e.getX(), e.getY())){
                        enter.click(e.getX(), e.getY());
                    }
                    if(z.isCollision(e.getX(), e.getY())){
                        z.click(e.getX(), e.getY());
                    }
                    if(x.isCollision(e.getX(), e.getY())){
                        x.click(e.getX(), e.getY());
                    }
                    if(c.isCollision(e.getX(), e.getY())){
                        c.click(e.getX(), e.getY());
                    }
                    if(v.isCollision(e.getX(), e.getY())){
                        v.click(e.getX(), e.getY());
                    }
                    if(b.isCollision(e.getX(), e.getY())){
                        b.click(e.getX(), e.getY());
                    }
                    if(n.isCollision(e.getX(), e.getY())){
                        n.click(e.getX(), e.getY());
                    }
                    if(m.isCollision(e.getX(), e.getY())){
                        m.click(e.getX(), e.getY());
                    }
                    if(comma.isCollision(e.getX(), e.getY())){
                        comma.click(e.getX(), e.getY());
                    }
                    if(question.isCollision(e.getX(), e.getY())){
                        question.click(e.getX(), e.getY());
                    }                
                }
            }
        };    
    }
    
    public void check(){
        q.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "q";  
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        w.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "w";
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        ee.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "e";
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        r.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "r";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        t.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "t";     
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        y.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "y";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        u.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "u";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        i.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
               name += "i";        
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        o.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "o";     
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        p.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "p";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        backspace.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                char[] tmp = new char[name.length()-1];
                for(int i = 0; i <name.length()-1; i++){
                    tmp[i] = name.charAt(i);
                }
               name =  String.valueOf(tmp);                     
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        a.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "a";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        s.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "s";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );    
        d.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
               name += "d";        
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        f.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "f";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        g.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "g";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        h.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
               name += "h";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        j.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "j";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        k.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "k";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        l.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "l";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        colon.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += ":";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        ///////////////
        enter.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        z.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "z";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        x.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "x";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        c.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "c";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        v.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
               name += "v";        
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );    
        b.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 name += "b";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        n.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 name += "n";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        m.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                name += "m";       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        comma.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 name += ",";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );
        
        question.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 name += "?";      
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );       
    }
    
    public String getName(){
            return name;        
    }
    
    public void checkName(){
        checkName = true;
    }
    
    public void resetCheck(){
        checkName = false;
    }
    
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);//畫背景
    }
    
}
