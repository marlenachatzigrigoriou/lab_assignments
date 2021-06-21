package filereader;

import java.io.IOException;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

public class NullSourceFileReaderTest {
	
	SourceFileReader sfr = null;
	private final static String TEST_CLASS_LOCAL = "src/test/resources/TestClass.java";
	
	SourceFileReaderFactory ss = new SourceFileReaderFactory();
	@Test
	public void testReadFileIntoListNull() throws IOException {
		//give a none existing type to cause a null List return
		sfr = ss.createFileReader("non-existing-type");
		List<String> actualList = sfr.readFileIntoList(TEST_CLASS_LOCAL);
		assertNull(actualList);
	}
	
	@Test
	public void testReadFileIntoStringNull() throws IOException {
		//give a none existing type to cause a null String return
		sfr = ss.createFileReader("non-existing-type");
		String actualString = sfr.readFileIntoString(TEST_CLASS_LOCAL);
		assertNull(actualString);
	}
}