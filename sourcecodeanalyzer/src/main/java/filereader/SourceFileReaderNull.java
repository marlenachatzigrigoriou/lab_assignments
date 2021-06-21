package filereader;

import java.io.IOException;
import java.util.List;

/**
 * Fails to retrieve (read) the contents of a given file.
 * The file is not stred in a known location.
 * @author marlenachatzigrigoriou
 *
 */
public class SourceFileReaderNull implements SourceFileReader{
	
	/**
	 * Aborts the reading of the file, due to 
	 * unknown source file reader.
	 * @param filepath the url of the file
	 * @return null if the type is neither <b>local</b> nor <b>web</b>
	 */
	@Override
	public List<String> readFileIntoList(String filepath) throws IOException {
		System.err.println("Operation aborted due to unknown source file reader.");
		return null;
	}

	/**
	 * Aborts the reading of the file, due to 
	 * unknown source file reader.  
	 * @param filepath the url of the file
	 * @return or null if the type is neither <b>local</b> nor <b>web</b>
	 */
	@Override
	public String readFileIntoString(String filepath) throws IOException {
		System.err.println("Operation aborted due to unknown source file reader.");
		return null;
	}
	
}