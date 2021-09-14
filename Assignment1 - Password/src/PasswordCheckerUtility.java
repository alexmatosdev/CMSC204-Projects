import java.util.ArrayList;
import java.util.regex.Pattern;

public class PasswordCheckerUtility {


	public static boolean hasBetweenSixAndNineChars(String password) {
		return password.length() >=6 && password.length() <= 9;
	}
	
	public static boolean hasDigit(String password) throws NoDigitException {
		for (int i = 0; i < password.length(); i++)
			if (!(password.contains("1") || password.contains("2") || password.contains("3") || password.contains("4") || password.contains("5") || password.contains("6")|| password.contains("7") || password.contains("8")|| password.contains("9") || password.contains("0")))
				throw new NoDigitException();
		return true;
	}
	
	public static boolean hasLowerAlpha(java.lang.String password) throws NoLowerAlphaException {
		for (int i = 0; i < password.length(); i++)
			if (password.charAt(i)>=97 && password.charAt(i)<=122)
				return true;
		throw new NoLowerAlphaException();
		
	}
	
	public static boolean hasSameCharInSequence(java.lang.String password) throws InvalidSequenceException {
		for (int i = 0; i < password.length()-2; i++)
			if ((password.charAt(i+1) == password.charAt(i)) && password.charAt(i) == password.charAt(i+2))
				throw new InvalidSequenceException();
		return true;
	}
	
	public static boolean hasSpecialChar(java.lang.String password) throws NoSpecialCharacterException {
		for (int i = 0; i < password.length(); i++)
			if ((password.charAt(i)>=33 && password.charAt(i)<=47) || password.charAt(i) == 64)
				return true;
		throw new NoSpecialCharacterException();
	}
	
	public static boolean hasUpperAlpha(java.lang.String password)
            throws NoUpperAlphaException {
		for (int i=0; i<password.length(); i++)
			if (password.charAt(i)>=65 && password.charAt(i)<=90)
				return true;
		throw new NoUpperAlphaException();
	}
	
	public static boolean isValidLength(java.lang.String password)
            throws LengthException {
		if (password.length() >= 6)
			return true;
		throw new LengthException();
	}
	
	public static boolean isValidPassword(java.lang.String password)
            throws LengthException,
                   NoUpperAlphaException,
                   NoLowerAlphaException,
                   NoDigitException,
                   NoSpecialCharacterException,
                   InvalidSequenceException {
		if (isValidLength(password) == false) {throw new LengthException();}
		if (hasUpperAlpha(password) == false) {throw new NoUpperAlphaException();}
		if (hasLowerAlpha(password) == false) {throw new NoLowerAlphaException();}
		if (hasDigit(password) == false) {throw new NoDigitException();}
		if (hasSpecialChar(password) == false) {throw new NoSpecialCharacterException();}
		if (hasSameCharInSequence(password) == false) {throw new InvalidSequenceException();}	
		return false;
	}
	
	public static boolean isWeakPassword(java.lang.String password)
            throws WeakPasswordException, LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException {
		if (isValidPassword(password) && password.length() <= 9)
			throw new WeakPasswordException();
		
		return false;
	}
	
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm))
			throw new UnmatchedException();
	}
	
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String password : passwords) {
			try {
				if (isValidPassword(password) == false) {
					
				}
			} catch (LengthException | NoUpperAlphaException | NoLowerAlphaException | NoDigitException
					| NoSpecialCharacterException | InvalidSequenceException e) {
				// TODO Auto-generated catch block
				invalidPasswords.add(password + " -> " + e.getMessage()); 
			}
		}
		return invalidPasswords;
	}
}
