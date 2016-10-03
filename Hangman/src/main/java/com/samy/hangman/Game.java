package com.samy.hangman;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * Created by Jiupeng on 10/2/16.
 * React with game server, create new game, send guess letter and
 * get results from server
 */
public class Game {

  private Hangman hangMan;

  private final static String HANGMAN_URL = "http://gallows.hulu.com/play?code=jiupengs@andrew.cmu.edu";

  public Hangman newGame() {
    try {
      String result = get(HANGMAN_URL);
      hangMan = resultToHangman(result);
      return hangMan;
    } catch (IOException e) {
      e.printStackTrace();
      System.out.println("Hangman Initialization Error, Malformed Url Address!");
      System.exit(1);
    }
    return null;
  }

  /**
   * Send request to server and get output
   * @param url
   * @return
   * @throws IOException
   */
  private String get(String url) throws IOException{
    BufferedReader br = null;
    br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
    return br.readLine();
  }

  /**
   * Map Json string to Object, here is Hangman class
   * @param json
   * @return
   */
  private Hangman resultToHangman(String json) {
    return JSON.parseObject(json, Hangman.class);
  }

  /**
   * send guess letter to server
   * @param guess
   * @return
   */
  public Hangman guess(char guess) {
    if (hangMan == null) {
      System.out.println("Please start new game firstly!");
      return null;
    }
    String url = HANGMAN_URL + "&token=" + hangMan.getToken() + "&guess=" + guess;
    String result;
    try {
      result = get(url);
      hangMan = resultToHangman(result);
      if (hangMan.getStatus().equals(Hangman.DEAD) || hangMan.getStatus().equals(Hangman.FREE)) {
        // gg or free
        // return a copy to client
        Hangman hangman = hangMan.copy();
        this.hangMan = null;
        return hangman;
      }
      // alive
      return hangMan.copy();

    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

}
