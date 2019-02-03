import java.util.*;

public class Word {
	private String phrase;
	private ArrayList<Character> letters = new ArrayList<>();
	
	public Word(String words){
		this.phrase = words;
	}
	
	public String display(){
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
		return displayWords.replace(",","");
	}
	
	public void guess(char letter){
		this.letters.add(letter);
	}
}
