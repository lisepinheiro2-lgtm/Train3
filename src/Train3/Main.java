package Train3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		ArrayList<Movie> movies = new ArrayList<>();

		movies.add(new Movie("Avatar", 162, 8.1));
		movies.add(new Movie("Alien", 117, 8.5));
		movies.add(new Movie("Arrival", 116, 7.9));

		movies.add(new Movie("Titanic", 195, 8.8));
		movies.add(new Movie("Terminator", 107, 8.4));

		movies.add(new Movie("Matrix", 136, 9.5));
		System.out.println(Tra. bestMovieFromBestInitialGroup(movies));
	}
} 