package de.htwsaar.model;

import java.util.Date;

import de.htwsaar.exception.model.TweetException;
import de.htwsaar.validator.model.TweetValidator;
import twitter4j.MediaEntity;
import twitter4j.Status;

public class Tweet {
	
	private   long tweetId; 
	private   long authorId;
	private   String text; 
	private   String place;
	private   int favoriteCount;
	private   int retweetCount;
	private   String image;
	private	  String language;
	protected Date createdAt; 
	
	public Tweet() {}

	/**
	 * Initializes a tweet object with information gained from the
	 * received status object.
	 * @param status
	 * @throws TweetException 
	 */
	public Tweet(Status status) throws TweetException {
		
		TweetValidator.checkStatus(status);		
		
		setTweetId(status.getId());
		setAuthorId(status.getUser());
		setText(status.getText());				
		setCreatedAt(status.getCreatedAt());
		setPlace(status.getPlace());
		setFavoriteCount(status.getFavoriteCount());
		setRetweetCount(status.getRetweetCount());
		setImage(status.getMediaEntities());
		setLanguage(status.getLang());
	}

	public long getTweetId() {
		return tweetId;
	}

	public void setTweetId(long tweetId) throws TweetException {		
		TweetValidator.checkTweetId(tweetId);		
		this.tweetId = tweetId;
	}

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) throws TweetException {
		TweetValidator.checkAuthorId(authorId);
		this.authorId = authorId;
	}
	
	public void setAuthorId(twitter4j.User user) throws TweetException {
		TweetValidator.checkUser(user);
		setAuthorId(user.getId());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) throws TweetException {
		text = TweetValidator.checkText(text);
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		createdAt = TweetValidator.checkCreatedAt(createdAt);
		this.createdAt = createdAt;
	}
	
	public long getAge( ) {
		return new Date().getTime() - getCreatedAt().getTime();
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		TweetValidator.checkPlace(place);
		this.place = place;
	}
	
	public void setPlace(twitter4j.Place place) {	
		if (place == null)
			setPlace("");
		else
			setPlace(place.getCountry());
	}

	public int getFavoriteCount() {
		return favoriteCount;
	}

	public void setFavoriteCount(int favoriteCount) {
		favoriteCount = TweetValidator.checkFavoriteCount(favoriteCount);
		this.favoriteCount = favoriteCount;
	}

	public int getRetweetCount() {
		return retweetCount;
	}

	public void setRetweetCount(int retweetCount) {
		retweetCount = TweetValidator.checkRetweetCount(retweetCount);
		this.retweetCount = retweetCount;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		image = TweetValidator.checkImage(image);
		this.image = image;
	}
	
	private void setImage(MediaEntity[] mediaEntities) {
		if (mediaEntities.length == 0)
			setImage("");
		else
			setImage(mediaEntities[0].getMediaURL());
	}
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	@Override
	public boolean equals(Object object) {
		if ( object instanceof Tweet ) {
			if ( ((Tweet) object).getTweetId() == getTweetId() )
				return true;
		}		
		return false;
			
	}

	@Override
	public String toString() {
		return "Tweet [tweetId=" + tweetId + ", authorId=" + authorId + ", text=" + text + ", place=" + place
				+ ", favoriteCount=" + favoriteCount + ", retweetCount=" + retweetCount + ", image=" + image
				+ ", language=" + language + ", createdAt=" + createdAt + "]";
	}
}
