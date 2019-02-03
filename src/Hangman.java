import java.util.*;

public class Hangman {
	
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		boolean playing = true;
		boolean playAgain = true;
		System.out.print("Welcome to Hamgman ");
		while(playAgain){
			System.out.print("please input the word or phrase: ");
			Word Game = new Word(console.nextLine().toLowerCase());
			for(int times = 0; times < 100; times++){
				System.out.println();
			}
			while(playing){
				System.out.println(Game.display());
				System.out.print("What letter do you want to guess? ");
				String letterGuess = console.next().toLowerCase();
				if (letterGuess.length() > 0){
					Game.guess(letterGuess.charAt(0));		
				} else {
					System.out.println("INVALID INPUT");
				}
			}
		}
		console.close();
	}
}
