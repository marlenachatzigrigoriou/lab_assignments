# Lab assignment #4
A java project that reads a Java source 
code file that is stored locally or on the web, calculates the Lines of Code (LOC), Number of Classes (NOC) and Number of Methods (NOM) metrics, 
and finally, exports these metrics to an output file.


## Class diagram of the redesigned system:

<p align="center">
  <img alt="Class diagram" src="">
</p>

## SOLID design principles application report:

First, I applied the <b>Strategy Pattern</b> in MetricsExporter class creating 2 classes (MetricsExporterJson, MetricsExporterCsv) which 
implement the interface MetricsExporter. The functionality of writeExporter moved to DemoClient as a new function.
Then, i applied Strategy in SourceFileReader and SourceCodeAnalyzer, creating SourceFileReaderWeb and SourceFileReaderLocal, and 
SourceCodeAnalyzerNOM, SourceCodeAnalyzerNOC and SourceCodeAnalyzerLOC, accordingly. In this way, SourceFileReader's execution stays in 
SourceCodeAnalyzer, while SourceCodeAnalyzer execution in DemoClient's main method, turns into a new function in DemoClient.
As it concerns SourceCodeAnalyzer, due to the many repetitions of constructor's code, I changed the interface into an abstract class,
in order to reduce the repetitions by inheritance.
Applying <b>Strategy</b> Pattern, reduces the complexity of the system (by "isolating" the functionality and the different cases in the implementations) and improves cohesion. 
But, still, DemoClient is highly coupled to implementations, the implementations are neither interchangeable nor extensible in DemoClient.

Secondly, I applied the <b>Null Object Pattern</b>. I added all the null classes, in order to catch invalid/null type cases, beginning from SourceCodeAnalyzer and MetricsExporter (in this way DemoClient is not throwing exceptions). Last, to the SourceFileReader, but in this interface implementations, as we override the methods, they should return something not valid(-assumed as not valid) and at the same time String, so returning null was the only option. But this would throw exceptions when running, so I had to try-catch them. The SourceFileReader has no implementation in the DemoClient, but in the SourceCodeAnalyzer, so I had to catch them in the implementations of this interface (SourceCodeAnalyzer). Also, I restricted the execution of writeExporter function when this error (of file location) happens in the DemoClient.
Applying <b>Null Object</b> Pattern, removes the responsibility of DemoClient handling null cases and simplifies its code, but complicates testing.

The next step was to apply the <b>Factory Pattern</b> in all the 3 classes (SourceCodeAnalyzer, MetricsExporter, SourceFileReader). In this way, the instantiating methods of the corresponding objects are moved to 3 separate factory classes, one for each of the 3 already mentioned. 
Applying <b>Factory</b> Pattern, sets the DemoClient with less concerns and adds to the flexibility of SourceCodeAnalyzer, MetricsExporter and SourceFileReader.

Next, I adjusted the existing tests and created the ones that have occured after the application of the above patterns. 
Moreover, I packaged all the different parts (dimensions) of the analysis of source code, in both src/main and src/test in different packages.

Then, I applied the <b>Bridge Pattern</b> in codeanalyzer's classes. There are 2 dimensions, the type of metric (LOC, NOM, NOC) and the type of analyzer (regex, strcomp or null). The SourceCodeAnalyzer class remained abstract and extended by SourceCodeAnalyzerLOC, SourceCodeAnalyzerNOC, SourceCodeAnalyzerNOM, but the different executions (of the metrics calculation) due to the different analyzer types move to the 3 new implementations of SourceCodeAnalyzerType interface. The factory of SourceCodeAnalyzer becomes the management class for this pattern. 
In this way, adding new types of SourceCodeAnalyzerType does not affect the SourceCodeAnalyzer, and conversely. Dimensions can vary independently and each class has a single responsibility. 
I also tried to apply Bridge in filereader's classes, as -again- there are 2 dimensions, the location of file (web, local, null) and the output type (String or ArrayList), but the output depends on the choice of analyzer type (which is out of the scope of the particular class), plus, the fact that the method in the abstract class should represent both sides of one dimension, which is not possible as the return types are different (String, ArrayList). So, i didn't applied Bridge in filereader package. 
I didn't applied Bridge in metricsexporter package, too, as there is only one dimension.

Last, I applied the <b>Façade Pattern</b> in the whole system and moved all the functions from DemoClient, except for main, in the Façade class. DemoClient is clean and calls only the Façade, which connects with metricsexporter and codeanalyzer and "does the job".

Furthermore, I readjusted all the tests, and created the remaining ones.



## How to run the project:

1. Build the executable Java application with: 

		mvn package jacoco:report

2. Run the executable by executing

		java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
	were args translate to: 	

		arg0 = “JavaSourceCodeInputFile” (e.g., src/test/resources/TestClass.java)
		arg1 = “sourceCodeAnalyzerType” [regex|strcomp]
		arg2 = “SourceCodeLocationType” [local|web]
		arg3 = “OutputFilePath” (e.g., ../output_metrics_file)
		arg4 = “OutputFileType” [csv|json]
	example: 

		java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv