package metricsexporter;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given JSON file.
 * @author marlenachatzigrigoriou
 *
 */
public class MetricsExporterJson implements MetricsExporter {
	
	/**
	 * Writes the metrics to a given output file (filepath) of type JSON.
	 * @param filepath the url of the file
	 * @param metrics a list of LOC, NOM, NOC numbers
	 *
	 */
	@Override
	public void writeExporter(Map<String, Integer> metrics, String filepath) {
			// Functionality not implemented yet
	}
}