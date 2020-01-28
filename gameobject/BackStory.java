/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import util.DelayCounter;
import static util.Global.MY_RATIO;

/**
 *
 * @author User
 */
public class BackStory {  //pass
    private BufferedImage img;
    private BufferedImage img2;
    private TextArea text;
    private TextArea title;
    private int y;
    private DelayCounter delay;
    
    public BackStory(){
        ImageResourceController irc = ImageResourceController.getInstance();
        img = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.BACKSOTRY));
        img2 = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.BACKSOTRYTITLE));
        title = new TextArea((int)(152.5*MY_RATIO),(int)(17.5*MY_RATIO),(int)(15*MY_RATIO),"STORY").changeToBlod(); //610,70,60
        delay = new DelayCounter(1);
        this.y = (int)(150*MY_RATIO); //600
        text = new TextArea((int)(120*MY_RATIO),y,(int)(7.5*MY_RATIO)," ").changeToBlod().setInterval((int)(0.75*MY_RATIO));
        addStory();
    }
    
    public void update(){
        if(delay.update()){
            if(this.y > -(int)(35*MY_RATIO)){
                this.y -= (int)(1*MY_RATIO);        
                text.resetY(this.y);
            }
        }
    }
    
    private void addStory(){
        text.addContent("一座位於邊陲地帶的森林");
        text.addContent("有著豐富的自然資源");
        text.addContent("而此處的森民");
        text.addContent("上百年來過著與世隔絕的生活");
        text.addContent("                    ");
        text.addContent("另一方面");
        text.addContent("半獸人從默默無名的種族崛起");
        text.addContent("短短時間就統治了所有的怪物種族");
        text.addContent("慾望進一步擴張");
        text.addContent("統治全世界是他們的下個目標");
        text.addContent("為此半獸人必須掌握大量的資源");
        text.addContent("來進行更大的戰爭");
        text.addContent("                ");
        text.addContent("於是");
        text.addContent("這座森林就成了首要目標");
        text.addContent("                 ");
        text.addContent("但……");
        text.addContent("半獸人不知道的是");
        text.addContent("森民們能夠百年來過著與世隔絕的生活");
        text.addContent("是因為");
        text.addContent("他們擁有絕對的強悍");
    }
    
    public void paint(Graphics g){
        update();
        g.drawImage(img, (int)(87.5*MY_RATIO), 0,(int)(177.5*MY_RATIO),(int)(192*MY_RATIO), null);
        //title.paint(g);
        text.paint(g);
        g.drawImage(img2, (int)(87.5*MY_RATIO), 0,(int)(177.5*MY_RATIO),(int)(32.5*MY_RATIO),null);

    }
}
