import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
public class TweetList 
{
	private ArrayList<Tweet> list = new ArrayList<Tweet>();
	
		public void add(Tweet tweet)
		{
			list.add(tweet);
		}
		public Tweet findShortest()
		{
			Tweet mine = list.get(0);
			for(Tweet tweets : list)
			
				if(mine.getTweetText().length() > tweets.getTweetText().length())
					mine = tweets;
						
			return mine;
					
		}
		public ArrayList<Tweet> findAllBySender(String user)
		{
			ArrayList<Tweet> matches = new ArrayList<Tweet>();
			for (Tweet currTweet : list)
				if (currTweet.getUserID().equals(user))
					matches.add(currTweet);
			
			return matches;
		}
		public int howManyByDate(LocalDate dt)
		{
			int count = 0;
			for (Tweet currTweet : list)
			{
				LocalDate currDate = currTweet.getTweetDate().toLocalDate();
				if (currDate.equals(dt))
					count++;
			}
			return count;
		}
		public String toString()
		{
			String newline = System.getProperty("line.separator");
			String retStr="";
			for (Tweet currTweet : list)
				retStr = retStr + currTweet + newline;
			
			return retStr;
		}
		public ArrayList<Tweet> sortByName()
		{
			ArrayList<Tweet> myList = new ArrayList<Tweet>(list);
			Collections.sort(myList);
			return myList;
		}
		
}
