package jsoup.jsoup;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

public class AppTest {

	@Test
	public void test() {
		try {
			Document doc = Jsoup.connect("http://www.baidu.com").get();
			Element body = doc.body();
			System.out.println(body.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
