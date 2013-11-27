import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class fileDownload {
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
	
    public static String loadUrlFile(String urlPath,String savePath,String fileName) throws IOException{
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
}
