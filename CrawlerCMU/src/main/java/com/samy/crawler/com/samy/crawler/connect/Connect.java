package com.samy.crawler.com.samy.crawler.connect;

import com.samy.crawler.CourseChapter;
import com.samy.crawler.Runner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by samy on 16-5-11.
 */
public class Connect {

  private final static int timeOut = 20000; // 20000 ms
  private final static int maxTryTimes = 5; // if fails, try again till 5 times;
  private static String targetUrl = "https://www.cs.cmu.edu/afs/cs/academic/class/15213-m16/www/schedule.html";

  public void run(Properties prop){
    int threadNum = Integer.parseInt(prop.getProperty(Runner.THREAD_NUM));
    String basePath = prop.getProperty(Runner.BASE_PATH);

    Document doc = getDocument();

    if (doc == null){
      System.out.println("Network connection error!");
      return;
    }

    // retrievel data list
    List<CourseChapter> cList = Analysis.getChapterList(doc);

    if(cList.size() == 0){
      System.out.println("Cannot find course info!");
      return;
    }

    LoadFile.download(cList, prop);

  }

  private Document getDocument() {
    Document doc = null;
    try {
      int tryTimes = maxTryTimes;
      while (doc == null && tryTimes-- > 0)
        // repeat call
        // in case of time out error
        doc = Jsoup.connect(targetUrl).timeout(timeOut).get();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }

}
