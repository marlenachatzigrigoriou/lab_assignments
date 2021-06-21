package metricsexporter;

import java.util.Map;

/**
 * Fails to exports (writes) the metrics to a given output.
 * @author marlenachatzigrigoriou
 *
 */
public class MetricsExporterNull implements MetricsExporter {

	/**
	 * Aborts the export of the metrics to a given 
	 * output file (filepath) of type CSV or JSON.
	 * @param filepath the url of the file
	 * @param metrics a list of LOC, NOM, NOC numbers
	 *
	 */
	@Override
	public void writeExporter(Map<String, Integer> metrics, String filepath) {
		System.err.println("Operation aborted due to unknown output file type.");
	}
	
}