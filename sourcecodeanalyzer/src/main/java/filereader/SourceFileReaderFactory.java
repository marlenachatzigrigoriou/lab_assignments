package filereader;

/**
 * The factory of SourceFileReader class, that generates
 * SourceFileReader objects.
 * @author marlenachatzigrigoriou
 *
 */
public class SourceFileReaderFactory {
	
	/**
	 * Object of class SourceFileReader representing
	 * where the file locates (web or locally).
	 *
	 */
	private SourceFileReader fileReader;
	
	/**
	 * Generates SourceFileReader objects, depending on 
	 * the defined fileReaderType.
	 * @param fileReaderType location of the file (local or web)
	 * @return a SourceFileReader object, local, web or null
	 */
	public SourceFileReader createFileReader(String fileReaderType) {
		if (fileReaderType.equals("local")) {
			fileReader = new SourceFileReaderLocal();
		} else if (fileReaderType.equals("web")) {
			fileReader = new SourceFileReaderWeb();
		} else {
			fileReader = new SourceFileReaderNull();
		}
		return fileReader;
	}

}	
	
	