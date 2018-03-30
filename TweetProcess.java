import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**This class utilizes the read method in the TweetReader class to analyze the tweets2 txt file
 * and figure out how many characters are in the file, what is the average number of charaters and who 
 * has the shortest tweet
 * @author Jordan Morin
 *
 */
public class TweetProcess 
{
	public static void main(String[] args)   
	{	
		double charCounter = 0;
		double counter = 0;
		double avgLength = 0;
		int finder;
		int current = 140;
		String user = "";
		/** Reads in the file and uses a loop with algorithms to figure out the assigned tasks
		 */
		File inFile = new File("tweets2.txt");
		try 
		{
			Scanner in = new Scanner(inFile);
			TweetReader reader = new TweetReader();
			Tweet tweet= reader.read(in);	
			while(!(tweet == null))
			{
				finder = tweet.numChars();
				counter++;
				charCounter = charCounter + tweet.numChars();
				avgLength = charCounter / counter;
				if(current > finder)
				{
					current = finder;
					user = tweet.getUserID();
				}

				tweet = reader.read(in);
			}
			System.out.println("The amount of characters in the tweets are: " + charCounter);
			System.out.println("The average number of characters are: " + avgLength);
			System.out.println("The shortest tweet was sent by " + user + " and is " + current + " characaters long");

		} catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
