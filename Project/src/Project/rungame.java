package Project;
import java.util.Scanner;
import java.util.Random;
public class rungame {
	static int rooms(int room, String name) {
		// TODO Auto-generated constructor stub
		Scanner output = new Scanner(System.in);
		int hp=30,lvl=0,gold=0,atk=0,r=0,y=0, hit=0; // Player Stats
		double xp = 0, loot; //Player xp
		int mHP =0, mAtk =0; //monster stats
		int input = 0,coins =0;// input
		switch (room) {
			case 1: //chest room (This can be changed just wanted to try it out and give them an attacking weapon
				System.out.println(name + " walked in the first room. You discovered that there is three chest numbered: '1', '2', '3'. \n What will " + name+ " take?"  );
				input = output.nextInt();
				while (input !=6876)// while so they need to answer it.
				{
					if (input == 1) // first chest
					{
					atk = atk + 1;
					System.out.println(name + " opened the 1st chest. you have recieved a sword with Attack 1! *\n *attack was rose to:  "
							+atk + "*");
						input = 6876; // to get out of the loop
					}
					else if(input == 2) //second chest
					{
						atk = atk + 2;
						System.out.println(name + " opened the 2nd chest. you have recieved a sword with Attack 2! *\n *attack was rose to:  "
								+atk + "*");
							input = 6876;// to get out of the loop
					}
					else if(input == 3) //third chest
					{
						atk = atk + 3;
						System.out.println(name + " opened the 2nd chest. you have recieved a sword with Attack 3! *\n\n *attack was rose to:  "
								+atk + "*\n\n\n");
							input = 6876;// to get out of the loop
					}
					else
					{
						System.out.println("Please type in: 1, 2, or 3."); // wrong input pls try again.
					}
				}
				System.out.println(name + " says outloud: \n Alright time to go to the next room.\n\n\n");
				room=2; // room 2 is accessible 
				input = 0;
				return room;
				
			case 2: // mob room
				mHP=5;mAtk = 1; // mob stat for room
				System.out.println(name + " entered the second room.\n " + name + "There is a monster! What will you do? \n1. Slash your sword \n2. Say hi \n3. hide "); // change what you want
				input = output.nextInt();
				while (input != 6876) //while until they kill the monster
				{
					
					if (input == 1) // attack
					{
						System.out.println(name + " Starts slashing the monster");
						hit = RandHit(atk);
						mHP = mHP - hit ;
						System.out.println("While " +name + " slashed the sword, he hit him for: " +hit +" .\n The monster now has: " + (mHP)+ " hp.");
						System.out.println("The monster got up and punched you! ");
						hit = RandHit(mAtk);
						hp = hp- hit;
						System.out.println("The monster hit you for: " + hit + "! \n You now have: " + hp + "hp." );
						input = 0;
					}
					else if(input == 2) //say hi (IDK)
					{
						hit = RandHit(mAtk);
						hp = hp - hit;
						System.out.println(name + " shouted at the monster: \n 'Hello! come and fight me!'\n\n The monster comes running over and throws a punch! " + name + " took " + hit + " damage! He has " + hp + " hp left.");
					}
					else if(input == 3)//hide
					{
						hp = hp+ 5;
						System.out.println(name + " hides behind a rock. " + name + "noticed that there was something hiding under the rock. There is a potion of healing! " + name + " drinks the potion and recieved +5 hp. \n " + name +" now has " + hp + " hp.");
						
					}
					if (mHP <= 0) // see if the monster is ded.
					{
						coins = RandMoney(1);
						gold = gold + coins;
						loot = RandXP(5); // loot 5-10 xp
						Level l1 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
						lvl = l1.newLvl; //update lvl
						xp = l1.newXP; //update xp
						System.out.println("Good Job " + name +"! You have killed the monster! \n Your reward is: " + loot + "XP! and got " + coins+ " coins!"); // tell player that they killed the monster
						if (lvl >= 1); // see if lvl up
						{
							System.out.println("You leveled up! \n+5 HP \n+2 Attack");
							hp = hp + 5;
							atk = atk +2;
							System.out.println("Your new HP is: " + hp + " and your new attack is: " + atk +".");
						}
						room = 3;
						input = 6876;
						
						//get out of loop
						
					}
					if (hp <= 0)
					{
						System.out.println(name + "has died. You lose.");
						room = 888;
					}
					if (input != 6876)
					{
					System.out.println(name + " is in the second room.\n " +  " The monster is at " + mHP + " hp. What will you do? \n1. Slash your sword \n2. Say hi "); // change what you want
					input = output.nextInt();
					}
				}
				
				//System.out.println("\n\n\n TEST ");
				
				return room;
			case 3:// another room 
				System.out.println();
				return room;
		}
		
		return room;
	}
	static int RandMoney(int x) {
		Random rand = new Random();
		int random = (rand.nextInt(2)+x); 
		return random;		
	}
	static int RandHit(int x) {
		Random rand = new Random();
		int random = rand.nextInt(3)+x; //attack plus 0-3 bonus 
		return random;
		
	}
	static double  RandXP(double  x) {
		Random rand = new Random();
		double random = rand.nextDouble(10)+x; //attack plus 0-3 bonus 
		return random;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y =0,x =0, check=0;
		String name = null;
		Scanner output = new Scanner(System.in);
		System.out.println("Welcome to the dungeon! \n\n What is your name? "); // ask for name
		name = output.nextLine();
		System.out.println("Hello " + name +"! Are you ready to go into the dungeon? (1 for yes, 2 for no)"); //yes to play the game
		y = output.nextInt();
		
		if (y == 1)
		{
			x=1;
			check = rooms(1,name); // goes to first room
		}
		else if (y == 2)
		{
			System.out.println("Goodbye " + name + "!");
		}
		
		while (check != 888)
		{
		switch(check) { // check what room will be next until dead (888 value)
		case 2:
			check = rooms(2,name);
			break;
		case 3:
			check = rooms(3,name);
			break;
		case 4:
			check = rooms(4,name);
			break;
		case 5:
			check = rooms(5,name);
			break;
		default:
			break;
		}
			
		}
	}
	
}
