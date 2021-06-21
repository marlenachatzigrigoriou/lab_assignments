package metricsexporter;

import java.util.Map;

/**
 * The factory of MetricsExporter class, that generates
 * MetricsExporter objects.
 * @author marlenachatzigrigoriou
 *
 */
public class MetricsExporterFactory {

	/**
	 * Object of class MetricsExporter representing
	 * how the metrics will be exported (csv or json types).
	 *
	 */
	private MetricsExporter exporter;

	/**
	 * Generates MetricsExporter objects, depending on 
	 * the defined outputFileType.
	 * @param metrics a list of LOC, NOM, NOC numbers
	 * @param outputFileType the type (.csv, .json) of the file that contains the metrics
	 * @return a MetricsExporter object, csv, json or null
	 */
	public MetricsExporter createExporter(String outputFileType, Map<String, Integer> metrics) {
		if (outputFileType.equals("csv")) {
			exporter = new MetricsExporterCsv();
		} else if (outputFileType.equals("json")) {
			exporter = new MetricsExporterJson();
		} else {
			exporter = new MetricsExporterNull();
		}
		return exporter;
	}
}