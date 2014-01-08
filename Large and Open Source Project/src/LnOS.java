import java.io.File;
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

		File originFile = new File("CSV/origin/");
		File newFile = new File("CSV/new/");

		if (!originFile.exists()) {
			originFile.mkdir();
		} else if (originFile.list().length == 0) {
			originFile.delete();
			newFile.renameTo(originFile);
			newFile.mkdir();
		} else {
			for (int i = 0; i < originFile.list().length; i++) {
				if (!CheckSameFile.isSame(originFile.list()[i], newFile.list()[i]))
					System.out.println("!!!!!!");
			}
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
