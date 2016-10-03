package com.samy.hangman;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created by samy on 10/3/16.
 */
public class Task extends Thread{

  // LAMBDA parameter, using to balance the word with
  // none letter has been discovered, and the word
  // with some of letters have been discovered
  private final static float LAMBDA = 10f;

  private CountDownLatch cdl;
  private Set<Character> trialChain;
  private Word word;
  CharPair cp;

  /**
   * helper class, with letter and weight
   */
  class CharPair {
    char next;
    float weight;
  }

  public Task(Word w, CountDownLatch cd, Set<Character> lastChar) {
    this.word = w;
    this.cdl = cd;
    // set default value
    cp = new CharPair();
    cp.next = Word.nextRandomLetter();
    cp.weight = Float.MIN_VALUE;
    this.trialChain = lastChar;
  }

  @Override
  public void run() {
    // return next available char
    // judge whether word has found some characters
    int num = word.findNumber;

    if (num == word.length) {
      // has found all
      // no need to guess for this thread
      cp.next = Word.nextRandomLetter();
      // return a min value
      cp.weight = Float.MIN_VALUE;
    } else if (num == 0) {
      // hasn't found any yet
      char[] candidate = Strategy.HIGH_FREQUENCY[word.length - 1];
      for (int i=0, l=candidate.length; i<l; ++i) {
        if (trialChain.contains(candidate[i]))
          continue;
        cp.next = candidate[i];
        // prob: (l-1-i)/(l-i)
        float probability = (float)1 / (candidate.length - i);
        cp.weight = LAMBDA * probability;
        break;
      }
    } else {
      // has found some
      // search in dictionary to find words that has match the existing letter
      // and count the next possible letter that doesn't in the guessing chain
      // store the count of letter
      int[] letters = new int[26];
      // find the matched position
      // e.g. the state is E_ _ A _ _, then the matched position is 0 and 3
      int[] matchPos = new int[num];
      // find which position has the guessed letter
      for (int i=0, j=0; i<word.length && j<num; ++i) {
        if (word.word[i] != '_') {
          // only find match word
          matchPos[j++] = i;
        }
      }
      List<String> wordList = Strategy.wordList_length.get(word.length);
      for (String s : wordList) {
        char[] w = s.toCharArray();
        boolean isMatch = true;
        for (int pos : matchPos) {
          if (w[pos] != word.word[pos]) {
            isMatch = false;
            break;
          }
        }
        if (isMatch) {
          // fully match
          // statistic the letter appearances that not in trialchain
          for (char c : w) {
            if (!trialChain.contains(c)) {
              letters[c - 'A']++;
            }
          }
        }
      }

      // after travering all the list
      // find the next char which has the highest frequency
      int pos = 0, freq = 0, total = 0;
      for (int i=0; i<26; ++i) {
        if (letters[i] > 0) {
          total += letters[i];
          if (letters[i] > freq) {
            pos = i;
            freq = letters[i];
          }
        }
      }

      float proportion = (float)word.findNumber / word.length;
      cp.next = (char) ('A' + pos);
      cp.weight = freq * proportion / total;
    }

    cdl.countDown();
  }
}
