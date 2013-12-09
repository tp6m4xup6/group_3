import java.io.IOException;

public class LnOS {

	public static void main(String[] args) throws IOException {

		PatternReadCSV factoryCSV = new PatternReadCSV();
		
		@SuppressWarnings("unused")
		DataCSV csv = factoryCSV.getCSVData("test.csv");

		boolean wait_download = true;

		while (wait_download) {
			try {

				// open HIV opendata download page and save url to html
				String webUrl = "http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS";
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

	} // end of main()

} // end of class LnOS
