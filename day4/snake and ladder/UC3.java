package snakeladder;
public class UC3 {
	
	public static void main(String[] args) {
		System.out.println("Snake And ladder Game using Single Player");
		System.out.println("Game Starts Here !! (: ");
		int counter = 0, position = 0;
		double Rolling = Math.floor(Math.random() * 10 ) % 6 + 1;
		double Random_Player = Math.floor(Math.random() * 10 ) % 3;
		if (Random_Player == 0) {
			System.out.println("No Play ");
			position = 0;
		}
		else if (Random_Player == 1) {
			System.out.println("Moving Ahead");
			position = (int) (position + Rolling);
		}
		else {
			System.out.println("Moving back");
			Rolling = (int) (Rolling - position);
			position = (int) (position - Rolling);
			if (Rolling > position ) {
				position = (int) Rolling-position;
			}
			else if (position < 0) {
				position = 0;
			}
		}
		counter = position+counter;
		System.out.println("Current Count is " + counter);
		System.out.println("----------------------------");
		
		}
	}