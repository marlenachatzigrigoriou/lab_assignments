package math;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyMathTest {
	
	MyMath mm = new MyMath();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testFactorialGreaterThanTwelveReturnIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should be <= 12");
		mm.factorial(13);		
	}
	@Test
	public void testFactorialLowerThanZeroReturnIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("number should be >= 0");
		mm.factorial(-1);		
	}
	@Test
	public void testIsPrimeInvalidInputReturnIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input number n should be >= 2");
		mm.isPrime(-10);	
		mm.factorial(1);		
	}

	@Test
	public void testIsPrime() {
		Assert.assertTrue(mm.isPrime(23));
		Assert.assertTrue(mm.isPrime(97));
		Assert.assertFalse(mm.isPrime(42));		
	}
	
}
