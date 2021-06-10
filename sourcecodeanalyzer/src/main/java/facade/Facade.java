package facade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import metricsexporter.MetricsExporter;
import metricsexporter.MetricsExporterFactory;
import codeanalyzer.*;

/**
 * Serves as a front-facing interface in source
 * code analyzer implementation.
 * @author marlenachatzigrigoriou, agkortzis
 *
 */
public class Facade {
	
	/**
	 * Analyzes the file (source code) located in filepath and saves 
	 * the results-metrics in the file located in outputFilePath.
	 * @param fileReaderType location of the file (local or web)
	 * @param sourceCodeAnalyzerType how the analysis performs (rejex, strcomp)
	 * @param filepath path of the location of the file that is analyzed
	 * @param outputFilePath path of the location of the file with the metrics will be saved
	 * @param outputFileType the type (.csv, .json) of the file that contains the metrics
	 *
	 */
	public void analyzer(String sourceCodeAnalyzerType, String fileReaderType, String filepath,
												String outputFileType, String outputFilePath) throws IOException {
		
		SourceCodeAnalyzerFactory scaf = new SourceCodeAnalyzerFactory();
		ArrayList<SourceCodeAnalyzer> lnn = scaf.createAnalyzer(sourceCodeAnalyzerType, fileReaderType);
		
		int locvar = lnn.get(0).calculateTheAnalysis(filepath);
		int nocvar = lnn.get(1).calculateTheAnalysis(filepath);
		int nomvar = lnn.get(2).calculateTheAnalysis(filepath);
		
		Map<String, Integer> metrics = new HashMap<>();
		
		if (locvar != -1) {
			metrics.put("loc",locvar);
			metrics.put("nom",nomvar);
			metrics.put("noc",nocvar);
			
			writeExporter(outputFileType, metrics, outputFilePath);
		}
		
	}
		
	/**
	 * Writes the metrics in the file located in outputFilePath.
	 * @param metrics list containing the analysis' results
	 * @param outputFilePath path of the location of the file with the metrics will be saved
	 * @param outputFileType the type (.csv, .json) of the file that contains the metrics
	 *
	 */
	public void writeExporter(String outputFileType, Map<String, Integer> metrics, String outputFilePath) {
		// after the creation of MetricsExporterFactory
		MetricsExporterFactory mef = new MetricsExporterFactory();
		MetricsExporter exporter = mef.createExporter(outputFileType, metrics);
		exporter.writeExporter(metrics, outputFilePath);
	}
}
