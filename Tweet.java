import java.time.LocalDateTime;
public class Tweet implements Comparable<Tweet>
{
	private LocalDateTime tweetDate;//the date of the users tweet 
	private String userID;//the tweeters identification 
	private String tweet;//the tweeters actual message
	/** constructor that assigns all the instance variables to its   value
	 * @param uid
	 * @param aDate
	 * @param Tweet
	 */
	public Tweet(String uid, LocalDateTime aDate, String Tweet)
	{
		userID = uid;
		tweetDate = aDate;
		tweet = Tweet;
	}
	//returns the number of characters in the tweet
	public int numChars()
	{	
		int counter = tweet.length();
		return counter;
	}
	//returns the tweeters user identification
	public String getUserID()
	{
		return userID;
	}
	
	//returns the tweeters actual tweet 
	public String getTweetText()
	{
		return tweet;
	}
	//returns when the tweeter tweeted the message 
	public LocalDateTime getTweetDate()
	{
		return tweetDate;
	}
	public void setTweetText(String tweetText) 
	{
		this.tweet = tweetText;
	}

	public void setUserID(String userID) 
	{
		this.userID = userID;
	}
	public String toString()
	{
		return "Date: " + tweetDate + "User: " + userID + "\n" + "Text: " + tweet;
	}
	@Override
	public int compareTo(Tweet other) 
	{
		return(getUserID().compareTo(other.getUserID()));
		
	}
	
	
}
