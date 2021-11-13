/**
 * 
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ChipmanJustin 
 * @author Jacob Skenandore
 *
 */
public class DatabaseConnectFunctions {
    
    Connection connection;//SQL connection
    private final String TABLE_NAME = "Movie_Quotes";//The name of the table on quotix database that is housing all quote data

    
    /**
     * @brief Takes an id and gets the quote and movie data related to that quote id number
     * @description Gets the quote and all the movie data related to that quote from the quotix database using the id
     * passed into this function that must equal one of the idMovie_Quotes numbers (in order to work) in the Movie_Quotes table 
     * and returns that quote/data.
     * 
     * @param id The id number of the quote
     * @return result The movie data related to the quote
     */
    public MovieQuoteData getQbyId(int id) {
		try {
		    connection = QuotixDB.getConnection();
		    String query = "Select * FROM Movie_Quotes WHERE idMovie_Quotes = ?;";
		    PreparedStatement statement = connection.prepareStatement(query);
	
		    statement.setInt(1, id);
		    System.out.println(statement);
	
		    ResultSet queryResult = statement.executeQuery();
		    queryResult.next();
		    
		    //get all the movie quote data related to the id number from DB and return it
		    MovieQuoteData result = new MovieQuoteData(
			    queryResult.getInt(1), 
			    queryResult.getString(2), 
			    queryResult.getString(3), 
			    queryResult.getString(4),
			    queryResult.getString(5), 
			    queryResult.getString(6), 
			    queryResult.getInt(7), 
			    queryResult.getDouble(8),
			    queryResult.getBlob(9), 
			    queryResult.getInt(10), 
			    queryResult.getDate(11), 
			    queryResult.getDate(12));
	
		   return result;//the quote with all the data related to the id number
	    } catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

    }//end of getMovieByID
    
    
    /**
     * @brief Will get the data related to a quote
     * @description Gets the quote and all the movie data related to that quote from the quotix database inside of
     * the Movie_Quotes table using the quote passed into this function as a param and returns that quote/data.
     * That is is the quote exists (and it was type in correctly) in the database.
     * 
     * @param quote The movie quote to be grabbed from the database
     * @return quoteDataByString The quote with all its relevant movie data
     */
    public MovieQuoteData getQbyString(String quote) {
    	try {
		    connection = QuotixDB.getConnection();
		    String query = "Select * FROM Movie_Quotes WHERE Quote = ?;";
		    PreparedStatement statement = connection.prepareStatement(query);
	
		    statement.setString(1, quote);
		    System.out.println(statement);
	
		    ResultSet queryResult = statement.executeQuery();
		    queryResult.next();
	
		    // System.out.println(queryResult.getInt(1));//testing purposes
		    // System.out.println(queryResult.getString(2));//testing purposes
	
		    MovieQuoteData quoteDataByString = new MovieQuoteData(
			    queryResult.getInt(1), 
			    queryResult.getString(2),
			    queryResult.getString(3), 
			    queryResult.getString(4), 
			    queryResult.getString(5),
			    queryResult.getString(6), 
			    queryResult.getInt(7), 
			    queryResult.getDouble(8), 
			    queryResult.getBlob(9),
			    queryResult.getInt(10),
			    queryResult.getDate(11), 
			    queryResult.getDate(12));
	
		    return quoteDataByString;
	  
	    } catch (SQLException e) {
	    	// e.printStackTrace();
    		System.out.println("Quote Not Found due to SQL issue");
    		return null;
    	} catch (Exception e) {
		    // e.printStackTrace();
		    System.out.println("Quote Not Found");
		    return null;
    	}

    }
    
    
    /**
     * @brief Sends the quote and its data to the quotix database to be added to the Movie_Quotes table
     * @description Takes the quote and its data that has been passed into this function and inserts it into the quotix database.
     * More specifically, it inserts the quote and all the movie quote data entered into the Movie_Quotes table.
     * 
     * @param qData The quote and its data to be sent to the database to be added to it
     * @return true If the insert succeeded
     * @return false
     */
    public Boolean sendQandDataToDB(MovieQuoteData qData) {
    	try {
		    connection = QuotixDB.getConnection();
		    String query = "INSERT INTO Movie_Quotes (Quote, CharName, ActorName, MovieName, "
			    + "Genre, ReleaseYear, Length, Image, Visits, DayAdded, LastModified) "
			    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		    PreparedStatement statement = connection.prepareStatement(query);
	
		    /*
		     * Example INSERT INTO statement that works on MySQL workbench INSERT INTO
		     * Movie_Quotes (Quote, CharName, ActorName, MovieName, Genre, ReleaseYear,
		     * Length, Image, Visits, DayAdded, LastModified) VALUES ("Why so serious?",
		     * "The Joker", "Heath Ledger", "The Dark Knight", "Action/Crime", 2008, 2.53,
		     * NULL, 1, "2021-11-3", "2021-11-3");
		     */
	
		    //System.out.println(statement);//should have the question marks or NOT SPECIFIED first 
	
		    statement.setString(1, qData.getQuote());// Quote
		    statement.setString(2, qData.getMovieCharacter());// Character Name
		    statement.setString(3, qData.getActor());// Actor/actress name
		    statement.setString(4, qData.getMovieTitle());// Movie Name
		    statement.setString(5, qData.getMovieGenre());// Movie genre(s)
		    statement.setInt(6, qData.getReleaseYear());// release year for movie
		    statement.setDouble(7, qData.getRuntime());// Length of the movie
		    statement.setBlob(8, qData.getImage());// The movie poster
		    statement.setInt(9, qData.getVisits());// Number of times it has been viewed
		    statement.setDate(10, qData.getDateAdded());// Today's date (as this is creating a new one)
		    statement.setDate(11, qData.getLastModified());// Today's date
	
		    System.out.println(statement);// should have everything inserted above
	
		    int rowsAffected = statement.executeUpdate();// has to be executeUpdate for inserting, updating, or deleting
	
		    // System.out.println("Number of rows affected: " + rowsAffected);//testing
		    // purposes
		    // System.out.println(qData.getQuote());//testing purposes
		    // System.out.println(qData.getLastModified());//testing purposes
	
		    if (rowsAffected == 1) {// only one row should be changed here as we are inserting one quote and its data
		    	return true;
		    } 
		    else {// otherwise something went wrong
		    	return false;
		    }

    	} catch (SQLException e) {
    		e.printStackTrace();
    		return null;
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }
    
    
    /**
     * @brief Sends the updated quote(s) with the new field values to the database
     * @description Updates the quote or quotes with a new value for every field passed into this function where each entry has
     * (or doesn't have) certain field value(s).
     * 
     * @param qData The quote and all its data that is/are to be changed/updated
     * @param qUpdateData The values to compare with the original to determine which fields need to be updated (quote, character, etc)
     * @param id The id number assigned to the quote passed into this function that shall be updated
     * @return true If there was at least one row affected with the update statement passed
     * @return false If no rows were affected or an exception of some sort was issued
     */
    public Boolean updateQandDataToDB(MovieQuoteData qData, MovieQuoteData qUpdateData, int id) {
    	try {
    	    connection = QuotixDB.getConnection(); 
    	    String query = "UPDATE Movie_Quotes SET Quote = ?, CharName = ?, ActorName = ?, MovieName = ?, "
    		    + "Genre = ?, ReleaseYear = ?, Length = ?, Image = ?, Visits = ?, DayAdded = ?, LastModified = ?"//Where '?' are all the fields to be updated
    		    + " WHERE idMovie_Quotes = ?;";//Where '?' is the quote to be changed
    	    PreparedStatement statement = connection.prepareStatement(query);

		    /*
		     * Example UPDATE statement that works on MySQL workbench UPDATE Movie_Quotes
		     * SET Quote = "Test update inside SQL" where idMovie_Quotes = 13;
		     */
	
		    // System.out.println(statement);//should have the question marks first
	
		    /*
		     * Set the fields that need changing (Assume that the new values are not equal
		     * already - for if they are it will just be the original quote or data that was
		     * there)
		     */
	
		    // Quote
		    // might be able to make this smarter
		    if(qUpdateData.getQuote() == null || qUpdateData.getQuote() == "") {
		    	statement.setString(1, qData.getQuote());// set it equal to the original (make no changes)
		    } else {
		    	statement.setString(1, qUpdateData.getQuote());// otherwise set the new value
		    }
	
		    // Character name
		    if (qUpdateData.getMovieCharacter() == null || qUpdateData.getMovieCharacter() == "") {
		    	statement.setString(2, qData.getMovieCharacter());
		    } else {
		    	statement.setString(2, qUpdateData.getMovieCharacter());
		    }
	
		    // Actor/actress name
		    if (qUpdateData.getActor() == null || qUpdateData.getActor() == "") {
		    	statement.setString(3, qData.getActor());
		    } else {
		    	statement.setString(3, qUpdateData.getActor());
		    }
	
		    // Movie title/name
		    if (qUpdateData.getMovieTitle() == null || qUpdateData.getMovieTitle() == "") {
		    	statement.setString(4, qData.getMovieTitle());
		    } else {
		    	statement.setString(4, qUpdateData.getMovieTitle());
		    }
	
		    // Movie genre(s)
		    if (qUpdateData.getMovieGenre() == null || qUpdateData.getMovieGenre() == "") {
		    	statement.setString(5, qData.getMovieGenre());
		    } else {
		    	statement.setString(5, qUpdateData.getMovieGenre());
		    }
	
		    // Release year
		    if (qUpdateData.getReleaseYear() == null || qUpdateData.getReleaseYear() == 0) {
		    	statement.setInt(6, qData.getReleaseYear());
		    } else {
		    	statement.setInt(6, qUpdateData.getReleaseYear());
		    }
	
		    // Runtime
		    if (qUpdateData.getRuntime() == 0) {
		    	statement.setDouble(7, qData.getRuntime());
		    } else {
		    	statement.setDouble(7, qData.getRuntime());
		    }
	
		    // Blob
		    if (qUpdateData.getImage() == null) {
		    	statement.setBlob(8, qData.getImage());
		    } else {
		    	statement.setBlob(8, qUpdateData.getImage());
		    }
	
		    // Visits
		    if (qUpdateData.getVisits() == null || qUpdateData.getVisits() == 0) {
		    	statement.setInt(9, qData.getVisits());
		    } else {
		    	statement.setInt(9, qData.getVisits());
		    }
	  		   
		    // Date added
		    statement.setDate(10, qData.getDateAdded());// Will not change (or should never update)
	
		    // Date last modified
		    statement.setDate(11, qUpdateData.getLastModified());// Today's date that the update was sent
	
		    // where the idMovie_Quotes is the id (passed in as param)
		    statement.setInt(12, id);// set the rows or columns to have those changes
	
		    // System.out.println(statement);//testing purposes - should have everything
		    // inserted above
	
		    int rowsAffected = statement.executeUpdate();// number of rows affected by updating
	
		    // System.out.println("Number of rows affected: " + rowsAffected);//testing
		    // purposes
	
		    if (rowsAffected != 0) {// should be at least one row affected (updated)
		    	return true;
		    } 
		    else {// otherwise something went wrong
		    	return false;
		    }
	
	    } catch (SQLException e) {
		    e.printStackTrace();
		    return null;
	    } catch (Exception e) {
		    e.printStackTrace();
		    return null;
		}
    }
    
}
