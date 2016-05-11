package com.samy.crawler.com.samy.crawler.connect;

import com.samy.crawler.CourseChapter;
import com.samy.crawler.Runner;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

/**
 * Created by samy on 16-5-11.
 */
public class Connect {

  public final static int timeOut = 20000; // 20000 ms
  public final static int maxTryTimes = 5; // if fails, try again till 5 times;
  private static String targetUrl = "https://www.cs.cmu.edu/afs/cs/academic/class/15213-m16/www/schedule.html";

  public void run(Properties prop) {
    //int threadNum = Integer.parseInt(prop.getProperty(Runner.THREAD_NUM));
    //String basePath = prop.getProperty(Runner.BASE_PATH);

    Document doc = getDocument();

    if (doc == null) {
      System.out.println("Network connection error!");
      return;
    }

    // retrievel data list
    List<CourseChapter> cList = Analysis.getChapterList(doc);

    if (cList.size() == 0) {
      System.out.println("Cannot find course info!");
      return;
    }

    writeToFile(cList);

    //LoadFile.download(cList, prop);

  }

  private void writeToFile(List<CourseChapter> list) {

    File file = new File("/home/samy/Documents/MyDocuments/513.txt");


    PrintWriter pw = null;
    try {
      pw = new PrintWriter(file);
      for(CourseChapter course : list){
        pw.println(course.getChapterName());
        pw.println(course.getVideoAddr());
        pw.println();

      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {

      if (pw != null) {
        pw.flush();
        pw.close();
        pw = null;
      }

    }

  }

  private Document getDocument() {
    return Connect.getDocument(this.targetUrl, this.timeOut, this.maxTryTimes);
  }

  public static Document getDocument(Connection conn, int tryTimes) throws UnsupportedMimeTypeException {
    try {
      if (tryTimes > 0)
        return conn.get();
    } catch (UnsupportedMimeTypeException e) {
      throw e;
    } catch (IOException e) {
      return getDocument(conn, tryTimes--);
    }
    return null;

  }

  public static Document getDocument(String targetUrl, int timeOut, int tryTimes) {

    Document doc = null;
    Connection conn = Jsoup.connect(targetUrl);
    conn.followRedirects(true);
    conn.timeout(timeOut);
    try {
      while (doc == null && tryTimes-- > 0)
        // repeat call
        // in case of time out error
        doc = conn.get();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return doc;
  }

  public static void main(String[] args) {
    Properties prop = new Properties();
    Connect connect = new Connect();

    connect.run(prop);
//    Document doc = Connect.getDocument("https://scs.hosted.panopto.com/Panopto/Pages/Viewer.aspx?id=d8c83d3a-8074-4afe-ae3b-693e2250999a", Connect.timeOut, Connect.maxTryTimes);

    //   File file = new File("/home/samy/Documents/MyDocuments/513.html");



/*    PrintWriter pw = null;
    try {
      pw = new PrintWriter(file);
      pw.print(doc.toString());
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } finally {

      if(pw != null) {
        pw.flush();
        pw.close();
        pw = null;
      }

    }*/
  }

}
