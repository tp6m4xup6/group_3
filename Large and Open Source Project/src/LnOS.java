import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LnOS {

	public static void main(String[] args) {

		//TODO command line argument for input .csv file path
		
		ArrayList<ArrayList<String>> CSVdata = null;
		
		try {
			CSVdata = readCSV("C:\\Users\\OEG\\Desktop\\test.CSV");
			printCSV(CSVdata);
		} catch (IOException e) {
			System.err.println("Read .csv file error!");
			e.printStackTrace();
		}
	}

	/**
	 * Read data from input .csv file.
	 * 
	 * @author OEG
	 * @param path
	 *            - Path of input .csv file
	 * @return ArrayList that contain data in .csv file
	 * @throws IOException
	 *             - If an I/O error occurs
	 */
	public static ArrayList<ArrayList<String>> readCSV(String path)
			throws IOException {

		// Store all data in csv file
		ArrayList<ArrayList<String>> allData = new ArrayList<ArrayList<String>>();

		BufferedReader rd = new BufferedReader(new FileReader(path));

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

			allData.add(lineData);
		}

		rd.close();

		return allData;
	} // end of readCSV()

	/**
	 * Print all data in .csv file.
	 * 
	 * @author OEG
	 * @param dataCSV
	 *            - ArrayList that contain data in .csv file
	 */
	public static void printCSV(ArrayList<ArrayList<String>> dataCSV) {

		if(checkCSV(dataCSV) == false){
			System.out.println("CSV data not available!");
			return;
		}
		
		for (int i = 0; i < dataCSV.size(); i++) {
			ArrayList<String> lineData = dataCSV.get(i);

			for (int j = 0; j < lineData.size(); j++) {
				System.out.println(lineData.get(j));
			}
		}
	} // end of printCSV()

	/**
	 * Check .csv data is available or not.
	 * 
	 * @author OEG
	 * @param dataCSV
	 *            - ArrayList that contain data in .csv file
	 * @return true - CSV data is available <br/>
	 *         false - CSV data is not available
	 */
	public static boolean checkCSV(ArrayList<ArrayList<String>> dataCSV) {
		if (dataCSV == null || dataCSV.isEmpty()) {
			return false;
		} else {
			return true;
		}
	} // end of checkCSV()

} // end of LnOS
