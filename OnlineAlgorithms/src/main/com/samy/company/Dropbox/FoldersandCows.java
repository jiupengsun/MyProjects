package com.samy.company.Dropbox;

import java.util.*;

public class FoldersandCows {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // number of cows
    int Q = Integer.parseInt(in.nextLine());
    String[] lines = in.nextLine().split(" ");
    // number of shared folders
    int M = Integer.parseInt(lines[0]);
    // number of confidential folders
    int N = Integer.parseInt(lines[2]);
    Map<Integer, Folder> folderMap = new HashMap<>();
    // add shared folder
    for (int i = 0; i < M; ++i) {
      lines = in.nextLine().split(" ");
      int fid = Integer.parseInt(lines[0]);
      Folder f = new Folder(fid, true);
      for (int j = 2; j < lines.length; ++j) {
        int cid = Integer.parseInt(lines[j]);
        f.cows.add(cid);
      }
      folderMap.put(fid, f);
    }

    // add confidential folder
    for (int i = 0; i < N; ++i) {
      lines = in.nextLine().split(" ");
      int fid = Integer.parseInt(lines[0]);
      Folder f = new Folder(fid, false);
      for (int j = 2; j < lines.length; ++j) {
        int cid = Integer.parseInt(lines[j]);
        f.cows.add(cid);
      }
      folderMap.put(fid, f);
    }

    // construct hierarchy
    int G = Integer.parseInt(in.nextLine());
    for (int i = 0; i < G; ++i) {
      lines = in.nextLine().split(" ");
      Folder parent = folderMap.get(Integer.parseInt(lines[0]));
      Folder sub = folderMap.get(Integer.parseInt(lines[2]));
      sub.parent = parent;
      parent.subFolders.add(sub);
    }

    List<Integer> notcool = findNotCoolCows(Q, folderMap);
    for (int c : notcool)
      System.out.print(c + " ");
    System.out.println();
  }

  private static List<Integer> findNotCoolCows(int Q, Map<Integer, Folder> folderMap) {
    // construct recursive hierarchy
    List<Integer> notcool = new ArrayList<>(20);
    List<Folder> leafFolders = new LinkedList<>();
    for (Folder f : folderMap.values()) {
      if (f.parent == null) {
        // parent folder
        passCows(f, null);
      }
      if (f.subFolders.isEmpty()) {
        // leaf nodes
        leafFolders.add(f);
      }
    }
    for (int i = 0; i < Q; ++i) {
      for (Folder f : leafFolders) {
        if (!f.cows.contains(i)) {
          notcool.add(i);
          break;
        }
      }
    }
    return notcool;
  }

  private static void passCows(Folder f, Set<Integer> cows) {
    if (f.isShared) {
      if (cows != null)
        f.cows.addAll(cows);
      // pass to the next
      for (Folder sub : f.subFolders) {
        passCows(sub, f.cows);
      }
    } else {
      // confidential
      // check next
      for (Folder sub : f.subFolders) {
        passCows(sub, null);
      }
    }
  }

  static class Folder {
    int id;
    boolean isShared;
    List<Folder> subFolders;
    Set<Integer> cows;
    Folder parent;

    Folder(int i, boolean share) {
      id = i;
      isShared = share;
      subFolders = new ArrayList<>();
      cows = new HashSet<>();
    }
  }

}
