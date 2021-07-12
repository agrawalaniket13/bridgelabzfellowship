package snakeladder;

public class UC7 {
	public static void main(String[] args) {
		
    System.out.println("Snake And ladder Game using Single Player");
	System.out.println("Game Starts Here !! (: ");
	
	int counter = 0, position = 0, dice = 0;
	while (counter <= 100 || counter > 100) {
		
		if (counter > 100) {
			
			counter = counter - position;
		}
		else if (counter == 100) {
				System.out.println("** Wooo! Player Wins! **");
				break;
				
			}
	
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
	counter = position + counter;
	dice = (int) (dice + position);
	
	System.out.println("Current Position is " + counter);
	System.out.println("Number of dice Played " + dice);
	System.out.println("----------------------------");
	
	}
	
	
	
	
}

}


