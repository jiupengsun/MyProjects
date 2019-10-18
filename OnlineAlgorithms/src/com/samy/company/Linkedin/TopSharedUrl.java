package com.samy.company.Linkedin;

public class TopSharedUrl {

  private static TopSharedUrl instance;

  private TopSharedUrl() {
  }

  public static TopSharedUrl getInstance() {
    if (instance == null) {
      synchronized (instance) {
        if (instance == null)
          instance = new TopSharedUrl();
      }
    }
    return instance;
  }

  public static void main(String[] args) {
    new Thread(new Job()).start();
  }

  public void shared(String url, int time) {
  }

  public String top() {
    return "";
  }
}

class Job implements Runnable {
  boolean isStop = false;

  public void setFlag(boolean f) {
    isStop = f;
  }

  @Override
  public void run() {
    do {
      try {
        // sleep 30s
        wait(30000);
        String topUrl = TopSharedUrl.getInstance().top();
        // write topUrl to file/db
        System.out.println(topUrl);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    } while (!isStop);
  }
}
