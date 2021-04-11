package gradeshistogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author marlenachatzigrigoriou  The purpose of this class is to demonstrate a simple
 *         scenario of a JFreeChart XYLine chart.
 * @since March 2021
 */
public class HistogramGenerator {

	/***
	 * Receives a single dimension Integer Array. From this Array the dataset
	 * that will be used for the visualization is generated. Finally, the chart
	 * is generated with the use of the aforementioned dataset and then
	 * presented in the screen.
	 * 
	 * @author agkortzis - marlenachatzigrigoriou
	 * @param freq Single dimension integer Array
	 */
	public void generateChart(int [] freq ) {
		/*
		 * The XYSeriesCollection object is a set XYSeries series (dataset) that
		 * can be visualized in the same chart
		 */
		XYSeriesCollection dataset = new XYSeriesCollection();
		/*
		 * The XYSeries that are loaded in the dataset. There might be many
		 * series in one dataset.
		 */
		XYSeries data = new XYSeries("random"); 
		/*
		 * Populating the XYSeries data object from the input Integer array
		 * values.
		 */

		for (int i = 0; i < freq.length; i++) {
			data.add(i, freq[i]);
		}

		// add the series to the dataset
		dataset.addSeries(data);

		boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		// Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Grades' Histogram", "grades", "frequency", dataset, 
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		/*
		 * Initialize a frame for visualizing the chart and attach the
		 * previously created chart.
		 */
		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();
		// makes the previously created frame visible
		frame.setVisible(true);
	}
	
	/***
	 * Receives comand's line arguments, in this case a .txt file. The file is turned into
	 * an Integer Array. Finally, it returns the array.
	 * 
	 * @param args Single dimension String Array
	 */
	public static int [] fileToArray(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();

		try {
			/*
			 * Reads all lines from the .txt file.
			 */
			List<String> allLines = Files.readAllLines(Paths.get(args[0]));
			/*
			 * Each line, which contains a number, is casted into Integer
			 * and is added in the ArrayList.
			 */
			for (String line : allLines) {
			    list.add(Integer.parseInt(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Convert ArrayList to Array
		 */
		int [] array = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	public static void main(String[] args) throws Exception {
		
		// args: the input values
		int [] dataValues = fileToArray(args);
	
		int [] freq = new int[11];	
		for (int i = 0; i < dataValues.length; i++) {
			freq[dataValues[i]] += 1;
		}

		HistogramGenerator demo = new HistogramGenerator();
		demo.generateChart(freq);	
	}

}
