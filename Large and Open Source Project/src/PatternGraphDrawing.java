import java.io.IOException;

/**
 * A factory that will Draw Image
 * @author perfume776
 */
public class PatternGraphDrawing{
	public GraphDrawing drawGraph(){
		GraphDrawing temp = new GraphDrawing();
		GraphDrawing.DevelopedCountry();
		try {
			GraphDrawing.drawImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
}