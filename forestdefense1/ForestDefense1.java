/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forestdefense1;

import io.CommandSolver;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import util.Global;

public class ForestDefense1 {

    public static void main(String[] args) {    	
        JFrame j = new JFrame();
        j.setTitle("Forest Defense");
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.setSize((int)(Global.PANEL_X * Global.MY_RATIO) , (int)(Global.PANEL_Y * Global.MY_RATIO)+38);
        GameJpanel jp = new GameJpanel();
        j.add(jp);        
        j.setVisible(true);
        CommandSolver cs = new CommandSolver.Builder(Global.MILLISEC_PER_UPDATE, new int[][]{
        }).enableMouseTrack(jp).gen();
        cs.start();
        
        long startTime = System.currentTimeMillis();
        long lastRepaintTime = System.currentTimeMillis();
        long passedFrames = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            long totalTime = currentTime - startTime;
            long targetTotalFrames = totalTime / Global.MILLISEC_PER_UPDATE ;

            while (passedFrames < targetTotalFrames) {
                Global.MY_RATIO = (float)j.getBounds().width/Global.PANEL_X;//取得當前視窗X大小比例
                j.setSize((int)(Global.PANEL_X * Global.MY_RATIO) , (int)(Global.PANEL_Y * Global.MY_RATIO)+38);
                jp.update(cs.update());
                passedFrames++;
            }
            
            if (Global.MILLISEC_PER_FRAME <= currentTime - lastRepaintTime) {
                lastRepaintTime = currentTime;
                j.repaint();
            }
        }
    }
   
}
    

