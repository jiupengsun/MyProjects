package com.samy.leetcode.algorithm.hard;

import java.util.*;

/**
 * https://leetcode.com/problems/word-ladder-ii/
 * Created by samy on 11/10/16.
 */
public class WordLadderII {

  private final char[] letters = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
      'p','q','r','s','t','u','v','w','x','y','z'};

/*  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    Set<String> visited1 = new HashSet<>();
    Set<String> visited2 = new HashSet<>();
    Map<String, List<List<String>>> layer1 = new HashMap<>();
    Map<String, List<List<String>>> layer2 = new HashMap<>();
    List<List<String>> p1 = new ArrayList<>();
    p1.add(new ArrayList<>());
    List<List<String>> p2 = new ArrayList<>();
    p2.add(new ArrayList<>());
    layer1.put(beginWord, p1);
    layer2.put(endWord, p2);
    List<List<String>> paths = new ArrayList();
    int min_path = Integer.MAX_VALUE;
    while(!layer1.isEmpty() && !layer2.isEmpty()) {
      // start from left
      Iterator<String> iterator = layer1.keySet().iterator();
      Map<String, List<List<String>>> newLayer1 = new HashMap<>();
      while(iterator.hasNext()) {
        String word = iterator.next();
        List<List<String>> left = layer1.get(word);
        // add this word to trace list
        for(List<String> l : left)
          l.add(word);
        // add into visited node
        visited1.add(word);
        if(layer2.containsKey(word)) {
          // meet in middle
          List<List<String>> right = layer2.get(word);
          int path_length = left.get(0).size() + right.get(0).size();
          if (path_length > min_path) {
            // longer path, skip
            continue;
          }
          if (path_length < min_path) {
            // clear the paths
            paths = new ArrayList();
            min_path = path_length;
          }
          for(List<String> l : left) {
            for(List<String> r : right) {
              List<String> path = new ArrayList<>();
              path.addAll(l);
              path.addAll(r);
              paths.add(path);
            }
          }
        } else {
          // not meet
          // go further
          Iterator<String> it = nextWord(word, wordList).iterator();
          while(it.hasNext()) {
            String w = it.next();
            if(!visited1.contains(w)) {
              List<List<String>> prepath = newLayer1.get(w);
              if (prepath == null) {
                prepath = new ArrayList<>();
              }
              for(List<String> l : left)
                prepath.add(new ArrayList<>(l));
              newLayer1.put(w, prepath);
            }
          }
        }
      }
      layer1 = newLayer1;

      Map<String, List<List<String>>> newLayer2 = new HashMap<>();
      // start from right
      iterator = layer2.keySet().iterator();
      while(iterator.hasNext()) {
        String word = iterator.next();
        List<List<String>> right = layer2.get(word);
        // insert the word at the header of list
        for(List<String> r : right)
          r.add(0, word);
        // add into visited node
        visited2.add(word);
        if(layer1.containsKey(word)) {
          // meet in middle
          List<List<String>> left = layer1.get(word);
          int path_length = left.get(0).size() + right.get(0).size();
          if (path_length > min_path) {
            // longer path, skip
            continue;
          }
          if (path_length < min_path) {
            // clear the paths
            paths = new ArrayList();
            min_path = path_length;
          }
          for(List<String> l : left) {
            for(List<String> r : right) {
              List<String> path = new ArrayList<>();
              path.addAll(l);
              path.addAll(r);
              paths.add(path);
            }
          }
        } else {
          // go further
          Iterator<String> it = nextWord(word, wordList).iterator();
          while(it.hasNext()) {
            String w = it.next();
            if(!visited2.contains(w)) {
              List<List<String>> prepath = newLayer2.get(w);
              if (prepath == null)
                prepath = new ArrayList<>();
              for(List<String> l : right)
                prepath.add(new ArrayList<>(l));
              newLayer2.put(w, prepath);
            }
          }
        }
      }
      layer2 = newLayer2;
    }

    return paths;
  }*/


  public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
    Set<String> visited = new HashSet<>();
    Map<String, List<List<String>>> layer1 = new HashMap<>();
    Map<String, List<List<String>>> layer2 = new HashMap<>();
    List<List<String>> p1 = new ArrayList<>();
    p1.add(new ArrayList<>());
    List<List<String>> p2 = new ArrayList<>();
    p2.add(new LinkedList<>());
    // initialize layer
    layer1.put(beginWord, p1);
    layer2.put(endWord, p2);
    List<List<String>> paths = new ArrayList<>();
    Iterator<String> iter = null;
    int min_path = Integer.MAX_VALUE;
    while(!layer1.isEmpty() && !layer2.isEmpty() && paths.size()==0) {
      Map<String, List<List<String>>> newlayer1 = new HashMap<>();
      iter = layer1.keySet().iterator();
      while(iter.hasNext()) {
        String word = iter.next();
        List<List<String>> left = layer1.get(word);
        for(List<String> l : left)
          l.add(word);
        visited.add(word);
        if(layer2.containsKey(word)) {
          // meet in middle
          List<List<String>> right = layer2.get(word);
          int path_l = left.get(0).size() + right.get(0).size();
          if(path_l > min_path)
            continue;
          if(path_l < min_path) {
            paths = new ArrayList<>();
            min_path = path_l;
          }
          for(List<String> l : left)
            for(List<String> r : right) {
              List<String> path = new ArrayList<>();
              path.addAll(l);
              path.addAll(r);
              paths.add(path);
            }
        } else {
          Iterator<String> it = nextWord(word, wordList).iterator();
          while(it.hasNext()) {
            String w = it.next();
            if(!visited.contains(w)) {
              List<List<String>> prepath = newlayer1.get(w);
              if (prepath == null)
                prepath = new ArrayList<>();
              for(List<String> l : left)
                prepath.add(new ArrayList<>(l));
              newlayer1.put(w, prepath);
            }
          }
        }
      }
      layer1 = newlayer1;

      Map<String, List<List<String>>> newlayer2 = new HashMap<>();
      iter = layer2.keySet().iterator();
      while(iter.hasNext()) {
        String word = iter.next();
        List<List<String>> right = layer2.get(word);
        for(List<String> r : right)
          r.add(0, word);
        visited.add(word);
        if(layer1.containsKey(word)) {
          // meet in middle
          List<List<String>> left = layer1.get(word);
          int path_l = left.get(0).size() + right.get(0).size();
          if(path_l > min_path)
            continue;
          if(path_l < min_path) {
            paths = new ArrayList<>();
            min_path = path_l;
          }
          for(List<String> l : left)
            for(List<String> r : right) {
              List<String> path = new ArrayList<>();
              path.addAll(l);
              path.addAll(r);
              paths.add(path);
            }
        } else {
          Iterator<String> it = nextWord(word, wordList).iterator();
          while(it.hasNext()) {
            String w = it.next();
            if(!visited.contains(w)) {
              List<List<String>> prepath = newlayer2.get(w);
              if(prepath == null)
                prepath = new ArrayList<>();
              for(List<String> r : right) {
                prepath.add(new LinkedList<>(r));
              }
              newlayer2.put(w, prepath);
            }
          }
        }
      }
      layer2 = newlayer2;
    }
    return paths;
  }

  private Set<String> nextWord(String word, Set<String> dict) {
    Set<String> set = new HashSet<>();
    char[] letter = word.toCharArray();
    for(int i=0; i<letter.length; ++i) {
      char tmp = letter[i];
      for(char c : letters) {
        if(c == tmp)
          continue;
        letter[i] = c;
        String nw = new String(letter);
        if(dict.contains(nw))
          set.add(nw);
      }
      letter[i] = tmp;
    }
    return set;
  }

/*  private Set<String> nextWord(String word, Set<String> dict) {
    Iterator<String> it = dict.iterator();
    Set<String> set = new HashSet<>();
    while(it.hasNext()) {
      String w = it.next();
      int diff = 0;
      for(int i=0,l=word.length(); i<l; ++i) {
        if(word.charAt(i) != w.charAt(i)) {
          ++diff;
        }
      }
      if (diff == 1) {
        set.add(w);
      }
    }
    return set;
  }*/

  public static void main(String[] args) {
    Set<String> dict = new HashSet<>();
    dict.add("ted");
    dict.add("tex");
    dict.add("red");
    dict.add("tax");
    dict.add("tad");
    dict.add("den");
    dict.add("rex");
    dict.add("pee");
    String beginWord = "red";
    String endWord = "tax";

/*    dict.add("magic");
    dict.add("manic");
    dict.add("mania");
    dict.add("maria");
    dict.add("marta");
    dict.add("maris");
    dict.add("paris");
    dict.add("marty");
    dict.add("marks");
    dict.add("party");
    dict.add("parks");
    dict.add("marry");
    dict.add("parry");
    dict.add("perks");
    dict.add("merry");
    dict.add("peaks");
    dict.add("perry");
    dict.add("peary");
    dict.add("pears");
    dict.add("pearl");
    String beginWord = "magic";
    String endWord = "pearl";*/

/*    String beginWord = "nape";
    String endWord = "mild";
    String[] words = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
    for(String w : words)
      dict.add(w);
    System.out.println(dict.size());*/
    WordLadderII wl = new WordLadderII();
    List<List<String>> result = wl.findLadders(beginWord, endWord, dict);
    for(List<String> l : result)
      System.out.println(l);
  }
}
