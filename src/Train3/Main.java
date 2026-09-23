package Train3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		ArrayList<String> values = new ArrayList<>();

		values.add("4"); // 0
		values.add("hello"); // ignoré
		values.add("7"); // 2
		values.add("4"); // 3
		values.add("-2"); // 4
		values.add("7"); // 5
		values.add("7"); // 6
		values.add("4"); // 7
		values.add(" "); // ignoré
		values.add("7"); // 9

		System.out.println(Tra.indexOfMostFrequentValidNumber(values));
	}
}
