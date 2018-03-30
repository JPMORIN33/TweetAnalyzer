import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
/** this class utilizes the tweetlist class and the tweetreader class to upload the tweets from the txt file into the list as well
 * as implement methods chosen via a menu that is selected by the user
 * @author jmori156
 *
 */
public class TweetMain 
{
	public static void main(String[] args)
	{
		TweetList myList = new TweetList();
		File inFile = new File("tweets2.txt");
		try 
		{
			Scanner kb = new Scanner(inFile);
			TweetReader reader = new TweetReader();
			Tweet tweet= reader.read(kb);	
			while(!(tweet == null))
			{
				myList.add(tweet);
				tweet= reader.read(kb);	
			} 	
		}
		catch (FileNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menu();
		Scanner in = new Scanner(System.in);
		String input;
		do
		{
			input = in.nextLine();
			if(input.equals("add"))
			{
				System.out.println("Enter your tweet txt");
				String tweet = in.nextLine();
				System.out.println("Enter your ID");
				String id = in.nextLine();
				Tweet newTweet = new Tweet(id , LocalDateTime.now() , tweet);
				myList.add(newTweet);
			}
			else if(input.equals("short"))
			{
				System.out.println(myList.findShortest());
			}
			else if(input.equals("find name"))
			{
				System.out.println("What is the users name");
				String ID = in.nextLine();
				System.out.println(myList.findAllBySender(ID));
			}
			else if(input.equals("date"))
			{
				System.out.println("Enter the date, Ex: 20161121 ");
				String line= in.nextLine();
				LocalDate date = LocalDate.parse(line, DateTimeFormatter.BASIC_ISO_DATE);
				System.out.print(myList.howManyByDate(date));
			}
			else if(input.equals("all"))
			{
				System.out.println(myList);
			}
			else if(input.equals("sort name"))
			{
				System.out.print(myList.sortByName());
			}
					
			else
			{
				System.out.println("Try again");
			}
			menu();
		}
		while(!(input.equals("quit")));
			in.close();	
	}
	public static void menu()
	{
		System.out.println("To add a tweet, enter add");
		System.out.println("To find and display the shortest tweet, enter short");
		System.out.println("To find a certain tweet from a certain user, enter find name");
		System.out.println("To find how many tweets were sent on a certain day, enter date");
		System.out.println("To display all the tweets, enter all");
		System.out.println("To sort by name, enter sort name");
		System.out.println("To quit, enter quit");
	}
}

