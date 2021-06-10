package metricsexporter;

import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

public class NullMetricsExporterTest {
	
	@Test
	public void testWriteNull() {
		MetricsExporterNull mockedExporter = mock(MetricsExporterNull.class);
		
		Map<String, Integer> metrics = new HashMap<>();
		metrics.put("loc",30);
		metrics.put("nom",5);
		metrics.put("noc",2);
		String outputFilepath = null;
		
		doCallRealMethod().when(mockedExporter).writeExporter( metrics, outputFilepath);
		mockedExporter.writeExporter(metrics, outputFilepath);
		verify(mockedExporter).writeExporter(metrics, outputFilepath);
	}
}
