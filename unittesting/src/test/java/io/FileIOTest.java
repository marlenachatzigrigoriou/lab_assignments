package io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FileIOTest {
	
	FileIO fileio = new FileIO();
	public static String resourcesPath = "src/test/resources/";
	
	@Test
	public void testReadFileValidInput() {
		int[] expectedNumbers = new int[] {5, 10, 15, 20, 25};
		String validInputFilepath = resourcesPath.concat("numbers.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	@Test
	public void testReadFileFileDoesNotExistReturnsIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Input file does not exist");
		int[] expectedNumbers = new int[] {5, 10, 15, 20, 25};
		String validInputFilepath = resourcesPath.concat("numbers1.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	@Test
	public void testReadFileFileIsEmptyReturnsIllegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Given file is empty");
		int[] expectedNumbers = new int[] {};
		String validInputFilepath = resourcesPath.concat("empty.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}
	
	@Test
	public void testReadFileContainsInvalidEntries() {
		thrown.expect(NumberFormatException.class);
		thrown.expectMessage("Ignore no int values.");
		int[] expectedNumbers = new int[] {5, 10, 4};
		String validInputFilepath = resourcesPath.concat("invalid_entries.txt");
		
		Assert.assertArrayEquals(expectedNumbers, fileio.readFile(validInputFilepath));
	}

}