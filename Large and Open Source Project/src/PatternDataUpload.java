
public class PatternDataUpload {

	/**
	 * @author tp6m4xup6
	 * @param DBconnect
	 * @return no return
	 */
	public boolean DataUpload() {

		DBconnect.Hiv_upload("hiv.csv");
		DBconnect.Born_upload("born.csv");

		return true;

	} // end of getCSVData()

} // end of class PatternReadCSV
