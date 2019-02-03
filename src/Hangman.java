import java.util.*;

public class Hangman {
	
	public static void main(String[] args){
		Scanner console = new Scanner(System.in);
		boolean playing = true;
		boolean playAgain = true;
		System.out.print("Welcome to Hamgman ");
		while(playAgain){
			System.out.println("please input the word or phrase: ");
			String phrase = console.nextLine();
			String hiddenPhrase = hidePhrase(phrase);
			for(int times = 0; times < 100; times++){
				System.out.println();
			}
			while(playing){
				System.out.println(hiddenPhrase);
				
				
			}
		}
	}
}
