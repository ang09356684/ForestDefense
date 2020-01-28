/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author user
 */
public class DelayCounter {
    private int delay;
    private int count;
    private boolean isPause;
    
    public DelayCounter(int delay){
        this.delay = Global.DELAY*delay;
        isPause = false;
    }
    
    public void stop(){
        isPause = true;
        count = 0;
    }
    
    public boolean isPause(){
        return isPause;
    }
    
    public boolean update(){
        if(isPause){
            return false;
        }
        if(count < delay){
            count++;
            return false;
        }
        count = 0;
        return true;
    }
}
