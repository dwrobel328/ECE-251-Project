package Project;
import java.util.Random;
import Project.Room;
public class Rand {
static Random rand = new Random();
 
 public Rand() { 
 }
	public static int RandomHit(int hit) {
		int random;
		random = rand.nextInt(hit);
		return random;
	}
	public static int RandomXP() {
		int random; 
		random  = rand.nextInt(10); //attack plus 0-3 bonus
		return random;
	}
	public static int RandMoney(int money) {
		int random;
		random = rand.nextInt(money);
		return random;
	}
	public static boolean didTrip() {
		int random;
		random = rand.nextInt(1000);
		if (random <= 500) {
			return true;
		}else {
			return false;
		}
	}
	
	public static int bossAtk() {
		int random;
		int atk =0;
		random = rand.nextInt(3000);
		if(random<=1000) {
			atk=1;
		}else if(1000<random & random<=2000){
			atk=2;
		}else {
			atk=3;
		}
		return atk;
	}
	
	public static boolean runUnder() {
		int random;
		random = rand.nextInt(1000);
				if(random<=700) {
					return true;
				}else {
					return false;
				}
	}
}
