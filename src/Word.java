import java.util.*;

public class Word {
	private String phrase;
	private ArrayList<Character> letters = new ArrayList<>();
	private int wrongGuesses;
	private String[] hangmen = {
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "      |	\n" +
			             "      |	\n" + // 0
			             "      |	\n" +
			             "      |	\n" +
			             " =========\n" ,
			             
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" +
			             "      |	\n" + // 1
			             "      |	\n" + 
			             "      |	\n" +
			             " =========\n" ,
			             
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" +
			             "  |   |	\n" + // 2
			             "      |	\n" +
			             "      |	\n" +
			             " =========\n" ,
			             
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" + 
			             " /|   |	\n" + // 3
			             "      |	\n" +
			             "      |	\n" +
			             " =========\n" ,
			             
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" +
			             " /|\\  |	\n" + // 4
			             "      |	\n" +
			             "      |	\n" +
			             " =========\n" ,
			             
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" +
			             " /|\\  |	\n" +	// 5
			             " /    |	\n" +
			             "      |	\n" +
			             " =========\n" ,
			             	
			             "  +---+	\n" +
			             "  |   |	\n" +
			             "  O   |	\n" +
			             " /|\\  |	\n" + // 6
			             " / \\  |	\n" +
			             "      |	\n" +
			             " =========\n" };
	
	public void newWord(String words){
		this.phrase = words;
		this.letters.clear();
		this.wrongGuesses = 0;
	}
	
	public String display(){
		this.updateWrongGuesses();
		Character[] words = new Character[this.phrase.length()];
		for(int ch = 0; ch < words.length; ch++){
			if(this.phrase.charAt(ch) != ' '){
				words[ch] = '_';
			} else {
				words[ch] = ' ';
			}
			if(letters.contains(this.phrase.charAt(ch))){
				words[ch] = this.phrase.charAt(ch);
			}
		}
		String displayWords =  Arrays.toString(words);
		displayWords = displayWords.replace("[","");
		displayWords = displayWords.replace("]","");
		displayWords = displayWords.replace(",","");
		return this.hangmen[this.wrongGuesses] + "\n" + displayWords;
	}
	
	public void guess(char letter){
		if(!this.letters.contains(letter)){
			this.letters.add(letter);
		} else {
			System.out.println("\nYou have already chosen that charecter ");
		}
	}
	
	private void updateWrongGuesses(){
		int badGuesses = 0;
		for(int ch = 0; ch < this.letters.size(); ch++){
			if(!this.phrase.contains(Character.toString(this.letters.get(ch)))){
				badGuesses++;
			}
		}
		this.wrongGuesses = badGuesses;
	}
	
	public boolean isComplete(){
		if(this.display().contains("_") && this.wrongGuesses != 6){
			return false;
		} else {
			return true;
		}
	}
}
