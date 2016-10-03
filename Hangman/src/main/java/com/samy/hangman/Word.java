package com.samy.hangman;

/**
 * Created by Jiupeng on 10/2/16.
 * A helper class which contains a character array and its length
 * Because this is a helper class, so it's more convenience to use field inside directly
 * thus I use public keyword instead private here
 */
public class Word {
  public int length;
  public int findNumber;
  public char[] word;

  Word (String s) {
    word = s.toCharArray();
    length = word.length;
    hasFindNumber();
  }

  /**
   * return the number of has matched letters
   * @return
   */
  private void hasFindNumber() {
    int i = 0;
    for (char c : word)
      if (c != '_')
        ++i;
    findNumber = i;
  }

  /**
   * A helper function, return a random upper alphabet
   * @return
   */
  public static char nextRandomLetter() {
    return (char)('A' + (int)(26 * Math.random()));
  }
}
