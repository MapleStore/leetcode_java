package darren.gong.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Twitter355 {
  public static void main(String[] args) {
    Twitter355 twitter355 = new Twitter355();
    twitter355.postTweet(1,1);
    twitter355.getNewsFeed(1);
    twitter355.follow(2, 1);
    twitter355.getNewsFeed(2);
    twitter355.unfollow(2, 1);
    twitter355.getNewsFeed(2);
  }
  private Map<Integer, Deque<int[]>> userToTweets = new HashMap<>();
  private Map<Integer, Set<Integer>> targets = new HashMap<>();
  private int index = 0;
  /** Initialize your data structure here. */
  public Twitter355() {

  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    Deque<int[]> tweets = userToTweets.get(userId);
    if (tweets == null) {
      tweets = new ArrayDeque<>();
      userToTweets.put(userId, tweets);
    }
    if (tweets.size() >= 10) {
      tweets.removeFirst();
    }
    tweets.addLast(new int[]{userId, tweetId, ++index});
  }

  /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
  public List<Integer> getNewsFeed(int userId) {
    Set<Integer> oneTarget = targets.get(userId);
    if (oneTarget == null) {
      oneTarget = new HashSet<>();
      oneTarget.add(userId);
      targets.put(userId, oneTarget);
    }

    List<Integer> result = new LinkedList<>();
    PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b)->b[2]-a[2]);
    Map<Integer, Iterator<int[]>> followerToTweets = new HashMap<>();

    for (Integer followerId : oneTarget) {
      Deque<int[]> tweets = userToTweets.get(followerId);
      if (tweets != null && !tweets.isEmpty()) {
        followerToTweets.put(followerId, tweets.descendingIterator());
        priorityQueue.add(followerToTweets.get(followerId).next());
      }
    }

    for (int i = 0; i < 10 && !priorityQueue.isEmpty(); i++) {
      int[] info = priorityQueue.poll();
      result.add(info[1]);
      if (followerToTweets.get(info[0]).hasNext()) {
        priorityQueue.add(followerToTweets.get(info[0]).next());
      }
    }
    return result;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(int followerId, int followeeId) {
    if (followeeId == followerId) {
      return;
    }
    Set<Integer> oneTarget = targets.get(followerId);
    if (oneTarget == null) {
      oneTarget = new HashSet<>();
      oneTarget.add(followerId);
      targets.put(followerId, oneTarget);
    }
    oneTarget.add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(int followerId, int followeeId) {
    if (followeeId == followerId) {
      return;
    }
    Set<Integer> oneTargets = targets.get(followerId);
    if (oneTargets == null) {
      oneTargets = new HashSet<>();
      oneTargets.add(followerId);
      targets.put(followerId, oneTargets);
    }
    oneTargets.remove(followeeId);
  }
}
