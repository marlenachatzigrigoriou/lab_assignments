package codeanalyzer;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import filereader.SourceFileReader;


/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes, 
 * supporting the regex (with the use of regular expressions) type
 * of source code analysis.
 * @author marlenachatzigrigoriou, agkortzis
 *
 */
public class SourceCodeAnalyzerTypeRejex implements SourceCodeAnalyzerType{
	
	@Override
	public int calculateLOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile("((//.*)|(/\\*.*)|(\\*+.*))");
	        Matcher nonCodeLinesMatcher = pattern.matcher(sourceCode);
	
	        int nonCodeLinesCounter = 0;
	        while (nonCodeLinesMatcher.find()) {
	        	nonCodeLinesCounter++;
	        }
	        int sourceFileLength = sourceCode.split("\n").length;
	        int loc =  sourceFileLength - nonCodeLinesCounter;
	
			return loc;
		} catch (NullPointerException ex) {
			return -1; //not because of invalid analyzer type, but invalid file reader location.
		}
	}	
	

	@Override
	public int calculateNOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*\\s*class\\s+.*"); 
	        Matcher classSignatures = pattern.matcher(sourceCode);
	
	        int classCounter = 0;
	        while (classSignatures.find()) {
	        	classCounter++;
	        }
	        
			return classCounter;
		} catch(NullPointerException ex) {
			return -1;//not because of invalid analyzer type, but invalid file reader location.
		}
		
	}

	@Override
	public int calculateNOMAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {
			String sourceCode = fileReader.readFileIntoString(filepath);
			Pattern pattern = Pattern.compile(".*(public |protected |private |static )?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;]).*"); 
	        Matcher methodSignatures = pattern.matcher(sourceCode);
	
	        int methodCounter = 0;
	        while (methodSignatures.find()) {
	        	methodCounter++;
	        }
	        
			return methodCounter;
		} catch(NullPointerException ex) {
			return -1;//not because of invalid analyzer type, but invalid file reader location.
		}
	}

}