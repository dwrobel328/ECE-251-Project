package Project;

import java.util.Scanner;

import Project.Level;
import Project.Rand;

public class Room {
	static int atk=0,hp=3000,lvl=0,gold=1000,r=0,y=0, hit=0;//player stats
	static double xp =0, loot = 0;
	static int input =  0, input2=0,x=0;
	static int rooms(int room, String name) {
		Scanner output = new Scanner(System.in);
		int mHP =0, mAtk =0; //monster stats
		int coins =0, i =0;// input
		switch (room) {
			case 1: //chest room 
				
				//System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n"+name + " walked in the first room. You discovered that there is three chest numbered: '1', '2', '3'. \n What will " + name+ " take?"  );
				//input = output.nextInt();
				System.out.println("\n"+name + " walked in the first room. He discovered that there are three chest numbered: '1', '2', '3'. \nWhich chest will " + name+ " take?"  );
				input = output.nextInt();
				while (i !=1)// while so they need to answer it.
				{
					
					switch(input) {
					case 1:
						atk += 1;
						System.out.println(name + " opened the 1st chest and received a sword with Attack 1! *\n *attack rose to:  " +atk + "*\n\n");
						i=1;
						break;
					case 2:
						atk += 2;
						System.out.println(name + " opened the 2nd chest and received a sword with Attack 2! *\n *attack rose to:  " +atk + "*\n\n");
						i=1;
						break;
					case 3:
						atk += 3;
						System.out.println(name + " opened the 3rd chest and recieved a sword with Attack 3! *\n\n *attack rose to: "+atk + "*\n\n");
						i=1;
						break;
					default:
						System.out.println("Please type in 1, 2, or 3.");
						System.out.println("\n"+name + " walked in the first room and discovered that there are three chest numbered: '1', '2', '3'. \n What will " + name+ " take?"  );
						input = output.nextInt();
						break;
					}
				}
				System.out.println(name + " says out loud: 'Alright, time to go to the next room.'");
				room=2; // room 2 is accessible 
				return room;
				
			case 2: // mob room
				mHP=50;mAtk = 1; // mob stat for room
				System.out.println(name + " entered the second room. There is a monster! What will "+name+" do? \n1.Attack \n2.Say hi \n3.Hide"); // change what you want
				input = output.nextInt(); 
				int potionFlag = 0;
				while (i != 1) //while until they kill the monster
				{
					
					switch (input) {
					case 0: 
						input = output.nextInt();
						break;
					case 1:
							System.out.println(name + " Starts slashing the monster     " );
							hit = Rand.RandomHit(100)+atk;
							mHP -= hit ;
							if (mHP <= 0) 
								mHP = 0;
							System.out.println(name + " slashed the sword and hit it for " +hit +"hp. The monster now has: " + (mHP)+ "hp.");
							if (mHP != 0) {
							System.out.println("The monster got up and punched "+name+"! ");
							hit = Rand.RandomHit(100)+mAtk;
							hp -= hit;
							System.out.println("The monster hit "+name+" for " + hit + "hp! "+name+" now has " + hp + "hp." );
							}
							else{}
							input = 0;
							break;
						case 2:
							hit = Rand.RandomHit(100)+mAtk;
							hp = hp - hit;
							System.out.println(name + " shouted at the monster: 'Hello! come and fight me!' The monster comes running over and throws a punch! " + name + " took " + hit + " damage and has " + hp + "hp left.");
							input = 0;
							break;
						case 3:
							if (potionFlag == 0) {
								hp +=5;
								System.out.println(name + " hides behind a rock and finds a potion of healing! " + name + " drinks the potion and recieved +5 hp. \n" + name +" now has " + hp + " hp.");	
								potionFlag = 1;
							}else {
								System.out.println("There is nowhere left to hide!");
							}
							input = 0;
							break;
						default: 
							System.out.println("Please type in 1 or 2.");
							input =0;
							break;
					}
					if (mHP <= 0) // see if the monster is ded.
					{
						coins = Rand.RandMoney(41)+1;
						gold += coins;
						loot = Rand.RandomXP()+5; // loot 5-10 xp
						Level l1 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
						lvl = l1.newLvl; //update lvl
						xp = l1.newXP; //update xp
						System.out.println("Good Job " + name +"! You have killed the monster! \nYour reward is: " + loot + "XP and " + coins+ " coins!"); // tell player that they killed the monster
						if (lvl >= 1); // see if lvl up
						{
							System.out.println("You leveled up! \n+5 HP \n+2 Attack");
							hp = hp + 5;
							atk = atk +2;
							System.out.println("Your new HP is " + hp + "hp and your new attack is: " + atk +".");
						}
						input = 0;
						System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.)");
						input = output.nextInt();
						while (input != 1 | input != 2)
						{
							
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
								System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.)");
								input = output.nextInt();
								break;
							}
							
						}
						
					}
					if (hp <= 0) // if dead
					{
						System.out.println(name + " has died. You lose.");
						room = 888;
						i = 1;
					}
					if (i != 1) 
					{
					System.out.println(name + " is in the second room." +  " The monster is at " + mHP + "hp. What will you do? \n1.Slash your sword \n2.Say hi \n3.Hide "); // change what you want
					input = output.nextInt();
					}
					
				}
				
				
				
				return room;
			case 3:// another room 
				mHP = 15; mAtk = 2;
				System.out.println( name + " has entered the third room and noticed a lever that is on the cave wall. What will "+name+" do?:\n1.Pull the lever\n2.Continue through the room"); 
				input = output.nextInt();
				while(x!=1)
				{
				switch(input)
				{
				case 1:
					System.out.println(name + " pulled the lever. Suddenly, a skeleton fell from the sky! What will " + name+ " do!?\n1.Slash at him \n2.Try to go around him");
					input2 = output.nextInt();
				
				while(i !=1)
				{
					switch(input) {
					case 1:
						if(input2 == 1) { // slash at him
							hit = Rand.RandomHit(3)+atk;
							mHP -= hit;
							if(mHP <=0)
								mHP = 0;
							System.out.println(name + " attacked the skeleton for " + hit + " damage! The skeleton has " + mHP + "hp!");
							if(mHP !=0)
							{
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp - hit;
							System.out.println("The skeleton shot an arrow at you! He delt " + hit + " of damage! " + name + " has " + hp + "hp!");
							}
							else {}
							input2 = 0;
							break;
						}
						else if(input2==2) { //try to go around him
							if(Rand.didTrip()) {
								hp-=5;
								System.out.println(name+" tried to go around, but tripped and lost 5hp! "+name+" has "+hp+"hp left.");
							}else {
								System.out.println(name+" got away succesfully!");
								i=1;
							}
							input2=0;
							
							break;
						}
						else {
							System.out.println("Please type 1 or 2");
							System.out.println(name + " pulled the lever. Suddenly, a skeleton fell from the sky! What will " + name+ " do!?\n1.Slash at him \n2.Try to go around him");
							input2 = output.nextInt();
							break;
						}
					case 2:
						System.out.println(name + " began walking and found two doors. Which door does " + name + " want to go through? \n1.Next room \n2.Shop. ");
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
							System.out.println("Please type 1 or 2.");
					}
					if (mHP <= 0) // see if the monster is ded. 
					{
						coins = Rand.RandMoney(41)+1;
						gold = gold + coins;
						loot = Rand.RandomXP()+5; // loot 5-15 xp
						Level l2 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
						lvl = l2.newLvl; //update lvl
						xp = l2.newXP; //update xp
						System.out.println("Good Job " + name +"! You have killed the Skeleton! \nYour reward is: " + loot + "XP and " + coins+ " coins!"); // tell player that they killed the monster
						if (lvl >= 2); // see if lvl up
						{
							System.out.println("You leveled up! \n+7 HP \n+4 Attack");
							hp = hp + 7;
							atk = atk +4;
							System.out.println("Your new HP is: " + hp + " and your new attack is: " + atk +".");
						}
						int input3 = 0;
						System.out.println("Do you want to go to the next room or the shop? (Press 1 to go to the next room\nPress 2 to go to the shop\nPress 3 stop playing.");
						input3 = output.nextInt();
						while (input3 != 1 | input3 != 2 | input3 != 3 ) 
						{
							
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
								System.out.println("Do you want to go to the next room or the shop? (Press 1 to go to the next room\nPress 2 to go to the shop\nPress 3 stop playing.");
								input3 = output.nextInt();
								break;
							}
						}
						
					}
					if (input != 6876 & i != 1)
					{
					System.out.println(name + " is in the second room.\n " +  " The monster is at " + mHP + " hp. What will you do? \n1.Attack \n2.Try to go around him "); // change what you want
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
				case 2:
					int input3 =0;
					System.out.println(name + " has walked straight and found a door. What would " +name + " want to do? \n1.Go through the door \n2.Go to the Shop\n3.Quit");
					input3 = output.nextInt();
					while (input3 != 1 | input3 != 2 | input3 != 3 ) 
					{
						
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
							System.out.println("Do you want to go to the next room or the shop? (Press 1 to go to the next room\nPress 2 to go to the shop\nPress 3 stop playing.");
							input3 = output.nextInt();
							break;
						}
					}
					default:
						System.out.println("Please type in 1, 2, or 3");
						System.out.println( name + " has entered the third room. " + name + " noticed that there is a lever that is on the cave wall. What will he do?: \n1.Pull the lever \n2.Continue straight"); 
						input = output.nextInt();
						break;
				}
			}
			case 4://another room
				mHP = 15; mAtk = 5;
				System.out.println(name + " entered the fourth room and finds a zombie! What will " + name + " do? \n 1.Attack \n 2.Scream at the zombie.");
				input = output.nextInt();
				while (i != 1) //while until they kill the monster
				{
					switch (input) {
						case 1:
							System.out.println(name + " Starts slashing the zombie     " );
							hit = Rand.RandomHit(3)+atk;
							mHP = mHP - hit ;
							if (mHP <= 0)
								mHP = 0;
							System.out.println(name + " slashed the sword, hitting him for: " +hit +" .\n The zombie now has: " + (mHP)+ "hp.");
							if (mHP !=0) {
							System.out.println("The monster got up and punched you! ");
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp- hit;
							System.out.println("The zombie hit you for: " + hit + "! \n You now have: " + hp + "hp." );
							break;
							}
							else 
							input = 0;
							break;
						case 2:
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp - hit;
							System.out.println(name + " screamed at the zombie: \n 'AHHHHH! come and fight me!'\n The zombie runs over and throws a punch! " + name + " took " + hit + " damage and has " + hp + "hp left.");
							input = 0;
							break;
						default: 
							System.out.println("Please type in 1,2 or 3.");
							System.out.println(name + " entered the fourth room. " + name + " sees a zombie! What will " + name + " do? \n 1.Attack \n 2.Scream at the zombie.");
							input = output.nextInt();
							break;
					}
					if (mHP <= 0) // see if the monster is ded.
					{
						coins = Rand.RandMoney(41)+1;
						gold = gold + coins;
						loot = Rand.RandomXP()+5; // loot 5-10 xp
						Level l3 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
						lvl = l3.newLvl; //update lvl
						xp = l3.newXP; //update xp
						System.out.println("Good Job " + name +"! You have killed the monster! \n Your reward is: " + loot + "XP! and got " + coins+ " coins!"); // tell player that they killed the monster
						if (lvl >= 1); // see if lvl up
						{
							System.out.println("You leveled up! \n+5 HP \n+2 Attack");
							hp = hp + 5;
							atk = atk +2;
							System.out.println("Your new HP is " + hp + " and your new attack is: " + atk +".");
						}
						input = 0;
						System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.");
						input = output.nextInt();
						while (input != 1 | input != 2)
						{
							switch(input) {
							case 0: // ask again if the player did not put 1, or 2
								System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.");
								input = output.nextInt();
								break;
							case 1:
								room = 6;
								i = 1;
								return room;
							case 2:
								System.out.println("Okay, have a good day!");
								room = 888;
								i=1;
								return room;
							default:
								System.out.println("Please type in 1 or 2");
								input = 0;
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
					System.out.println(name + " is in the fourth room.\n " +  " The zombie is at " + mHP + "hp. What will you do? \n1.Hit him \n2.Scream at him "); // change what you want
					input = output.nextInt();
					}
					
				}
				
			case 5: // shop
				int potion =5, armor = 1, bladeSharpener = 1;
				System.out.println(name + " went into the shop. He noticed a man selling:  Armor (+10 hp) for 10 coins, potion (+5 hp), for 5 coins, and a blade sharpener (+10 Atk) for 20 coins. \n What will " +name + " buy (Coins: "+gold+")? \n1. armor -  " + armor + " in stock \n2. potion - " + potion + " in stock. \n3. Blade Sharpener - " + bladeSharpener + " in stock. \n4. Leave the shop");
				input = output.nextInt();
				while (input != 4)
				{
					
					if(input == 1 & armor !=0 & gold >= 10) // check to see if in stock and enough coins
					{
						armor = 0;
						hp = hp + 10;
						gold-=20;
						System.out.println(name + " bought armor for 10 coins and has " + gold + " coins left.");
						input = 0;
						
					}
					else if(armor==0) {
						System.out.println("This item is out of stock.");
					}
					else if(input == 2 & potion != 0 & gold >= 5) // check to see if in stock and enough coins
					{
						potion -= 1;
						hp += 5;
						gold -= 10;
						System.out.println(name + " bought a potion for 5 coins and has " + gold + " coins left.");
						input = 0;
					}
					else if(input == 2 & bladeSharpener != 0 & gold >= 20) // check to see if in stock and enough coins
					{
						bladeSharpener = 0;
						atk += 10;
						gold-= 40;
						System.out.println(name + " bought a blade sharpener for 20 coins and has" + gold + " coins left.");
						input = 0;
					}
					//if they dont have coins
					if( input == 1 & armor != 1 | gold < 10) {
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					else if(input == 2 & potion != 1 | gold < 5) {
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					else if(input == 2 & bladeSharpener != 1 | gold < 20)
					{
						System.out.println("You do not have enough funds.");
						input = 0;
					}
					if(input != 1 | input != 2|input != 3|input != 4 | input != 0)
					{
						System.out.println("Please type 1, 2, 3, or 4");
						input = 0;
					}
					if (input == 0) {
					System.out.println("The update stock is: \n1.Armor -  " + armor + " in stock \n2.Potion - " + potion + " in stock. \n3.Blade Sharpener - " + bladeSharpener + " in stock. \n4.Leave the shop ");
					input = output.nextInt();
					break;
					}
				}
				System.out.println("Would " + name + " like to go to the next room? \n1.Go to the next room \n2.Quit");
				input = output.nextInt();
				while (i!=1)
				{
					switch(input) {
					case 0:
						System.out.println("Go to the next room? \n1.Go to the next room \n2.Quit");
						input = output.nextInt();
						break;
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
							input = 0;
				}
				}
			case 6:
				int boulder = 1, brick = 1, goldIngot  = 1;
				System.out.println("The next room had a boulder, a brick, and a gold ingot. There were also words carved into the wall that read: "
								   + "\n\nRed in color, small in size \nOften seen by city eyes.\nI make up structures very tall \nI could "
								   + "make up offices and a wall.\nI am usually made of clay\nLaid in mortar pale and gray."
								   + "\n\nWhat am I? \n\n What will "+name+" pick up? \n1.The boulder  \n2.The brick \n3.The gold ingot.");
				input = output.nextInt();
				while (i != 1)
				{
					switch (input) {
					case 1:
						if (boulder ==1) {
						hp = hp/2;
						System.out.println(name + " tried to pick up the boulder, but it slipped and flattened him, reducing his HP by half! The new HP is: " + (hp = hp/2));
						boulder = 0;
						}else {
							System.out.println(name+" already tried picking up the boulder");
						}
						input =0;
						break;
					case 2:
						System.out.println(name + " picked up the brick and a slab of stone moved, revealing a tunnel!\n'That must have been the right choice!' "+name+" says.");
						input = 0;
						i = 1;
						break;
					case 3:
						if (goldIngot ==1) {							
								System.out.println(name + " put the gold ingot in his pocket. This is worth 35 coins!");
								gold += 35;
								goldIngot = 0;
								System.out.println("Please pick up another material");							
							}else {
								System.out.println("You already picked up the Gold Ingot");
							}
							input =0;
					}
					if (hp <= 0) {
						System.out.println(name + " has died. You lose.");
						room = 888;
						return room;
					}
				}
				System.out.println(name + " walked to the end of the tunnel, and noticed a door. Will " + name + " go through that door? \n1. Go to the next room \n2. Quit");
				input = output.nextInt();
				while(input2 != 1) {
				
				switch(input) {
				case 0:
					System.out.println(name + " walked to the end of the tunnel, and noticed a door. Will " + name + " go through that door? \n1. Go to the next room \n2. Quit");
					input = output.nextInt();
					break;
				case 1: 
					System.out.println(name + " opened the door.");
					room = 7;
					input2=1;
					return room;
				case 2:
					System.out.println("GoodBye!");
					room = 888;
					input2=1;
					return room;
				default:
					System.out.println("Please type in 1 or 2.");
					input = 0;
					input2 = 0;
				}
				}
			case 7: //room 7
				mHP = 30; mAtk = 10;
				System.out.println(name + " has entered a new room. " + name + " saw a small looking figure. " + name + " thought to himself, 'What is that thing? ' While thinking this, the little elf came up to " + name + " and said, 'Hello! I am Silvian, an elf! I need you're help young adventurer! Will you help me?  \n What will " + name + " do? \n1. Say yes \n2. say no");
				input = output.nextInt();
				int tries =0,coin=0, eAtk;
				while (i != 1)
				{
				switch(input) {
					
					case 1:
						System.out.println(name + " said: 'of course I can help you! what do you need help with?' \n Silvian responds: ' Can you find my wand? I was sleeping and some troll hid it!' \n What will" + name + " do? \n1. Check behind the rock \n2. Check behind the log \n3. check behind the camping bag.");
						input2 = output.nextInt();
						//finish later
						while( x != 1)
						{
							switch(input2) {
							case 1:
								tries++;
								System.out.println(name + " checked behind the log. " + name+ " did not find the wand. Please look at a different spot.");
								System.out.println(name + " said: 'of course I can help you! what do you need help with?' \n Silvian responds: ' Can you find my wand? I was sleeping and some troll hid it!' \n What will" + name + " do? \n1. Check behind the rock \n2. Check behind the log \n3. check behind the camping bag.");
								input2 = output.nextInt();
								break;
							case 2:
								tries++;
								System.out.println(name + " checked behind the rock. " + name+ " did not find the wand. Please look at a different spot.");
								System.out.println(name + " said: 'of course I can help you! what do you need help with?' \n Silvian responds: ' Can you find my wand? I was sleeping and some troll hid it!' \n What will" + name + " do? \n1. Check behind the rock \n2. Check behind the log \n3. check behind the camping bag.");
								input2 = output.nextInt();
							case 3:
								if (tries == 0) 
								{
									coin = Rand.RandMoney(20);
									gold = gold + coin;
									eAtk = Rand.RandomHit(5);
									atk = atk + eAtk;
									System.out.println(name + " found the wand! This was their first spot that they checked! You got a first try bonus! \n " + coin + " was added to your gold pouch. " + eAtk + " was added to your attack.");
									
								}
								else
									System.out.println(name +  " found the wand! ");
								gold = gold + 30;
								System.out.println("'Thank you so much! I thought I looked at that spot! Here is 30 extra gold for your trouble! \n You now have " + gold + " gold!");
								x=1;
								break;
							}
						}
					case 2:
						while(x!=1) {
							System.out.println("Elf looks sad. The Elf said: ' If you dont want to help me, then fight me! What will " + name+ " do? \n1. Slash \n2. Try to talk to him");
							input2 = output.nextInt();
							switch(input2) {
							case 1: 
								hit = Rand.RandomHit(3)+atk;
								mHP = mHP - hit;
								if(mHP <=0)
									mHP = 0;
								System.out.println(name + " attacked the Elf! " + name + " slashed him for " + hit + " damage! The Elf has " + mHP + "hp!");
								if(mHP !=0)
								{
								hit = Rand.RandomHit(1)+mAtk;
								hp = hp - hit;
								System.out.println(" The Elf punched you! He delt " + hit + " of damage! " + name + " has " + hp + " hp!");
								}
								else {}
								input2 = 0;
								break;
							
							case 2:
								hit = Rand.RandomHit(1)+mAtk;
								hp = hp - hit;
								System.out.println(name + " said: \n 'Lets talk about this!!'\n\n The elf comes running over and throws a punch! " + name + " took " + hit + " damage! He has " + hp + " hp left.");
								input2 = 0;
								break;
							default:
								System.out.println("Please type in 1, or 2");
								input = output.nextInt();
								break;
								
						}	
							if (mHP <= 0) // see if the monster is ded.
							{
								coins = Rand.RandMoney(61)+10;
								gold = gold + coins;
								loot = (Rand.RandomXP()+35.0); // loot 30-40 xp
								Level l7 = new Level(loot, xp, lvl); // goes to lvl class and see if you lvl up. 
								lvl = l7.newLvl; //update lvl
								xp = l7.newXP; //update xp
								System.out.println("Good Job " + name +"! You have killed the monster! \n Your reward is: " + loot + "XP! and got " + coins+ " coins!"); // tell player that they killed the monster
								if (lvl >= 1); // see if lvl up
								{
									System.out.println("You leveled up! \n+10 HP \n+12 Attack");
									hp = hp + 20;
									atk = atk +12;
									System.out.println("Your new HP is: " + hp + " and your new attack is: " + atk +".");
									
								}
								input = 0;
								System.out.println("Do you want to go to the next room? (Press 1 to go to the next room Press 2 to stop playing.");
								input = output.nextInt();
								while (input != 1 | input != 2)
								{
									switch(input) {
									case 0: // ask again if the player did not put 1, or 2
										System.out.println("Do you want to go to the next room? (Press 1 to go to the finalroom Press 2 to stop playing.");
										input = output.nextInt();
										break;
									case 1:
										room = 8;
										i = 1;
										return room;
									case 2:
										System.out.println("Okay have a good day!");
										room = 888;
										i=1;
										return room;
									default:
										System.out.println("Please type in 1 or 2");
										input = 0;
										break;
									}
									
								}
								
							}
							if (hp <= 0) // if ded
							{
								System.out.println(name + " has died. You lose.");
								room = 888;
								break;
							}
						}
					default: 
						System.out.println("Please type in 1, or 2");
						input = output.nextInt();
						break;
				}
				}
			case 8: // final boss
				mAtk = 10; mHP = 40;
				while( i != 1)
				{
					System.out.println(name + " entered the boss room. They are very scared but determine the beat it! The boss said: Hello young soldier. Are you ready to fight?. \n1. Attack him \n2. say hi ");
					input = output.nextInt();
					switch (input) {
						case 1:
							System.out.println(name + " Starts slashing the final boss     " );
							hit = Rand.RandomHit(3)+atk;
							mHP = mHP - hit ;
							if (mHP <= 0)
								mHP = 0;
							System.out.println(name + " slashed the sword, hitting him for: " +hit +" .\n The Final boss now has: " + (mHP)+ "hp.");
							if (mHP !=0) {
								System.out.println("The final boss got up and punched you! ");
								hit = Rand.RandomHit(1)+mAtk;
								hp = hp- hit;
								System.out.println("The final boss hit you for: " + hit + "! \n You now have: " + hp + "hp." );
								break;
							}
							else 
								input = 0;
							break;
						case 2:
							hit = Rand.RandomHit(1)+mAtk;
							hp = hp - hit;
							System.out.println(name + " screamed at the final boss: \n 'AHHHHH! come and fight me!'\n The final boss runs over and throws a punch! " + name + " took " + hit + " damage and has " + hp + "hp left.");
							input = 0;
							break;
					default: 
							System.out.println("Please type in 1,2 or 3.");
							System.out.println(name + " entered the fourth room. " + name + " sees a final boss! What will " + name + " do? \n 1.Attack \n 2.Scream at the final boss.");
							input = output.nextInt();
							break;
				}
				if (mHP <= 0) // see if the monster is ded.
				{
					System.out.println("Good Job " + name +"! You have killed the final boss! \n You have won the game! \n Thank you for playing! \n This was made for Spring 2024 ECE 251 and was created by: +"
							+ "David Wrobel, George Gorgievski and Gannon Andrews. "); // tell player that they killed the monster and won the game!
					break;
					}
				}
		}
		
	
		
		return room;
	}

}
