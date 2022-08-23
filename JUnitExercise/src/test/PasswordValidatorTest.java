package test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.PasswordValidator;


public class PasswordValidatorTest{
	static PasswordValidator passwordValidator;
	@BeforeAll
	public static void setUp() {
		passwordValidator = new PasswordValidator();
	}
	@Test
	public void validatePasswordValidPassword() throws InfyAcademyException {
		String validPass = "Sur12345";
		boolean expected = true;
//		assertEquals(expected, passwordValidator.validatePassword(validPass));
		Assert.assertTrue(passwordValidator.validatePassword(validPass));
	}
	@Test
	public void validatePasswordInvalidPassword() throws InfyAcademyException {
		String inValidPass = "Sur";
		boolean expected = false;
		assertEquals(expected, passwordValidator.validatePassword(inValidPass));
	}
	@Test
	public void validatePasswordInvalidPasswordException() throws InfyAcademyException {
		String password = null;
		Assert.assertThrows(InfyAcademyException.class,
							()->passwordValidator.validatePassword(password));
	}
	
	@ParameterizedTest
	@ValueSource(strings= { "Qwerty","Qwerty1234","Qwertyxdfgsdfdsfdsf","zxcv12365" })
	public void validatePasswordParameterizedPassword(String pass) throws InfyAcademyException {
		
	}
	@AfterAll
	public static void tearDown() {
		passwordValidator=null;
	}
}