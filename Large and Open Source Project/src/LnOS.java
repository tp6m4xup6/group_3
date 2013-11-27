import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;

import java.util.*;
import java.net.*;
import java.util.regex.*;


public class LnOS {

	public static void main(String[] args) {
		
		
		System.out.println("Hello world\n");
		System.out.println("Test open CSV\n");
<<<<<<< HEAD

		String csvpath = "C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src\\hiv.csv";

		DataCSV csv = new DataCSV("C:\\Users\\OEG\\Desktop\\test.CSV");
=======
	
>>>>>>> origin/昱霖-test
		
		//open HIV opendata download page and save html to tml
		String webUrl="http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS";
		String html=fileDownload.getWebHtml(webUrl);
		System.out.println("download pagehtml="+html);
		
		//catch the download url (ex:http:\\xXXXX.download)
		String download_url = fileDownload.pregUrl(html);
		System.out.println("download url="+download_url);
		

		
<<<<<<< HEAD
		loadUrlFile(download_url,"C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src","hiv.zip");
		
	}
	
	/*
	 * catch the html from webUrl
	 * webUrl:the homepage url from download page 
	 */
	
	public static String getWebHtml(String webUrl){
		 System.out.println("Reading Web-");
		
		 URL u = null;
		 InputStream in = null;
		 InputStreamReader r = null;
		 BufferedReader br = null;
		 String message = null;
		 String html = null;
	
		 
		 List<String> data = new ArrayList<String>();

		 try {
		    u = new URL(webUrl);
		    in = u.openStream();
		    r = new InputStreamReader(in, "UTF-8");
		    br = new BufferedReader(r);	    
		    
		    while ((message = br.readLine()) != null) {
		    	html=html+message;
		    	//System.out.println(message);
		    }
		    //System.out.println(html);
		    
		 } catch (Exception e) {
		    e.getStackTrace();
		    System.out.println(e.getMessage());
		 } finally {
		    try {
		       u = null;
		       in.close();
		       r.close();
		       br.close();
		    } catch (Exception e) {

		    }
		 }
 
		 System.out.println("----Read finisded");
		 return html; 
	}
	
	
	/*
	 * use RE to get the download URL from htmlText
	 * htmlText: the download page's html
	 */
	
	public static String pregUrl(String htmlText){
		System.out.println("Start pregUrl------");		
		String temp=null;
		
		Pattern pattern = Pattern.compile("<a href=\"([^>]+)\">CSV");
		String testString = htmlText;	
	
		Matcher matcher = pattern.matcher(testString);
		
		while (matcher.find()) {			
			temp=matcher.group();			//Filter the <a fref="XXX"><CSV
			temp=temp.replace("<a href=\"","");
			temp=temp.replace("\">CSV","");
		}
		
		System.out.println("------pregUrl down");	
		
		return temp;
	}
	
	
	/**
	 * download file from urlPath
	 * savaParh:the download file saved site 
	 * fileName:the download file named
	 */
	
    public static String loadUrlFile(String urlPath,String savePath,String fileName){
        String msg = "";
       
        System.out.println("stat download--->"+urlPath);

        try{
            URL zeroFile=new URL(urlPath);
            String name=zeroFile.getFile();

            InputStream is = zeroFile.openStream();

            String tmpName = name.substring(name.lastIndexOf("."), name.length());//get sub filename
            msg = fileName+tmpName;			//filename
            BufferedInputStream bs=new BufferedInputStream(is);
            byte[] b=new byte[1048576];		//catch 1048576  bytes
            FileOutputStream fs=new FileOutputStream(savePath + "/" + ((fileName.indexOf(".") == -1) ? msg : fileName));
            int len;
            while((len=bs.read(b,0,b.length))!=-1){
                fs.write(b,0,len);
            }
            System.out.println("done====>");
            bs.close();
            fs.close();
        }catch(IOException e){
            e.printStackTrace();
            System.out.println("error when reading file");
            msg = "error";
        }
        return msg;
    }
=======
		fileDownload.loadUrlFile(download_url,"C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src","hiv.zip");
>>>>>>> origin/昱霖-test
		
	}	
	
}
