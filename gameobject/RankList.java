/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static util.Global.MY_RATIO;

/**
 *
 * @author user
 */

public class RankList implements Serializable{
    private ArrayList<Record> list;
    private TextArea textName;
    private TextArea textScore;
    
    public RankList(){
        list = new ArrayList<>();
        textName = new TextArea((int)(100*MY_RATIO),(int)(42.5*MY_RATIO),(int)(10*MY_RATIO)).changeToBlod().setInterval((int)(15*MY_RATIO));
        textScore = new TextArea((int)(180*MY_RATIO),(int)(42.5*MY_RATIO),(int)(10*MY_RATIO)).changeToBlod().setInterval((int)(15*MY_RATIO));
    }
    
    public void sort(){
        Collections.sort(list);
    }
    
    public void writeData(){
        FileOutputStream fos;
        try{
            fos = new FileOutputStream("rank.ser"); //序列化不需要附檔名 ser只是習慣
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public boolean readData(){
        FileInputStream fis;
        try {
            fis = new FileInputStream("rank.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ArrayList<Record> s = (ArrayList<Record>) ois.readObject();
            this.list = s;
            fis.close();
            ois.close();
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public void add(String name, int score){
        Record tmp = new Record(name, score);
        if(readData()){
            sort();
            if(list.size()<5){
                list.add(tmp);
            }else{
                list.set(4, tmp);
            }
        }else{        
            list.add(tmp);
        }
        resetRank();
        writeData();
    }
    
    public Record getlast(){
        if(list.size()<5){
            return null;
        }
        return list.get(4);
    }
    
    public void resetRank(){
        sort();
        for(int i = 0; i <list.size();i++){
            textName.addContent(list.get(i).nametoString());
            textScore.addContent(list.get(i).scoretoString());
        }
    }
    
    public void paint(Graphics g) {
        textName.paint(g);
        textScore.paint(g);
    }
}
