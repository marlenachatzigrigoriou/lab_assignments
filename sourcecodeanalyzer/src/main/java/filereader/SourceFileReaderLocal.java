package filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Retrieves (reads) the contents of a given file.
 * The file is stored locally.
 * @author marlenachatzigrigoriou
 *
 */
public class SourceFileReaderLocal implements SourceFileReader{

	/**
	 * Reads a file and returns its content in a List
	 * @param filepath the location of the file
	 * @return a List that contains the contents of the file 
	 * @throws IOException
	 */
	
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		List<String> lines = new ArrayList<>();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}
		reader.close();
		return lines;
	}
	
	/**
	 * Reads a file and returns its content in a single String
	 * @param filepath the location of the file
	 * @return a String that contains the contents of the file
	 * @throws IOException
	 */
	
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		StringBuilder sb = new StringBuilder();
		File file = new File(filepath);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = null;
		while ((line = reader.readLine()) != null) {
			sb.append(line + "\n");
		}
		reader.close();
		return sb.toString();
		
	}

}
    