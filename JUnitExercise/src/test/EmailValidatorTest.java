package test;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.infy.exception.InfyAcademyException;

import application.EmailValidator;

public class EmailValidatorTest{
	private static EmailValidator emailValidator;
	
	@BeforeAll
	public static void init() {
		emailValidator= new EmailValidator();
	}
	@Test
	public void validateEmailIdValidEmailId() throws InfyAcademyException {
		String validEmail = "James_Potter123@infy.com";
		boolean expected= true;
		Assert.assertEquals(expected, emailValidator.validateEmailId(validEmail));
		
	}
	@Test
	public void validateEmailIdInvalidEmailId() throws InfyAcademyException {
		String inValidEmail = "James_Potter123@infy.org";
		boolean expected = false;
		Assert.assertEquals(expected, emailValidator.validateEmailId(inValidEmail));
	}
	@Test
	public void validateEmailIdInvalidEmailIdException() throws InfyAcademyException {
		String email = null;
		Assert.assertThrows(InfyAcademyException.class,
							()->emailValidator.validateEmailId(email));
	}
	@ParameterizedTest
	@ValueSource(strings = {"serius_black@infy.com","Lily_Evans@Hoggy.in","Remus_lups@amazon.in","NymphieTonks@magic.com"})
	public void validateEmailIdParamterizedEmailId(String email) throws InfyAcademyException {
		//boolean expected= true;
		System.out.println(email);
		//Assert.assertEquals(expected, emailValidator.validateEmailId(email1));
		Assert.assertTrue(emailValidator.validateEmailId(email));
		
	}
	@AfterAll
	public static void tearDown() {
		emailValidator=null;
	}
}
