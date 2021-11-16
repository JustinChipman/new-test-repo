package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import model.QuotixDB;

class TestQuotixDB {

	@Test //@Test1
	void testGetConnection() throws ClassNotFoundException, SQLException {
		
		boolean connectSuccess = false;
		if(QuotixDB.getConnection() != null) {
			connectSuccess = true;
		}
		
		assertTrue(connectSuccess);
			
	}

}
