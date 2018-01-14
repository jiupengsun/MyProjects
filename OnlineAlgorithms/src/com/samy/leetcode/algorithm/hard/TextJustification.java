package com.samy.leetcode.algorithm.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {

  /**
   * https://leetcode.com/problems/text-justification/description/
   * @param words
   * @param maxWidth
   * @return
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> list = new LinkedList<>();
    List<String> tmp = new ArrayList<>();
    int length=0;
    StringBuilder s = new StringBuilder();
    for(int i=0; i<maxWidth; ++i) {
      s.append(' ');
    }
    String ss = s.toString();
    for(int i=0; i<words.length; ++i) {
      if(length + words[i].length() + tmp.size() <= maxWidth) {
        tmp.add(words[i]);
        length += words[i].length();
      } else {
        // reach the end a line
        int numOfSpace = maxWidth - length;
        int spaces = 0, extraSpace = 0;
        if(numOfSpace > 0) {
          if(tmp.size() > 1) {
            spaces = numOfSpace / (tmp.size()-1);
            extraSpace = numOfSpace % (tmp.size() - 1);
          } else {
            spaces = numOfSpace;
          }
        }
        StringBuilder sb = new StringBuilder();
        for(int j=0; j<tmp.size(); ++j) {
          sb.append(tmp.get(j));
          if(numOfSpace > 0) {
            int count = spaces;
            if(extraSpace-- > 0)
              count++;
            sb.append(ss.substring(0, count));
            numOfSpace -= count;
          }
        }
        list.add(sb.toString());
        //
        tmp = new ArrayList<>();
        tmp.add(words[i]);
        length = words[i].length();
      }
    }
    if(tmp.size() > 0) {
      // last line
      StringBuilder sb = new StringBuilder();
      for(int i=0; i<tmp.size(); ++i) {
        sb.append(tmp.get(i)).append(' ');
      }
      sb.deleteCharAt(sb.length() - 1);
      sb.append(ss.substring(0, maxWidth - sb.length()));
      list.add(sb.toString());
    }
    return list;
  }

  public static void main(String[] args) {
    TextJustification tj = new TextJustification();
    tj.fullJustify(new String[]{"Imagination","is","more","important","than","knowledge."}, 14);
  }
}
