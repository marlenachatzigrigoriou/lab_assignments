package codeanalyzer;

import java.io.IOException;

/**
 * NOM (Number Of Methods) Analysis class
 * @author marlenachatzigrigoriou
 *
 */
public class SourceCodeAnalyzerNOM extends SourceCodeAnalyzer{
	
	/**
	 * Constructor class.
	 * @param fileReaderType location of the file (local or web)
	 * @param _analyzerType object of SourceCodeAnalyzerType indicating the analyzer type (regex or strcomp) 
	 *
	 */
	public SourceCodeAnalyzerNOM(String fileReaderType, SourceCodeAnalyzerType _analyzerType) {
		super(fileReaderType, _analyzerType);
	}

	@Override
	public int calculateTheAnalysis(String filepath) throws IOException {
		return this.analyzerType.calculateNOMAnalysis(filepath, fileReader);
	}

}