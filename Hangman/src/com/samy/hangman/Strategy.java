package com.samy.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jiupeng on 10/2/16.
 */
public class Strategy {
  // use word list dataset from http://wordlist.aspell.net/
  private final static String DICTIONARYP_PATH = "dictionary/final/";
  // the most high frequency letter: A E O I U
  // Here I reference the statistics from website: http://www.datagenetics.com/blog/april12012/
  // The following matrix is used when I know the length a word, but none of letters in this word
  // has been discovered.
  // The length is from 1 to 20
  public final static char[][] HIGH_FREQUENCY = new char[][] {
      {'A','I'},
      {'A','O','E','I','U','M','B','H'},
      {'A','E','O','I','U','Y','H','B','C','K'},
      {'A','E','O','I','U','Y','S','B','F'},
      {'S','E','A','O','I','U','Y','H'},
      {'E','A','I','O','U','S','Y'},
      {'E','I','A','O','U','S'},
      {'E','I','A','O','U'},
      {'E','I','A','O','U'},
      {'E','I','O','A','U'},
      {'E','I','O','A','D'},
      {'E','I','O','A','F'},
      {'I','E','O','A'},
      {'I','E','O'},
      {'I','E','A'},
      {'I','E','H'},
      {'I','E','R'},
      {'I','E','A'},
      {'I','E','A'},
      {'I','E'},
  };

  // a map using length as key value
  public static Map<Integer, List<String>> wordList_length = new HashMap<>();

  static {
    System.out.println("Pre-processing dictionary files");
    try {
      for (File f : new File(DICTIONARYP_PATH).listFiles()) {
        System.out.print(".");
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String str;
        while( (str=reader.readLine()) != null) {
          // transform every letter to uppercase
          str = str.toUpperCase();
          // if this word contains special character, then discard it
          if (!checkString(str))
            continue;
          int l = str.length();
          if (wordList_length.containsKey(l)) {
            List<String> wl = wordList_length.get(l);
            wl.add(str);
            wordList_length.put(l, wl);
          } else {
            List<String> wl = new ArrayList<>();
            wl.add(str);
            wordList_length.put(l, wl);
          }
        }
      }
      System.out.println();
      System.out.println("Finish processing dictionary files");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * check string
   * @param s
   * @return
   */
  private static boolean checkString(String s) {
    for (char c : s.toCharArray()) {
      if ( !(c >= 'A' && c <='Z'))
        return false;
    }
    return true;
  }
}
