import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
 
public class SpiralTest {
	@Rule 
	public ExpectedException thrown = ExpectedException.none();
	Spiral testSpiral = new Spiral();
	@Test()
	public void testNumberFormatException(){
	
		int numb = testSpiral.getNumber();
		assertTrue(numb==testSpiral.testinteger());
	}
	
	@Test()
	public void ifDirectionIsCorrect(){
		String input = testSpiral.getDirection();
	    assertTrue(input.matches(testSpiral.testdirection()));
	}
}
