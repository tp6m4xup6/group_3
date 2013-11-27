import java.io.IOException;

public class LnOS {

	public static void main(String[] args) {

		// TODO command line argument for input .csv file path

		DataCSV csv = new DataCSV("C:\\Users\\OEG\\Desktop\\test.CSV");

		try {
			csv.readCSV();
			csv.printCSV();
		} catch (IOException e) {
			System.err.println("Read .csv file error!");
			e.printStackTrace();
		}
	} // end of main()

} // end of class LnOS
