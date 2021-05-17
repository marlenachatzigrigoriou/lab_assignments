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
	
	/**
	 * Performs if a number is prime or not.
	 * @param n the number to be checked.
	 * @return True if n is a prime number, False if it is not.
	 * @exception IllegalArgumentException when n is lower than 2.
	 */
	public boolean isPrime(int n) {
		boolean isItPrime = true;
		if (n >= 2) {
			for (int i = 2; i<= n/2; i++) {
				if ((n % i) == 0) {
					isItPrime = false;
					break;
				}
			}
			return isItPrime;
		} else {
			throw new IllegalArgumentException("Input number n should be >= 2");
		}
	}
	
}
