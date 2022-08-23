package test;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({EmailValidatorTest.class, PasswordValidatorTest.class})
public class TestSuite {
//	@BeforeClass
//	public static void printMe() {
//		System.out.println("All Test case execution via Suite ");
//	}

}