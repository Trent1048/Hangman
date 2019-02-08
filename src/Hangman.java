import java.util.*;
import java.io.*;

public class Hangman {
	
	public static void main(String[] args){
		File words = new File("words.txt");
		try {
			Scanner document = new Scanner(words);
			Scanner console = new Scanner(System.in);
			boolean playAgain = true;
			boolean playing = true;
			boolean playingAlone = false;
			Word Game = new Word();
			System.out.print("Welcome to Hamgman \n");
			System.out.print("Do you have a friend to play with? ");
			if(console.nextLine().equals("no")){
				playingAlone = true;
			}
			while(playAgain && document.hasNextLine()){
				String wordyPhrase;
				if(playingAlone){
					wordyPhrase = document.nextLine().toLowerCase();
				} else {
					System.out.print("Please enter a word or phrase ");
					wordyPhrase = console.nextLine().toLowerCase();
					for(int times = 0; times < 100; times++){
						System.out.println();
					}
				}
				Game.newWord(wordyPhrase);
				while(playing){
					System.out.println("\n" + Game.display() + "\n");
					System.out.print("What letter do you want to guess? ");
					String letterGuess = console.next().toLowerCase();
					if (letterGuess.length() > 0){
						Game.guess(letterGuess.charAt(0));		
					} else {
						System.out.println("INVALID INPUT");
					}
					playing = !Game.isComplete();
				}
				System.out.print("\nThe word or phrase was \"" + wordyPhrase + "\" \n \nDo you want to play again? ");
				if(console.next().equalsIgnoreCase("no")){
					playAgain = false;
				} else {
					playing = true;
				}
			}
			if(document.hasNextLine()){
				System.out.println("text file is out of words, ");
			}
			System.out.println("goodbye");
			console.close();
			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}