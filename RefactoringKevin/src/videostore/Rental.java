package videostore;

class Rental {
	
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}
	
	double getCharge() {
		return _movie.getCharge(_daysRented);
	}
	
	int getFrequentRenterPoints(int daysRented) {
		if ((_movie.getPriceCode() == Movie.NEW_RELEASE) && daysRented > 1)
			return 2;
		else
			return 1;
	}
}
