package com.samy.hangman;

import java.util.ArrayList;
import java.util.List;

/**
 * Object which is used to map json string from server to class
 * Created by Jiupeng on 10/2/16.
 */
public class Hangman {

  public final static String ALIVE = "ALIVE";
  public final static String DEAD = "DEAD";
  public final static String FREE = "FREE";

  private String status;
  private String token;
  private String remaining_guesses;
  private String state;

  public boolean isAlive() {
    return this.status.equals(ALIVE);
  }

  public boolean isDead() {
    return this.status.equals(DEAD);
  }

  public boolean isFree() {
    return this.status.equals(FREE);
  }

  /**
   * parser the state string and return a word list
   * @return
   */
  public List<Word> parser() {
    if (state== null || state.equals(""))
      return null;
    List<Word> wordList = new ArrayList<>();
    for(int i=0, j=0, l=state.length(); i<l && j<l; i=j+1) {
      while (i<l) {
        char c = state.charAt(i);
        // tread both of upper alphabet and underline as word
        if ( !(c >= 'A' && c<= 'Z' || c == '_') ) {
          ++i;
        } else
          break;
      }
      if (i < l) {
        // not end
        j = i + 1;
        while (j < l) {
          char c = state.charAt(j);
          if ( c >= 'A' && c<='Z' || c == '_') {
            ++j;
          } else
            break;
        }
        // got the space or end
        // then [i, j) is a word
        Word w = new Word(state.substring(i, j));
        wordList.add(w);
      }
    }
    return wordList;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getRemaining_guesses() {
    return remaining_guesses;
  }

  public void setRemaining_guesses(String remaining_guesses) {
    this.remaining_guesses = remaining_guesses;
  }

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  public Hangman copy() {
    Hangman hangman = new Hangman();
    hangman.setState(this.state);
    hangman.setRemaining_guesses(this.remaining_guesses);
    hangman.setStatus(this.status);
    hangman.setToken(this.token);
    return hangman;
  }

  public String toString() {
    return "Token:" + this.token + " Status:" + this.status
        + " Remaining Times:" + this.remaining_guesses
        + " State:" + this.state;
  }
}
