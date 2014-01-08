import java.io.IOException;
import java.util.*;


public class LnOS {

	public static void main(String[] args) throws IOException {

		System.out.println(CheckSameFile.isSame("C:\\Users\\OEG\\Desktop\\LnOS_group3.zip", "C:\\Users\\OEG\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src\\hiv.zip"));

		Mail testMail = new Mail("oeg8168@hotmail.com.tw");
		testMail.InitialSet();
		try {
			testMail.Msg();
		} catch (Exception e) {
			// TODO: handle exception
		}

		PatternReadCSV factoryCSV = new PatternReadCSV();
<<<<<<< HEAD

=======
		PatternDownload factoryDownload = new PatternDownload();
		
/*		
>>>>>>> origin/12/26-Data-Base-connect
		@SuppressWarnings("unused")
		DataCSV csv = factoryCSV.getCSVData("test.csv");
		
		Download path -> Large and Open Source Project\CSV
		factoryDownload.getDownload("http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS");
		System.out.println("run success");
<<<<<<< HEAD
		/*
		 * boolean wait_download = true;
		 * 
		 * while (wait_download) { try {
		 * 
		 * // open HIV opendata download page and save url to html String webUrl
		 * = "http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS"; String
		 * html = FileDownload.getWebHtml(webUrl);
		 * System.out.println("download page html=" + html);
		 * 
		 * // catch the download url (ex:http:\\xXXXX.download) String
		 * download_url = FileDownload.pregUrl(html);
		 * 
		 * System.out.println("download url=" + download_url);
		 * 
		 * FileDownload.loadUrlFile(download_url, "src", "hiv.zip");
		 * 
		 * wait_download = false; } catch (NullPointerException e) {
		 * System.out.println("\nThe connection went wrong! Try again!"); } }
		 */

=======
*/		
		
		
		GraphDrawing.drawImage();
		
		
		
		
	//	The way to upload hiv.csv to database	
	/*  
		boolean hiv_sucess= DBconnect.Hiv_upload("hiv.csv");
	*/
		
		
	//	The way to read hivinfo table 
<<<<<<< HEAD
		
=======
		/*		
>>>>>>> origin/Image
		ArrayList<ArrayList<String>>  dataHiv=new ArrayList<ArrayList<String>>();
		dataHiv=DBconnect.getHivSQL();
		
		for(int i=0;i<dataHiv.size();i++){
			System.out.print(dataHiv.get(i).get(0).toString()+" ");
			System.out.print(dataHiv.get(i).get(1).toString()+" ");
			System.out.print(dataHiv.get(i).get(2).toString()+" ");
			System.out.print(dataHiv.get(i).get(3).toString()+" ");
			System.out.println(dataHiv.get(i).get(4).toString());
		}
	
		
	//	The way to read borninfo table 
		
	/*	
		boolean born_sucess= DBconnect.Born_upload("born.csv");
	*/
		
/*	
		ArrayList<ArrayList<String>>  dataBorn=new ArrayList<ArrayList<String>>();
		dataBorn=DBconnect.getBornSQL();
		
		for(int i=0;i<dataBorn.size();i++){
			System.out.print(dataBorn.get(i).get(0).toString()+" ");
			System.out.print(dataBorn.get(i).get(1).toString()+" ");
			System.out.print(dataBorn.get(i).get(2).toString()+" ");
			System.out.print(dataBorn.get(i).get(3).toString()+" ");
			System.out.print(dataBorn.get(i).get(4).toString()+" ");
			System.out.print(dataBorn.get(i).get(5).toString()+" ");
			System.out.println(dataBorn.get(i).get(6).toString());
		}
*/	
		
>>>>>>> origin/12/26-Data-Base-connect
	} // end of main()

} // end of class LnOS
