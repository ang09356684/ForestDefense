package magic;

import enemy.Enemy;
import controllers.ImagePath;
import controllers.ImageResourceController;
import controllers.PathBuilder;
import enemy.Enemy;
import gameobject.*;
import java.awt.Point;
import java.awt.image.BufferedImage;
import util.DelayCounter;
import util.Global;

public abstract class Magic extends EffectObject {

    private BufferedImage effectImg;
    private int speed;
    private int power;
    private boolean isReady;
    private DelayCounter delayCounter;
    private DelayCounter effectDuration;
    protected int picNum = 0;//第幾格的動作圖
    protected int cx = 0;
    protected int cy = 0;
    private boolean isMagicDone;

    public Magic(int x, int y, int width, int height, int speed, int power, int duration, String path) {
        super(x, y, width, height);
        this.speed = speed * Global.MAGIC_MOVE_SPEED;
        this.power = power;
        isReady = false;
        delayCounter = new DelayCounter(1);
        effectDuration = new DelayCounter(duration);

        if (!path.equals("")) {
            ImageResourceController irc = ImageResourceController.getInstance();
            effectImg = irc.getImage(path);
        }
    }

    public void updatePos(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    public void setReady(boolean value) {
        isReady = value; //更新完釋放座標 設為true
    }

    public boolean isReady() {
        return isReady;
    }

    public int getSpeed() {
        return this.speed;
    }

    public abstract int getNum();// picNum limit
    // 暫時 = duration time

    public int getPower() {
        return this.power;
    }

    public void magicEffect(Enemy e) {
        if (!e.isCollision(this) || isEffectDone() || !isReady()) {
            //沒有碰撞 技能效果結束 
            effectEnd(e);// ice 用 要恢復原本的速度
            e.setMagicEffectImg(null);
            return;
        }
        e.setMagicEffectImg(effectImg);
        effect(e);
    }

    public abstract void effectEnd(Enemy e);

    public abstract void effect(Enemy e);

    protected void magicDone() {
        this.isMagicDone = true;
    }

    public boolean isMagicDone() {
        return isMagicDone;
    }

    public boolean updateNum() {
        if (picNum == getNum()) {
            return false;
        }
        if (delayCounter.update()) {
            picNum = ++picNum;
            updatePic();
        }
        return true;
    }

    public boolean checkAnima() {
        return picNum != getNum(); //!= true == false
    }

    public void update() {
        if (effectDuration.update()) { // duration in DelayCounter
            effectDuration.stop(); //DelayCounter.isPause = true;
        }
        if (!checkAnima() && effectDuration.isPause()) {
            //技能動畫釋放結束 效果結束
            magicDone(); // magicDone = true;
        }
    }
    
    public abstract void playSound();
    protected boolean isEffectDone() {
        return effectDuration.isPause();
    }

    public abstract void updatePic();

    public MagicRange getRange() {
        return null;
    }
}
