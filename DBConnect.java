package application;

import java.sql.*;
import java.time.LocalDate;


public class DBConnect {
	
	// made these static as I'm not going to be creating an object of the DBConnect class.
	private static Connection connObj = null;
	private static Statement stmt = null;
	
	
	public static void connectToDB() {
		try {
			// Database params
			// Provided an absolute path.
			String url = "jdbc:sqlite:/home/nthuser/eclipse-workspace/fx_test/sqlite/db/testDB.db";
			// Creating a connection object and passing it the url to the database.
			connObj = DriverManager.getConnection(url);
			
			System.out.println("Connection to SQLite has been established!");
			
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(connObj == null) {
					connObj.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	
	// method to create the table I'll be using for the database.
	public void createTable() {
		try {
			// test connection to DB
			connectToDB();
			
			// Create Table Statement
			stmt = connObj.createStatement();
			String createTableVaccine = "CREATE TABLE VACCINE " +
                    					"(ID INT PRIMARY KEY NOT NULL," +
                    					"NAME TEXT NOT NULL, " + 
                    					"PHONE TEXT NOT NULL, " + 
                    					"VACCINE NAME CHAR(50) NOT NULL, " + 
                    					"EFFICACY INT, " +
                    					"FIRST DOSE DATE DATE, " + 
                    					"SECOND DOSE DATE DATE)";
			stmt.executeUpdate(createTableVaccine);
			stmt.close();
			connObj.close();
			System.out.println("Table created successfully!");
//			ResultSet rs = stmt.executeQuery(])
			
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(connObj == null) {
					connObj.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	
	// Performs connectToDB check first. Insert full client details(-secondDoseDate, has been hardcoded ftb) in DB
	public static void insertStatement(String id, clientName name, String phone, String vaccine, int efficacy, LocalDate firstDate) {
		try {
//			, LocalDate secondDate
			
			// test connection to DB
//			connectToDB();
			
			// Create Table Statement
			stmt = connObj.createStatement();
			
	        String sqlStmtInsert = "INSERT INTO VACCINE (ID, NAME, PHONE, VACCINE, EFFICACY, FIRST DOSE DATE, SECOND DOSE DATE) ";
	        String sqlStmtValues = "VALUES ('"+id+"', '"+name+"', '"+phone+"', '"+vaccine+"', '"+efficacy+"', '"+firstDate+"', '2021-08-28');";
	        
	        String fullSqlInsertStmt = sqlStmtInsert+sqlStmtValues;
	        System.out.println("SQL STATEMENT BELOW: ");
	        System.out.println(fullSqlInsertStmt);
	        
//	        stmt.executeUpdate(fullSqlInsertStmt);
//	        
//			stmt.close();
//			connObj.close();
//			System.out.println("Inserted ? successfully!");
////			ResultSet rs = stmt.executeQuery(])
			
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(connObj == null) {
					connObj.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	
	// Delete Statement
	public static void deleteStatement(String id) {
		// Delete Statement
		try {
			// test connection to DB
//			connectToDB();
			
			stmt = connObj.createStatement();
			
	        String sqlStmtDelete = "DELETE FROM VACCINE WHERE id='"+id+"';";
	        
	        System.out.println("SQL STATEMENT BELOW: ");
	        System.out.println(sqlStmtDelete);
	        
//	        stmt.executeUpdate(sqlStmtDelete);
//	        
//			stmt.close();
//			connObj.close();
//			System.out.println("Inserted ? successfully!");
//			// need to check this ResultSet rs???
//			ResultSet rs = stmt.executeQuery()
			
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(connObj == null) {
					connObj.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}

	
	// select statement
	public static void selectStatement(String id) {
		try {
//			, LocalDate secondDate
			
			// test connection to DB
//			connectToDB();
			
			// Create Table Statement
			stmt = connObj.createStatement();
			
//			SELECT * FROM Customers
//			WHERE Country='Mexico'; 
			
	        String sqlStmtSelect = "SELECT * FROM VACCINE WHERE ID='"+id+"';";
	        
	        System.out.println("SQL STATEMENT BELOW: ");
	        System.out.println(sqlStmtSelect);
	        
//	        stmt.executeUpdate(sqlStmtSelect);
//	        
//			stmt.close();
//			connObj.close();
//			System.out.println("Inserted ? successfully!");
//			ResultSet rs = stmt.executeQuery(])
			
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if(connObj == null) {
					connObj.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Used for testing the above methods.
	}

}
