package codeanalyzer;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The factory of SourceCodeAnalyzer class, that generates
 * SourceCodeAnalyzer objects.
 * @author marlenachatzigrigoriou
 *
 */
public class SourceCodeAnalyzerFactory {
	
	/**
	 * Object of class SourceCodeAnalyzer representing
	 * nom analysis.
	 *
	 */
	private SourceCodeAnalyzer nom;
	/**
	 * Object of class SourceCodeAnalyzer representing
	 * noc analysis.
	 *
	 */
	private SourceCodeAnalyzer noc;
	/**
	 * Object of class SourceCodeAnalyzer representing
	 * loc analysis.
	 *
	 */
	private SourceCodeAnalyzer loc;
	
	/**
	 * Generates SourceCodeAnalyzer objects, depending on 
	 * the defined sourceCodeAnalyzerType.
	 * @param sourceCodeAnalyzerType how the analysis performs (rejex, strcomp)
	 * @param fileReaderType location of the file (local or web)
	 * @return a list of the created SourceCodeAnalyzer objects, one index for each type of analysis (loc, nom, noc)
	 */
	public ArrayList<SourceCodeAnalyzer> createAnalyzer(String sourceCodeAnalyzerType, String fileReaderType) throws IOException {
		
		ArrayList<SourceCodeAnalyzer> lnn = new ArrayList<SourceCodeAnalyzer>();
		
		if (sourceCodeAnalyzerType.equals("regex")) {
			
			nom = new SourceCodeAnalyzerNOM(fileReaderType, new SourceCodeAnalyzerTypeRejex());
			noc = new SourceCodeAnalyzerNOC(fileReaderType, new SourceCodeAnalyzerTypeRejex());
			loc = new SourceCodeAnalyzerLOC(fileReaderType, new SourceCodeAnalyzerTypeRejex());
			
		} else if (sourceCodeAnalyzerType.equals("strcomp")) {
			nom = new SourceCodeAnalyzerNOM(fileReaderType, new SourceCodeAnalyzerTypeStrComp());
			noc = new SourceCodeAnalyzerNOC(fileReaderType, new SourceCodeAnalyzerTypeStrComp());
			loc = new SourceCodeAnalyzerLOC(fileReaderType, new SourceCodeAnalyzerTypeStrComp());
		
		} else {
			nom = new SourceCodeAnalyzerNOM(fileReaderType, new SourceCodeAnalyzerTypeNull());
			noc = new SourceCodeAnalyzerNOC(fileReaderType, new SourceCodeAnalyzerTypeNull());
			loc = new SourceCodeAnalyzerLOC(fileReaderType, new SourceCodeAnalyzerTypeNull());
		}
		
		lnn.add(loc);
		lnn.add(noc);
		lnn.add(nom);
		return lnn;
		
	}
	
}