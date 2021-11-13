/**
 * 
 */
package application;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import model.DatabaseConnectFunctions;
import model.MovieQuoteData;
import model.QuotixDB;


/**
 * @author ChipmanJustin
 * @author Jacob Skenandore
 */
public class Main {

  /**
   * @param args 
   */
  public static void main(String[] args) throws ParseException {
    // TODO Auto-generated method stub

      
      try {
	    //test connection (QuotixDB)-------------------------------------------------------------------------------------------
		QuotixDB.getConnection();
		System.out.println("connection success");
		//---------------------------------------------------------------------------------------------------------------------
		
		System.out.println();//formatting
		
		//TEST: getting the quote by entering the id number of the quote (DatabaseConnectFunctions and MovieQuoteData)---------
		DatabaseConnectFunctions test1 = new DatabaseConnectFunctions();
		final int id = 13;
		MovieQuoteData qData1 = test1.getQbyId(id);//get quote and data with the id passed in (in this case 1)
		System.out.println("ID = " + qData1.getId() + "     Quote = " + qData1.getQuote());//print out the id and the quote for proof
		//----------------------------------------------------------------------------------------------------------------------
		
		System.out.println();//formatting
		
		//TEST: Getting a quote by entering the quote/string (DatabaseConnectFunctions and MovieQuoteData)----------------------
		DatabaseConnectFunctions test2 = new DatabaseConnectFunctions();
		final String quote = "No, I am your father";
		MovieQuoteData qData2 = test2.getQbyString(quote);//get the quote entered (if the quote exists in DB)
		
		if(qData2 != null) {
			System.out.println("ID = " + qData2.getId() + "     Quote = " + qData2.getQuote());
		}
		//----------------------------------------------------------------------------------------------------------------------
		
		//System.out.println();//formatting
		
		//TEST: Sending a quote to the database (DatabaseConnectFunctions and MovieQuoteData)-----------------------------------
		/*Note: change the end point of this comment block to below the "--" when done testing this function
		DatabaseConnectFunctions test3 = new DatabaseConnectFunctions();
	
		String dAdded = "2021-11-04";//whatever today's date is (change this if not today's date)
		Date dateAdded = Date.valueOf(dAdded); //will be the same as date modified too
		final int notID = 0;//an auto incremented id will be created went the statement is sent to DB so doesn't matter what is put for id
		
		MovieQuoteData qData3 = new MovieQuoteData(notID, "Changed this from inside the code - yay!", "Jacob", "Jacob Skenandore", 
				"Quotix DB Send From Code", "Code/Test", 2021, 1.00, null, 1, dateAdded, dateAdded);
		
		boolean successfulSend = test3.sendQandDataToDB(qData3);
		System.out.println("The quote was inserted into the database?: " + successfulSend);//true if it was
		
		*/
		//----------------------------------------------------------------------------------------------------------------------
		
		//System.out.println();//formatting
		
		//TEST: Updating a quote and its data (DatabaseConnectFunctions and MovieQuoteData)-------------------------------------
		/*Note: change the end point of this comment block to just above the "--" when done testing this function
		DatabaseConnectFunctions test4 = new DatabaseConnectFunctions();
		final int idForMovie = 13;//id for the quote being tested on
		
		////////////////
		// 1.) get the original quote information 
		// 2.) create an updated quote and/or any other data related to the original
		// 3.) pass the two into the update function
		////////////////
		  
		MovieQuoteData qData4 = test4.getQbyId(idForMovie);//original movie quote and data
		
		final Date dateAdded = null;//do not want to change the date a quote was added
		String dModified = "2021-11-05";//must be the current date (needs to change no matter what as we're updating)
		Date dateModified = Date.valueOf(dModified);
		MovieQuoteData qUpdateData = new MovieQuoteData(idForMovie, "Changed this from inside the code - yay!", "", "", "", "", null, 0, null, 
				null, dateAdded, dateModified);
		
		boolean successfulUpdate = test4.updateQandDataToDB(qData4, qUpdateData, idForMovie);//true if the update to the database was successful
		System.out.println("The database was updated: " + successfulUpdate);
		
		*/
		//--------------------------------------------------------------------------------------------------------------------
		
		System.out.println();//formatting
		
		//TEST: Program "interface" (DatabaseConnectFunctions and MovieQuoteData)---------------------------------------------
		/*Note: change the end point of this comment block to just above the "--" when done testing this function */
		DatabaseConnectFunctions test5 = new DatabaseConnectFunctions();
		System.out.println("Enter a quote to be searched: ");//prompt user
		Scanner console = new Scanner(System.in);
		String qToSearchFor = console.nextLine();//get the entered quote 
		
		MovieQuoteData qData5 = test5.getQbyString(qToSearchFor);//search for the entered quote in the database
		if(qData5 != null) {//if the quote exists in the DB then show its id and the actual quote
			System.out.println("ID = " + qData5.getId() + "     Quote = " + qData5.getQuote() 
			+ "     Character = " + qData5.getMovieCharacter() + "     Actor = " + qData5.getActor() 
			+ "     Movie = " + qData5.getMovieTitle() + "     Genre = " + qData5.getMovieGenre() 
			+ "     Release Year = " + qData5.getReleaseYear() + "     Runtime = " + qData5.getRuntime() + " hrs"
			+ "     Poster = " + qData5.getImage() + "     Visits = " + qData5.getVisits()
			+ "     Day Added = " + qData5.getDateAdded() + "     Date Last Modified = " + qData5.getLastModified());
		}
		
		
		//--------------------------------------------------------------------------------------------------------------------
		
		System.out.println();//formatting
		
    } catch (ClassNotFoundException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    } catch (SQLException e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    }  
      
  
  }

}
