package codeanalyzer;

import java.io.IOException;
import filereader.SourceFileReader;

/**
 * Manages the cases when the analyzer type is not valid 
 * (null or not implemented).
 * @author marlenachatzigrigoriou
 *
 */
public class SourceCodeAnalyzerTypeNull implements SourceCodeAnalyzerType{

	@Override
	public int calculateLOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		abortCalculation();
		return -1;
	}

	@Override
	public int calculateNOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		abortCalculation();
		return -1;
	}

	@Override
	public int calculateNOMAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		abortCalculation();
		return -1;
	}
	
	/**
	 * Prints the message when there is error
	 * due to unknown analyzer type. 
	 */
	public void abortCalculation() {
		System.err.println("Operation aborted due to unknown source code analyzer type.");
	}
	
}