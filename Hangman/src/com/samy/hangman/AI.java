
package com.samy.hangman;

import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Author: Jiupeng Sun<br>
 * Date: 10/2/16<br>
 * Email: jiupengs@andrew.cmu.edu<br>
 *
 * <p>
 * This is a Hangman game AI.<br>
 * The basic idea for this program is try to guess each word in the sentence,
 * basing on the probability of next letter.
 * </p>
 *
 * <p>
 * First, the program will start a new game by sending request to game server,
 * and get the total number of words in the sentence, along with the number of
 * letters in each word. Then start threads for each word to run.
 * </p>
 * <p>
 * Each thread will evaluate the word and return a guessing letter with a weight,
 * the main program will choose the letter with highest weight. So the core ranking
 * strategy would be the vital key to crack the game.
 * </p>
 *
 * <p>
 * I use the following method to decide next letter. Before starting, I searched
 * some useful references on the website, the following pages gave me lots of assistance:
 * 1. SCOWL <a href="http://wordlist.aspell.net/">http://wordlist.aspell.net/</a>, an English word dataset more than 8MB
 * 2. A blog gave a basic strategy for hangman
 * <a href="http://www.datagenetics.com/blog/april12012/">http://www.datagenetics.com/blog/april12012/</a>. This page gave a form which I used in
 * my program.
 * </p>
 *
 * <p>
 * At the start of program, the Strategy class will initialize a HashMap, using the length of
 * word as key, and a List contains different words with same length as value data. This is
 * a dictionary which I will used to search words.
 * </p>
 *
 * <p>
 * Each single thread will receive a word from main program, and will return a guessing
 * letter that itself regards it's the most possible letter in the next round, along with a
 * weight. This weight should be given in the same standard among different threads. The task
 * thread will rank as following procedure:<br><br>
 * 1. If the word has been fully matched, that is each letter in this word has been confirmed,
 * the thread will return a random letter with extreme low weight, which ensures the main program
 * would never choose this letter;<br><br>
 * 2. If the word hasn't been discovered any letter(in this program it's a all-underline string),
 * then using the form in reference 2, which is a choosing order for words with different length.
 * E.g. if I received a two-letter word, then I will pick up row {'A','O','E','I','U','M','B','H'}
 * then search each letter in this row which hasn't been guessed in previous rounds. The weight will be
 * the reciprocal of lengthOf(row) minus current index. That's, in this example, letter A has the weight 1/8,
 * letter O has the weight 1/7, and so on, the last letter H has the weight 1. A simple idea here is as the
 * font letter be eliminated, the latter letter would have higher probability;<br><br>
 * 3. If the word has been partially matched, let's say, I received a three-letter word _a_, then
 * the thread will look up in the dictionary according to word's length, in this example the thread will
 * search in 3-letter word list, and try to match word with a 'a' in the middle of word. Then
 * memorize occurrence for each letter. The final weight will be the product of two parts: Frequency and
 * Proportion. The frequency is most-frequent letter in the dictionary. For example, if a 3-letter word
 * with a 'a' in the middle will have 38 'm' at the beginning, which is the largest frequency among
 * the 240-letter space. Then the letter 'm' will be returned, and the Frequency will be 38/240.
 * The second Proportion should be the number of discovered letter divided by total length of the
 * word, in this case is 1/3. This rule is based on such principle: the shorter word will has the higher
 * opportunity to be matched. In a intuitional saying, a 2-letter word should be much easier to guess than
 * a 10-letter word.
 * </p>
 *
 * <p>
 * There is a lambda parameter used at the rule 2 above. Because I think the sequence form from
 * reference 2 should be weighted higher. Actually, after 2~3 times of guessing, each word will have
 * at least one letter that been discovered, so the lambda parameter will only be used in first
 * several rounds.
 * </p>
 *
 * <p>
 * Build step: First ensure the url in the Game.java file is correct.
 * Then run the main method in AI.java. This project depends a jar file called fastjson, which is
 * used to map JSON string to Object. Here I've imported the jar into project.
 *
 * Import this project into Intellij, directly run AI main
 * </p>
 *
 *
 */
public class AI {

  /**
   * Play a single game
   * return true if Free, otherwise false
   * @return
   */
  public boolean playGame() {
    Game game = new Game();

    // start new game
    Hangman hm = game.newGame();
    // a set used to store letters that has been guessed
    Set<Character> trialChain = new HashSet<>();
    // set default char
    char nextChar = Word.nextRandomLetter();
    // max test times
    // loop if game is still alive
    while (hm.isAlive()) {
      // get word list
      List<Word> wl = hm.parser();
      CountDownLatch cdl = new CountDownLatch(wl.size());
      // multiple threads to parse
      Task[] threads = new Task[wl.size()];
      int i = 0;
      for (Word w : wl) {
        threads[i] = new Task(w, cdl, trialChain);
        threads[i++].start();
      }
      try {
        cdl.await();
        // finish
        // accumulate the score of each thread
        Map<Character, Float> scores = new HashMap<>();
        for (Task t : threads) {
          if (scores.containsKey(t.cp.next)) {
            float score = scores.get(t.cp.next);
            score += t.cp.weight;
            scores.put(t.cp.next, score);
          } else {
            scores.put(t.cp.next, t.cp.weight);
          }
        }

        float weight = Float.MIN_VALUE;
        Iterator<Character> it = scores.keySet().iterator();
        while(it.hasNext()) {
          char c = it.next();
          float f_wei = scores.get(c);
          if (f_wei > weight) {
            nextChar = c;
            weight = f_wei;
          }
        }

        // add into trail chain
        trialChain.add(nextChar);
        hm = game.guess(nextChar);

      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

    if (hm.isDead()) {
      System.out.println("Game Over!");
      return false;
    }
    else {
      System.out.println("Free!!!");
      return true;
    }

  }


  public static void main(String[] args) {
    AI ai = new AI();
    while(true) {
      ai.playGame();
    }
  }
}
