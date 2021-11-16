package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import model.MovieQuoteData;

class TestMovieQuoteData {
	//Date information for the quote being used to test methods
	String dAdded = "2021-10-24";
	Date dateAdded = Date.valueOf(dAdded);
	String dModified = "2021-10-24";
	Date lastModified = Date.valueOf(dModified);
	
	//An example of a movie quote that is in the database currently
	MovieQuoteData testData = new MovieQuoteData(6, "Here's Johny!", "Jack Torrance", "Jack Nicholson", "The Shining", "Horror/Drama", 1980, 2.43, null, 1, dateAdded, lastModified);

	@Test //@Test1
	void testGetId() {//Test to see if it gets the correct Id
		boolean idMatches = false;
		
		if(testData.getId() == 6) {
			idMatches = true;
		}
		
		assertTrue(idMatches);
	}
	
	@Test //@Test2
	void testGetQuote() {//Test to see if it gets the correct quote
		boolean quoteMatches = false;
		
		if(testData.getQuote() == "Here's Johny!") {
			quoteMatches = true;
		}
		
		assertTrue(quoteMatches);
	}
	
	@Test //@Test3
	void testGetCharacter() {//Test to see if it gets the correct character
		boolean charMatches = false;
		
		if(testData.getMovieCharacter() == "Jack Torrance") {
			charMatches = true;
		}
		
		assertTrue(charMatches);
	}
	
	@Test //@Test4
	void testGetActor() {//Test to see if it gets the correct actor/actress
		boolean actorMatches = false;
		
		if(testData.getActor() == "Jack Nicholson") {
			actorMatches = true;
		}
		
		assertTrue(actorMatches);
	}
	
	@Test //@Test5
	void testGetMovieTitle() {//Test to see if correct Movie Title
		boolean movieTitleMatches = false;
		
		if(testData.getMovieTitle() == "The Shining") {
			movieTitleMatches = true;
		}
		
		assertTrue(movieTitleMatches);
	}
	
	@Test //@Test6
	void testGetGenre() {//Test to see if correct Movie genre
		boolean genreMatches = false;
		
		if(testData.getMovieGenre() == "Horror/Drama") {
			genreMatches = true;
		}
		
		assertTrue(genreMatches);
	}
	
	@Test //@Test7
	void testGetReleaseYear() {//Test to see if it returns the correct movie release year
		boolean yearMatches = false;
		
		if(testData.getReleaseYear() == 1980) {
			yearMatches = true;
		}
		
		assertTrue(yearMatches);
	}
	
	@Test //@Test8
	void testGetRuntime() {//Test to see if it returns correct runtime for the movie
		boolean runtimeMatches = false;
		
		if(testData.getRuntime() == 2.43) {
			runtimeMatches = true;
		}
		
		assertTrue(runtimeMatches);
	}
	
	@Test //@Test9
	void testGetImage() {//Test to see if it returns the correct blob (in this case it is null for simplicity)
		boolean blobMatches = false;
		
		if(testData.getImage() == null) {
			blobMatches = true;
		}
		
		assertTrue(blobMatches);
	}
	
	@Test //Test10
	void testGetVisits() {//Test to see if the correct amount of visits return
		boolean numOfVisitsMatch = false;
		
		if(testData.getVisits() == 1) {
			numOfVisitsMatch = true;
		}
		
		assertTrue(numOfVisitsMatch);
	}
	
	@Test //Test11
	void testGetDateAdded() {//Test to see if it matches the correct date the quote was added
		boolean dateAddedMatches = false; 
		
		if(testData.getDateAdded() == dateAdded) {
			dateAddedMatches = true;
		}
		
		assertTrue(dateAddedMatches);
	}
	
	@Test //Test12
	void testGetLastModified() {//Test to see if the get function returns the correct last modified date
		boolean lModifiedMatches = false;
		
		if(testData.getLastModified() == lastModified) {
			lModifiedMatches = true;
		}
		
		assertTrue(lModifiedMatches);
	}
	
	//Could test all setters if found that is needed (currently not needed)

}
