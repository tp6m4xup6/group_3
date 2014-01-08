import java.io.IOException;

public class LnOS {

	public static void main(String[] args) {

		PatternDownload factoryDownload = new PatternDownload();

		try {
			factoryDownload.getDownload("http://data.worldbank.org.cn/indicator/SH.HIV.1524.MA.ZS");
		} catch (IOException e1) {
			System.err.println("Download file error!");
			e1.printStackTrace();
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
