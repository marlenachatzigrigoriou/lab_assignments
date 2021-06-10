package codeanalyzer;

import org.junit.Test;
import filereader.SourceFileReader;
import filereader.SourceFileReaderFactory;
import static org.junit.Assert.*;
import java.io.IOException;

public class RegexSourceCodeAnalyzerTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	private SourceCodeAnalyzerTypeRejex regexAnalyzer = new SourceCodeAnalyzerTypeRejex();
	
	private SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
	private SourceFileReader fileReader = sfrf.createFileReader("local");	
	private SourceFileReader fileReaderNull = sfrf.createFileReader("non-existing-type");	

	@Test
	public void testCalculateLOC() throws IOException {
		assertEquals(21, regexAnalyzer.calculateLOCAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, regexAnalyzer.calculateLOCAnalysis(TEST_CLASS, fileReaderNull));
	}
	
	@Test
	public void testCalculateNOM() throws IOException {
		assertEquals(3, regexAnalyzer.calculateNOMAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, regexAnalyzer.calculateNOMAnalysis(TEST_CLASS, fileReaderNull));
	}	
	
	@Test
	public void testCalculateNOC() throws IOException {
		assertEquals(3, regexAnalyzer.calculateNOCAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, regexAnalyzer.calculateNOCAnalysis(TEST_CLASS, fileReaderNull));
	}

}