import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

/**
 * testReadCSV: test if reading CSV file is successful.<br>
 * testPrintCSV: test if the CSV file is available.<br>
 * testCheckCSV: test if the CSV file is not empty.
 * 
 * @author j9988t
 *
 */

public class DataCSVTest {
	
	
	
	PatternReadCSV factoryCSV = new PatternReadCSV();
	
	DataCSV testCSV = factoryCSV.getCSVData("test.csv");
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testReadCSV() {
		try {
			testCSV.readCSV();
		} catch (IOException e) {
			fail("Read .csv file error!");
			e.printStackTrace();
		}
	}

	@Test
	public void testPrintCSV() {
		//only need to call checkCSV()
		assertFalse(!testCSV.checkCSV());
	}

	@Test
	public void testCheckCSV() {
		assertFalse(!testCSV.checkCSV());
	}

}	//end of DataCSVTest
