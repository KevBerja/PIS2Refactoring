package videostore;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class TestsVideoStore {

		// Movies
		private Movie fastandfurious;
		private Movie up;
		private Movie titanic;

		// Rentals

		private Rental rFastandfurious;
		private Rental rUp;
		private Rental rTitanic;

		// Customers
		private Customer david;
		private Customer alberto;

		@Before

		public void setUp() {

			//Movies
			fastandfurious = new Movie("Fast and Furious 8", Movie.NEW_RELEASE);
			up = new Movie("Up", Movie.CHILDRENS);
			titanic = new Movie("Titanic", Movie.REGULAR);

			//Rentals
			rFastandfurious = new Rental(fastandfurious, 4);
			rUp = new Rental(up, 7);
			rTitanic = new Rental(titanic, 10);

			//Customers
			david = new Customer("David");
			alberto = new Customer("Alberto");
		}

		@Test
		public void testGetTitleMovie() {
			String movieTitle = "";
			Movie movie = this.fastandfurious;
			movieTitle = "Fast and Furious 8";
			
			assertEquals(movie.getTitle(), movieTitle);

		}
		
		@Test
		public void testGetCustomerName() {
			String customer = "";
			Customer cust = this.alberto;
			customer = "Alberto";
			
			assertEquals(cust.getName(), customer);
		}
		
		@Test

		public void testGetRentalMovie() {
			String movie = "";
			Rental rental = this.rUp;
			movie = rental.getMovie().getTitle();
			
			assertEquals("Up", movie);
		}
		
		@Test
		public void testCustomerNoStatement() {
			String statement = "";
			Customer customer = this.david;
			statement = customer.statement();
			
			assertEquals("Rental Record for David\nAmount owed is 0.0\nYou earned 0 frequent renter points", statement);
		}
		
		@Test
		public void testAddRentalToCustomer() {
			String rental = "";
			this.david.addRental(rUp);
			rental = this.david.statement();

			assertEquals("Rental Record for David\n\tUp\t7.5\nAmount owed is 7.5\nYou earned 1 frequent renter points", rental);
		}
		
		@Test
		public void testCustomersStatement() {
			String statement = "";
			Customer[] customers = new Customer[2];
			customers[0] = this.david;
			customers[1] = this.alberto;
			
			david.addRental(rFastandfurious);
			david.addRental(rTitanic);
			alberto.addRental(rUp);
			
			for (int i = 0; i < customers.length; i++) {
				statement += customers[i].statement();
				if (i < customers.length - 1)
					statement += "\n\n";
			}
			assertEquals("Rental Record for David\n\tFast and Furious 8\t12.0\n\tTitanic\t14.0\nAmount owed is 26.0\nYou earned 3 frequent renter points\n\nRental Record for Alberto\n\tUp\t7.5\nAmount owed is 7.5\nYou earned 1 frequent renter points", statement);
		}	
		
		@Test
		public void testCustomerStatementHTML() {
			String statementHTML = "";
			
			Customer customer = this.alberto;
			alberto.addRental(rTitanic);
			
			statementHTML = customer.htmlStatement();

			assertEquals("<H1>Rentals for <EM>Alberto</EM></H1><P>\nTitanic: 14.0<BR>\n<P>You owe <EM>14.0</EM><P>\nOn this rental you earned <EM>1</EM> frequent renter points<P>", statementHTML);
		}

		@Test
		public void testMoviePriceCode() {
			Movie movie = new Movie("Bebe jefazo", 1);
			int price = movie.getPriceCode();
			
			assertEquals(price, 1);
		}
		
		@Test

		public void testDaysRented() {
			Rental rental = this.rFastandfurious;
			int days = rental.getDaysRented();
			
			assertEquals(days, 4);

		}
}
