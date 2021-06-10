package filereader;

import org.junit.Assert;
import org.junit.Test;

public class SourceFileReaderFactoryTest {
	
	private final static String TYPE_WEB = "web";
	private final static String TYPE_LOCAL = "local";
	
	SourceFileReaderFactory ss = new SourceFileReaderFactory();
	
	@Test
	public void createFileReaderWeb() {
		String fileReaderType = TYPE_WEB;
		SourceFileReader f = ss.createFileReader(fileReaderType);
		Assert.assertTrue(f instanceof SourceFileReaderWeb);
	}
	
	@Test
	public void createFileReaderLocal() {
		String fileReaderType = TYPE_LOCAL;
		SourceFileReader f = ss.createFileReader(fileReaderType);
		Assert.assertTrue(f instanceof SourceFileReaderLocal);
	}
	
	@Test
	public void createFileReaderNull() {
		String fileReaderType = "non-existing-type";
		SourceFileReader f = ss.createFileReader(fileReaderType);
		Assert.assertTrue(f instanceof SourceFileReaderNull);
	}
}
	