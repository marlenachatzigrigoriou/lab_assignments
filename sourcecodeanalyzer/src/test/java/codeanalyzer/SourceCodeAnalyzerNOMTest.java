package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SourceCodeAnalyzerNOMTest {
	
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	private SourceCodeAnalyzerNOM locAnalyzer = new SourceCodeAnalyzerNOM("local", new SourceCodeAnalyzerTypeRejex());

	@Test
	public void calculateTheAnalysisTest() throws IOException {
		Assert.assertEquals(3, locAnalyzer.calculateTheAnalysis(TEST_CLASS));
	}
	
}