package codeanalyzer;

import java.io.IOException;
import java.util.List;

import filereader.SourceFileReader;

/**
 * Analyzes the contents of a Java source code file 
 * and calculates the following metrics: loc = lines of code,
 * nom = number of methods, and noc=number of classes, 
 * supporting the strcomp (with the use of string comparison) type
 * of source code analysis.
 * @author marlenachatzigrigoriou, agkortzis
 *
 */
public class SourceCodeAnalyzerTypeStrComp implements SourceCodeAnalyzerType{

	@Override
	public int calculateLOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int nonCodeLinesCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if (line.startsWith("//") || line.startsWith("/*") || line.startsWith("*") || line.equals("{") || line.equals("}") || line.equals(""))
					nonCodeLinesCounter++;
			}
			int loc = sourceCodeList.size() - nonCodeLinesCounter;
			return loc; 
		} catch(NullPointerException ex) {
			return -1; //not because of invalid analyzer type, but invalid file reader location.
		}
	}

	@Override
	public int calculateNOCAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {	
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int classCounter = 0;
			for (String line : sourceCodeList) {
				line = line.strip(); //remove leading and trailing white spaces
				if ((line.startsWith("class ") || line.contains(" class ")) && line.contains("{")) {
					classCounter++;
				}
			}
			return classCounter; 
		} catch(NullPointerException ex) {
			return -1; //not because of invalid analyzer type, but invalid file reader location.
		}
	
	}

	@Override
	public int calculateNOMAnalysis(String filepath, SourceFileReader fileReader) throws IOException {
		try {
			List<String> sourceCodeList = fileReader.readFileIntoList(filepath);
			int methodCounter = 0;
			for (String line : sourceCodeList) {
				line = line.stripLeading().stripTrailing(); //clear all leading and trailing white spaces
				if ( ((line.contains("public") || line.contains("private") || line.contains("protected"))
						|| line.contains("void") || line.contains("int") || line.contains("String"))
					&& line.contains("(") && line.contains(")") && line.contains("{") )
					methodCounter++;
			}
			return methodCounter; 
		} catch(NullPointerException ex) {
			return -1; //not because of invalid analyzer type, but invalid file reader location.
		}
	}
	
}