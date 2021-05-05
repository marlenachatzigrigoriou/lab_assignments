package math;

import java.util.ArrayList;
import java.util.List;

import io.FileIO;

/**
* The ArrayOperations provides the process of 
* finding prime numbers in a file and turn them into 
* an array.
*
* @author  marlenachatzigrigoriou
* @version 1.0
* @since   2021-04-23 
*/
public class ArrayOperations {
	
	/**
	 * Iterates an array of numbers and keep the prime ones.
	 * @param fileIo object of class FileIO.
	 * @param filepath path of the file that fileIo reads.
	 * @param myMath object of class MyMath.
	 * @return a new array that contains only its prime numbers
	 */
	public int[] findPrimesInFile(FileIO fileIo, String filepath, MyMath myMath) {
		int[] numbers = fileIo.readFile(filepath);
		List<Integer> primeNumbers = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			if (myMath.isPrime(numbers[i])) {
				primeNumbers.add(numbers[i]);
			}
		}
		return primeNumbers.stream().mapToInt(i -> i).toArray();
	}

}
