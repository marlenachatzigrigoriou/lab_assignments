package codeanalyzer;

import java.io.IOException;
import org.junit.Test;
import filereader.SourceFileReader;
import filereader.SourceFileReaderFactory;

import static org.junit.Assert.*;


public class StrcompSourceCodeAnalyzeTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	private SourceCodeAnalyzerTypeStrComp strCompAnalyzer = new SourceCodeAnalyzerTypeStrComp();
	
	private SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
	private SourceFileReader fileReader = sfrf.createFileReader("local");	
	private SourceFileReader fileReaderNull = sfrf.createFileReader("non-existing-type");	
	
	@Test
	public void testCalculateLOC() throws IOException {
		assertEquals(7, strCompAnalyzer.calculateLOCAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, strCompAnalyzer.calculateLOCAnalysis(TEST_CLASS, fileReaderNull));
	}
	
	@Test
	public void testCalculateNOM() throws IOException {
		assertEquals(3, strCompAnalyzer.calculateNOMAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, strCompAnalyzer.calculateNOMAnalysis(TEST_CLASS, fileReaderNull));
	}	
	
	@Test
	public void testCalculateNOC() throws IOException {
		assertEquals(3, strCompAnalyzer.calculateNOCAnalysis(TEST_CLASS, fileReader));
		assertEquals(-1, strCompAnalyzer.calculateNOCAnalysis(TEST_CLASS, fileReaderNull));
	}
	
}