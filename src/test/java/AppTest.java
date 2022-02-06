import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static org.testng.Assert.*;

@Test
public class AppTest 
{
	private final Logger logger = LogManager.getLogger(AppTest.class);
	ExerciseOneValidation validation = new ExerciseOneValidation();
	@Test(enabled=true)
	private void testIsValidCity() {
		logger.debug("Test valid city");
		assertTrue(validation.isValidCity("abcdd"), "Not a valid city");
		assertFalse(validation.isValidCity(""), "city name is empty");
	}
	
	@Test(enabled=true)
	private void testIsValidNOT() {
		logger.info("Test valid NOT");
		assertTrue(validation.isValidCity("abcdd"), "NOT is empty");
		assertFalse(validation.isValidCity(""), "should return false");
	}
	
	@Test(enabled=true)
	private void testIsCorrectTAN() {
		assertEquals(validation.isCorrectTAN("T12345678"), true);
		logger.debug("TAN format ok");
		assertEquals(validation.isCorrectTAN("1234567"), false);
		logger.debug("passed TAN without T");
		assertNotEquals(validation.isCorrectTAN("12345678"), false);
	}
	
	@Test(enabled=true)
	private void testIsValidTAN() {
		ArrayList<TrustAccountReturn> myList = new ArrayList<TrustAccountReturn>();
		myList.add(new TrustAccountReturn("12345678", 432, 3234, "scar", "kdfdk", "SK"));
		assertEquals(validation.isValidTAN("T12345678", myList), false);
		assertEquals(validation.isValidTAN("12345678", myList), false);
		assertEquals(validation.isValidTAN("T12345679", myList), true);
	}
	
	@Test(enabled=true)
	private void testIsValidPI() {
		assertTrue(validation.isValidPensionIncome("1234"));
		//System.out.println();
		assertFalse(validation.isValidPensionIncome("-1234"));
		assertFalse(validation.isValidPensionIncome("-t123"));
		assertFalse(validation.isValidPensionIncome("-12er34"));
	}
	
//	@Test(enabled=true)
//	private void testIsValidRI() {
//		assertNull(validation.isValidRentalIncome("aff"));
//	}
}
