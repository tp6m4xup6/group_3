import java.io.IOException;

/**
 * A factory that will generate DataCSV
 * @author OEG
 */

public class PatternDownload {

	/**
	 * dO
	 * 
	 * @author tp6m4xup6
	 * @param FileDownPattern
	 *           
	 * @return no return (download file from world bank website)
	 * @throws IOException 
	 */
	public boolean getDownload(String path) throws IOException {

		boolean wait_download = true;

		
		while (wait_download) {
			try {
				// open HIV opendata download page and save url to html
				String webUrl = path;
				String html = FileDownload.getWebHtml(webUrl);
				System.out.println("download page html=" + html);

				// catch the download url (ex:http:\\xXXXX.download)
				String download_url = FileDownload.pregUrl(html);

				System.out.println("download url=" + download_url);

				FileDownload.loadUrlFile(download_url, "CSV", "hiv.zip");

				wait_download = false;
			} catch (NullPointerException e) {
				System.out.println("\nThe connection went wrong! Try again!");
			}
		}
		
		if(wait_download==true){
			return false;
		}
		else{ 
			return true;
		}
	} // end of getCSVData()

} // end of class PatternReadCSV
