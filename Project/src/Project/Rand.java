package Project;
import java.util.Random;
public class Rand {
static Random rand = new Random();
 
 public Rand() { 
 }
	public static int RandomHit(int hit) {
		int random;
		random = rand.nextInt(hit);
		return random;
	}
	public static double RandomXP() {
		double random; 
		random  = rand.nextDouble(10); //attack plus 0-3 bonus
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
}
