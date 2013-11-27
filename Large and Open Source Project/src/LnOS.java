import java.io.IOException;
import java.util.ArrayList;

public class LnOS {

	public static void main(String[] args) {

		// TODO command line argument for input .csv file path

		DataCSV csv = new DataCSV();

		ArrayList<ArrayList<String>> CSVdata = null;

		try {
			CSVdata = csv.readCSV("C:\\Users\\OEG\\Desktop\\test.CSV");
			csv.printCSV(CSVdata);
		} catch (IOException e) {
			System.err.println("Read .csv file error!");
			e.printStackTrace();
		}
	} // end of main()

} // end of class LnOS
