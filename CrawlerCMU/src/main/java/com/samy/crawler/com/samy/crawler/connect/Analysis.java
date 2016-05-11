package com.samy.crawler.com.samy.crawler.connect;

import com.samy.crawler.CourseChapter;
import com.samy.crawler.Runner;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by samy on 16-5-11.
 */
public class Analysis {


  public static List<CourseChapter> getChapterList(Document doc) {
    List<CourseChapter> list = new ArrayList<CourseChapter>();
    // define html key word
    String className1 = "recitation";
    String className2 = "recbody";
    retrieveData(doc, list, className1);
    retrieveData(doc, list, className2);
    return list;
  }

  private static void retrieveData(Document doc, List<CourseChapter> list, String className) {
    // <tr class>
    Elements eles = doc.getElementsByClass(className);
    for (Element ele : eles) {
      Elements children = ele.children();
      if (children.size() == 0)
        continue;
/*      boolean flag = false;
      for (Element child : children) {
        // <a href>
        if (child.tagName().equals("a")) {
          flag = true;
          break;
        }
      }*/
      String innerH = ele.html().trim();
      CourseChapter chapter = new CourseChapter();
      // such as "Overview (...."
      chapter.setChapterName(innerH.substring(0, innerH.indexOf("(")));
      Elements aChildren = ele.getElementsByTag("a");
      for (Element aChild : aChildren) {
        // the number of a elements is either 1 or 2
        String href = aChild.attr("href").trim();
        if (href.contains(".pdf"))
          chapter.setPdfAddr(href);
        else
          chapter.setVideoAddr(jumpToVideo(href));
      }
      System.out.println("Add course " + chapter.getChapterName());
      list.add(chapter);
    }

  }

  /**
   * The video address needs to jump a new web page, and retrieve this
   * message in that page
   *
   * @param href
   * @return
   */
  private static String jumpToVideo(String href) {
    Document doc = Connect.getDocument(href, Connect.timeOut, Connect.maxTryTimes);
    if (doc == null)
      return "";
    String regexString = "https://.*?\\.mp4";
    String head = doc.head().toString();
    Pattern p = Pattern.compile(regexString);
    Matcher m = p.matcher(head);
    if (m.find()) {
      String nextHref = m.group();
      Connection conn = Jsoup.connect(nextHref);
      conn.followRedirects(true);
      conn.timeout(Connect.timeOut);
      try {
        Document docJ = Connect.getDocument(conn, Connect.maxTryTimes);
      } catch (UnsupportedMimeTypeException e) {
        return e.getUrl();
      }

    }
    return "";
  }


}
