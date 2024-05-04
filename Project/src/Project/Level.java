package Project;

public class Level {
	int newLvl;
	int newXP;
	public Level(int loot, int xp,int lvl) {
		int newXP = loot + xp;
		if(newXP >= 15 & newXP <20)
			newLvl = 2;
		else if (newXP >= 20 & newXP <35) 
			newLvl = 3;
		else if (newXP >= 35 & newXP <45) 
			newLvl = 4;
		else if (newXP >= 45 & newXP <70) 
			newLvl = 5;
}
}
