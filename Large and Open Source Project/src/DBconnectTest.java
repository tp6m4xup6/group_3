import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DBconnectTest {

	@Test
	public void testHiv_upload() {

		// boolean hiv_sucess= DBconnect.Hiv_upload("hiv.csv");
		// assertTrue(hiv_sucess);

	}

	@Test
	public void testGetHivSQL() {
		boolean getHiv = false;
		ArrayList<ArrayList<String>> dataHiv = new ArrayList<ArrayList<String>>();
		dataHiv = DBconnect.getHivSQL();
		if (dataHiv.size() > 0) {
			getHiv = true;
		}
		assertTrue(getHiv);
	}

	@Test
	public void testBorn_upload() {
		// boolean born_sucess= DBconnect.Born_upload("born.csv");
		// assertTrue(born_sucess);
	}

	@Test
	public void testGetBornSQL() {
		boolean getBorn = false;
		ArrayList<ArrayList<String>> dataBorn = new ArrayList<ArrayList<String>>();
		dataBorn = DBconnect.getBornSQL();
		if (dataBorn.size() > 0) {
			getBorn = true;
		}
		assertTrue(getBorn);

	}

}
