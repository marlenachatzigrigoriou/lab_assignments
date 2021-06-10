package demo;

import java.io.IOException;
import facade.Facade;

/**
 * Demo class for the execution of source code analysis.
 * @author marlenachatzigrigoriou, agkortzis
 *
 */
public class DemoClient {
	
	public static void main(String[] args) throws IOException {
		String filepath = "src/main/resources/TestClass.java";
		String sourceCodeAnalyzerType = "regex";
		String fileReaderType = "local";
		String outputFilePath = "output_metrics";
		String outputFileType = "csv";
		
		if(args.length == 5) {
			filepath = args[0];
			sourceCodeAnalyzerType = args[1];
			fileReaderType = args[2];
			outputFilePath = args[3];
			outputFileType = args[4];
			
			Facade facade = new Facade();
			facade.analyzer(sourceCodeAnalyzerType, fileReaderType, filepath, outputFileType, outputFilePath);
		
		} else if (args.length != 0) {
			System.out.println("Incorrect number of arguments.");
		}
		

	}
}
