package codeanalyzer;

import java.io.IOException;

import filereader.SourceFileReader;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates LOC, NOC, NOM, using two types of source code analysis,
 * namely regex (with the use of regular expressions) and 
 * strcomp (with the use of string comparison).
 * @author marlenachatzigrigoriou
 *
 */
public interface SourceCodeAnalyzerType {
	
	/**
	 * Calculates LOC.
	 * @param filepath path of the location of the file that is analyzed
	 * @param fileReader object of class SourceFileReader representing where the file locates (web or locally).
	 * @return the number of lines of code
	 *
	 */
	public int calculateLOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException;
	
	/**
	 * Calculates NOC.
	 * @param filepath path of the location of the file that is analyzed
	 * @param fileReader object of class SourceFileReader representing where the file locates (web or locally).
	 * @return the number of classes
	 *
	 */
	public int calculateNOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException;
	
	/**
	 * Calculates NOM.
	 * @param filepath path of the location of the file that is analyzed
	 * @param fileReader object of class SourceFileReader representing where the file locates (web or locally).
	 * @return the number of methods
	 *
	 */
	public int calculateNOMAnalysis(String filepath, SourceFileReader fileReader) throws IOException;

}