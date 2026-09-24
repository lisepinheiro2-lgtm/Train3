package Train3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		int[][] numbers = {
			    {4, 4, 2, 2, 7},      // 4 et 2 répétés → 2
			    {5, 5, 5, 1, 9, 9},   // 5 et 9 répétés → 2
			    {3, 3, 8, 8, 10, 10}, // 3, 8, 10 → 3
			    {1, 2, 3},             // 0
			    {}
			};

			System.out.println(Tra.rowWithMostRepeatedValues(numbers));
	}
}
