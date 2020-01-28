package enemy;

import static util.Global.ENEMY_RIGHT;
import static util.Global.ENEMY_UP;
import static util.Global.ENEMY_WIDTH;
import static util.Global.MY_RATIO;

import java.util.ArrayList;

public class SoldiersFactory {
	private int stage; //關卡
	StageEnemy se; //可以從StageEnemy中抽一種 new一隻敵人
	ArrayList<Enemy> soldiers; //要return的敵人軍隊
	
	public SoldiersFactory(int stage) {
		se = new StageEnemy();
		setStage(stage); //關卡 -> 決定敵人種類 陣型內敵人數
						//陣型數-> 需要"敵人" 會決定陣型排列方式
						//在Scene Begin建造一次 每次出現的一樣
		setStageEnemy(); //只有begin set一次
	}
	
	public void setStage(int stage) {
		this.stage = stage;
	}
	
	public void setStageEnemy() { //設定關卡內敵人種類 
		int i;
		Enemy leader;
		Enemy member;
		soldiers = new ArrayList<>();
		switch( stage ) { 
		//StageEnemy裡隨機產生一隻
		
		case 2: 			//speed = 4 ~ 5
			i = (int) (Math.random() * 3); 
			leader = StageEnemy.stageTwo(i) ;
			soldiers.add( leader ) ;	
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageTwo(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第二隻必須跟第一隻同速度
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageTwo(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第三隻也必須跟第一隻同速度
			
			trainSoldiers(); //改變位置
		break;

		case 3:
			i = (int) (Math.random() * 3); 
			leader = StageEnemy.stageThree(i) ;
			soldiers.add( leader ) ;	
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageThree(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第二隻必須跟第一隻同速度
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageThree(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第三隻也必須跟第一隻同速度
			
			trainSoldiers(); //改變位置 	
		break;
		
		case 4:
			i = (int) (Math.random() * 3); 
			leader = StageEnemy.stageFour(i) ;
			soldiers.add( leader ) ;	
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFour(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第二隻必須跟第一隻同速度
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFour(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第三隻也必須跟第一隻同速度			
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFour(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; 
			
			trainSoldiers(); //改變位置 	
		break;
		
		case 5:
			i = (int) (Math.random() * 3); 
			leader = StageEnemy.stageFive(i) ;
			soldiers.add( leader ) ;	
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFive(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第二隻必須跟第一隻同速度
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFive(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; //第三隻也必須跟第一隻同速度	
			
			do {
				i = (int) (Math.random() * 3);
				member = StageEnemy.stageFive(i);
			}while(member.getSpeed() != leader.getSpeed());
			soldiers.add( member ) ; 
			trainSoldiers(); //改變位置 	
		break;
		}
	}
		
 
	private void trainSoldiers() { 
		int r = (int) (Math.random() * 3 );
		if( stage == 2 || stage == 3 ) { //三隻敵人的陣型		
			
			switch( 2 ){
				case 0: //直列 在第一排
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO)*2,(int)(ENEMY_UP*MY_RATIO));
					//System.out.println("form 1");
				break;
				case 1: //橫排
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					//System.out.println("form 2");
				break;
				case 2: //凸型
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					//System.out.println("form 3");
				break;
			}
		}
		
		if( stage == 4 || stage == 5) {	 //四隻敵人的陣型		
			switch( r ){ //感覺卡卡的
				case 0: //直列 在第三排
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO)*2,(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					soldiers.get(3).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO)*3,(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					//System.out.println("form 1");
				break;
				case 1: //方形 在一二排
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(3).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					//System.out.println("form 2");
				break;
				case 2: //凸型
					soldiers.get(0).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO));
					soldiers.get(1).setFormation((int)(ENEMY_RIGHT*MY_RATIO)-(int)(ENEMY_WIDTH*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					soldiers.get(2).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO)*2);
					soldiers.get(3).setFormation((int)(ENEMY_RIGHT*MY_RATIO),(int)(ENEMY_UP*MY_RATIO)+(int)(ENEMY_WIDTH*MY_RATIO));
					//System.out.println("form 3");
				break;
			}	
		}
	}
	
	public ArrayList<Enemy> getSoldiers(){
            //System.out.println("set");
	setStageEnemy();
	//trainSoldiers();	
            return soldiers; 
	}
}