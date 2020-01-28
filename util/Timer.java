package util;

import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import static util.Global.MY_RATIO;

public class Timer {

    private int currentRemainingTime;
    private int defaultRemainingTime;
    DelayCounter dCounter;
    private int tens;
    private int units;
    private BufferedImage tensImg;
    private BufferedImage unitsImg;
    private int unitsPicX;
    private int tensPicX;

    public Timer(int defaultRemainingTime) {
        this.defaultRemainingTime = defaultRemainingTime; //固定值
        this.currentRemainingTime = defaultRemainingTime; //會減少
        tens = this.currentRemainingTime / 10;
        units = this.currentRemainingTime % 10;
        updatePic();
        dCounter = new DelayCounter(30); //時間會不穩
        ImageResourceController irc = ImageResourceController.getInstance();
        tensImg = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.NUM));
        unitsImg = irc.getImage(PathBuilder.getImg(ImagePath.Meterial.NUM));
    }

    public boolean update() {
        if (dCounter.update()) {
            currentRemainingTime -= 1;
            tens = this.currentRemainingTime / 10;
            units = this.currentRemainingTime % 10;
            updatePic();
        }
        if (currentRemainingTime <= 0) {
            return false;
        }
        return true;
    }

    public void reset() {
        this.currentRemainingTime = defaultRemainingTime;
    }

    public void updatePic() {
        unitsPicX = units * 64;
        tensPicX = tens * 64;
    }

    public void paint(Graphics g) {
        g.drawImage(tensImg, (int)(141*MY_RATIO), (int)(7.5*MY_RATIO), (int)(157*MY_RATIO), (int)(23.5*MY_RATIO), tensPicX, 0,
                tensPicX + 64, 0 + 65, null);
        g.drawImage(unitsImg, (int)(157*MY_RATIO), (int)(7.5*MY_RATIO), (int)(173*MY_RATIO), (int)(23.5*MY_RATIO), unitsPicX, 0,
                unitsPicX + 64, 0 + 65, null);
        }
    
    public int getTime() {
    	return currentRemainingTime;
    }
}


