import org.jfree.data.category.*;   
import org.jfree.chart.*; 
import org.jfree.chart.plot.*; 

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * A factory that will Draw Image
 * @author perfume776
 */
public class PatternGraphDrawing{
	public GraphDrawing drawGraph(){
		GraphDrawing temp = new GraphDrawing();
		temp.DevelopedCountry();
		try {
			temp.drawImage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
		
	}
	
}