package com.samy.test;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class HParTest {

	private final String baseUri = System.getProperty("user.dir");

	@Test
	public void parseFromFileTest() {
		String filePath = baseUri + "\\resource\\index.html";
		File html = new File(filePath);
		String encode = "UTF-8";
		try {
			Document doc = Jsoup.parse(html, encode);
			Element body = doc.body();
			Elements paragraphs = body.select("div");
			System.out.println(paragraphs.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//@Test
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
