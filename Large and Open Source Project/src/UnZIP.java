import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 * 
 * @author OEG
 * 
 */
public class UnZIP {

	public static void unZip(String source, String destination) {
		try {
			ZipFile zipFile = new ZipFile(source);
			if (zipFile.isEncrypted()) {
				System.err.println("Need Password!");
			}
			zipFile.extractAll(destination);
		} catch (ZipException e) {
			System.err.println("UnZip file error");
			e.printStackTrace();
		}
	} // end of unZip()

} // end of class UnZIP
