import java.util.*;

public class Word {
	private String phrase;
	private ArrayList<Character> letters = new ArrayList<>();
	
	public Word(String words){
		this.phrase = words;
	}
	
	public String display(){
		String words = this.phrase;
		for(int ch = 0; ch < this.letters.size(); ch++){
			if(words.indexOf(ch) == -1){
				
			}
		}
		return words;
	}
	
	public void guess(char letter){
		this.letters.add(letter);
	}
}
