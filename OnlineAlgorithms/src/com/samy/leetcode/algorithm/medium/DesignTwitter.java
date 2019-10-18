package com.samy.leetcode.algorithm.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/design-twitter/description/
 */
public class DesignTwitter {
}

class Twitter {
  Map<Integer, Set<Integer>> follow;
  Map<Integer, List<Post>> feeds;
  long timestamp = 0;
  /**
   * Initialize your data structure here.
   */
  public Twitter() {
    follow = new HashMap<>();
    feeds = new HashMap<>();
  }

  /**
   * Compose a new tweet.
   */
  public void postTweet(int userId, int tweetId) {
    List<Post> list = feeds.getOrDefault(userId, new ArrayList<>());
    list.add(new Post(tweetId));
    feeds.put(userId, list);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    PriorityQueue<Post> que = new PriorityQueue<>(new Comparator<Post>() {
      @Override
      public int compare(Post p1, Post p2) {
        return (int) (p2.time - p1.time);
      }
    });

    Set<Integer> follower = follow.get(userId);
    if (follower != null) {
      for (int uid : follower) {
        List<Post> l = feeds.get(uid);
        if (l != null) {
          que.addAll(l);
        }
      }
    }
    List<Post> l = feeds.getOrDefault(userId, new ArrayList<>());
    que.addAll(l);
    List<Integer> list = new ArrayList<>();
    int i = 0;
    while (!que.isEmpty() && i++ < 10) {
      list.add(que.poll().tid);
    }
    return list;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    if (followerId == followeeId)
      return;
    Set<Integer> follower = follow.getOrDefault(followerId, new HashSet<>());
    follower.add(followeeId);
    follow.put(followerId, follower);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    if (followerId == followeeId)
      return;
    Set<Integer> follower = follow.getOrDefault(followerId, new HashSet<>());
    follower.remove(followeeId);
    follow.put(followerId, follower);
  }

  class Post {
    int tid;
    long time;

    Post(int id) {
      tid = id;
      time = timestamp++;
    }
  }
}
