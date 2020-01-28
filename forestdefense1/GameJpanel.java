/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forestdefense1;

import controllers.SceneController;
import enemy.Enemy;
import enemy.EnemyFactory;
import gameobject.Arrow;
import gameobject.Bow;
import gameobject.EffectObject;
import enemy.EnemyFactory;
import io.CommandSolver.CommandWrapper;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JPanel;
import scene.TitleScene;
import util.DelayCounter;
import util.Global;

/**
 *
 * @author user
 */
public class GameJpanel extends JPanel {
   private SceneController sceneController;
    public GameJpanel() {
        sceneController = new SceneController();
        sceneController.changeScene(new TitleScene(sceneController));
    }
    
    public void update(CommandWrapper commands) {
        sceneController.sceneUpdate(commands);
    }
    @Override
    public void paintComponent(Graphics g) { //若每秒更新20張圖 就會呼叫20次
        //g是操作畫布的變數 畫出元件
        sceneController.paint(g);
    }
  
}
