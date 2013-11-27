import static org.junit.Assert.*;

import java.io.IOException;
import org.junit.Before;
import org.junit.Test;


public class DataCSVTest {
	
	//ReadMe
	
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
		assertFalse(!testCSV.printCSV());
	}

	@Test
	public void testCheckCSV() {
		assertFalse(!testCSV.checkCSV());
	}

}	//end of DataCSVTest
