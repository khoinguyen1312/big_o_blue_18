package heap;

import java.util.Scanner;

public class RoyAndTrendingTopics {
	class Topic {
		Integer id;
		Integer currentScore;
		Integer posts;
		Integer likes;
		Integer comments;
		Integer shares;
		
		Topic(Integer id, 
				Integer currentScore,
				Integer posts,
				Integer likes,
				Integer comments,
				Integer shares) {
			this.id = id;
			this.currentScore = currentScore;
			this.posts = posts;
			this.likes = likes;
			this.comments = comments;
			this.shares = shares;
		}
		
		public int calculatedScore() {
			return this.currentScore;
			
		}
	}
	
	public static void main(String[] args) {
    	Scanner argumentScanner = new Scanner(System.in);
	
		int numberOfTopic = argumentScanner.nextInt();
		
		for (int i = 0; i < numberOfTopic; i++) {
			
		}
	}
}
