import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ScrambleWords {
	
	private static Scanner file;
	private static List<String> words = new ArrayList<String>();
	private static List<Character> characters = new ArrayList<>();
	
	public static void openFile() {
		
		try {
			file = new Scanner(new File("words.txt"));
			
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
			
		} catch (Exception e) {
			System.out.println("IOException");
		}
	}
	
	public static String randomWord() {

		Random r = new Random();
		
		while(file.hasNext()) {
			words.add(file.next());
		}
		
		Collections.shuffle(words);
		String randomWord = words.get(r.nextInt(words.size()));
		
		return randomWord;
	}
	
	public static String readScramble(String randomWord) {
		
		for(char ch : randomWord.toCharArray()) {
			characters.add(ch);
		}

		Collections.shuffle(characters);
		StringBuilder sb = new StringBuilder();
		
		for(char ch: characters) { 
			sb.append(ch);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println("Welcome to Jumble Scamble Word Game: " + " Guess the Scrambled Word Below. ");
		System.out.println("---------------------------------------------------------------------------");
		
		openFile();
		String word = randomWord();
		String scramble = readScramble(word);
		
		System.out.println("The Scrambled Word is: " + scramble + "\n");
		System.out.print("------> ");
		
		Scanner scan = new Scanner(System.in);
		
		while(scan.hasNext()) {
			String input = scan.nextLine();
		
		if(input.equals(word)) {
			System.out.println("\nCorrect!");
			System.out.println("The Scrambled Word was: " + word + "\n");
			System.out.println("--------------------------------------");
			System.out.println("Thank You for Playing Jumble Word Game");
			System.out.println("--------------------------------------");
		}
		
		
		
		else {
			System.out.print("Wrong, Try again! ");
			System.out.print("----> ");
		}
		}
		scan.close();
	
	}
}


