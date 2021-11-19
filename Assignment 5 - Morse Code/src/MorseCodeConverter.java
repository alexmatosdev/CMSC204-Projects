import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter extends Object{
	
	static MorseCodeTree cl = new MorseCodeTree();
	
	public static String convertToEnglish(String codeFile) {
		String english = "";
		String[] letters;
		String[] words = codeFile.split(" / ");
		for (String word : words) {
			letters = word.split(" ");
			for (String letter : letters) {
				english += cl.fetch(letter);
			}
			english += " ";
		}
		
		return english.trim();
	}
	
	public static String convertToEnglish(File code) throws FileNotFoundException{
		Scanner input = new Scanner(code);
		String morseCode = input.nextLine();
		input.close();
		
		String english = "";
		String[] words = morseCode.split(" / ");
		String[] letters;
		for (String word : words) {
			letters = word.split(" ");
			for (String letter : letters) {
				english += cl.fetch(letter);
			}
			english += " ";
		}
		
		return english.trim();
	}
	
	public static String printTree() {
		ArrayList<String> list = cl.toArrayList();
		String treeStr = "";
		for (String treeNode : list) {
			treeStr += treeNode + " ";
		}
		return treeStr;
	}
}