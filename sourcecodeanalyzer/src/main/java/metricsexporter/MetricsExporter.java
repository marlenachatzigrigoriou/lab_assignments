package metricsexporter;

import java.util.Map;

/**
 * Exports (writes) the metrics to a given output.
 * The output can be CSV or JSON files.
 * @author marlenachatzigrigoriou
 *
 */
public interface MetricsExporter {
	
	/**
	 * Writes the metrics to a given output file (filepath).
	 * @param filepath the url of the file
	 * @param metrics a list of LOC, NOM, NOC numbers
	 *
	 */
	public void writeExporter(Map<String, Integer> metrics, String filepath);

}
