package math;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;
import io.FileIO;

public class ArrayOperationsTest {

	@Test
	public void testFindPrimesInFile() {
		
		FileIO fileio = mock(FileIO.class);
		
		String path = "src/test/resources/numbers.txt";
		when(fileio.readFile(path)).thenReturn(new int[] {5, 10, 15, 20, 25});
		
		ArrayOperations ao = new ArrayOperations();
		MyMath mm = new MyMath();
		int[] expected = {5};
		int[] actual = ao.findPrimesInFile(fileio, path, mm);
		
		assertArrayEquals(expected, actual);
	}
}
