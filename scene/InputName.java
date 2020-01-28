/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scene;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.MusicPath;
import controllers.MusicPlay;
import controllers.PathBuilder;
import controllers.SceneController;
import gameobject.ButtonRec;
import gameobject.Keyboard;
import gameobject.RankList;
import gameobject.TextArea;
import io.CommandSolver;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import util.Global;
import static util.Global.MY_RATIO;

/**
 *
 * @author user
 */
public class InputName extends Scene{
    private CommandSolver.MouseCommandListener mouseCommandListener;
    private CommandSolver.KeyCommandListener keyCommandListener;    

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
    
    private boolean checkInput;
    private String name;
    private TextArea textArea;
    private BufferedImage keyBoardImg;
    private BufferedImage img;
    private int keyboardX;
    private int keyboardY;
    private RankList ranklist;
    private MusicPlay bgm;
    private float nowsize;
    
    public InputName(SceneController sceneController) {
        super(sceneController);
        nowsize = Global.MY_RATIO;
        checkInput = false;
        textArea = new TextArea((int)(127.5*MY_RATIO),(int)(87.75*MY_RATIO),(int)(20*MY_RATIO)," ").changeToBlod();
        
        keyboardX = (int)(62.5*MY_RATIO);
        keyboardY = (int)(118.75*MY_RATIO);
        name = "";
        ranklist = new RankList();
        bgm = new MusicPlay(PathBuilder.getMusic(MusicPath.SceneMusic.RANK));
        bgm.loop();
        
        mouseCommandListener = new CommandSolver.MouseCommandListener(){
            @Override
            public void mouseTrig(MouseEvent e, CommandSolver.MouseState state, long trigTime) {
                if(state == CommandSolver.MouseState.PRESSED){
                    if(backspace.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        backspace.click(e.getX(), e.getY());
                    }
                    
                    if(enter.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        enter.click(e.getX(), e.getY());
                    }
                    
                    if(name.length()<5){
                    if(q.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        q.click(e.getX(), e.getY());
                    }
                    if(w.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        w.click(e.getX(), e.getY());
                    }
                    if(ee.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        ee.click(e.getX(), e.getY());
                    }
                    if(r.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        r.click(e.getX(), e.getY());
                    }
                    if(t.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        t.click(e.getX(), e.getY());
                    }
                    if(y.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        y.click(e.getX(), e.getY());
                    }
                    if(u.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        u.click(e.getX(), e.getY());
                    }
                    if(i.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        i.click(e.getX(), e.getY());
                    }
                    if(o.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        o.click(e.getX(), e.getY());
                    }
                    if(p.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        p.click(e.getX(), e.getY());
                    }
                    if(a.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        a.click(e.getX(), e.getY());
                    }
                    if(s.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        s.click(e.getX(), e.getY());
                    }
                    if(d.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        d.click(e.getX(), e.getY());
                    }
                    if(f.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        f.click(e.getX(), e.getY());
                    }
                    if(g.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        g.click(e.getX(), e.getY());
                    }
                    if(h.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        h.click(e.getX(), e.getY());
                    }
                    if(j.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        j.click(e.getX(), e.getY());
                    }
                    if(k.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        k.click(e.getX(), e.getY());
                    }
                    if(l.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        l.click(e.getX(), e.getY());
                    }
                    if(colon.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        colon.click(e.getX(), e.getY());
                    }
                    if(z.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        z.click(e.getX(), e.getY());
                    }
                    if(x.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        x.click(e.getX(), e.getY());
                    }
                    if(c.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        c.click(e.getX(), e.getY());
                    }
                    if(v.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        v.click(e.getX(), e.getY());
                    }
                    if(b.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        b.click(e.getX(), e.getY());
                    }
                    if(n.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        n.click(e.getX(), e.getY());
                    }
                    if(m.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        m.click(e.getX(), e.getY());
                    }
                    if(comma.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        comma.click(e.getX(), e.getY());
                    }
                    if(question.isCollision(e.getX(), e.getY())){
                        checkTrue();
                        question.click(e.getX(), e.getY());
                    }                
                }
            }
            }        
        };           
    }

    @Override
    public void sceneBegin() {
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.SceneImg.INPUTNAME));
        keyBoardImg = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.KEYBOARD));
        reset();
    }

    @Override
    public void sceneUpdate() {
        if(nowsize != Global.MY_RATIO){
            nowsize = Global.MY_RATIO;
            reset();
        }
        
        if(getCheckinput()){
            if(name.length()>5){
                this.checkInput = false;
                return;
            }
            Global.userName = name;
            textArea.resetContent(0,name);
            this.checkInput = false;
        }
    }

    @Override
    public void sceneEnd() {
        bgm.stop();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, (int)(320*MY_RATIO), (int)(192*MY_RATIO), null);
        g.drawImage(keyBoardImg, +keyboardX, +keyboardY, (int)(187.75*MY_RATIO), (int)(39.5*MY_RATIO), null);
        textArea.paint(g);
    }
    
    public boolean getCheckinput(){
        return checkInput;
    }
    
    public void checkTrue(){
        this.checkInput = true;
    }
    
    public void reset(){
        textArea = new TextArea((int)(127.5*MY_RATIO),(int)(87.75*MY_RATIO),(int)(20*MY_RATIO)," ").changeToBlod();
        keyboardX = (int)(62.5*MY_RATIO);
        keyboardY = (int)(118.75*MY_RATIO);
        
        q = new ButtonRec((int)(0.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        w = new ButtonRec((int)(16*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        ee = new ButtonRec((int)(31.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        r = new ButtonRec((int)(47*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        t = new ButtonRec((int)(62.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        y = new ButtonRec((int)(78*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        u = new ButtonRec((int)(93.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        i = new ButtonRec((int)(109*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        o = new ButtonRec((int)(124.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        p = new ButtonRec((int)(140*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        backspace = new ButtonRec((int)(155.5*MY_RATIO)+keyboardX,(int)(1.25*MY_RATIO)+keyboardY,(int)(31*MY_RATIO),(int)(13.75*MY_RATIO));
        
        a = new ButtonRec((int)(5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        s = new ButtonRec((int)(20.5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        d = new ButtonRec((int)(35.5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        f = new ButtonRec((int)(51*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        g = new ButtonRec((int)(67*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        h = new ButtonRec((int)(82.5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        j = new ButtonRec((int)(98*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        k = new ButtonRec((int)(113.5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        l = new ButtonRec((int)(129*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        colon = new ButtonRec((int)(144.5*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        enter = new ButtonRec((int)(160*MY_RATIO)+keyboardX,(int)(15*MY_RATIO)+keyboardY,(int)(26.5*MY_RATIO),(int)(13.75*MY_RATIO));
        
        z = new ButtonRec((int)(16*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        x = new ButtonRec((int)(31.5*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        c = new ButtonRec((int)(47*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        v = new ButtonRec((int)(62.5*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        b = new ButtonRec((int)(78*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        n = new ButtonRec((int)(93.5*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        m = new ButtonRec((int)(109*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        comma = new ButtonRec((int)(124.5*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        dot = new ButtonRec((int)(140*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        question = new ButtonRec((int)(155.5*MY_RATIO)+keyboardX,(int)(28.75*MY_RATIO)+keyboardY,(int)(15.5*MY_RATIO),(int)(13.75*MY_RATIO));
        
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
        enter.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                if(!ranklist.readData() || ranklist.getlast() == null){
                    ranklist.add(Global.userName, (Global.score + Global.wallHp));
                }else{
                    if((Global.score + Global.wallHp) > ranklist.getlast().getScore()){
                        ranklist.add(Global.userName, (Global.score + Global.wallHp));
                    }
                }
                sceneEnd();
                Global.resetGame(); //破關後 reset
                sceneController.changeScene(new RankScene(sceneController));       
            }
            @Override
            public void hover(int x, int y) {
            }
        }
        );        
        if(name.length()<5){
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
        dot.setButtonListener(new ButtonRec.ButtonListener(){            
            @Override            
            public void onClick(int x, int y) {
                 name += ".";      
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
        
    }
    
    @Override
    public CommandSolver.KeyCommandListener getKeyCommandListener(){return keyCommandListener;}
    @Override
    public CommandSolver.MouseCommandListener getMouseCommandListener(){return mouseCommandListener;}    
}
