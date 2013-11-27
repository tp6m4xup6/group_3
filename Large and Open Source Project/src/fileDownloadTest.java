import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;


public class fileDownloadTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetWebHtml() {
		String html=null;
		html=fileDownload.getWebHtml("http://tw.yahoo.com/");
	}

	@Test
	public void testPregUrl() {
		String url="<a href=\"http://api.worldbank.org/v2/zh/indicator/sh.hiv.1524.ma.zs?downloadformat=csv\">CSV</a>";
		String URL="http://api.worldbank.org/v2/zh/indicator/sh.hiv.1524.ma.zs?downloadformat=csv";
		String download_url = fileDownload.pregUrl(url);
		assertEquals(URL,download_url);
	}

	@Test
	public void testLoadUrlFile() throws IOException {
		{
			String download_url="http://api.worldbank.org/v2/zh/indicator/sh.hiv.1524.ma.zs?downloadformat=csv";	
			int flag=1;
			try {
				fileDownload.loadUrlFile(download_url,"C:\\Users\\user\\Documents\\GitHub\\group_3\\Large and Open Source Project\\src","hiv.zip");	
			} catch (IOException e) {
		        fail("Read .csv file error!");
		        e.printStackTrace();
		        flag=0;
			}
			assertEquals(flag,1);
		}
	}
}
