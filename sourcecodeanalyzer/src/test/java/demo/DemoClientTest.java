package demo;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;

public class DemoClientTest {
	
	DemoClient d = new DemoClient();
	
	
	@Test
	public void testMain() throws IOException {
	    String[] args = {"./src/test/resources/TestClass.java", "regex", "local", "metrics_results", "csv"};
	    final InputStream original = System.in;
	    DemoClient.main(args);
	    System.setIn(original);
	}
	
	@Test
	public void testMainZeroArgs() throws IOException {
	    String[] args = {};
	    final InputStream original = System.in;
	    DemoClient.main(args);
	    System.setIn(original);
	}
	
	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

	@Test
	public void testMainLessArgsThanExpected() throws IOException {
	    String[] args = {"./src/test/resources/TestClass.java", "regex", "local"};
	    DemoClient.main(args);
	    
	    Assert.assertEquals("Incorrect number of arguments.", systemOutRule.getLog().trim());
	}

	
}