package com.samy.crawler;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by samy on 16-5-10.
 */
public class Connection {

  private final static int timeOut = 20000; //10000 ms
  private final static int maxTryTimes = 5; // if fails, try again till 5 times;
  private static String targetUrl = "https://www.cs.cmu.edu/afs/cs/academic/class/15213-m16/www/schedule.html";
  private String className = "recitation";

  private Document getDocument() {
    Document doc = null;
    try {
      doc = Jsoup.connect(targetUrl).timeout(timeOut).get();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }

  private void analysis() {
    Document doc = null;
    List<CourseChapter> chapters = new ArrayList<CourseChapter>();

    int tryTimes = maxTryTimes;
    while (doc == null && tryTimes-- > 0)
    /* in case of time out error */
      doc = getDocument();
    if (doc != null) {
      List<CourseChapter> chapterList = Analysis.getChapterList(doc);
      if (chapterList != null && chapterList.size() > 0) {
        LoadFile.download(chapterList);

      }
    }
  }


  public static void main(String[] args) {
    Connection c = new Connection();
    c.analysis();
    /**
     PrintWriter pw = null;
     //    String file = "/home/samy/Documents/MyDocuments/513.html";
     Document doc = null;
     int try=maxTrytimes;
     try {
     doc = Jsoup.connect(targetUrl).timeout(timeOut).get();
     pw = new PrintWriter(new File(file));
     pw.print(doc.toString());
     } catch (IOException e) {
     if ( try -- > 0)
     doc = Jsoup.connect(targetUrl).timeout(timeOut).get();
     } finally {
     if (pw != null) {
     pw.close();
     pw = null;
     }
     */
  }
}

class CourseChapter {
  private String chapterName;
  private String pdfAddr;
  private String videoAddr;

  public String getChapterName() {
    return chapterName;
  }

  public void setChapterName(String chapterName) {
    this.chapterName = chapterName;
  }
}
