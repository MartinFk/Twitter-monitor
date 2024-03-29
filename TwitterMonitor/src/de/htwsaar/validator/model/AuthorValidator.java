package de.htwsaar.validator.model;

import de.htwsaar.exception.model.AuthorException;
import twitter4j.Status;

public class AuthorValidator {

	public static void checkStatus(Status status) throws AuthorException {		
		if ( status == null )
			throw new AuthorException();		
		if ( status.getUser() == null )
			throw new AuthorException();		
	}

	public static void checkId(long id) throws AuthorException {
		if ( id < 0 )
			throw new AuthorException();
	}

	public static String checkName(String name) {		
		if ( name == null )
			name = "";		
		if ( name.length() > 14 )
			name = name.substring(0, 14);		
		return name;
	}

	public static String checkScreenName(String screenName) {
		if ( screenName == null )
			screenName = "";		
		if ( screenName.length() > 19 )
			screenName = screenName.substring(0, 19);		
		return screenName;
	}

	public static int checkFollowerCount(int followerCount) {
		if ( followerCount < 0 )
			followerCount = 0;
		return followerCount;
	}

	public static int checkFavoriteCount(int favoriteCount) {
		if ( favoriteCount < 0 )
			favoriteCount = 0;
		return favoriteCount;
	}

	public static String checkPictureUrl(String pictureUrl) {
		if ( pictureUrl == null )
			pictureUrl = "";		
		if ( pictureUrl.length() > 99 )
			pictureUrl = pictureUrl.substring(0, 99);		
		return pictureUrl;
	}

}
