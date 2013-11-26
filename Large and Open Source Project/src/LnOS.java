import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LnOS {

	public static void main(String[] args){

		try {
			readCSV("C:\\Users\\OEG\\Desktop\\test.CSV");
		} catch (IOException e) {

			System.err.println("Read .csv file error!");
			e.printStackTrace();
		}
		
	}

	/**
	 * @author OEG
	 * 
	 * @param path
	 *            - Path of input .csv file
	 * 
	 * @return ArrayList that contain data in .csv file
	 * 
	 * @throws IOException
	 *             - If an I/O error occurs
	 * 
	 * 
	 */
	@SuppressWarnings("rawtypes")
	public static ArrayList<ArrayList> readCSV(String path) throws IOException {

		// Store all data in csv file
		ArrayList<ArrayList> allData = new ArrayList<ArrayList>();

		BufferedReader rd = new BufferedReader(new FileReader(path));
		
		// String to store data of single line temporarily
		String line = null;

		while ((line = rd.readLine()) != null) {

			// Store data of single line in csv file
			ArrayList<String> lineData = new ArrayList<String>();
			
			String item[] = line.split(",");
			
			// Add each item to lineData
			for(int i=0; i<item.length; i++){            
                lineData.add(i, item[i]);
            }
			
			allData.add(lineData);
		}

		rd.close();

		return allData;
	}	//end of readCSV()

}	//end of LnOS
