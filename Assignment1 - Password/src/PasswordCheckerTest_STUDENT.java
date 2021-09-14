
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {

	ArrayList<String> validPasswords;
	ArrayList<String> invalidPasswords;
	
	@Before
	public void setUp() throws Exception {
		String[] validPasswordsArr = {"Asdf$18", "ZsT6jkk$", "789jklM!#", "&BKing12"};
		String[] invalidPasswordsArr = {"12", "aaaalex", "matoss", "ty&8"};
		
		validPasswords = new ArrayList<>();
		validPasswords.addAll(Arrays.asList(validPasswordsArr));
		invalidPasswords = new ArrayList<>();
		invalidPasswords.addAll(Arrays.asList(invalidPasswordsArr));
		
	}

	@After
	public void tearDown() throws Exception {
		validPasswords = null;
		invalidPasswords = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertFalse(PasswordCheckerUtility.isValidLength(invalidPasswords.get(0)));
		} catch (LengthException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha(validPasswords.get(0)));
		} catch (NoUpperAlphaException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha(validPasswords.get(0)));
		} catch (NoLowerAlphaException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(invalidPasswords.get(1)));
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(invalidPasswords.get(1)));
		} catch (InvalidSequenceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertFalse(PasswordCheckerUtility.hasDigit(invalidPasswords.get(2)));
		} catch (NoDigitException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(validPasswords);
		assertTrue(results.isEmpty());
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> results;
		results = PasswordCheckerUtility.getInvalidPasswords(invalidPasswords);
		assertEquals(results.get(0), "12 -> The password must be at least 6 characters long");
		assertEquals(results.get(1), "aaaalex -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(2), "matoss -> The password must contain at least one uppercase alphabetic character");
		assertEquals(results.get(3), "ty&8 -> The password must be at least 6 characters long");
	}
	
}