import java.util.*;

public class Hangman {
	
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		boolean playAgain = true;
		boolean playing = true;
		Word Game = new Word();
		System.out.print("Welcome to Hamgman \n");
		while(playAgain){
			System.out.print("\nplease input the word or phrase: ");
			String wordyPhrase = console.nextLine().toLowerCase();
			Game.newWord(wordyPhrase);
			for(int times = 0; times < 100; times++){
				System.out.println();
			}
			while(playing){
				System.out.println("\n" + Game.display() + "\n");
				System.out.print("What letter do you want to guess? ");
				String letterGuess = console.nextLine().toLowerCase();
				if (letterGuess.length() > 0){
					Game.guess(letterGuess.charAt(0));		
				} else {
					System.out.println("INVALID INPUT");
				}
				playing = !Game.isComplete();
			}
			System.out.print("\nThe word or phrase was \"" + wordyPhrase + "\" \n \nDo you want to play again? ");
			if(console.nextLine().equalsIgnoreCase("no")){
				playAgain = false;
			} else {
				playing = true;
			}
		}
		System.out.println("Goodbye");
		console.close();
	}
}