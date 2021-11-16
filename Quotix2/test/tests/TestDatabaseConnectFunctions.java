package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.Test;

import model.DatabaseConnectFunctions;
import model.MovieQuoteData;

class TestDatabaseConnectFunctions {

	@Test //@Test1
	void testGetQbyId() {//Testing to see if the quote/data gotten by the Id entered is correct/not null
		boolean qByIdMatches = false;
		DatabaseConnectFunctions test1 = new DatabaseConnectFunctions();
		final int id = 2;
		MovieQuoteData qData1 = test1.getQbyId(id);
		
		//assuming that if the first three are correct, then the rest of fields are correct
		if(qData1.getId() == 2 && qData1.getQuote() == "No, I am your father" && qData1.getActor() == "James Earl Jones") {
			qByIdMatches = true;
		}
		
		assertTrue(qByIdMatches);
	}
	
	@Test //@Test2
	void testGetQbyString() {//Checking if the quote/data
		boolean qByStringMatches = false;
		DatabaseConnectFunctions test2 = new DatabaseConnectFunctions();
		final String quote = "No, I am your father";
		MovieQuoteData qData2 = test2.getQbyString(quote);
		
		if(qData2.getId() == 2 && qData2.getQuote() == "No, I am your father" && qData2.getActor() == "James Earl Jones") {
			qByStringMatches = true;
		}
		
		assertTrue(qByStringMatches);
	}

}
