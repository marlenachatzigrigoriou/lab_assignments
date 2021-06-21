package codeanalyzer;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;


public class SourceCodeAnalyzerFactoryTest {
	
	private final static String TYPE_REGEX = "regex";
	private final static String TYPE_STRCOMP = "strcomp";
	
	SourceCodeAnalyzerFactory mexfac = new SourceCodeAnalyzerFactory();
	
	@Test
	public void createAnalyzerRegex() throws IOException {
		String sourceCodeAnalyzerType = TYPE_REGEX;
		String fileReaderType = "web";
		ArrayList<SourceCodeAnalyzer> f = mexfac.createAnalyzer(sourceCodeAnalyzerType, fileReaderType);
		Assert.assertTrue(f.get(0) instanceof SourceCodeAnalyzerLOC);
		Assert.assertTrue(f.get(1) instanceof SourceCodeAnalyzerNOC);
		Assert.assertTrue(f.get(2) instanceof SourceCodeAnalyzerNOM);

	}

	@Test
	public void createAnalyzerStrcomp() throws IOException {
		String sourceCodeAnalyzerType = TYPE_STRCOMP;
		String fileReaderType = "local";
		ArrayList<SourceCodeAnalyzer> f = mexfac.createAnalyzer(sourceCodeAnalyzerType, fileReaderType);
		Assert.assertTrue(f.get(0) instanceof SourceCodeAnalyzerLOC);
		Assert.assertTrue(f.get(1) instanceof SourceCodeAnalyzerNOC);
		Assert.assertTrue(f.get(2) instanceof SourceCodeAnalyzerNOM);
	}
	
	@Test
	public void createAnalyzerNull() throws IOException {
		String sourceCodeAnalyzerType = "other";
		String fileReaderType = "web";
		ArrayList<SourceCodeAnalyzer> f = mexfac.createAnalyzer(sourceCodeAnalyzerType, fileReaderType);
		Assert.assertTrue(f.get(0) instanceof SourceCodeAnalyzerLOC);
		Assert.assertTrue(f.get(1) instanceof SourceCodeAnalyzerNOC);
		Assert.assertTrue(f.get(2) instanceof SourceCodeAnalyzerNOM);	
	}
	
}