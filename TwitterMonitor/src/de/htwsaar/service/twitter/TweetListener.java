package de.htwsaar.service.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * @author philipp
 *
 * Der TweetListener hoert den Stream nach neuen Tweets ab und schreibt (zunaechst ausnahmslos alle) Tweets in
 * die Datenbank.
 */

@Component("tweetListener")
public class TweetListener implements StatusListener {
			
	private StatusService statusService;
					
	public TweetListener() {}
	
	@Autowired
	public void setStatusService(StatusService statusService) {
		this.statusService = statusService;
	}


	/* (non-Javadoc)
	 * Triggers the tweetService to insert Objects into the
	 * database whenever a status object is received
	 * @see twitter4j.StatusListener#onStatus(twitter4j.Status)
	 */
	@Override
	public void onStatus(Status status) {
		statusService.insertStatus(status);
	}

	@Override
	public void onException(Exception arg0) {
		System.out.println("onException: " + arg0.getMessage());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		System.out.println("StatusDeletionNotice: " + arg0);
	}

	@Override
	public void onScrubGeo(long arg0, long arg1) {
		System.out.println("onScrubGeo: " + arg0 + ", " + arg1);
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		System.out.println("onStallWarning: " + arg0.getMessage());
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		System.out.println("onTrackLimitationNotice: " + arg0);
	}	

}
