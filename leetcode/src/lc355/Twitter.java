package lc355;

import java.util.*;

public class Twitter {
	
	private int timeStamp = 0;
	
	public class Tweet {
		Tweet next = null;
		public int id;
		public int stamp;
		public Tweet(int id) {
			this.id = id;
			this.stamp = timeStamp++;
		}
	}
	
	public class User {
		public int id;
		public Tweet tweets;
		public Set<Integer> followsId;
		public User(int id) {
			this.id = id;
			this.followsId = new HashSet<Integer>();
		}
		
		public void postTweet(int tweetId) {
			Tweet tweet = new Tweet(tweetId);
			tweet.next = tweets;
			tweets = tweet;
		}
		
		public void follow(int id) {
			this.followsId.add(id);
		}
		
		public void unfollow(int id) {
			this.followsId.remove(id);
		}

		public List<User> getFollowUsers() {
			List<User> ans = new ArrayList<User>();
			for (int userId : followsId) {
				ans.add(userMap.get(userId));
			}
			ans.add(this);
			return ans;
		}
	}
	
	private Map<Integer, User> userMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
        	userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        user.postTweet(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<Integer>();
        if (!userMap.containsKey(userId)) return ans;
    	User user = userMap.get(userId);
    	List<User> users = user.getFollowUsers();
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (Tweet t0, Tweet t1) -> {
        	return t1.stamp - t0.stamp;
        });
        for (User aUser : users) {
        	if (aUser.tweets != null) {
        		q.add(aUser.tweets);
        	}
        }
        while (q.size() > 0 && ans.size() < 10) {
        	Tweet aTweet = q.poll();
        	ans.add(aTweet.id);
        	if (aTweet.next != null) {
        		q.add(aTweet.next);
        	}
        }
        return ans;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
        	userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
        	userMap.put(followeeId, new User(followeeId));
        }
        if (followerId == followeeId) return;
        User follower = userMap.get(followerId);
        follower.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || !userMap.containsKey(followeeId) || !userMap.get(followerId).followsId.contains(followeeId)) {
        	return;
        }
        userMap.get(followerId).followsId.remove(followeeId);
    }
}