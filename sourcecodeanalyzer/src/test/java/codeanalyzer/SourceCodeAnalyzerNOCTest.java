package codeanalyzer;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SourceCodeAnalyzerNOCTest {
	
	private final static String TEST_CLASS = "src/test/resources/TestClass.java";
	
	private SourceCodeAnalyzerNOC locAnalyzer = new SourceCodeAnalyzerNOC("local", new SourceCodeAnalyzerTypeRejex());

	@Test
	public void calculateTheAnalysisTest() throws IOException {
		Assert.assertEquals(3, locAnalyzer.calculateTheAnalysis(TEST_CLASS));
	}

}