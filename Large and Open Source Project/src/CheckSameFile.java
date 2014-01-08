import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * @author OEG
 * 
 */
public class CheckSameFile {

	/**
	 * check two file are same or not.
	 * 
	 * @param f1
	 *            - file 1 path
	 * @param f2
	 *            - file 2 path
	 * @return boolean - two file are same or not
	 */
	public static boolean isSame(String f1, String f2) {

		return fileMD5(f1).equals(fileMD5(f2));

	} // end of isSame()

	/**
	 * hash file by MD5
	 * 
	 * @param path
	 *            - file path
	 * @return String - file hash code by MD5
	 */
	private static String fileMD5(String path) {

		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			System.err.println("Hashing piece error!");
			e.printStackTrace();
		}
		md.reset();

		InputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			System.err.println("File not found!(MD5)");
			e.printStackTrace();
		}

		// read file
		int numRead;
		byte[] buffer = new byte[1024];
		try {
			do {
				numRead = fis.read(buffer);
				if (numRead > 0) {
					md.update(buffer, 0, numRead);
				}
			} while (numRead != -1);
			fis.close();
		} catch (Exception e) {
			System.err.println("File I/O Error!(MD5)");
		}

		byte[] digest = md.digest();
		BigInteger bigInt = new BigInteger(1, digest);
		String hashText = bigInt.toString(16);

		// We need to zero pad it if you actually want the full 32 chars
		while (hashText.length() < 32) {
			hashText = "0" + hashText;
		}

		return hashText.toUpperCase();

	} // end of fileMD5()

} // end of class CheckSameFile
