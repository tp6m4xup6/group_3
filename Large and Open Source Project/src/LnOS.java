
public class LnOS {

	public static void main(String[] args) {

		System.out.println("Test open CSV\n");

		String csvpath = "C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src\\hiv.csv";

		DataCSV csv = new DataCSV("C:\\Users\\OEG\\Desktop\\test.CSV");

		// open HIV opendata download page and save url to html
		String webUrl = "http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS";
		String html = fileDownload.getWebHtml(webUrl);
		System.out.println("download page html=" + html);

		// catch the download url (ex:http:\\xXXXX.download)
		String download_url = fileDownload.pregUrl(html);
		System.out.println("download url=" + download_url);

		fileDownload
				.loadUrlFile(
						download_url,
						"C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src",
						"hiv.zip");

	}

}
