package com.samy.crawler;

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
    String className1 = "recitation";
    String className2 = "recbody";
    retrieveData(doc, list, className1);
    retrieveData(doc, list, className2);
    return list;
  }

  private static void retrieveData(Document doc, List<CourseChapter> list, String className) {
    Elements eles = doc.getElementsByClass(className);
    for (Element ele : eles) {
      Elements children = ele.children();
      if (children.size() == 0)
        continue;
      for (Element child : children) {
        // find tag
        if (child.tagName().equals("a")) {

        }

      }
    }

  }
}
