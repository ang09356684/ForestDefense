/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enemy;

import util.Global;

public class EnemyFactory {
	private int stage;
	private Enemy enemy;
	public Enemy generateEnemy(Generator generator) {
		int r= (int) (Math.random() * 3);
		return generator.generateEnemy(r); 
	}
	
	public EnemyFactory() {
		this.stage = Global.stage; 
	}
	
	public Enemy generateEnemy( ) {
		switch(stage) {
		case 1:
			enemy = generateEnemy(StageEnemy::stageOne);
		break;
		case 2:
			enemy = generateEnemy(StageEnemy::stageTwo);
		break;
		case 3:
			enemy = generateEnemy(StageEnemy::stageThree);
		break;
		case 4:
			enemy = generateEnemy(StageEnemy::stageFour);
		break;
		case 5:
			enemy =generateEnemy(StageEnemy::stageFive);
		break;
		}
		return enemy;
	}
}
