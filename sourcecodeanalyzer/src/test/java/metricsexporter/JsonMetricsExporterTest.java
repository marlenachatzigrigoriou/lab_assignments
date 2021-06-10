package metricsexporter;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.doCallRealMethod;

public class JsonMetricsExporterTest {
	
	@Test
	public void testWriteJson() {
		MetricsExporterJson mockedExporter = mock(MetricsExporterJson.class);
		// create an empty metrics content
		Map<String, Integer> metrics = new HashMap<>();
		String outputFilepath = "whatever-path";
		
		//this is a demo of how a mocked object can call a real method (partial mocking)
		doCallRealMethod().when(mockedExporter).writeExporter( metrics, outputFilepath);
		mockedExporter.writeExporter(metrics, outputFilepath);
		//just verify that the method was executed/called
		verify(mockedExporter).writeExporter(metrics, outputFilepath);
	}
}
