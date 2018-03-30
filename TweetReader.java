import java.util.Scanner; 
import java.time.LocalDateTime;
import java.io.File;
import java.util.StringTokenizer;
import java.text.ParseException;
import java.time.LocalDate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;
/** imports two text files, one with multiple tweets and one with zero tweets and breaks
 * them up into individual tokens
 * @author Jordan Morin
 *
 */
public class TweetReader 
{
	
	public Tweet read(Scanner in)
	{
		if(!in.hasNextLine())
			return null;
		String line = in.nextLine();
		StringTokenizer tokenizer = new StringTokenizer(line, "\t");
		String userID = tokenizer.nextToken();
		String tweetDate = tokenizer.nextToken();
		//turns the String tweetDate into a LocalDateTime variable
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss xxxx yyyy");
		LocalDateTime tweetTime = LocalDateTime.parse(tweetDate, formatter);
		String tweetTxt = tokenizer.nextToken();
		Tweet myTweet = new Tweet(userID , tweetTime, tweetTxt);
		myTweet.setUserID(userID);
		myTweet.setTweetText(tweetTxt);
		return myTweet;
	}
}
