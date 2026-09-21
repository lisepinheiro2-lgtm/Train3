package Train3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[][] numbers = {
			    {4, 4, 2, -1, 2, 7},
			    {5, 1, 5, 9, -20},
			    {3, 3, 3, 8, 8, 10},
			    {},
			    {-1, -2, -3},
			    {6, 6, 2, 1, 1}
			};

			System.out.println(Tra.rowWithMostDistinctPositives(numbers));
		
	}
} 