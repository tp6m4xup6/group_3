import java.io.IOException;

public class LnOS {

	public static void main(String[] args) {

		PatternDownload factoryDownload = new PatternDownload();
<<<<<<< HEAD

		try {
			factoryDownload.getDownload("http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS");
		} catch (IOException e1) {
			System.err.println("Download file error!");
			e1.printStackTrace();
=======
		PatternGraphDrawing factoryGraph = new PatternGraphDrawing(); 
		
/*		
		@SuppressWarnings("unused")
		DataCSV csv = factoryCSV.getCSVData("test.csv");
		
		Download path -> Large and Open Source Project\CSV
		factoryDownload.getDownload("http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS");
		System.out.println("run success");
*/		
		
		//draw image
		factoryGraph.drawGraph();

		
	//	The way to upload hiv.csv to database	
	/*  
		boolean hiv_sucess= DBconnect.Hiv_upload("hiv.csv");
	*/
		
		
	//	The way to read hivinfo table 
		/*		
		ArrayList<ArrayList<String>>  dataHiv=new ArrayList<ArrayList<String>>();
		dataHiv=DBconnect.getHivSQL();
		
		for(int i=0;i<dataHiv.size();i++){
			System.out.print(dataHiv.get(i).get(0).toString()+" ");
			System.out.print(dataHiv.get(i).get(1).toString()+" ");
			System.out.print(dataHiv.get(i).get(2).toString()+" ");
			System.out.print(dataHiv.get(i).get(3).toString()+" ");
			System.out.println(dataHiv.get(i).get(4).toString());
>>>>>>> origin/Image2
		}
		System.out.println("download success");

		UnZIP.unZip("CSV/hiv.zip", "CSV/new/");

		if(CheckUpdate.hasUpdate("CSV/origin/", "CSV/new/")){
			System.out.println("Data updated!");
		}else {
			System.out.println("Data no update");
		}

		try {
			GraphDrawing.drawImage();
		} catch (IOException e1) {
			System.err.println("Draw image error!");
			e1.printStackTrace();
		}

		Mail mail = new Mail("oeg8168@hotmail.com.tw");
		mail.InitialSet();
		try {
			mail.Msg();
		} catch (Exception e) {
			e.printStackTrace();
		}

	} // end of main()
} // end of class LnOS
