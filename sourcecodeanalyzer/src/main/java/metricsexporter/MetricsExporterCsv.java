package metricsexporter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Exports (writes) the metrics to CSV file.
 * @author marlenachatzigrigoriou
 *
 */
public class MetricsExporterCsv implements MetricsExporter{
	
	/**
	 * Writes the metrics to a given output file (filepath) of type CSV.
	 * @param filepath the url of the file
	 * @param metrics a list of LOC, NOM, NOC numbers
	 *
	 */
	@Override
	public void writeExporter(Map<String, Integer> metrics, String filepath) {
		File outputFile = new File(filepath + ".csv");
		StringBuilder metricsNames = new StringBuilder();
		StringBuilder metricsValues = new StringBuilder();
		
		for (Map.Entry<String, Integer> entry : metrics.entrySet()) {
			metricsNames.append(entry.getKey() + ",");
			metricsValues.append(entry.getValue()+",");
		}
		try {
			FileWriter writer = new FileWriter(outputFile);
			writer.append(metricsNames + "\n");
			writer.append(metricsValues + "\n");
			writer.close();
			System.out.println("Metrics saved in " + outputFile.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}