package codeanalyzer;

import java.io.IOException;
import org.junit.Test;

import filereader.SourceFileReader;
import filereader.SourceFileReaderFactory;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class NullSourceCodeAnalyzerTest {

	private final static String TEST_CLASS = "src/test/resources/TestClass.java";

	private SourceCodeAnalyzerTypeNull nullAnalyzer1 = new SourceCodeAnalyzerTypeNull();
	private SourceCodeAnalyzerTypeNull nullAnalyzer = mock(SourceCodeAnalyzerTypeNull.class);

	private SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
	private SourceFileReader fileReader = sfrf.createFileReader("local");	

	@Test
	public void testCalculateNullLOC() throws IOException {
		
		assertEquals(-1, nullAnalyzer1.calculateLOCAnalysis(TEST_CLASS, fileReader));
		
		doCallRealMethod().when(nullAnalyzer).calculateLOCAnalysis(TEST_CLASS, fileReader);
		nullAnalyzer.calculateLOCAnalysis(TEST_CLASS, fileReader);
		verify(nullAnalyzer).calculateLOCAnalysis(TEST_CLASS, fileReader);
	}
	
	@Test
	public void testCalculateNullNOC() throws IOException {
		
		assertEquals(-1, nullAnalyzer1.calculateNOCAnalysis(TEST_CLASS, fileReader));
		
		doCallRealMethod().when(nullAnalyzer).calculateNOCAnalysis(TEST_CLASS, fileReader);
		nullAnalyzer.calculateNOCAnalysis(TEST_CLASS, fileReader);
		verify(nullAnalyzer).calculateNOCAnalysis(TEST_CLASS, fileReader);
	}
	
	@Test
	public void testCalculateNullNOM() throws IOException {
		
		assertEquals(-1, nullAnalyzer1.calculateNOMAnalysis(TEST_CLASS, fileReader));
		
		doCallRealMethod().when(nullAnalyzer).calculateNOMAnalysis(TEST_CLASS, fileReader);
		nullAnalyzer.calculateNOMAnalysis(TEST_CLASS, fileReader);
		verify(nullAnalyzer).calculateNOMAnalysis(TEST_CLASS, fileReader);
	}
		
}
