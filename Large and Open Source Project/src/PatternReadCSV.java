import java.io.IOException;

/**
 * A factory that will generate DataCSV
 * @author OEG
 */

public class PatternReadCSV {

	/**
	 * A function that get CSV data from input file
	 * 
	 * @author OEG
	 * @param path
	 *            - input .csv file path
	 * @return csv data from input file
	 */
	public DataCSV getCSVData(String path) {
		DataCSV temp = new DataCSV(path);

		try {
			temp.readCSV();
		} catch (IOException e) {
			System.err.println("Read .csv file error!");
			e.printStackTrace();
		}

		if (temp.checkCSV())
			return temp;
		else
			return null;
	} // end of getCSVData()

} // end of class PatternReadCSV
