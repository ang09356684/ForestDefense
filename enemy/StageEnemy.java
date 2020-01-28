package enemy;

import static util.Global.ENEMY_RIGHT;
import static util.Global.ENEMY_UP ;
import static util.Global.ENEMY_WIDTH;
import static util.Global.MY_RATIO;
import static util.Global.DEFAULT_BLOOD_ZOMBIE;
import static util.Global.DEFAULT_BLOOD_MUMMY;
import static util.Global.DEFAULT_BLOOD_ROCKMAN;
import static util.Global.DEFAULT_BLOOD_KILLER;
import static util.Global.DEFAULT_BLOOD_GHOST;
import static util.Global.DEFAULT_BLOOD_MONSTER;
import java.lang.Math;

public class StageEnemy { //用來設定不同關卡要new什麼敵人種類
	static Enemy enemy;
	
	public static Enemy stageOne( int i ) {
		int randomPosition = (int) (Math.random() * 3); 

		switch(i) { 
			case 0:
				enemy = new Zombie( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)),DEFAULT_BLOOD_ZOMBIE,1,10 );	
			return enemy;
			case 1:
				enemy = new Mummy( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1*MY_RATIO)),DEFAULT_BLOOD_MUMMY,1,10 );
			return enemy;
			case 2: 
				enemy = new Mummy( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1*MY_RATIO)),DEFAULT_BLOOD_MUMMY,1,10 );
			return enemy;
		}
		return null;
	}
	
	public static Enemy stageTwo( int i ) {
		int randomPosition = (int) (Math.random() * 3);
		//int speed, int hp, int atk, int def
		switch(i) { //隨機取出關卡2的敵人
			case 0:
				enemy = new Zombie( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)),DEFAULT_BLOOD_ZOMBIE,1,10 );	
			return enemy;
			case 1:
				enemy = new Mummy( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1*MY_RATIO)),DEFAULT_BLOOD_MUMMY,1,10 );
			return enemy;
			case 2:
				enemy = new Rockman( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)),DEFAULT_BLOOD_ROCKMAN,2,15 );
			return enemy;
		}
		return null;
	}
	
	public static Enemy stageThree( int i ) {
		int randomPosition = (int) (Math.random() * 3);

		switch(i) { 
			case 0:
				enemy = new Mummy( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1*MY_RATIO)),DEFAULT_BLOOD_MUMMY,1,10 );	
			return enemy;
			case 1:
				enemy = new Rockman( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)),DEFAULT_BLOOD_ROCKMAN,2,15 );
			return enemy;
			case 2:
				enemy = new Killer( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(2*MY_RATIO)), DEFAULT_BLOOD_KILLER, 2, 15 );
			return enemy;
		}
		return null;
	}
	
	public static Enemy stageFour( int i ) {
		int randomPosition = (int) (Math.random() * 3);

		switch(i) { 
			case 0:
				enemy = new Rockman( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)),DEFAULT_BLOOD_ROCKMAN,2,15 );	
			return enemy;
			case 1:
				enemy = new Killer( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(2*MY_RATIO)), DEFAULT_BLOOD_KILLER, 2, 15 );
			return enemy;
			case 2:
				enemy = new Ghost( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)), DEFAULT_BLOOD_GHOST, 3, 20 );
			return enemy;
		}
		return null;
	}
	
	public static Enemy stageFive( int i ) {
		int randomPosition = (int) (Math.random() * 3);

		switch(i) { 
			case 0:
				enemy = new Killer( (int)(ENEMY_RIGHT*MY_RATIO) ,(int) (ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(2*MY_RATIO)), DEFAULT_BLOOD_KILLER, 2, 15 );	
			return enemy;
			case 1:
				enemy = new Ghost( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)), DEFAULT_BLOOD_GHOST, 3, 20 ); //G
			return enemy;
			case 2:
				enemy = new Monster( (int)(ENEMY_RIGHT*MY_RATIO) , (int)(ENEMY_UP*MY_RATIO)+randomPosition*(int)(ENEMY_WIDTH*MY_RATIO) , (int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_WIDTH*MY_RATIO), (int)(Math.round(1.25*MY_RATIO)), DEFAULT_BLOOD_MONSTER, 3, 30 ); //M
			return enemy;
		}
		return null;
	}
	
}
