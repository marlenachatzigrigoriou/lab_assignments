package codeanalyzer;

import java.io.IOException;

import filereader.SourceFileReader;
import filereader.SourceFileReaderFactory;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes. 
 * The current functionality supports two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * @author marlenachatzigrigoriou
 *
 */
public abstract class SourceCodeAnalyzer {
	
	/**
	 * Object of class SourceFileReader representing
	 * where the file locates (web or locally).
	 *
	 */
	protected SourceFileReader fileReader;
	/**
	 * Object of class SourceCodeAnalyzerType representing
	 * the type of analysis (loc, nom, noc).
	 *
	 */
	protected SourceCodeAnalyzerType analyzerType;

	/**
	 * Constructor class.
	 * @param fileReaderType location of the file (local or web)
	 * @param _analyzerType object of SourceCodeAnalyzerType indicating the analyzer type (regex or strcomp) 
	 *
	 */
	public SourceCodeAnalyzer(String fileReaderType, SourceCodeAnalyzerType _analyzerType) {
		SourceFileReaderFactory sfrf = new SourceFileReaderFactory();
		fileReader = sfrf.createFileReader(fileReaderType);		
		this.analyzerType = _analyzerType;
	}
	
	/**
	 * Analyzes the contents of a Java source code file, 
	 * located in filepath.
	 * @param filepath path of the location of the file that is analyzed
	 * @return the analysis results
	 *
	 */
	public abstract int calculateTheAnalysis(String filepath) throws IOException;
	
}
