package incubyte;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class StringCalculatorTest {

	@Test
	public void emptyString() {
		assertEquals(0,StringCalculator.add(""));
	}

	@Test
	public void singleElement() {
		assertEquals(8,StringCalculator.add("8"));
	}

	@Test
	public void twoElement() {
		assertEquals(3,StringCalculator.add("1,2"));
		
	}

	@Test
	public void threeElements() {
		assertEquals(6,StringCalculator.add("1,2,3"));
	}

	@Test
	public void twoNumWithDelimiter() {
		assertEquals(3,StringCalculator.add("1\n2"));
	}

	@Test
	public void threeNumWithDelimiter() {
		assertEquals(6,StringCalculator.add("1,2\n3"));
	}

	@Test
	public void usesDelimiterSepcified() {
		assertEquals(3,StringCalculator.add("//;\n1;2"));
		assertEquals(13,StringCalculator.add("//.\n2.5.6"));
	}

	@Test
	public void negativeNumber() {
		Assertions.assertThrows(Exception.class, ()-> StringCalculator.add("-1"));
		
		//StringCalculator.add("1,-3,5,-5,-13");
	}

	@Test
	public void greaterThanThousand() {
		assertEquals(2,StringCalculator.add("1002"));
		assertEquals(47,StringCalculator.add("1022,10025"));
	}

	@Test
	public void delimiterOfArbitraryLength() {
		assertEquals(6,StringCalculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void multipleDelimiters() {
		assertEquals(6,StringCalculator.add("//[-][;]\n1-2;3"));
		assertEquals(9,StringCalculator.add("//[--][...]\n2--3...4"));
	}
}

