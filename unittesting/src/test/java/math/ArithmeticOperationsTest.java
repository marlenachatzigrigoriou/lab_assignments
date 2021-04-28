package math;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

public class ArithmeticOperationsTest {
	
	/* 
	 * A reference to the ArithmeticOperations class
	 * whose methods we are testing in this class
	 */
	ArithmeticOperations obj ;
	
	/*
	 * This is a constructor which is called 
	 * when the ArithmeticOperationsTest class is initialized
	 */
	public ArithmeticOperationsTest() {
		this.obj = new ArithmeticOperations();
	}
	
	@Test
	public void testDivide() {
		Assert.assertEquals(2.0, obj.divide(10.0, 5.0), 0);
		Assert.assertEquals(-1.826, obj.divide(3.14, -1.72), 0.001);
	}
	
	@Test (expected = ArithmeticException.class)
	public void testDivideReturnsArithmeticException() {
		obj.divide(5.0, 0.0);		
	}
	
	@Test
	public void testMultiply() {
		Assert.assertEquals(50, obj.multiply(10, 5), 0);
		Assert.assertEquals(118800, obj.multiply(1200, 99), 0);
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testMultiplyShouldShowIllegalArgumentExceptionOnNegativeInputX() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(-5, 8);
	}
	@Test
	public void testMultiplyShouldShowIllegalArgumentExceptionOnNegativeInputY() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("x & y should be >= 0");
		obj.multiply(5, -8);
	}
	@Test
	public void testMultiplyShouldShowIllegalArgumentExceptionOnMAX_VALUEProduct() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("The product does not fit in an Integer variable");
		obj.multiply(Integer.MAX_VALUE, 8);
	}

}
