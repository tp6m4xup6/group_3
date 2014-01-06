
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.util.ArrayList;


public class DBconnect {
	
	/*
	 * upload hiv.csv to database	
	 * path: the site of hiv.csv
	 */
	
	
	public static boolean Hiv_upload(String path) {

		String Country_name,Country_code,year_2012,year_2013;
		
		System.out.println("run upload hiv.csv");
		
		//open CSV file
		PatternReadCSV factoryCSV = new PatternReadCSV();
		DataCSV csv = factoryCSV.getCSVData(path);
		
		csv.data.get(0).indexOf(0);
		System.out.println("有幾列資料:"+csv.data.size());
		System.out.println("有幾行資料:"+csv.data.get(3).size());

		
		for(int i=3;i<csv.data.size();i++){
		
			try{
				Class.forName("org.postgresql.Driver").newInstance();
		
				String url = "jdbc:postgresql://210.61.10.89:9999/Team3";
				Connection con = DriverManager.getConnection(url, "Team3", "2013postgres");
				Statement st = con.createStatement();
			
				System.out.println("有幾列資料:"+csv.data.size());

					Country_name=csv.data.get(i).get(0).toString();		
					Country_name = Country_name.substring(1,Country_name.length()-1);
					
					Country_code=csv.data.get(i).get(1).toString();
					Country_code = Country_code.substring(1,Country_code.length()-1);
					
					year_2012=csv.data.get(i).get(55).toString();
					year_2012 = year_2012.substring(1,year_2012.length()-1);
					
					year_2013=csv.data.get(i).get(56).toString();					
					year_2013 = year_2013.substring(1,year_2013.length()-1);
					
					if(Country_name.equals("")) Country_name="_";
					if(Country_code.equals("")) Country_code="_";
					if(year_2012.equals("")) year_2012="_";
					if(year_2013.equals("")) year_2013="_";

					String sql = "insert into hivinfo values ('"+(i-2)+"','_','"+Country_code+"','"+year_2012+"','"+year_2013+"');";
	
					System.out.println(sql);
					st.executeQuery(sql);
				
					st.close();
					con.close();
			}
			catch(Exception ee){
				System.out.print(ee.getMessage());
			}
		}	
		return true;
	}
	
	/*
	 * read database's table "hivinfo"  as  ArrayList<ArrayList<String>>
	 */
	
	
	public static ArrayList<ArrayList<String>> getHivSQL(){
		ArrayList<ArrayList<String>>  dataHiv=new ArrayList<ArrayList<String>>();
		
		
		try{
			Class.forName("org.postgresql.Driver").newInstance();
			String url = "jdbc:postgresql://210.61.10.89:9999/Team3";
			Connection con = DriverManager.getConnection(url, "Team3", "2013postgres");
			Statement st = con.createStatement();
		

			
			String sql = "SELECT * FROM hivinfo;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){				//add ArrayList
				ArrayList<String> temp = new ArrayList<String>();
			//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				dataHiv.add(temp);
			}
		
			st.close();
			con.close();
		}
		catch(Exception ee){
			System.out.print(ee.getMessage());
		}	 
		return dataHiv;
	}
	
	/*
	 * upload born.csv to database	
	 * path: the site of hiv.csv
	 */
	
	
	public static boolean Born_upload(String path) {

		String Country_name,Country_code,year_2010,year_2011,year_2012,year_2013;
		
		System.out.println("run upload born.csv");
		
		//open CSV file
		PatternReadCSV factoryCSV = new PatternReadCSV();
		DataCSV csv = factoryCSV.getCSVData(path);
		
		csv.data.get(0).indexOf(0);
		System.out.println("有幾列資料:"+csv.data.size());
		System.out.println("有幾行資料:"+csv.data.get(3).size());

		
		for(int i=3;i<csv.data.size();i++){
		
			try{
				Class.forName("org.postgresql.Driver").newInstance();
		
				String url = "jdbc:postgresql://210.61.10.89:9999/Team3";
				Connection con = DriverManager.getConnection(url, "Team3", "2013postgres");
	
				Statement st = con.createStatement();
			
				System.out.println("有幾列資料:"+csv.data.size());

					Country_name=csv.data.get(i).get(0).toString();		
					Country_name = Country_name.substring(1,Country_name.length()-1);
					Country_name="_";	
					
					Country_code=csv.data.get(i).get(1).toString();
					Country_code = Country_code.substring(1,Country_code.length()-1);
					
					year_2010 = csv.data.get(i).get(54).toString();
					year_2010 = year_2010.substring(1,year_2010.length()-1);
					
					year_2011 = csv.data.get(i).get(55).toString();
					year_2011 = year_2011.substring(1,year_2011.length()-1);
					
					year_2012="_";	year_2013="_";
	/*					
					year_2012 = csv.data.get(i).get(57).toString();
					year_2012 = year_2012.substring(1,year_2012.length()-1);	
					year_2013 = csv.data.get(i).get(58).toString();					
					year_2013 = year_2013.substring(1,year_2013.length()-1);
	*/				
		
					if(Country_name.equals("")) Country_name="_";
					if(Country_code.equals("")) Country_code="_";
					if(year_2010.equals("")) year_2010="_";
					if(year_2011.equals("")) year_2011="_";
					if(year_2012.equals("")) year_2012="_";
					if(year_2013.equals("")) year_2013="_";
	
					String sql = "insert into borninfo values ('"+(i-2)+"','_','"+Country_code+"','"+year_2010+"','"+year_2011+"','"+year_2012+"','"+year_2013+"');";

					System.out.println(sql);
					st.executeQuery(sql);
				
					st.close();
					con.close();
			}
			catch(Exception ee){
				System.out.print(ee.getMessage());
			}
		}	
		return true;
	}	
	
	/*
	 * read database's table "borninfo"  as  ArrayList<ArrayList<String>>
	 */
	
	
	public static ArrayList<ArrayList<String>> getBornSQL(){
		ArrayList<ArrayList<String>>  dataHiv=new ArrayList<ArrayList<String>>();
		
		
		try{
			Class.forName("org.postgresql.Driver").newInstance();
			String url = "jdbc:postgresql://210.61.10.89:9999/Team3";
			Connection con = DriverManager.getConnection(url, "Team3", "2013postgres");
			Statement st = con.createStatement();
		

			
			String sql = "SELECT * FROM borninfo;";
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()){				//add ArrayList
				ArrayList<String> temp = new ArrayList<String>();
			//	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				temp.add(rs.getString(5));
				temp.add(rs.getString(6));
				temp.add(rs.getString(7));
				dataHiv.add(temp);
			}
		
			st.close();
			con.close();
		}
		catch(Exception ee){
			System.out.print(ee.getMessage());
		}	 
		return dataHiv;
	}
	
}
