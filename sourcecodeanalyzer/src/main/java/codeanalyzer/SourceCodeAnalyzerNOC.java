package codeanalyzer;

import java.io.IOException;

/**
 * NOC (Number Of Classes) Analysis class
 * @author marlenachatzigrigoriou
 *
 */
public class SourceCodeAnalyzerNOC extends SourceCodeAnalyzer{
	
	/**
	 * Constructor class.
	 * @param fileReaderType location of the file (local or web)
	 * @param _analyzerType object of SourceCodeAnalyzerType indicating the analyzer type (regex or strcomp) 
	 *
	 */
	public SourceCodeAnalyzerNOC(String fileReaderType, SourceCodeAnalyzerType _analyzerType) {
		super(fileReaderType, _analyzerType);
	}

	@Override
	public int calculateTheAnalysis(String filepath) throws IOException {
		return this.analyzerType.calculateNOCAnalysis(filepath, fileReader);
	}

}