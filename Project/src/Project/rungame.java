package Project;
import java.util.Scanner;

public class rungame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int y =0,x =0, check=0;
		String name = null;
		Scanner output = new Scanner(System.in);
		//Rand hitRand = new Rand(hit);
		System.out.println("Welcome to the dungeon! \n\n What is your name? "); // ask for name
		name = output.nextLine();
		System.out.println("Hello " + name +"! Are you ready to go into the dungeon? (1 for yes, 2 for no)"); //yes to play the game
		y = output.nextInt();
		
		if (y == 1)
		{
			x=1;
			check = Room.rooms(1,name); // goes to first room
		}
		else if (y == 2)
		{
			System.out.println("Goodbye " + name + "!");
		}
		
		while (check != 888)
		{
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
		case 9:
			check = Room.rooms(9,name);
			break;
		case 10:
			check = Room.rooms(10,name);
			break;
		case 888:
			System.out.println("Please reload the game to play again");
		default:
			break;
		}
			
		}
	}
	
}
