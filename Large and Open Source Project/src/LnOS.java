import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.*;
import java.io.IOException;
import java.util.*;
import java.net.*;
import java.util.regex.*;

public class LnOS {

	public static void main(String[] args) throws IOException {
		
		
		System.out.println("Hello world\n");
		
		boolean wait_download=true;
		
		while(wait_download){
			try{
		
				//open HIV opendata download page and save html to tml
				String webUrl="http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS";
				String html=fileDownload.getWebHtml(webUrl);
				System.out.println("download pagehtml="+html);
		
				//catch the download url (ex:http:\\xXXXX.download)
				String download_url = fileDownload.pregUrl(html);
				System.out.println("download url="+download_url);		
				fileDownload.loadUrlFile(download_url,"C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src","hiv.zip");
				wait_download=false;
			}
			catch(NullPointerException e){		
				System.out.println("\nThe connect has some Wromng! try again !");
			}
		}	
		
	}	
	
}
