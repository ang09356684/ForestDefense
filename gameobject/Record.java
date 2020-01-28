/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameobject;

import java.io.Serializable;

public class Record implements Comparable<Record>, Serializable{
    private String name;
    private int score;
    
    public Record(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getScore(){
        return this.score;
    } 
    
    public String nametoString(){
        return "player:   " + this.name;
    }
    
    public String scoretoString(){
        return "score:   " + this.score;
    }

    @Override
    public int compareTo(Record other) {
        return other.getScore()-this.score;
    }
  
}
