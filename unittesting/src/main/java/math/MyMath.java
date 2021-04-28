package math;

/**
* The MyMath provides the simple factorial operation
* that serve as hands-on practice on Unit Testing.
*
* @author  marlenachatzigrigoriou
* @version 1.0
* @since   2021-04-23 
*/
public class MyMath {
	
	/**
	 * Performs the arithmetic operation of factorial.
	 * @param number the number of the operation
	 * @return the result of the factorial of the number
	 * @exception IllegalArgumentException when number is greater than 12 and lower than 0
	 */
	public int factorial(int number) {
		if (number < 0 || number > 12) {
			if (number < 0) {
				throw new IllegalArgumentException("number should be >= 0");
			} else {
				throw new IllegalArgumentException("number should be <= 12");
			}
		} else if (number == 0) {
			return 1;    
		} else {    
			return(number * factorial(number-1));    
		}
	} 
	
}
