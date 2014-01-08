import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

/**
 * testHighDeveloped : test whether the arraylist HighCountry is null or not
 * testMidDeveloped  : test whether the arraylist MidCountry is null or not
 * testLowDeveloped  : test whether the arraylist LowCountry is null or not
 *  
 * @author perfume776
 *
 */

public class GraphDrawingTest {

	GraphDrawing drawImage = new GraphDrawing(); 
	
	@Before
	public void setUp() throws Exception {
		GraphDrawing.DevelopedCountry();
	}
	
	@Test
	public void testHighDeveloped() {
		assertNotNull(GraphDrawing.HighCountry);
	}
	@Test
	public void testMidDeveloped() {
		assertNotNull(GraphDrawing.MidCountry);
	}
	@Test
	public void testLowDeveloped() {
		assertNotNull(GraphDrawing.MidCountry);
	}
}
