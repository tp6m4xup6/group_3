import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GraphDrawing {

	// ArrayList to store the country is Developed Country or not
	public static ArrayList<String> HighCountry = new ArrayList<String>();
	public static ArrayList<String> MidCountry = new ArrayList<String>();
	public static ArrayList<String> LowCountry = new ArrayList<String>();

	/**
	 * add country name to arraylist according to it is Developed Country or not
	 * 
	 * @author perfume776
	 */
	public static void DevelopedCountry() {
		PatternReadCSV factoryCSV = new PatternReadCSV();
		DataCSV csv = factoryCSV.getCSVData("country2.csv");
		for (int i = 0; i < csv.data.size(); i++) {
			// System.out.print(csv.data.get(i).get(3) + "\n");
			if (csv.data.get(i).get(3).indexOf("高") == 1)
				HighCountry.add(csv.data.get(i).get(1));
			else if (csv.data.get(i).get(3).indexOf("中") == 1)
				MidCountry.add(csv.data.get(i).get(1));
			else if (csv.data.get(i).get(3).indexOf("低") == 1)
				LowCountry.add(csv.data.get(i).get(1));
			else
				LowCountry.add(csv.data.get(i).get(1));
		}

	}

	/**
	 * get Hiv data from database
	 * 
	 * @author perfume776
	 */
	public static void drawImage() throws IOException {
		DevelopedCountry();
		ArrayList<ArrayList<String>> StringHiv = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> StringBorn = new ArrayList<ArrayList<String>>();
		StringHiv = DBconnect.getHivSQL();
		StringBorn = DBconnect.getBornSQL();
		/*
		 * for(int i=0;i<StringBorn.size();i++){ for(int
		 * j=0;j<StringBorn.get(0).size();j++){
		 * System.out.print(StringBorn.get(i).get(2) + "\t"); }
		 * System.out.print("\n"); }
		 */

		int HivHighCount = 0, HivMidCount = 0, HivLowCount = 0;
		double HivHighValue = 0;
		double HivMidValue = 0;
		double HivLowValue = 0;
		for (int i = 0; i < StringHiv.size(); i++) {
			if (HighCountry.contains("\"" + StringHiv.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringHiv.get(i).get(3).charAt(0))) {
					HivHighCount++;
					HivHighValue += Double.parseDouble(StringHiv.get(i).get(3));
				}
			} else if (MidCountry.contains("\"" + StringHiv.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringHiv.get(i).get(3).charAt(0))) {
					HivMidCount++;
					HivMidValue += Double.parseDouble(StringHiv.get(i).get(3));
				}
			} else if (LowCountry.contains("\"" + StringHiv.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringHiv.get(i).get(3).charAt(0))) {
					HivLowCount++;
					HivLowValue += Double.parseDouble(StringHiv.get(i).get(3));
				}
			} else
				continue;
		}
		int BornHighCount = 0, BornMidCount = 0, BornLowCount = 0;
		double BornHighValue = 0;
		double BornMidValue = 0;
		double BornLowValue = 0;
		for (int i = 0; i < StringHiv.size(); i++) {
			if (HighCountry.contains("\"" + StringBorn.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringBorn.get(i).get(3).charAt(0))) {
					BornHighCount++;
					BornHighValue += Double.parseDouble(StringBorn.get(i).get(3));
				}
			} else if (MidCountry.contains("\"" + StringBorn.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringBorn.get(i).get(3).charAt(0))) {
					BornMidCount++;
					BornMidValue += Double.parseDouble(StringBorn.get(i).get(3));
				}
			} else if (LowCountry.contains("\"" + StringBorn.get(i).get(2) + "\"") == true) {
				if (Character.isDigit(StringBorn.get(i).get(3).charAt(0))) {
					BornLowCount++;
					BornLowValue += Double.parseDouble(StringBorn.get(i).get(3));
				}
			} else
				continue;
		}

		System.out.print(HivHighValue + "\t" + HivHighCount + "\n");
		System.out.print(HivMidValue + "\t" + HivMidCount + "\n");
		System.out.print(HivLowValue + "\t" + HivLowCount + "\n");
		System.out.print(BornHighValue + "\t" + BornHighCount + "\n");
		System.out.print(BornMidValue + "\t" + BornMidCount + "\n");
		System.out.print(BornLowValue + "\t" + BornLowCount + "\n");
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(HivHighValue / (double) HivHighCount, "Hiv", "High");
		dataset.addValue(HivMidValue / (double) HivMidCount, "Hiv", "Mid");
		dataset.addValue(HivLowValue / (double) HivLowCount, "Hiv", "Low");
		dataset.addValue(BornHighValue / (double) BornHighCount / 1000, "Born", "High");
		dataset.addValue(BornMidValue / (double) BornMidCount / 1000, "Born", "Mid");
		dataset.addValue(BornLowValue / (double) BornLowCount / 1000, "Born", "Low");

		JFreeChart chart = ChartFactory.createBarChart3D("Title", // 圖的標題
				"Developed Country", // x 座標標題
				"%", // y 座標標題
				dataset, // 你放數據的地方
				PlotOrientation.VERTICAL, // 圖表方向：水平、垂直
				true, // 是否顯示圖例
				false, // 是否 tooltips 工具
				false // 是否生成URL
				);
		FileOutputStream fos_jpg = null;
		try {
			fos_jpg = new FileOutputStream("print.jpg");
			ChartUtilities.writeChartAsJPEG(fos_jpg, 1.0f, chart, 400, 300, null);
		} finally {
			try {
				fos_jpg.close();
			} catch (Exception e) {
			}
		}

	}

}
