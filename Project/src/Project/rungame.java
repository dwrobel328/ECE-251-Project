package Project;
import java.util.Scanner;

public class rungame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y =0,x =0, check=0;
		String name = null;
		Scanner output = new Scanner(System.in);
		//Rand hitRand = new Rand(hit);
		System.out.println("Welcome to Dungeon Adventure! \n\nWhat is your name? "); // ask for name
		name = output.nextLine();
		System.out.println("Hello " + name +"! Are you ready to go into the dungeon? (1 for yes, 2 for no)"); //yes to play the game
		y = output.nextInt();
		
		while(true) { 
		if (y == 1)
		{
			x=1;
			check = Room.rooms(1,name); // goes to first room
			break;
		}
		else if (y == 2)
		{
			System.out.println("Goodbye " + name + "!");
			check=888;
			break;
		}
		else {
			System.out.println("Please input 1 or 2");
			y=output.nextInt();
		}
		}
		
		while (check != 889){
		switch(check) { // check what room will be next until dead (888 value)
		case 2:
			check = Room.rooms(2,name);
			break;
		case 3:
			check = Room.rooms(3,name);
			break;
		case 4:
			check = Room.rooms(4,name);
			break;
		case 5:
			check = Room.rooms(5,name);
			break;
		case 6:
			check = Room.rooms(6,name);
			break;
		case 7:
			check = Room.rooms(7,name);
			break;
		case 8:
			check = Room.rooms(8,name);
			break;
		case 888:
			System.out.println("Please reload the game to play again");
			check = 889;
			break;
		default:
			break;
		}
			
		}
	}
	
}
