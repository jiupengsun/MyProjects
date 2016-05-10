package com.samy.crawler.com.samy.crawler.connect;

import com.samy.crawler.CourseChapter;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

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
      boolean flag = false;
      for (Element child : children) {
        // <a href>
        if (child.tagName().equals("a")) {
          flag = true;
          break;
        }
      }
      if (flag) {
        // find tag
        String innerH = ele.html().trim();
        CourseChapter chapter = new CourseChapter();
        // such as "Overview (...."
        chapter.setChapterName(innerH.substring(0, innerH.indexOf("(")));
        Elements aChildren = ele.getElementsByTag("a");
        for (Element aChild : aChildren) {
          // the number of a elements is either 1 or 2
          String href = aChild.attr("href");
          if (href.contains(".pdf"))
            chapter.setPdfAddr(href);
          else
            chapter.setVideoAddr(jumpToVideo(href));
        }
        list.add(chapter);
      }
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
    Connection conn = Jsoup.connect(href);
    conn.followRedirects(true);
    return null;
  }
}
