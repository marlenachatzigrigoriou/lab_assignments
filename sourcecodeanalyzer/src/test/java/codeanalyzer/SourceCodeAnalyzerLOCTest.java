package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SourceCodeAnalyzerLOCTest {
	
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	private SourceCodeAnalyzerLOC locAnalyzer = new SourceCodeAnalyzerLOC("local", new SourceCodeAnalyzerTypeRejex());

	@Test
	public void calculateTheAnalysisTest() throws IOException {
		Assert.assertEquals(21, locAnalyzer.calculateTheAnalysis(TEST_CLASS));
	}
	
}