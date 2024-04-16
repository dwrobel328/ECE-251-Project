package Project;

import java.util.Scanner;

public class Room {
	static int atk,hp=30,lvl=0,gold=0,r=0,y=0, hit=0;//player stats
	static double xp =0, loot = 0;
	static int input =  0, input2=0;
	static int rooms(int room, String name) {
		// TODO Auto-generated constructor stub
		Scanner output = new Scanner(System.in);
		int mHP =0, mAtk =0; //monster stats
		int coins =0, i =0;// input
		switch (room) {
			case 1: //chest room (This can be changed just wanted to try it out and give them an attacking weapon
				
				//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+name + " walked in the first room. You discovered that there is three chest numbered: '1', '2', '3'. \n What will " + name+ " take?"  );
				//input = output.nextInt();
				while (i !=1)// while so they need to answer it.
				{
					System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+name + " walked in the first room. You discovered that there is three chest numbered: '1', '2', '3'. \n What will " + name+ " take?"  );
					input = output.nextInt();
					switch(input) {
					case 1:
						atk = atk + 1;
						System.out.println(name + " opened the 1st chest. you have recieved a sword with Attack 1! *\n *attack was rose to:  " +atk + "*");
						i=1;
						break;
					case 2:
						atk = atk + 2;
						System.out.println(name + " opened the 2nd chest. you have recieved a sword with Attack 2! *\n *attack was rose to:  " +atk + "*");
						i=1;
						break;
					case 3:
						atk = atk + 3;
						System.out.println(name + " opened the 3rd chest. you have recieved a sword with Attack 3! *\n\n *attack was rose to:  "+atk + "*\n\n\n");
						i=1;
						break;
					default:
						System.out.println("Please type in 1, 2, or 3.");
						input = 0;
						break;
					}
				}
				System.out.println(name + " says outloud: \n Alright time to go to the next room.\n\n\n");
				room=2; // room 2 is accessible 
				return room;
				
			case 2: // mob room
				mHP=5;mAtk = 1; // mob stat for room
				System.out.println(name + " entered the second room.\n " + name + " There is a monster! What will you do? \n1. Slash your sword \n2. Say hi \n3. hide "); // change what you want
				input = output.nextInt();
				while (i != 1) //while until they kill the monster
				{
					switch (input) {
						case 1:
							System.out.println(name + " Starts slashing the monster     " );
							hit = Rand.RandomHit(3)+atk;
							mHP = mHP - hit ;
							System.out.println("While " +name + " slashed the sword, he hit him for: " +hit +" .\n The monster now has: " + (mHP)+ " hp.");
							System.out.println("The monster got up and punched you! ");
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp- hit;
							System.out.println("The monster hit you for: " + hit + "! \n You now have: " + hp + "hp." );
							input = 0;
							break;
						case 2:
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp - hit;
							System.out.println(name + " shouted at the monster: \n 'Hello! come and fight me!'\n\n The monster comes running over and throws a punch! " + name + " took " + hit + " damage! He has " + hp + " hp left.");
							input = 0;
							break;
						case 3:
							hp = hp+ 5;
							System.out.println(name + " hides behind a rock. " + name + "noticed that there was something hiding under the rock. There is a potion of healing! " + name + " drinks the potion and recieved +5 hp. \n " + name +" now has " + hp + " hp.");
							input =0;
							break;
						default: 
							System.out.println("Please type in 1,2 or 3.");
							input =0;
							break;
					}
					if (mHP <= 0) // see if the monster is ded.
					{
						coins = Rand.RandMoney(41)+1;
						gold = gold + coins;
						loot = Rand.RandomXP()+5; // loot 5-10 xp
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
						input = 0;
						while (input != 1 | input != 2)
						{
							System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.");
							input = output.nextInt();
							switch(input) {
							case 1:
								room = 3;
								i = 1;
								return room;
							case 2:
								System.out.println("Okay have a good day!");
								room = 888;
								i=1;
								return room;
							default:
								System.out.println("Please type in 1 or 2");
								break;
							}
							
						}
						
					}
					if (hp <= 0) // if ded
					{
						System.out.println(name + " has died. You lose.");
						room = 888;
					}
					if (i != 1) // send back the msg without third option.
					{
					System.out.println(name + " is in the second room.\n " +  " The monster is at " + mHP + " hp. What will you do? \n1. Slash your sword \n2. Say hi "); // change what you want
					input = output.nextInt();
					}
					
				}
				
				
				
				return room;
			case 3:// another room 
				mHP = 15; mAtk = 2;
				System.out.println( name + " has entered the third room. " + name + " noticed that there is a lever that is on the cave wall. What will he do?: \n1. pull the lever \n2. keep going straight"); 
				input = output.nextInt();
				if (input == 1)
				{
					System.out.println(name + " pulled the lever. When the lever was pulled, a skeleton fell from the sky! What will " + name+ " do!?\n1. Slash at him \n2. try to go around him");
					input2 = output.nextInt();
				}
				while(i !=1)
				{
					switch(input) {
					case 1:
						if(input2 == 1) { // slash at him
							hit = Rand.RandomHit(3)+atk;
							mHP = mHP - hit;
							System.out.println(name + " attacked the skeleton! " + name + " slashed him for " + hit + " damage! The skeleton has " + mHP + "hp!");
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp - hit;
							System.out.println(" The skeleton shot an arrow at you! He delt " + hit + " of damage! " + name + " has " + hp + " hp!");
							input2 = 0;
							break;
						}
						else if(input2==2) { //try to go around him
							hp = hp -5;
							System.out.println(name + " tried to go around the skeleton. When trying to do that, " + name+ " stepped into a trap and lost 5 hp! " + name + " now has " + hp + ".");
							input2=0;
							break;
						}
						else {
							System.out.println("Please type 1 or 2");
							System.out.println(name + " pulled the lever. When the lever was pulled, a skeleton fell from the sky! What will " + name+ " do!?\n1. Slash at him \n2. try to go around him");
							input2 = output.nextInt();
							break;
						}
					case 2:
						System.out.println(name + " began walking. After walking, you found two doors. Which door does " + name + " want to go through? \n1. next room \n2. Shop. ");
						input2 = output.nextInt();
						if(input2 == 1) {
						room =5;
						i = 1;
						return room;
						}
						else if(input2 == 2) {
							room = 4;
							i =1;
							return room;
						}
						else // not working 
							System.out.println("Please type 1, or 2.");
					}
					if (mHP <= 0) // see if the monster is ded. 
					{
						coins = Rand.RandMoney(41)+1;
						gold = gold + coins;
						loot = Rand.RandomXP()+5; // loot 5-15 xp
						Level l2 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
						lvl = l2.newLvl; //update lvl
						xp = l2.newXP; //update xp
						System.out.println("Good Job " + name +"! You have killed the Skeleton! \n Your reward is: " + loot + "XP! and got " + coins+ " coins!"); // tell player that they killed the monster
						if (lvl >= 2); // see if lvl up
						{
							System.out.println("You leveled up! \n+7 HP \n+4 Attack");
							hp = hp + 7;
							atk = atk +4;
							System.out.println("Your new HP is: " + hp + " and your new attack is: " + atk +".");
						}
						int input3 = 0;
						while (input3 != 1 | input3 != 2 | input3 != 3 ) 
						{
							System.out.println("Do you want to go to the next room or the shop? (Press 1 to go to the next room\nPress 2 to go to the shop\nPress 3 stop playing.");
							input3 = output.nextInt();
							switch (input3) {
							case 1:
								room = 4;
								i = 1;
								return room;
							case 2: 
								room = 5;
								i = 1;
								return room;
							case 3:
								System.out.println("Okay have a good day!");
								room = 888; // ends
								return room;
							default: 
								System.out.println("Please type in 1, 2, or 3.");
								input3 = 0;
								break;
							}
						}
						
					}
					if (input != 6876)
					{
					System.out.println(name + " is in the second room.\n " +  " The monster is at " + mHP + " hp. What will you do? \n1. Slash your sword \n2. Say hi "); // change what you want
					input2 = output.nextInt();
					}
					if (hp <= 0)
					{
						System.out.println(name + "has died. You lose.");
						room = 888;
						input = 6876;
						return room;
					}
				}
				
			case 5: // shop
				int potion =5, armor = 1, bladeSharpener = 1;
				System.out.println(name + " went into the shop. He noticed a man selling:  Armor (+10 hp) for 20 coins, potion (+5 hp), for 10 coins, and a blade sharpener (+10 Atk) for 40 coins. \n What will " +name + " buy? \n1. armor -  " + armor + " in stock \n2. potion - " + potion + " in stock. \n3. Blade Sharpener - " + bladeSharpener + " in stock. \n4. Leave the shop");
				input = output.nextInt();
				while (input != 4)
				{
					if(input == 1 & armor !=0 & coins >= 20) // check to see if in stock and enough coins
					{
						armor = 0;
						hp = hp + 10;
						coins = coins-20;
						System.out.println(name + " bought armor for 20 coins. " + name + "has " + coins + " coins left.");
						input = 0;
						
					}
					else if(input == 2 & potion != 0 & coins >= 10) // check to see if in stock and enough coins
					{
						potion = potion - 1;
						hp = hp + 5;
						coins = coins - 10;
						System.out.println(name + " bought a potion for 10 coins. " + name + " has " + coins + " coins left.");
						input = 0;
					}
					else if(input == 2 & bladeSharpener != 0 & coins >= 40) // check to see if in stock and enough coins
					{
						bladeSharpener = 0;
						atk = atk + 10;
						coins = coins - 40;
						System.out.println(name + " bought a blade sharpener for 40 coins. " + name + " has" + coins + " coins left.");
						input = 0;
					}
					//if they dont have coins
					if( input == 1 & armor == 1 & coins < 20) {
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					else if(input == 2 & potion == 1 & coins < 10) {
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					else if(input == 2 & bladeSharpener == 1 & coins < 40)
					{
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					System.out.println("The update stock is: \n1. armor -  " + armor + " in stock \n2. potion - " + potion + " in stock. \n3. Blade Sharpener - " + bladeSharpener + " in stock. \n4. Leave the shop ");
					input = output.nextInt();
				}
				System.out.println("Would " + name + " want to go to the next room? \n1. go to the next room \n2. quit");
				input = output.nextInt();
				while (i!=1)
				{
					switch(input) {
						case 1:
							room =4;
							input = 0;
							i=1;
							return room;
						case 2:
							room =888;
							input = 0;
							i=1;
							return room;
						default:
							System.out.println("Please type 1, or 2");
				}
				}
		}
		
		return room;
	}

}
