package metricsexporter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class MetricsExporterFactoryTest {
	
	MetricsExporterFactory mexfac = new MetricsExporterFactory();
	
	@Test
	public void testCreateExporterCsv() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFileType = "csv";
		MetricsExporter f = mexfac.createExporter(outputFileType, metrics);
		Assert.assertTrue(f instanceof MetricsExporterCsv);
	}
	
	@Test
	public void testCreateExporterJson() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFileType = "json";
		MetricsExporter f = mexfac.createExporter(outputFileType, metrics);
		Assert.assertTrue(f instanceof MetricsExporterJson);
	}
	
	@Test
	public void testCreateExporterNull() {
		// create the metrics content
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		
		// generate and write the output file
		String outputFileType = "not-implemented-type";
		MetricsExporter f = mexfac.createExporter(outputFileType, metrics);
		Assert.assertTrue(f instanceof MetricsExporterNull);
	}
	
}