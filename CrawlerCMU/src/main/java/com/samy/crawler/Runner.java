package com.samy.crawler;

import com.samy.crawler.com.samy.crawler.connect.Connect;
import com.samy.crawler.com.samy.crawler.exception.IllegalArgsException;

import java.io.File;
import java.util.Properties;
import java.util.Scanner;

/**
 * Created by samy on 16-5-10.
 */
public class Runner {

  private final static String OUTPUT_PATH_PARAM = "-o";
  private final static String MAX_THREAD_NUMBER_PARAM = "-tn";
  private final static String DEFAULT_THREAD_NUMBER = "5";
  private static Properties prop = null;

  /*Name of keys in properties*/
  public final static String BASE_PATH = "basePath";
  public final static String THREAD_NUM = "threadNum";


  private static void readArgs(String[] args) throws IllegalArgsException {
    String lastArgs = null;
    for (String arg : args) {
      if (OUTPUT_PATH_PARAM.equals(lastArgs))
        if (!setBaseDir(arg))
          return;
        else if (MAX_THREAD_NUMBER_PARAM.equals(lastArgs))
          setThreadNum(arg);
        else if (OUTPUT_PATH_PARAM.equals(arg) || MAX_THREAD_NUMBER_PARAM.equals(arg))
          continue;
        else
          throw new IllegalArgsException();
      lastArgs = arg;

    }

  }

  private static void setThreadNum(String num) throws IllegalArgsException {

    num = num.trim();
    try {
      int n = Integer.parseInt(num.trim());
      if (n <= 0)
        throw new NumberFormatException();
      prop.setProperty(THREAD_NUM, num);
    } catch (NumberFormatException e) {
      throw new IllegalArgsException();
    }

  }

  private static boolean setBaseDir(String dir) throws IllegalArgsException {
    File f = new File(dir);
    Scanner scan = new Scanner(System.in);
    if (!f.exists()) {
      System.out.print("Directory does not exist, wanna make a new one?[y/n]:");
      String val = scan.next();
      if (!val.trim().toLowerCase().equals("y") || !f.mkdir())
        // do not want to continue or failed to create a new folder
        return false;
    } else if (!f.isDirectory()) {
      System.out.print("Input path is not a directory ! Please input a valid path:");
      String path = scan.next();
      return setBaseDir(path.trim());
    }

    // a valid path
    prop.setProperty(BASE_PATH, dir);
    return true;
  }

  private static void usage() {

    System.out.println();
    System.out.println(
        "Usage: -o <output-path> [ <options> ]");
    System.out.println("Options: -tn <max-thread-num>");
  }


  public static void main(String[] args) {
    prop = new Properties();
    prop.setProperty(THREAD_NUM, DEFAULT_THREAD_NUMBER);
    try {
      readArgs(args);
      Connect c = new Connect();
      c.run(prop);

    } catch (IllegalArgsException e) {

      usage();

    }
  }
}



