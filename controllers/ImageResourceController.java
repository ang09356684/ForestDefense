/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author User
 */
public class ImageResourceController {
    private static class KeyPair{
        private String path;
        private BufferedImage img;
    
        public KeyPair(String path, BufferedImage img){
            this.path = path;
            this.img = img;
        }
    }
    
    private static ImageResourceController irc;
    private ArrayList<KeyPair> pairs;
    
    private ImageResourceController(){
        pairs = new ArrayList<>();
    }
    
    public static ImageResourceController getInstance(){
        if(irc == null){
            irc = new ImageResourceController();
        }
        return irc;
    }
    
    public KeyPair findKeyPair(String path){
        KeyPair tmp;
        for(int i = 0; i <pairs.size();i++){
            tmp = pairs.get(i);
            if(tmp.path.equals(path)){
                return tmp;
            }
        }
        return null;
    }
    
    private BufferedImage addImg(String path){
        try{
            BufferedImage img = ImageIO.read(getClass().getResource(path));
            pairs.add(new KeyPair(path,img));
            return img;
        }catch(IOException e){            
        }
        return null;
    }
    
    public BufferedImage getImage(String path){
        KeyPair tmp = findKeyPair(path);
        if(tmp == null){
            return addImg(path);
        }
        return tmp.img;
    }
}
