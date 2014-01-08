import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Object will store one .csv data
 * 
 * @author OEG
 */
public class DataCSV {

	// .csv file path
	private String filePath;

	// ArrayList to store all data in csv file
	public ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

	/**
	 * Constructor of DataCSV
	 * 
	 * @author OEG
	 * @param path
	 *            - Path of input .csv file
	 */
	public DataCSV(String path) {
		this.filePath = path;
	}

	/**
	 * Read data from input .csv file.
	 * 
	 * @author OEG
	 * @throws IOException
	 *             - If an I/O error occurs
	 */
	public void readCSV() throws IOException {

		// BufferedReader rd = new BufferedReader(new
		// FileReader(this.filePath));
		InputStreamReader isr = new InputStreamReader(new FileInputStream(this.filePath), "UTF-8");
		BufferedReader rd = new BufferedReader(isr);
		// String to store data of single line temporarily
		String line = null;

		while ((line = rd.readLine()) != null) {

			// Store data of single line in csv file
			ArrayList<String> lineData = new ArrayList<String>();

			String item[] = line.split(",");

			// Add each item to lineData
			for (int i = 0; i < item.length; i++) {
				lineData.add(i, item[i]);
			}

			this.data.add(lineData);
		}

		rd.close();
	} // end of readCSV()

	/**
	 * Print all data in .csv file.
	 * 
	 * @author OEG
	 * @return true - Print CSV data success <br/>
	 *         false - Print CSV data fail
	 */
	public boolean printCSV() {

		if (checkCSV() == false) {
			System.out.println("CSV data not available!");
			return false;
		}

		for (int i = 0; i < this.data.size(); i++) {
			ArrayList<String> lineData = this.data.get(i);

			for (int j = 0; j < lineData.size(); j++) {
				System.out.println(lineData.get(j));
			}
		}

		return true;
	} // end of printCSV()

	/**
	 * Check .csv data is available or not.
	 * 
	 * @author OEG
	 * @return true - CSV data is available <br/>
	 *         false - CSV data is not available
	 */
	public boolean checkCSV() {
		if (this.data == null || this.data.isEmpty()) {
			return false;
		} else {
			return true;
		}
	} // end of checkCSV()

} // end of class DataCSV
