import java.io.IOException;
import java.util.*;


public class LnOS {

	public static void main(String[] args) throws IOException {

		PatternReadCSV factoryCSV = new PatternReadCSV();
		PatternDownload factoryDownload = new PatternDownload();
		
/*		
		@SuppressWarnings("unused")
		DataCSV csv = factoryCSV.getCSVData("test.csv");
		
		Download path -> Large and Open Source Project\CSV
		factoryDownload.getDownload("http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS");
		System.out.println("run success");
*/		
		
		
		
		
		
		
		
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
		}
	*/
		
	//	The way to read borninfo table 
		
	/*	
		boolean born_sucess= DBconnect.Born_upload("born.csv");
	*/
		
	
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
	
		
	} // end of main()

} // end of class LnOS
