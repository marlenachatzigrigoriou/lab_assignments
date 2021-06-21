package codeanalyzer;

import java.io.IOException;

/**
 * LOC (Lines Of Code) Analysis class
 * @author marlenachatzigrigoriou
 *
 */
public class SourceCodeAnalyzerLOC extends SourceCodeAnalyzer{
	
	/**
	 * Constructor class.
	 * @param fileReaderType location of the file (local or web)
	 * @param _analyzerType object of SourceCodeAnalyzerType indicating the analyzer type (regex or strcomp) 
	 *
	 */
	public SourceCodeAnalyzerLOC(String fileReaderType, SourceCodeAnalyzerType _analyzerType) {
		super(fileReaderType, _analyzerType);
	}

	@Override
	public int calculateTheAnalysis(String filepath) throws IOException {
		return this.analyzerType.calculateLOCAnalysis(filepath, fileReader);
	}

}