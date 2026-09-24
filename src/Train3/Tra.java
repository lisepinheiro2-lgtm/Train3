package Train3;

//Test portable
import java.util.ArrayList;
import java.util.Scanner;

public class Tra {

	public static double cleanAndAverageRatings(ArrayList<Movie> movies) {
		int count = 0;
		double total = 0.0;
		for (int i = movies.size() - 1; i >= 0; i--) {
			Movie movie = movies.get(i);
			Double rating = movie.getRating();
			if (rating < 0) {
				movies.remove(i);
				continue;
			}
			if (rating > 10) {
				movie.setRating(10);
				rating = 10.0;
			}
			total += rating;
			count++;
		}
		if (count == 0) {
			return 0;
		}
		return total / count;
	}

	public static String findBestMovie(ArrayList<Movie> movies, int maximumDuration) {
		Movie m = null;
		for (Movie movie : movies) {
			if (movie.getRating() < 0 || movie.getRating() > 10 || movie.getDuration() > maximumDuration) {
				continue;
			}
			if (m == null || m.getRating() < movie.getRating()
					|| m.getRating() == movie.getRating() && m.getDuration() > movie.getDuration()) {
				m = movie;
			}
		}
		if (m == null) {
			return "Aucun";
		}
		return m.getTitle();
	}

	public static int countRowsWithPositiveSum(int[][] grid) {
		int count = 0;
		for (int[] row : grid) {
			int total = 0;
			for (int num : row) {
				total += num;
			}
			if (total > 0) {
				count++;
			}
		}
		return count;
	}

	public static int executeCommands(String[] commands) {
		int total = 0;
		for (String command : commands) {
			if (command.equals("stop")) {
				break;
			}
			try {
				char operator = command.charAt(0);
				String numberText = command.substring(1);
				int num = Integer.parseInt(numberText);
				switch (operator) {
				case '+':
					total += num;
					break;
				case '-':
					total -= num;
					break;
				case '*':
					total *= num;
					break;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return total;
	}

	public static int executeCommands1(String[] commands) {
		int total = 0;
		for (String command : commands) {
			if (command.equals("stop")) {
				break;
			}
			try {
				char op = command.charAt(0);
				String num = command.substring(1);
				int number = Integer.parseInt(num);
				switch (op) {
				case '+':
					total += number;
					break;
				case '-':
					total -= number;
					break;
				case '*':
					total *= number;
					break;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return total;
	}

	public static int countRowsMeetingAverage(String[][] inputs, double minimumAverage) {
		int count = 0;
		for (String[] row : inputs) {
			double total = 0.0;
			int countNum = 0;
			for (String num : row) {
				try {
					int number = Integer.parseInt(num);
					if (number < 0 || number > 20) {
						continue;
					}
					total += number;
					countNum++;
				} catch (NumberFormatException e) {
					continue;
				}
			}
			if (countNum > 0) {
				double moyenne = total / countNum;
				if (moyenne >= minimumAverage) {
					count++;
				}
			}
		}
		return count;
	}

	public static int countRowsWithMorePositives(int[][] grid) {
		int count = 0;
		for (int[] row : grid) {
			int countNeg = 0;
			int countPos = 0;
			for (int num : row) {
				if (num < 0) {
					countNeg++;
				} else if (num > 0) {
					countPos++;
				}
			}
			if (countPos > countNeg) {
				count++;
			}
		}
		return count;
	}

	public static int sumAcceptedValues(String[] entries, char acceptedCategory) {
		int total = 0;
		for (String entrie : entries) {
			if (entrie.equals("stop")) {
				break;
			}
			char cat = entrie.charAt(0);
			String num = entrie.substring(1);
			if (cat != acceptedCategory) {
				continue;
			}
			try {
				int number = Integer.parseInt(num);
				if (number <= 0) {
					continue;
				}
				if (number > 50) {
					number = 50;
				}
				total += number;
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return total;
	}

	public static int findRowWithMostEvenNumbers(int[][] grid) {
		int bigCount = 0;
		int bigI = 0;
		for (int i = 0; i < grid.length; i++) {
			int countPair = 0;
			for (int j = 0; j < grid[i].length; j++) {
				int num = grid[i][j];
				if (num % 2 == 0) {
					countPair++;
				}
			}
			if (bigCount < countPair) {
				bigCount = countPair;
				bigI = i;
			}
		}
		return bigI;
	}

	public static int findBestScoreIndex(String[] inputs) {
		int i = 0;
		int bestI = -1;
		int bestScore = -1;
		while (i < inputs.length) {
			int currentI = i;
			String input = inputs[i];
			i++;
			try {
				int num = Integer.parseInt(input);
				if (num < 0 || num > 20) {
					continue;
				}
				if (num > bestScore) {
					bestScore = num;
					bestI = currentI;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return bestI;
	}

	private static boolean isValidRating(double rating) {
		return rating >= 0 && rating <= 10;
	}

	public static int countMoviesAboveAverage(ArrayList<Movie> movies) {
		int count = 0;
		double total = 0.0;
		for (Movie movie : movies) {
			double mR = movie.getRating();
			if (isValidRating(mR)) {
				total += mR;
				count++;
			}
		}
		if (count == 0) {
			return 0;
		}
		double moyenne = total / count;
		int totalF = 0;
		for (Movie movie : movies) {
			double mR = movie.getRating();
			if (mR > moyenne && isValidRating(mR)) {
				totalF++;
			}
		}
		return totalF;
	}

	public static int removeMoviesBelowAverage(ArrayList<Movie> movies) {
		double total = 0.0;
		int count = 0;
		int deleted = 0;
		for (int i = movies.size() - 1; i >= 0; i--) {
			double rating = movies.get(i).getRating();
			if (isValidRating(rating)) {
				total += rating;
				count++;
			} else {
				movies.remove(i);
				deleted++;
			}
		}
		if (count == 0) {
			return deleted;
		}
		double average = total / count;
		for (int i = movies.size() - 1; i >= 0; i--) {
			double rating = movies.get(i).getRating();
			if (rating < average) {
				movies.remove(i);
				deleted++;
			}
		}
		return deleted;
	}

	public static int findBestColumn(int[][] grid) {
		if (grid.length == 0 || grid[0].length == 0) {
			return -1;
		}
		int bestColumn = -1;
		int bestSum = 0;
		for (int j = 0; j < grid[0].length; j++) {
			int sum = 0;
			for (int i = 0; i < grid.length; i++) {
				int number = grid[i][j];
				if (number > 0) {
					sum += number;
				}
			}
			if (bestSum < sum) {
				bestSum = sum;
				bestColumn = j;
			}
		}
		return bestColumn;
	}

	public static int calculateGameScore(String[] actions) {
		int score = 0;
		for (String action : actions) {
			switch (action.toLowerCase()) {
			case "win":
				score += 3;
				break;
			case "bonus":
				score += 5;
				break;
			case "loss":
				score -= 2;
				break;
			case "double":
				score *= score;
				break;
			case "reset":
				score = 0;
			case "stop":
				return score;
			default:
				break;
			}
			if (score < 0) {
				score = 0;
			}
		}
		return score;
	}

	public static int countScoreIncreases(String[] inputs) {
		int count = 0;
		int previousNumber = -1;
		for (String input : inputs) {
			if (input.toLowerCase().equals("stop")) {
				break;
			}
			try {
				int number = Integer.parseInt(input);
				if (number < 0 || number > 20) {
					continue;
				}
				if (previousNumber != -1 && number > previousNumber) {
					count++;
				}
				previousNumber = number;
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return count;
	}

	public static int sumUntilLimit(int[] numbers, int maximumTotal) {
		int total = 0;
		int i = 0;
		while (i < numbers.length) {
			if (numbers[i] > 0) {
				if ((total + numbers[i]) > maximumTotal) {
					break;
				}
				total += numbers[i];
			}
			i++;
		}
		return total;
	}

	public static int findBestEntryIndex(String[] entries, char requiredPrefix) {
		int bestIndex = -1;
		int bestNumber = -1;
		for (int i = 0; i < entries.length; i++) {
			String entry = entries[i];
			if (entry.toLowerCase().equals("stop")) {
				break;
			}
			if (entry.length() < 2 || entry.charAt(0) != requiredPrefix) {
				continue;
			}
			try {
				int number = Integer.parseInt(entry.substring(1));
				if (number < 0 || number > 100) {
					continue;
				}
				if (bestNumber < number) {
					bestNumber = number;
					bestIndex = i;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return bestIndex;
	}

	public static int countColumnsReachingTotal(int[][] grid, int minimumTotal) {
		int count = 0;
		if (grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		for (int j = 0; j < grid[0].length; j++) {
			int sum = 0;
			for (int i = 0; i < grid.length; i++) {
				int columNumber = grid[i][j];
				sum += columNumber;
			}
			if (sum >= minimumTotal) {
				count++;
			}
		}
		return count;
	}

	public static int countStepsToTarget(int value, int increment, int target) {
		int count = 0;
		do {
			value += increment;
			count++;
		} while (value < target);
		return count;
	}

	public static int findLongestEvenStreak(int[] numbers) {
		int countPair = 0;
		int countMaxPair = 0;
		for (int number : numbers) {
			if (number % 2 == 0) {
				countPair++;
			} else {
				countPair = 0;
			}
			if (countPair > countMaxPair) {
				countMaxPair = countPair;
			}
		}
		return countMaxPair;
	}

	public static int removeDuplicateTitles(ArrayList<Movie> movies) {
		int countDeleted = 0;
		for (int i = 0; i < movies.size(); i++) {
			Movie movieI = movies.get(i);
			for (int j = movies.size() - 1; j > i; j--) {
				Movie movieJ = movies.get(j);
				if (movieI.getTitle().equalsIgnoreCase(movieJ.getTitle())) {
					movies.remove(j);
					countDeleted++;
				}
			}
		}
		return countDeleted;
	}

	public static boolean hasDuplicateTitle(ArrayList<Movie> movies) {
		for (int i = 0; i < movies.size(); i++) {
			Movie movieI = movies.get(i);
			for (int j = movies.size() - 1; j > i; j--) {
				Movie movieJ = movies.get(j);
				if (movieI.getTitle().equalsIgnoreCase(movieJ.getTitle())) {
					return true;
				}
			}
		}
		return false;
	}

	public static int findFirstIncreasingRow(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			int[] row = grid[i];
			if (row.length < 1) {
				continue;
			}
			boolean increasing = true;
			for (int j = 1; j < row.length; j++) {
				if (row[j] <= row[j - 1]) {
					increasing = false;
					break;
				}
			}
			if (increasing) {
				return i;
			}
		}
		return -1;
	}

	public static boolean isStrictlyIncreasing(int[] numbers) {
		if (numbers.length < 2) {
			return false;
		}
		boolean increasing = true;
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] <= numbers[i - 1]) {
				increasing = false;
				break;
			}
		}
		return increasing;
	}

	public static boolean areAllScoresValid(String[] inputs) {
		if (inputs.length == 0) {
			return false;
		}
		for (String input : inputs) {
			try {
				int number = Integer.parseInt(input);
				if (number < 0 || number > 20) {
					return false;
				}

			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	public static int countEqualPairs(int[] numbers) {
		int pairCount = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					pairCount++;
				}
			}
		}
		return pairCount;
	}

	public static boolean containsOnlyUniqueNumbers(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public static String joinLongWords(String[] words, int minimumLength) {
		String result = "";
		for (String word : words) {
			if (word.length() < minimumLength) {
				continue;
			}
			if (result.length() > 0) {
				result += " - ";
			}
			result += word;
		}
		if (result.length() == 0) {
			return "Aucun";
		}
		return result;
	}

	public static boolean hasConsecutiveDuplicate(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] == numbers[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public static boolean isStrictlyIncreasing1(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] >= numbers[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasDecrease(int[] numbers) {
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] > numbers[i + 1]) {
				return true;
			}
		}
		return false;
	}

	public static int countIncreases(int[] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i + 1]) {
				count++;
			}
		}
		return count;
	}

	public static int countEvenIncreases(int[] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] < numbers[i + 1] && numbers[i + 1] % 2 == 0) {
				count++;
			}
		}
		return count;
	}

	public static int countLongNames(ArrayList<String> names) {
		int count = 0;
		for (String name : names) {
			if (name.length() >= 5) {
				count++;
			}
		}
		return count;
	}

	public static int countValidIncreases(ArrayList<String> values) {
		int count = 0;
		for (int i = 0; i < values.size() - 1; i++) {
			String firstValue = values.get(i);
			String secondValue = values.get(i + 1);
			try {
				int first = Integer.parseInt(firstValue);
				int second = Integer.parseInt(secondValue);
				if (first < second) {
					count++;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return count;
	}

	public static int sumValidEvenNumbers(ArrayList<String> values) {
		int total = 0;
		for (String value : values) {
			try {
				int number = Integer.parseInt(value);
				if (number % 2 == 0) {
					total += number;
				}
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return total;
	}

	public static int countLocalPeaks(ArrayList<String> values) {
		int count = 0;
		for (int i = 1; i < values.size() - 1; i++) {
			String precedent = values.get(i - 1);
			String current = values.get(i);
			String next = values.get(i + 1);
			try {
				int precedentNumber = Integer.parseInt(precedent);
				int currentNumber = Integer.parseInt(current);
				int nextNumber = Integer.parseInt(next);
				if (precedentNumber < currentNumber && currentNumber > nextNumber) {
					count++;
				}
			} catch (NumberFormatException e) {
			}
		}
		return count;
	}

	public static int longestIncreasingStreak(int[] numbers) {
		int bigestSerie = 1;
		int serie = 1;
		for (int i = 0; i < numbers.length - 1; i++) {
			if (numbers[i] >= numbers[i + 1]) {
				serie = 1;
				continue;
			} else if (numbers[i] < numbers[i + 1]) {
				serie++;
			}
			if (bigestSerie <= serie) {
				bigestSerie = serie;
			}
		}
		return bigestSerie;
	}

	public static int longestEvenStreak(ArrayList<String> values) {
		int currentSerie = 0;
		int bigestSerie = 0;
		for (int i = 0; i < values.size(); i++) {
			String currentNumber = values.get(i);
			try {
				int current = Integer.parseInt(currentNumber);
				if (current % 2 == 0) {
					currentSerie++;
				} else {
					currentSerie = 0;
				}
				if (bigestSerie <= currentSerie) {
					bigestSerie = currentSerie;
				}
			} catch (NumberFormatException e) {
				currentSerie = 0;
			}
		}
		return bigestSerie;
	}

	public static int countIncreasingRows(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			boolean rowC = true;
			for (int j = 0; j < grid[i].length - 1; j++) {
				int currentNumber = grid[i][j];
				int nextNumber = grid[i][j + 1];
				if (currentNumber >= nextNumber) {
					rowC = false;
					break;
				}
			}
			if (rowC) {
				countRow++;
			}
		}
		return countRow;
	}

	public static boolean allValidEvenNumbers(ArrayList<String> values) {
		for (String value : values) {
			try {
				int number = Integer.parseInt(value);
				if (number % 2 != 0) {
					return false;
				}
			} catch (NumberFormatException e) {
				return false;
			}
		}
		return true;
	}

	public static boolean allWordsHaveNoConsecutiveDuplicate(ArrayList<String> words) {
		for (String word : words) {
			for (int i = 0; i < word.length() - 1; i++) {
				if (word.charAt(i) == (word.charAt(i + 1))) {
					return false;
				}
			}
		}
		return true;
	}

	public static boolean allRowsContainPositive(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			boolean found = false;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] > 0) {
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}

	public static int countRowsWithNegative(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			boolean found = false;
			for (int j = 0; j < grid[i].length; j++) {
				int number = grid[i][j];
				if (number < 0) {
					found = true;
					break;
				}
			}
			if (found) {
				countRow++;
			}
		}
		return countRow;
	}

	public static int countAllEvenRows(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			boolean found = true;
			for (int j = 0; j < grid[i].length; j++) {
				int number = grid[i][j];
				if (number % 2 != 0) {
					found = false;
					break;
				}
			}
			if (found) {
				countRow++;
			}
		}
		return countRow;
	}

	public static int countStrictlyIncreasingRows(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			boolean ascending = true;
			for (int j = 0; j < grid[i].length - 1; j++) {
				int currentNumber = grid[i][j];
				int nextNumber = grid[i][j + 1];
				if (currentNumber >= nextNumber) {
					ascending = false;
					break;
				}
			}
			if (ascending) {
				countRow++;
			}
		}
		return countRow;
	}

	public static int countRowsWithExactlyOneNegative(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			int countNegative = 0;
			for (int j = 0; j < grid[i].length; j++) {
				boolean foundNegative = (grid[i][j] < 0);
				if (foundNegative) {
					countNegative++;
				}
			}
			if (countNegative == 1) {
				countRow++;
			}
		}
		return countRow;
	}

	public static int countRowsWithMoreEvenThanOdd(int[][] grid) {
		int countRow = 0;
		for (int i = 0; i < grid.length; i++) {
			int countPair = 0;
			int countNotPair = 0;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] % 2 == 0) {
					countPair++;
				} else {
					countNotPair++;
				}
			}
			if (countPair > countNotPair) {
				countRow++;
			}
		}
		return countRow;
	}

	public static int longestValidIncreasingStreak(ArrayList<String> values) {
		int longestSerie = 0;
		int currentSerie = 0;
		int previous = 0;
		boolean hasPrevious = false;
		for (String value : values) {
			try {
				int current = Integer.parseInt(value);
				if (!hasPrevious) {
					currentSerie = 1;
				} else if (current > previous) {
					currentSerie++;
				} else {
					currentSerie = 1;
				}
				if (currentSerie > longestSerie) {
					longestSerie = currentSerie;
				}
				previous = current;
				hasPrevious = true;
			} catch (NumberFormatException e) {
				currentSerie = 0;
				hasPrevious = false;
			}
		}
		return longestSerie;
	}

	public static int countValidIncreases1(ArrayList<String> values) {
		int count = 0;
		int previous = 0;
		boolean hasPrevious = false;
		for (String value : values) {
			try {
				int current = Integer.parseInt(value);
				if (hasPrevious && previous < current) {
					count++;
				}
				hasPrevious = true;
				previous = current;
			} catch (NumberFormatException e) {
				hasPrevious = false;
			}
		}
		return count;
	}

	public static int countDropsAfterValid(ArrayList<String> values) {
		int count = 0;
		int previous = 0;
		boolean hasPrevious = false;
		for (String value : values) {
			try {
				int current = Integer.parseInt(value);
				if (hasPrevious && previous > current) {
					count++;
				}
				hasPrevious = true;
				previous = current;
			} catch (NumberFormatException e) {
				hasPrevious = false;
			}
		}
		return count;
	}

	public static int countEqualAfterValid(ArrayList<String> values) {
		int count = 0;
		int previous = 0;
		boolean hasPrevious = false;
		for (String value : values) {
			try {
				int current = Integer.parseInt(value);
				if (hasPrevious && previous == current) {
					count++;
				}
				hasPrevious = true;
				previous = current;
			} catch (NumberFormatException e) {
				hasPrevious = false;
			}
		}
		return count;
	}

	public static int sumValidIncreases(ArrayList<String> values) {
		int total = 0;
		int previous = 0;
		boolean hasPrevious = false;
		for (String value : values) {
			try {
				int current = Integer.parseInt(value);
				if (hasPrevious && current > previous) {
					total += (current - previous);
				}
				hasPrevious = true;
				previous = current;
			} catch (NumberFormatException e) {
				hasPrevious = false;
			}
		}
		return total;
	}

	public static int sumLargestOfEachRow(int[][] grid) {
		int total = 0;
		for (int i = 0; i < grid.length; i++) {
			int bigest = grid[i][0];
			for (int j = 1; j < grid[i].length; j++) {
				int next = grid[i][j];
				if (bigest < next) {
					bigest = next;
				}
			}
			total += bigest;
		}
		return total;
	}

	public static int calculate(int a, int b, String operation) {
		switch (operation) {
		case "add":
			return a + b;
		case "substract":
			return a - b;
		case "multiply":
			return a * b;
		case "divide":
			if (b == 0) {
				return 0;
			}
			return a / b;
		default:
			return 0;
		}
	}

	public static int parsePositive(String value) {
		int number = 0;
		try {
			number = Integer.parseInt(value);
			if (number <= 0) {
				return 0;
			}
		} catch (NumberFormatException e) {
			return 0;
		}
		return number;
	}

	public static int firstPositive(int[] numbers) {
		int i = 0;
		while (i < numbers.length) {
			if (numbers[i] > 0) {
				return numbers[i];
			}
			i++;
		}
		return 0;
	}

	public static int countUntilZero(int[] numbers) {
		int count = 0;
		int i = 0;
		do {
			if (numbers[i] == 0) {
				break;
			}
			count++;
			i++;
		} while (i < numbers.length);
		return count;
	}

	public static int countIncreases2(int[] numbers) {
		int i = 1;
		int count = 0;
		while (i < numbers.length) {
			if (numbers[i - 1] < numbers[i]) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countDrops(int[] numbers) {
		int i = 1;
		int count = 0;
		while (i < numbers.length) {
			if (numbers[i - 1] > numbers[i]) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countRepeatedLetters(String text) {
		int i = 1;
		int count = 0;
		while (i < text.length()) {
			if (text.charAt(i - 1) == text.charAt(i)) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countConsecutiveDuplicates(ArrayList<Movie> movies) {
		int count = 0;
		for (int i = 1; i < movies.size(); i++) {
			String previousTitle = movies.get(i - 1).getTitle();
			String currentTitle = movies.get(i).getTitle();
			if (previousTitle.equals(currentTitle)) {
				count++;
			}
		}
		return count;
	}

	public static int countIncreasingRows1(int[][] numbers) {
		int count = 0;
		for (int i = 0; i < numbers.length; i++) {
			boolean found = true;
			for (int j = 0; j < numbers[i].length - 1; j++) {
				int previousNumber = numbers[i][j];
				int currentNumber = numbers[i][j + 1];
				if (previousNumber >= currentNumber) {
					found = false;
					break;
				}
			}
			if (found) {
				count++;
			}
		}
		return count;
	}

	public static int sumValidNumbers(ArrayList<String> values) {
		int total = 0;
		for (String value : values) {
			try {
				int number = Integer.parseInt(value);
				total += number;
			} catch (NumberFormatException e) {
			}
		}
		return total;
	}

	public static int calculateScore(String[] commands) {
		int total = 0;
		for (String command : commands)
			try {
				int number = Integer.parseInt(command.substring(1));
				switch (command.charAt(0)) {
				case 'A':
					total += number;
					break;
				case 'S':
					total -= number;
					break;
				case 'X':
					continue;
				}
			} catch (NumberFormatException e) {

			}
		return total;
	}

	public static int findFirstEvenIndex1(int[] numbers) {
		int i = 0;
		do {
			if (numbers[i] % 2 == 0) {
				return i;
			}
			i++;
		} while (i < numbers.length);
		return -1;
	}

	public static int countEvenSumColumns(int[][] numbers) {
		int countPair = 0;
		for (int j = 0; j < numbers[0].length; j++) {
			int total = 0;
			for (int i = 0; i < numbers.length; i++) {
				int number = numbers[i][j];
				total += number;
			}
			if (total % 2 == 0) {
				countPair++;
			}
		}
		return countPair;
	}

	public static int removeMarkedMovies(ArrayList<String> movies) {
		int countDeleted = 0;
		int i = 0;
		while (i < movies.size()) {
			if (movies.get(i).equals("REMOVE")) {
				movies.remove(i);
				countDeleted++;
				i--;
			}
			i++;
		}
		return countDeleted;
	}

	public static int countVowels(String text) {
		int i = 0;
		int count = 0;
		while (i < text.length()) {
			switch (text.charAt(i)) {
			case 'a':
				count++;
				break;
			case 'e':
				count++;
				break;
			case 'i':
				count++;
				break;
			case 'o':
				count++;
				break;
			case 'u':
				count++;
				break;
			}
			i++;
		}
		return count;
	}

	public static String findLongestTitle(ArrayList<Movie> movies) {
		String longTitle = "";
		for (Movie movie : movies) {
			String currentTitle = movie.getTitle();
			if (currentTitle.length() > longTitle.length()) {
				longTitle = currentTitle;
			}
		}
		return longTitle;
	}

	public static double averagePassingScores(int[] scores) {
		int count = 0;
		int total = 0;
		for (int score : scores) {
			if (score >= 10) {
				count++;
				total += score;
			}
		}
		if (count == 0) {
			return 0.0;
		}
		double average = (double) total / count;
		return average;
	}

	public static String findFirstLongWord(String[] words) {
		for (String word : words) {
			if (word.length() >= 5) {
				return word;
			}
		}
		return "NONE";
	}

	public static boolean containsNumber(int[][] numbers, int target) {
		for (int[] row : numbers) {
			for (int number : row) {
				if (number == target) {
					return true;
				}
			}
		}
		return false;
	}

	public static String findPosition(int[][] numbers, int target) {
		for (int i = 0; i < numbers.length; i++) {
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] == target) {
					return i + "," + j;
				}
			}
		}
		return "NOT FOUND";
	}

	public static int findBestEvenAverageRow(int[][] numbers) {
		double bigestAverage = -1;
		int averageIndex = -1;
		for (int i = 0; i < numbers.length; i++) {
			int totalPairRow = 0;
			int count = 0;
			for (int j = 0; j < numbers[i].length; j++) {
				if (numbers[i][j] % 2 == 0) {
					totalPairRow += numbers[i][j];
					count++;
				}
			}
			if (count != 0) {
				double rowAverage = (double) totalPairRow / count;
				if (averageIndex == -1 || bigestAverage < rowAverage) {
					bigestAverage = rowAverage;
					averageIndex = i;
				}
			}
		}
		return averageIndex;
	}

	public static int countIncreasesBetweenValidNumbers(String[] entries) {
		int count = 0;
		int previousNumber = 0;
		boolean hasPrevious = false;
		for (int i = 0; i < entries.length; i++) {
			try {
				int currentNumber = Integer.parseInt(entries[i]);
				if (hasPrevious) {
					if (previousNumber < currentNumber) {
						count++;
					}
				}
				previousNumber = currentNumber;
				hasPrevious = true;
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return count;
	}

	public static int countIncreasesIgnoringNegatives(int[] numbers) {
		int count = 0;
		int previousNumber = 0;
		boolean hasPrevious = false;
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			if (currentNumber >= 0) {
				if (hasPrevious) {
					if (previousNumber < currentNumber) {
						count++;
					}
				}
				previousNumber = currentNumber;
				hasPrevious = true;
			}
		}
		return count;
	}

	public static int longestIncreasingSerie(int[] numbers) {
		int longestSerie = 0;
		int currentSerie = 0;
		int previousNumber = 0;
		boolean hasPrevious = false;
		for (int i = 0; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			if (!hasPrevious) {
				currentSerie = 1;
			} else if (previousNumber < currentNumber) {
				currentSerie++;
			} else {
				currentSerie = 1;
			}
			if (currentSerie > longestSerie) {
				longestSerie = currentSerie;
			}
			previousNumber = currentNumber;
			hasPrevious = true;
		}
		return longestSerie;
	}

	public static int findColumnWithMostEvenNumbers(int[][] numbers) {
		int longestSerie = 0;
		int bestIndex = -1;
		for (int j = 0; j < numbers[0].length; j++) {
			int countPair = 0;
			for (int i = 0; i < numbers.length; i++) {
				int number = numbers[i][j];
				if (number % 2 == 0) {
					countPair++;
				}
			}
			if (longestSerie == -1 || longestSerie < countPair) {
				longestSerie = countPair;
				bestIndex = j;
			}
		}
		return bestIndex;
	}

	public static int findRowWithHighestValidSum(String[][] entries) {
		int maxTotal = 0;
		int bigestTotalIndex = -1;
		for (int i = 0; i < entries.length; i++) {
			int total = 0;
			boolean hasValidNumber = false;
			for (int j = 0; j < entries[i].length; j++) {
				try {
					int number = Integer.parseInt(entries[i][j]);
					total += number;
					hasValidNumber = true;
				} catch (NumberFormatException e) {
					continue;
				}
			}
			if (hasValidNumber) {
				if (bigestTotalIndex == -1 || maxTotal < total) {
					maxTotal = total;
					bigestTotalIndex = i;
				}
			}
		}
		return bigestTotalIndex;
	}

	public static int findClosestToZeroIndex(int[] temperatures) {
		int bestIndex = -1;
		int bestDistance = 0;
		for (int i = 0; i < temperatures.length; i++) {
			int distance = temperatures[i];
			if (distance < 0) {
				distance = -distance;
			}
			if (bestIndex == -1 || distance < bestDistance) {
				bestDistance = distance;
				bestIndex = i;
			}
		}
		return bestIndex;
	}

	public static int findBiggestIncreaseIndex(int[] values) {
		int bestIndex = -1;
		int maxAug = 0;
		for (int i = 1; i < values.length; i++) {
			int previousNumber = values[i - 1];
			int currentNumber = values[i];
			int currentAug = 0;
			if (previousNumber < currentNumber) {
				currentAug = currentNumber - previousNumber;
			}
			if (maxAug < currentAug) {
				maxAug = currentAug;
				bestIndex = i;
			}
		}
		return bestIndex;
	}

	public static int findRowWithMostIncreases(int[][] numbers) {
		int countIncreases = 0;
		int bestIndex = -1;
		for (int i = 0; i < numbers.length; i++) {
			int countIncreasesRow = 0;
			boolean foundIncrease = false;
			for (int j = 1; j < numbers[i].length; j++) {
				int previousNumber = numbers[i][j - 1];
				int currentNumber = numbers[i][j];
				if (previousNumber < currentNumber) {
					countIncreasesRow++;
					foundIncrease = true;
				}
			}
			if (foundIncrease) {
				if (countIncreases < countIncreasesRow) {
					countIncreases = countIncreasesRow;
					bestIndex = i;
				}
			}
		}
		return bestIndex;
	}

	public static int countUniqueTitles(ArrayList<Movie> movies) {
		int countTitle = 0;
		int i = 0;
		while (i < movies.size()) {
			boolean duplicate = false;
			String currentTitle = movies.get(i).getTitle();
			for (int j = 0; j < i; j++) {
				if (currentTitle.equalsIgnoreCase(movies.get(j).getTitle())) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				countTitle++;
			}
			i++;
		}
		return countTitle;
	}

	public static int countUniqueNumbers(int[] numbers) {
		int count = 0;
		int i = 0;
		while (i < numbers.length) {
			boolean duplicate = false;
			int number = numbers[i];
			for (int j = 0; j < i; j++) {
				if (number == numbers[j]) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int findFirstDuplicateIndex(int[] numbers) {
		int i = 0;
		while (i < numbers.length) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					return i;
				}
			}
			i++;
		}
		return -1;
	}

	public static int countNumbersAppearingOnce(int[] numbers) {
		int count = 0;
		int i = 0;
		while (i < numbers.length) {
			boolean duplicate = false;
			for (int j = 0; j < numbers.length; j++) {
				if (i != j && numbers[i] == numbers[j]) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countRepeatedValues(int[] numbers) {
		int count = 0;
		int i = 0;
		while (i < numbers.length) {
			boolean alreadySeen = false;
			boolean repeated = false;
			for (int j = 0; j < i; j++) {
				if (numbers[i] == numbers[j]) {
					alreadySeen = true;
					break;
				}
			}
			if (!alreadySeen) {
				for (int k = 0; k < numbers.length; k++) {
					if (k != i && numbers[i] == numbers[k]) {
						repeated = true;
						break;
					}
				}
				if (repeated) {
					count++;
				}
			}
			i++;
		}
		return count;
	}

	public static int sumValidPositiveEvenNumbers(String[][] values) {
		int total = 0;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values[i].length; j++) {
				String num = values[i][j];
				try {
					int number = Integer.parseInt(num);
					if (number > 0 && number % 2 == 0) {
						total += number;
					}
				} catch (NumberFormatException e) {
				}
			}
		}
		return total;
	}

	public static String findBestShortMovie(ArrayList<Movie> movies, int maximumDuration, double minimumRating) {
		Movie bestMovie = null;
		for (Movie movie : movies) {
			boolean eligible = movie.getDuration() <= maximumDuration && movie.getRating() >= minimumRating;
			if (eligible) {
				if (bestMovie == null) {
					bestMovie = movie;
				} else if (movie.getRating() > bestMovie.getRating()) {
					bestMovie = movie;

				} else if (movie.getRating() == bestMovie.getRating()
						&& movie.getDuration() < bestMovie.getDuration()) {
					bestMovie = movie;
				}
			}
		}
		if (bestMovie == null) {
			return "";
		}

		return bestMovie.getTitle();
	}

	public static int applyMovieCommands(ArrayList<Movie> movies, String[] commands) {
		int commandsDone = 0;
		for (String command : commands) {
			if (command.equals("q")) {
				return commandsDone;
			}
			if (command.length() > 1) {
				try {
					int index = Integer.parseInt(command.substring(1)) - 1;
					Movie currentMovie = movies.get(index);
					switch (command.charAt(0)) {
					case 'b':
						currentMovie.addRatingBonus(0.5);
						commandsDone++;
						break;
					case 'd':
						currentMovie.setDuration(currentMovie.getDuration() - 10);
						commandsDone++;
						break;
					}
				} catch (NumberFormatException | IndexOutOfBoundsException e) {
				}
			}
		}
		return commandsDone;
	}

	public static double findFirstValidRating(String[] attempts) {
		int i = 0;
		do {
			try {
				double note = Double.parseDouble(attempts[i]);
				if (note >= 0 && note <= 10) {
					return note;
				}
			} catch (NumberFormatException e) {
			}
			i++;
		} while (i < attempts.length);
		return -1;
	}

	public static int findFirstInvalidMoviePosition(ArrayList<Movie> movies) {
		int i = 0;
		while (i < movies.size()) {
			boolean found = false;
			Movie movie = movies.get(i);
			if (movie.getTitle() == null || movie.getTitle().isEmpty() || movie.getDuration() <= 0
					|| movie.getRating() < 0 || movie.getRating() > 10) {
				found = true;
			}
			if (found) {
				return i + 1;
			}
			i++;
		}
		return -1;
	}

	public static int boostMoviesBelowAverage(ArrayList<Movie> movies, double bonus) {
		double total = 0.0;
		int modifiedCount = 0;
		if (movies.isEmpty()) {
			return 0;
		}
		for (Movie movie : movies) {
			total += movie.getRating();
		}
		double average = total / movies.size();
		for (Movie movie : movies) {
			if (movie.getRating() < average) {
				movie.addRatingBonus(bonus);
				modifiedCount++;
			}
		}
		return modifiedCount;
	}

	public static int longestIncreasingRatingStreak(ArrayList<Movie> movies) {
		int count = 1;
		int maxCount = 1;
		for (int i = 1; i < movies.size(); i++) {
			Movie previousMovie = movies.get(i - 1);
			Movie currentMovie = movies.get(i);
			if (previousMovie.getRating() < currentMovie.getRating()) {
				count++;
			} else {
				count = 1;
			}
			if (count > maxCount) {
				maxCount = count;
			}
		}
		return maxCount;
	}

	public static ArrayList<Movie> buildMovieMarathon(ArrayList<Movie> movies, int maximumTotalDuration,
			double minimumRating) {
		ArrayList<Movie> newMovies = new ArrayList<>();
		int totalDuration = 0;
		for (Movie movie : movies) {
			boolean duplicate = false;
			if (movie.getTitle() == null || movie.getTitle().isBlank() || movie.getRating() < minimumRating
					|| movie.getRating() > 10 || movie.getDuration() <= 0) {
				continue;
			}
			for (Movie newMovie : newMovies) {
				if (newMovie.getTitle().equalsIgnoreCase(movie.getTitle())) {
					duplicate = true;
					break;
				}
			}
			if (!duplicate && totalDuration + movie.getDuration() <= maximumTotalDuration) {
				newMovies.add(movie);
				totalDuration += movie.getDuration();
			}
		}
		return newMovies;
	}

	public static ArrayList<Movie> keepBestMoviePerTitle(ArrayList<Movie> movies) {
		ArrayList<Movie> bestMovies = new ArrayList<>();
		for (Movie movie : movies) {
			boolean duplicate = false;
			boolean bestRating = false;
			boolean equalRating = false;
			boolean bestDuration = false;
			if (movie.getTitle() == null || movie.getTitle().isBlank() || movie.getDuration() <= 0
					|| movie.getRating() < 0 || movie.getRating() > 10) {
				continue;
			}
			for (Movie bestMovie : bestMovies) {
				if (movie.getTitle().equalsIgnoreCase(bestMovie.getTitle())) {
					duplicate = true;
					if (duplicate && movie.getRating() > bestMovie.getRating()) {
						bestRating = true;
						break;
					} else if (duplicate && !bestRating && movie.getRating() == bestMovie.getRating()) {
						equalRating = true;
						if (movie.getDuration() < bestMovie.getDuration()) {
							bestDuration = true;
							break;
						}
					}
				}
			}
			if (!duplicate) {
				bestMovies.add(movie);
			} else {
				for (int i = 0; i < bestMovies.size(); i++) {
					if (movie.getTitle().equalsIgnoreCase(bestMovies.get(i).getTitle())) {
						if (duplicate && bestRating) {
							bestMovies.set(i, movie);
						} else if (duplicate && !bestRating && equalRating && bestDuration) {
							bestMovies.set(i, movie);
						}
						break;
					}
				}

			}
		}
		return bestMovies;
	}

	public static ArrayList<Movie> keepBestMoviePerTitleOpti(ArrayList<Movie> movies) {

		ArrayList<Movie> bestMovies = new ArrayList<>();

		for (Movie movie : movies) {
			String title = movie.getTitle();
			double rating = movie.getRating();

			if (title == null || title.isBlank() || movie.getDuration() <= 0 || rating < 0 || rating > 10) {
				continue;
			}

			int duplicateIndex = -1;

			for (int i = 0; i < bestMovies.size(); i++) {
				if (title.equalsIgnoreCase(bestMovies.get(i).getTitle())) {

					duplicateIndex = i;
					break;
				}
			}

			if (duplicateIndex == -1) {
				bestMovies.add(movie);
			} else {
				Movie currentBest = bestMovies.get(duplicateIndex);

				if (rating > currentBest.getRating()
						|| (rating == currentBest.getRating() && movie.getDuration() < currentBest.getDuration())) {

					bestMovies.set(duplicateIndex, movie);
				}
			}
		}
		return bestMovies;
	}

	public static boolean replaceMovieIfBetter(ArrayList<Movie> movies, Movie candidate) {

		int foundIndex = -1;

		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getTitle().equalsIgnoreCase(candidate.getTitle())) {
				foundIndex = i;
				break;
			}
		}

		if (foundIndex == -1) {
			return false;
		}

		if (candidate.getRating() > movies.get(foundIndex).getRating()
				|| candidate.getRating() == movies.get(foundIndex).getRating()
						&& candidate.getDuration() < movies.get(foundIndex).getDuration()) {
			movies.set(foundIndex, candidate);
			return true;
		}

		return false;
	}

	public static boolean replaceWorstMovie(ArrayList<Movie> movies, Movie candidate) {

		if (movies.isEmpty()) {
			return false;
		}

		int foundIndex = 0;
		Movie newCandidate = movies.get(0);

		for (int i = 1; i < movies.size(); i++) {
			double rating = movies.get(i).getRating();
			int duration = movies.get(i).getDuration();

			if (rating < newCandidate.getRating()) {
				newCandidate = movies.get(i);
				foundIndex = i;

			} else if (rating == newCandidate.getRating() && duration > newCandidate.getDuration()) {
				newCandidate = movies.get(i);
				foundIndex = i;
			}
		}

		if (candidate.getRating() > newCandidate.getRating() || candidate.getRating() == newCandidate.getRating()
				&& candidate.getDuration() < newCandidate.getDuration()) {
			movies.set(foundIndex, candidate);
			return true;
		}

		return false;
	}

	public static int applyMovieRatingUpdates(ArrayList<Movie> movies, String[][] updates) {

		int modifiedCount = 0;

		for (String[] update : updates) {
			String title = update[0];
			String ratingText = update[1];

			try {
				double rating = Double.parseDouble(ratingText);

				if (rating < 0 || rating > 10) {
					continue;
				}

				for (Movie movie : movies) {

					if (title.equalsIgnoreCase(movie.getTitle())) {
						movie.setRating(rating);
						modifiedCount++;
						break;
					}
				}

			} catch (NumberFormatException e) {
			}
		}

		return modifiedCount;
	}

	public static String findBestAverageMovie(String[][] ratings) {

		int bestRowIndex = 0;
		double currentBestAverage = 0.0;
		int bestValidRatingCount = 0;
		boolean found = false;

		for (int i = 0; i < ratings.length; i++) {

			double total = 0.0;
			int validRatingCount = 0;

			for (int j = 1; j < ratings[i].length; j++) {
				String ratingText = ratings[i][j];

				try {
					double rating = Double.parseDouble(ratingText);

					if (rating < 0 || rating > 10) {
						continue;

					} else {
						total += rating;
						validRatingCount++;
					}

				} catch (NumberFormatException e) {
					continue;
				}
			}

			if (validRatingCount == 0) {
				continue;
			}

			double average = total / validRatingCount;

			if (!found || average > currentBestAverage
					|| (average == currentBestAverage && validRatingCount > bestValidRatingCount)) {
				found = true;
				currentBestAverage = average;
				bestValidRatingCount = validRatingCount;
				bestRowIndex = i;
			}
		}

		if (found) {
			return ratings[bestRowIndex][0];
		}
		return "";
	}

	public static int applyTaskCommands(ArrayList<Task> tasks, String[] commands) {

		int count = 0;

		for (int i = 0; i < commands.length; i++) {
			String commandText = commands[i];

			if (commandText.equals("q")) {
				return count;
			}

			if (commandText.length() < 2) {
				continue;
			}

			char command = commandText.charAt(0);
			String number = commandText.substring(1);

			try {
				int index = Integer.parseInt(number) - 1;

				if (index >= 0 && index < tasks.size()) {
					switch (command) {
					case 'd':
						tasks.get(index).setDone(true);
						count++;
						break;
					case 'u':
						tasks.get(index).setDone(false);
						count++;
						break;
					case 'r':
						tasks.remove(index);
						count++;
						break;
					}
				}

			} catch (NumberFormatException e) {
				continue;
			}
		}

		return count;
	}

	public static int trimMovieMarathon(ArrayList<Movie> movies, int maximumTotalDuration) {

		int totalDuration = 0;
		int deletedMovieCount = 0;

		for (Movie movie : movies) {
			totalDuration += movie.getDuration();
		}

		while (totalDuration > maximumTotalDuration && !movies.isEmpty()) {

			int lastIndex = movies.size() - 1;

			totalDuration -= movies.get(lastIndex).getDuration();
			movies.remove(lastIndex);
			deletedMovieCount++;
		}

		return deletedMovieCount;
	}

	public static int removeWorstMoviesUntilAverage(ArrayList<Movie> movies, double minimumAverage) {

		int deletedCount = 0;

		if (movies.isEmpty()) {
			return 0;
		}

		while (!movies.isEmpty()) {

			double moviesAverage = 0.0;
			double totalNotes = 0.0;
			int countNotes = 0;
			int worstMovieIndex = -1;
			double worstMovieNote = 10.0;
			int worstMovieDuration = -1;

			for (int i = 0; i < movies.size(); i++) {

				double rating = movies.get(i).getRating();
				int duration = movies.get(i).getDuration();

				if (rating < worstMovieNote) {
					worstMovieNote = rating;
					worstMovieIndex = i;
				}

				if (rating < worstMovieNote || (rating == worstMovieNote && duration > worstMovieDuration)) {
					worstMovieNote = rating;
					worstMovieDuration = duration;
					worstMovieIndex = i;
				}

				totalNotes += rating;
				countNotes++;
			}

			moviesAverage = totalNotes / countNotes;

			if (moviesAverage >= minimumAverage) {
				return deletedCount;
			}

			if (moviesAverage < minimumAverage) {
				movies.remove(worstMovieIndex);
				deletedCount++;
			}
		}

		return deletedCount;
	}

	public static ArrayList<Movie> buildAboveAverageWatchlist(ArrayList<Movie> movies) {

		ArrayList<Movie> watchlist = new ArrayList<>();
		double moviesAverage = 0.0;
		double totalNotes = 0.0;
		int countNotes = 0;

		if (movies.isEmpty()) {
			return watchlist;
		}

		for (Movie movie : movies) {
			String title = movie.getTitle();
			double rating = movie.getRating();

			if (title == null || title.isBlank() || movie.getDuration() <= 0 || rating < 0 || rating > 10) {
				continue;
			}

			totalNotes += rating;
			countNotes++;
		}

		if (countNotes == 0) {
			return watchlist;
		}

		moviesAverage = totalNotes / countNotes;

		for (Movie movie : movies) {
			String title = movie.getTitle();
			double rating = movie.getRating();

			if (title == null || title.isBlank() || movie.getDuration() <= 0 || rating < 0 || rating > 10) {
				continue;
			}

			if (rating <= moviesAverage) {
				continue;
			}
			boolean duplicate = false;

			for (Movie selectedMovie : watchlist) {
				if (selectedMovie.getTitle().equalsIgnoreCase(title)) {
					duplicate = true;
					break;
				}
			}

			if (!duplicate) {
				watchlist.add(movie);
			}
		}

		return watchlist;
	}

	public static int countConsistentlyGoodMovies(String[][] ratings, double minimumRating) {

		int countValidMovies = 0;

		for (int i = 0; i < ratings.length; i++) {
			boolean validMovie = true;
			String title = ratings[i][0];

			if (title == null || title.isBlank() || ratings[i].length == 1) {
				continue;
			}

			for (int j = 1; j < ratings[i].length; j++) {
				String ratingText = ratings[i][j];

				try {

					double rating = Double.parseDouble(ratingText);

					if (rating < 0 || rating > 10 || rating < minimumRating) {
						validMovie = false;
						break;
					}

				} catch (NumberFormatException e) {
					validMovie = false;
					break;
				}
			}

			if (validMovie) {
				countValidMovies++;
			}
		}

		return countValidMovies;
	}

	public static int countAvailableRequestedMovies(ArrayList<Movie> movies, String[] requestedTitles,
			double minimumRating) {

		int validRequest = 0;

		for (String request : requestedTitles) {
			boolean valid = false;

			if (request == null || request.isBlank()) {
				continue;
			}

			for (Movie movie : movies) {

				String title = movie.getTitle();
				double rating = movie.getRating();

				if (title == null || title.isBlank() || movie.getDuration() <= 0 || rating < 0 || rating > 10
						|| rating < minimumRating) {
					continue;
				}

				if (request.equalsIgnoreCase(title)) {
					valid = true;
					break;

				}
			}

			if (valid) {
				validRequest++;
			}
		}

		return validRequest;
	}

	public static int countWantedMovies(ArrayList<Movie> movies, String[] wantedTitles, double minimumRating) {

		int count = 0;

		for (Movie movie : movies) {
			String title = movie.getTitle();
			double rating = movie.getRating();
			boolean validMovie = false;

			if (title == null || title.isBlank() || movie.getDuration() <= 0 || rating < 0 || rating > 10
					|| rating < minimumRating) {
				continue;
			}

			for (String wtitle : wantedTitles) {

				if (title.equalsIgnoreCase(wtitle)) {
					validMovie = true;
					break;
				}
			}

			if (validMovie) {
				count++;
			}
		}

		return count;
	}

	public static int countWantedProducts(String[] stockProducts, String[] wantedProducts) {

		int wantedProductsCount = 0;

		for (String stock : stockProducts) {
			boolean foundProductCode = false;

			for (String wantedProduct : wantedProducts) {
				if (wantedProduct == null || wantedProduct.isBlank()) {
					continue;
				}

				if (wantedProduct.equalsIgnoreCase(stock)) {
					foundProductCode = true;
					break;
				}
			}

			if (foundProductCode) {
				wantedProductsCount++;
			}
		}

		return wantedProductsCount;
	}

	public static int calculateFinalStock(ArrayList<String> commands) {

		int stockCount = 0;

		for (String command : commands) {

			if (command == null || command.isBlank()) {
				continue;
			}

			if (command.equalsIgnoreCase("reset")) {
				stockCount = 0;
				continue;
			}

			char operator = command.charAt(0);
			String numberText = command.substring(1);

			try {
				int number = Integer.parseInt(numberText);

				if (number <= 0) {
					continue;
				}

				switch (operator) {
				case ('+'):
					stockCount += number;
					break;
				case ('-'):
					stockCount -= number;
					break;
				default:
					continue;
				}

			} catch (NumberFormatException e) {
				continue;
			}

			if (stockCount < 0) {
				stockCount = 0;
			}
		}

		return stockCount;
	}

	public static int removeInvalidMovies(ArrayList<Movie> movies) {

		int deletedMoviesCount = 0;
		int i = 0;

		while (i < movies.size()) {
			boolean deleted = false;
			Movie movie = movies.get(i);

			if (movie == null || movie.getTitle() == null || movie.getTitle().isBlank() || movie.getDuration() <= 0
					|| movie.getRating() < 0 || movie.getRating() > 10) {
				movies.remove(i);
				deletedMoviesCount++;
				deleted = true;
			}

			if (!deleted) {
				i++;
			}
		}

		return deletedMoviesCount;
	}

	public static int countIncreasingColumns(int[][] numbers) {

		int increasingColumn = 0;

		if (numbers.length == 0 || numbers[0].length == 0) {
			return 0;
		}

		for (int j = 0; j < numbers[0].length; j++) {
			boolean increasing = true;

			for (int i = 1; i < numbers.length; i++) {

				int previousNumber = numbers[i - 1][j];
				int currentNumber = numbers[i][j];

				if (previousNumber >= currentNumber) {
					increasing = false;
					break;
				}
			}

			if (increasing) {
				increasingColumn++;
			}
		}

		return increasingColumn;
	}

	public static int longestAlternatingParity(int[] numbers) {

		int i = 0;
		int bestSerie = 1;
		int currentSerie = 1;

		if (numbers.length == 0) {
			return 0;
		}

		if (numbers.length == 1) {
			return 1;
		}

		while (i < numbers.length - 1) {
			int currentNumber = numbers[i];
			int nextNumber = numbers[i + 1];

			if (currentNumber % 2 != nextNumber % 2) {
				currentSerie++;
			} else {
				currentSerie = 1;
			}

			if (currentSerie > bestSerie) {
				bestSerie = currentSerie;
			}

			i++;
		}

		return bestSerie;
	}

	public static int countEvenDigits(int number) {

		int evenDigitCount = 0;

		do {

			int digit = number % 10;

			if (digit % 2 == 0) {
				evenDigitCount++;
			}

			number /= 10;

		} while (number > 0);

		return evenDigitCount;
	}

	public static int countMoviesAboveAverageRating(ArrayList<Movie> movies) {

		double tolalValidMoviesRating = 0.0;
		int validMoviesCount = 0;
		double validMoviesAverage = 0.0;
		int validMoviesBestAverageCount = 0;
		ArrayList<Movie> validMovies = new ArrayList<>();

		for (Movie movie : movies) {

			if (movie == null || movie.getTitle() == null || movie.getTitle().isBlank() || movie.getDuration() <= 0
					|| movie.getRating() < 0 || movie.getRating() > 10) {
				continue;
			}
			validMovies.add(movie);
			tolalValidMoviesRating += movie.getRating();
			validMoviesCount++;
		}

		if (validMoviesCount == 0) {
			return 0;
		}

		validMoviesAverage = tolalValidMoviesRating / validMoviesCount;

		for (Movie movie : validMovies) {

			if (movie.getRating() > validMoviesAverage) {
				validMoviesBestAverageCount++;
			}
		}

		return validMoviesBestAverageCount;
	}

	public static int removeDuplicateTitles1(ArrayList<Movie> movies) {

		int deletedCount = 0;

		for (int i = 0; i < movies.size(); i++) {
			Movie currentMovie = movies.get(i);
			int j = i + 1;

			while (j < movies.size()) {
				Movie comparedMovie = movies.get(j);

				if (currentMovie.getTitle().equalsIgnoreCase(comparedMovie.getTitle())) {
					movies.remove(j);
					deletedCount++;
				} else {
					j++;
				}
			}

		}

		return deletedCount;
	}

	public static int countIncreasesFromPrevious(int[] numbers) {

		int count = 0;

		if (numbers.length == 0) {
			return count;
		}

		int previousNumber = numbers[0];

		for (int i = 1; i < numbers.length; i++) {
			int currentNumber = numbers[i];

			if (previousNumber < currentNumber) {
				count++;
			}

			previousNumber = currentNumber;
		}

		return count;
	}

	public static int countRowsAboveAverage(int[][] numbers, double minimumAverage) {

		int countRow = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].length == 0) {
				continue;
			}

			double averageRow = 0.0;
			double total = 0.0;
			int j = 0;

			while (j < numbers[i].length) {

				total += numbers[i][j];
				j++;
			}

			averageRow = total / numbers[i].length;

			if (averageRow >= minimumAverage) {
				countRow++;
			}
		}

		return countRow;
	}

	public static void countRowNegativ(int[][] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			int j = 0;

			while (j < numbers[i].length) {

				if (numbers[i][j] < 0) {
					count++;
				}
				j++;
			}

			System.out.println("négativs numbers row " + (i + 1) + " : " + count);
		}

	}

	public static void countGreaterThanPrevious(int[][] numbers) {

		for (int i = 0; i < numbers.length; i++) {
			boolean hasPrevious = false;
			int previousNumber = 0;
			int count = 0;
			int j = 0;

			while (j < numbers[i].length) {

				if (hasPrevious && previousNumber < numbers[i][j]) {
					count++;
				}

				previousNumber = numbers[i][j];
				hasPrevious = true;
				j++;
			}

			System.out.println("Ascending numbers row " + (i + 1) + " : " + count);
		}
	}

	public static int countTitlesStartingSameLetter(ArrayList<Movie> movies) {
		int count = 0;

		for (int i = 1; i < movies.size(); i++) {

			if ((movies.get(i - 1).getTitle() == null || movies.get(i).getTitle() == null)
					|| (movies.get(i - 1).getTitle().isBlank() || movies.get(i).getTitle().isBlank())) {
				continue;
			}

			char previousFirstChar = movies.get(i - 1).getTitle().charAt(0);
			char currentFirstChar = movies.get(i).getTitle().charAt(0);

			if (Character.toLowerCase(previousFirstChar) == Character.toLowerCase(currentFirstChar)) {
				count++;
			}
		}
		return count;
	}

	public static double averageRatingLongMovies(ArrayList<Movie> movies, int minDuration) {

		int count = 0;
		double total = 0;

		for (Movie movie : movies) {

			if (movie.getDuration() > minDuration) {
				total += movie.getRating();
				count++;
			}
		}

		if (count != 0) {
			return total / count;
		}
		return 0;
	}

	public static String highestRatedTitle(ArrayList<Movie> movies) {

		if (movies.isEmpty()) {
			return "none";
		}

		int i = 1;
		double bestRating = movies.get(0).getRating();
		String bestRatingTitle = movies.get(0).getTitle();

		while (i < movies.size()) {
			double currentRating = movies.get(i).getRating();

			if (currentRating > bestRating) {
				bestRating = currentRating;
				bestRatingTitle = movies.get(i).getTitle();
			}
			i++;
		}

		return bestRatingTitle;
	}

	public static int countPositiveHigherThanPrevious(int[] numbers) {

		if (numbers.length == 0 || numbers.length < 1) {
			return 0;
		}

		int count = 0;
		int i = 1;

		while (i < numbers.length) {
			int previousNumber = numbers[i - 1];
			int currentNumber = numbers[i];

			if (currentNumber > 0 && currentNumber > previousNumber) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int longestPositiveCommandStreak(String commands) {
		int count = 0;
		int currentCount = 0;
		int i = 0;

		while (i < commands.length()) {
			char charCommand = commands.charAt(i);

			switch (Character.toLowerCase(charCommand)) {

			case 'a':
				currentCount++;
				break;
			case 'b':
				currentCount++;
				break;
			default:
				currentCount = 0;
				break;
			}
			if (currentCount > count) {
				count = currentCount;
			}
			i++;
		}

		return count;
	}

	public static int rowWithHighestSum(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		int index = -1;
		int bestTotal = 0;
		int i = 0;

		while (i < numbers.length) {
			int totalRow = 0;
			int j = 0;

			while (j < numbers[i].length) {
				totalRow += numbers[i][j];
				j++;
			}
			if (index == -1 || totalRow > bestTotal) {
				bestTotal = totalRow;
				index = i;
			}
			i++;
		}
		return index;
	}

	public static int countValidCommands(ArrayList<String> commands) {
		int count = 0;
		int i = 0;

		if (commands.isEmpty()) {
			return 0;
		}

		while (i < commands.size()) {
			String command = commands.get(i);

			if (command == null || command.isBlank()) {
				i++;
				continue;
			}

			if (command.equalsIgnoreCase("stop")) {
				break;
			}

			if (command.equalsIgnoreCase("add") || command.equalsIgnoreCase("remove")) {
				count++;
			}
			i++;
		}

		return count;
	}

	public static int firstPositiveNumber(String[] values) {
		int i = 0;

		if (values.length == 0) {
			return -1;
		}

		do {

			if (values[i].isBlank()) {
				i++;
				continue;
			}

			try {
				int positivFirstValue = Integer.parseInt(values[i]);

				if (positivFirstValue > 0) {
					return positivFirstValue;
				}
				i++;
			} catch (NumberFormatException e) {
				i++;
			}

		} while (i < values.length);

		return -1;
	}

	public static int countDistinctDuplicates(int[] numbers) {
		int count = 0;
		int i = 0;

		if (numbers.length == 0) {
			return 0;
		}

		while (i < numbers.length) {
			boolean alreadySeen = false;
			int j = 0;

			while (j < i) {
				if (numbers[i] == numbers[j]) {
					alreadySeen = true;
					break;
				}
				j++;
			}

			if (alreadySeen) {
				i++;
				continue;
			}

			boolean seeAgain = false;
			int k = i + 1;

			while (k < numbers.length) {
				if (numbers[i] == numbers[k]) {
					seeAgain = true;
					break;
				}
				k++;
			}

			if (seeAgain) {
				count++;
			}
			i++;
		}

		return count;
	}

	public static int columnWithMostPositives(int[][] numbers) {
		int index = -1;
		int betterCount = 0;

		if (numbers.length == 0) {
			return index;
		}

		for (int j = 0; j < numbers[0].length; j++) {
			int columnCount = 0;

			for (int i = 0; i < numbers.length; i++) {
				int number = numbers[i][j];
				if (number > 0) {
					columnCount++;
				}
			}
			if (index == -1 || columnCount > betterCount) {
				betterCount = columnCount;
				index = j;
			}
		}
		return index;
	}

	public static int countRepeatedFirstLetters(ArrayList<Movie> movies) {
		int count = 0;

		if (movies.isEmpty()) {
			return count;
		}

		for (int i = 0; i < movies.size(); i++) {
			char char2 = Character.toLowerCase(movies.get(i).getTitle().charAt(0));
			boolean alreadySeen = false;

			for (int j = 0; j < i; j++) {
				char char1 = Character.toLowerCase(movies.get(j).getTitle().charAt(0));

				if (char1 == char2) {
					alreadySeen = true;
					break;
				}
			}

			if (alreadySeen) {
				continue;
			}
			boolean seeAgain = false;
			for (int k = i + 1; k < movies.size(); k++) {
				char char3 = Character.toLowerCase(movies.get(k).getTitle().charAt(0));
				if (char2 == char3) {
					seeAgain = true;
					break;
				}
			}

			if (seeAgain) {
				count++;
			}
		}

		return count;
	}

	public static int countRowsHigherThanPrevious(int[][] numbers) {
		int count = 0;
		int totalPreviousRow = 0;
		boolean hasPrevious = false;

		if (numbers.length == 0) {
			return count;
		}

		int i = 0;
		while (i < numbers.length) {
			int j = 0;
			int totalRow = 0;

			while (j < numbers[i].length) {
				totalRow += numbers[i][j];
				j++;
			}

			if (hasPrevious && totalRow > totalPreviousRow) {
				count++;
			}
			totalPreviousRow = totalRow;
			hasPrevious = true;

			i++;
		}

		return count;
	}

	public static int calculateStock(ArrayList<String> commands) {
		int stock = 0;

		if (commands.isEmpty()) {
			return 0;
		}

		for (String command : commands) {
			if (command == null || command.isBlank()) {
				continue;
			}
			if (command.equalsIgnoreCase("stop")) {
				return stock;
			}
			if (command.equalsIgnoreCase("r")) {
				stock = 0;
				continue;
			}

			try {
				char operator = command.charAt(0);
				int number = Integer.parseInt(command.substring(1));

				switch (Character.toLowerCase(operator)) {
				case '+':
					stock += number;
					break;
				case '-':
					stock -= number;
					break;
				default:
					break;
				}

				if (stock < 0) {
					stock = 0;
				}

			} catch (NumberFormatException e) {
			}
		}

		return stock;
	}

	public static int countRowsWithPositiveMax(int[][] numbers) {
		int count = 0;

		if (numbers.length == 0) {
			return 0;
		}

		int i = 0;
		while (i < numbers.length) {
			int maximumToRow = numbers[i][0];
			int j = 1;

			while (j < numbers[i].length) {
				int number = numbers[i][j];

				if (number > maximumToRow) {
					maximumToRow = number;
				}
				j++;
			}

			if (maximumToRow > 0) {
				count++;
			}
			i++;
		}

		return count;
	}

	public static int countLocalPeaks(int[] numbers) {

		int peaksCount = 0;

		if (numbers.length < 3) {
			return 0;
		}

		int i = 1;

		while (i < numbers.length - 1) {

			if (numbers[i] > numbers[i - 1] && numbers[i] > numbers[i + 1]) {

				peaksCount++;
			}

			i++;
		}

		return peaksCount;
	}

	public static String bestShortMovie(ArrayList<Movie> movies, int maxDuration) {

		if (movies.isEmpty()) {
			return "none";
		}

		Movie m3 = null;

		for (int i = 0; i < movies.size(); i++) {
			Movie m1 = movies.get(i);

			if (m1.getDuration() > maxDuration) {
				continue;
			}

			if (m3 == null || m1.getRating() > m3.getRating()
					|| (m1.getRating() == m3.getRating() && m1.getDuration() < m3.getDuration())) {

				m3 = m1;
			}
		}

		if (m3 == null) {
			return "none";
		}
		return m3.getTitle();
	}

	public static int longestIncreasingRatingStreak1(ArrayList<Movie> movies) {

		if (movies.isEmpty()) {
			return 0;
		}

		int bestCount = 1;
		int count = 1;
		double previousRating = movies.get(0).getRating();

		for (int i = 1; i < movies.size(); i++) {
			double currentRating = movies.get(i).getRating();

			if (previousRating < currentRating) {
				count++;
			} else {
				count = 1;
			}

			previousRating = currentRating;

			if (count > bestCount) {
				bestCount = count;
			}
		}

		return bestCount;
	}

	public static int countMixedRows(int[][] numbers) {
		int count = 0;

		if (numbers.length == 0) {
			return 0;
		}

		int i = 0;
		while (i < numbers.length) {
			boolean negativ = false;
			boolean positiv = false;
			int j = 0;

			while (j < numbers[i].length) {
				int number = numbers[i][j];

				if (number > 0) {
					positiv = true;
				}
				if (number < 0) {
					negativ = true;
				}
				if (number == 0) {
					negativ = false;
					positiv = false;
					break;
				}
				j++;
			}

			if (positiv && negativ) {
				count++;
			}
			i++;
		}
		return count;
	}

	public static int countMoviesAboveAverage1(ArrayList<Movie> movies) {

		if (movies.isEmpty()) {
			return 0;
		}

		double total = 0;

		for (Movie movie : movies) {
			total += movie.getRating();
		}

		double average = total / movies.size();

		int count = 0;

		for (Movie movie : movies) {
			if (movie.getRating() > average) {
				count++;
			}
		}
		return count;
	}

	public static int countRowsAboveGlobalAverage(int[][] numbers) {

		if (numbers.length == 0) {
			return 0;
		}

		int total = 0;
		double average = 0;
		int countNumbers = 0;

		for (int[] row : numbers) {
			for (int number : row) {
				total += number;
				countNumbers++;
			}

			average = (double) total / countNumbers;
		}

		int count = 0;

		for (int i = 0; i < numbers.length; i++) {

			int totalRow = 0;
			double averageRow = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				totalRow += numbers[i][j];

			}

			averageRow = (double) totalRow / numbers[i].length;

			if (averageRow > average) {
				count++;
			}
		}

		return count;
	}

	public static int rowWithBestPositiveAverage(int[][] numbers) {

		double bestAverage = 0;
		int index = -1;

		for (int i = 0; i < numbers.length; i++) {

			int totalRow = 0;
			int countRow = 0;
			double averageRow = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				int number = numbers[i][j];

				if (number > 0) {
					totalRow += number;
					countRow++;
				}
			}

			if (countRow == 0) {
				continue;
			}
			averageRow = (double) totalRow / countRow;

			if (index == -1 || averageRow > bestAverage) {
				bestAverage = averageRow;
				index = i;
			}
		}

		return index;
	}

	public static String firstTitleOfLongestAboveAverageStreak(ArrayList<Movie> movies) {

		if (movies.size() == 0) {
			return "none";
		}

		double total = 0;
		double average = 0;

		for (Movie movie : movies) {

			total += movie.getRating();
		}

		average = total / movies.size();

		int bestSerie = 0;
		int currentSerie = 0;
		int firstIndex = -1;
		int i = movies.size() - 1;

		while (i >= 0) {

			if (movies.get(i).getRating() > average) {
				currentSerie++;

				if (currentSerie >= bestSerie) {
					firstIndex = i;
					bestSerie = currentSerie;
				}

			} else {
				currentSerie = 0;
			}

			i--;
		}

		if (firstIndex == -1) {
			return "none";
		}
		return movies.get(firstIndex).getTitle();
	}

	public static String bestRatedMovieWithRepeatedInitial(ArrayList<Movie> movies) {

		if (movies.isEmpty()) {
			return "none";
		}

		String title = "none";
		Movie m1 = null;

		for (int i = 0; i < movies.size(); i++) {

			if (movies.get(i).getTitle().isBlank()) {
				continue;
			}

			Movie m2 = movies.get(i);
			char secondChar = Character.toLowerCase(m2.getTitle().charAt(0));
			boolean isValid = false;

			for (int j = 0; j < movies.size(); j++) {

				if (j == i) {
					continue;
				}
				if (movies.get(j).getTitle().isBlank()) {
					continue;
				}

				Movie m3 = movies.get(j);
				char firstChar = Character.toLowerCase(m3.getTitle().charAt(0));

				if (firstChar == secondChar) {
					isValid = true;
					break;
				}
			}

			if (!isValid) {
				continue;
			}

			if (m1 == null || m2.getRating() > m1.getRating()
					|| (m2.getRating() == m1.getRating() && m2.getDuration() < m1.getDuration())) {

				m1 = m2;
				title = m2.getTitle();
			}
		}

		return title;
	}

	public static int rowWithLongestIncreasingStreak(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		int bestCount = 1;
		int bestTotal = 0;
		int index = -1;

		for (int i = 0; i < numbers.length; i++) {

			int countRowSerie = 1;
			int bestRowSerie = 1;
			int totalRow = numbers[i][0];

			for (int j = 1; j < numbers[i].length; j++) {

				totalRow += numbers[i][j];

				int previousNumber = numbers[i][j - 1];
				int nextNumber = numbers[i][j];

				if (previousNumber < nextNumber) {
					countRowSerie++;
				} else {
					countRowSerie = 1;
				}

				if (countRowSerie > bestRowSerie) {
					bestRowSerie = countRowSerie;
				}
			}

			if (index == -1 || bestRowSerie > bestCount || (bestRowSerie == bestCount && totalRow > bestTotal)) {

				bestCount = countRowSerie;
				bestTotal = totalRow;
				index = i;
			}
		}

		return index;
	}

	public static int columnWithMostValuesAboveRowAverage(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		int maxCountColumnNumbers = 0;
		int index = -1;
		double currentAverageRow = 0;
		int[] countColumnNumbers = new int[numbers[0].length];

		for (int i = 0; i < numbers.length; i++) {

			int totalRow = 0;

			if (numbers[i].length == 0) {
				continue;
			}

			for (int j = 0; j < numbers[i].length; j++) {

				totalRow += numbers[i][j];
			}

			double averageRow = (double) totalRow / numbers[i].length;
			currentAverageRow = averageRow;

			for (int j = 0; j < numbers[0].length; j++) {

				if (numbers[i][j] > currentAverageRow) {
					countColumnNumbers[j]++;
				}
			}
		}

		for (int j = 0; j < numbers[0].length; j++) {

			if (index == -1 || countColumnNumbers[j] > maxCountColumnNumbers) {
				maxCountColumnNumbers = countColumnNumbers[j];
				index = j;
			}
		}

		return index;
	}

	public static int countColumnsWithHigherAverageThanPrevious(int[][] numbers) {

		if (numbers.length == 0) {
			return 0;
		}

		int count = 0;
		boolean hasPrevious = false;
		double previousAverage = 0;

		for (int j = 0; j < numbers[0].length; j++) {

			int currentTotal = 0;

			for (int i = 0; i < numbers.length; i++) {

				if (numbers[i].length == 0) {
					continue;
				}

				currentTotal += numbers[i][j];
			}

			double currentAverage = (double) currentTotal / numbers.length;

			if (hasPrevious && previousAverage < currentAverage) {
				count++;
			}

			previousAverage = currentAverage;
			hasPrevious = true;
		}

		return count;
	}

	public static int rowWithMostValuesAboveColumnAverage(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		int index = -1;
		int bestTotal = 0;
		int bestCount = 0;
		double[] columnAverages = new double[numbers[0].length];

		for (int j = 0; j < numbers[0].length; j++) {

			int totalColumn = 0;
			double averageColumn = 0;

			for (int i = 0; i < numbers.length; i++) {

				totalColumn += numbers[i][j];
			}

			averageColumn = (double) totalColumn / numbers.length;
			columnAverages[j] = averageColumn;
		}

		for (int i = 0; i < numbers.length; i++) {

			int count = 0;
			int totalRow = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				if (columnAverages[j] < numbers[i][j]) {
					count++;
				}

				totalRow += numbers[i][j];
			}

			if (index == -1 || count > bestCount || count == bestCount && bestTotal < totalRow) {
				bestTotal = totalRow;
				bestCount = count;
				index = i;
			}
		}

		return index;
	}

	public static int rowWithMostColumnMaximums(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		int[] columnNumbersMax = new int[numbers[0].length];

		for (int j = 0; j < numbers[0].length; j++) {

			int maxNumber = numbers[0][j];

			for (int i = 0; i < numbers.length; i++) {

				if (numbers[i][j] > maxNumber) {
					maxNumber = numbers[i][j];
				}
			}
			columnNumbersMax[j] = maxNumber;
		}

		int index = -1;
		int maxCount = 0;
		int maxTotal = 0;

		for (int i = 0; i < numbers.length; i++) {

			int count = 0;
			int total = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				total += numbers[i][j];

				if (numbers[i][j] == columnNumbersMax[j]) {
					count++;
				}
			}

			if (index == -1 || count > maxCount || count == maxCount && maxTotal < total) {
				maxTotal = total;
				maxCount = count;
				index = i;
			}
		}

		return index;
	}

	public static int indexOfHighestBalance(ArrayList<String> commands) {

		int index = -1;
		int maxValue = 0;
		int solde = 0;

		for (int i = 0; i < commands.size(); i++) {

			if (commands.get(i) == null || commands.get(i).isBlank()) {
				continue;
			}

			if (commands.get(i).equalsIgnoreCase("r")) {
				solde = 0;
			}

			if (commands.get(i).length() < 2) {
				continue;
			}

			char operator = commands.get(i).charAt(0);

			try {
				int number = Integer.parseInt(commands.get(i).substring(1));

				switch (operator) {
				case '+':
					solde += number;

					if (maxValue < solde) {
						maxValue = solde;
						index = i;
					}
					break;

				case '-':
					solde -= number;

					if (solde < 0) {
						solde = 0;
					}
					break;

				default:
					break;
				}

			} catch (NumberFormatException e) {
			}
		}

		return index;
	}

	public static String firstMovieOfBestValidStreak(ArrayList<Movie> movies) {

		double minimumRating = 7.5;
		int maxDuration = 150;
		int count = 0;
		int maxCount = 0;
		double bestSerieBetterTotal = 0;
		double serieTotal = 0;
		String title = "none";

		for (int i = movies.size() - 1; i >= 0; i--) {

			String currentTitle = movies.get(i).getTitle();
			double rating = movies.get(i).getRating();
			int duration = movies.get(i).getDuration();

			if (currentTitle == null || currentTitle.isBlank() || rating <= minimumRating || duration >= maxDuration) {
				serieTotal = 0;
				count = 0;
			} else {
				count++;
				serieTotal += rating;
			}

			if (title.equals("none") || count > maxCount || count == maxCount && bestSerieBetterTotal <= serieTotal) {
				bestSerieBetterTotal = serieTotal;
				maxCount = count;
				title = currentTitle;
			}
		}

		return title;
	}

	public static int countMoviesAboveSameInitialAverage(ArrayList<Movie> movies) {
		int count = 0;

		for (int i = 0; i < movies.size(); i++) {

			double average = 0;
			double total = 0;
			int countSameInitial = 0;
			String currentTitle = movies.get(i).getTitle();
			char currentFirstChar = currentTitle.charAt(0);

			for (int j = 0; j < movies.size(); j++) {

				if (j == i) {
					continue;
				}

				String testTitle = movies.get(j).getTitle();
				char testFirstChar = currentTitle.charAt(0);

				if (Character.toLowerCase(currentFirstChar) == Character.toLowerCase(testFirstChar)) {
					total += movies.get(j).getRating();
					countSameInitial++;
				}
			}

			if (countSameInitial > 0) {
				average = total / countSameInitial;
			}
			if (movies.get(i).getRating() > average) {
				count++;
			}
		}

		return count;
	}

	public static int columnWithHighestAverage(int[][] numbers) {

		int index = -1;
		int maxColumns = 0;
		double maxAverageColumn = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].length > maxColumns) {
				maxColumns = numbers[i].length;
			}
		}

		for (int j = 0; j < maxColumns; j++) {

			int totalColumn = 0;
			int countColumn = 0;

			for (int i = 0; i < numbers.length; i++) {

				if (j < numbers[i].length) {
					totalColumn += numbers[i][j];
					countColumn++;
				}
			}

			double averageColumn = (double) totalColumn / countColumn;

			if (index == -1 || averageColumn > maxAverageColumn) {
				maxAverageColumn = averageColumn;
				index = j;
			}
		}

		return index;
	}

	public static int startIndexOfBestPositiveStreak(ArrayList<String> values) {

		int count = 0;
		int maxTotal = 0;
		int maxCount = 0;
		int index = -1;
		int total = 0;

		for (int i = values.size() - 1; i >= 0; i--) {

			if (values.get(i) == null || values.get(i).isBlank()) {
				count = 0;
				total = 0;
				continue;
			}

			try {
				int number = Integer.parseInt(values.get(i));
				if (number <= 0) {
					count = 0;
					total = 0;
					continue;
				}
				count++;
				total += number;

			} catch (NumberFormatException e) {
				count = 0;
				total = 0;
				continue;
			}

			if (index == -1 || count > maxCount || count == maxCount && total >= maxTotal) {
				maxTotal = total;
				maxCount = count;
				index = i;

			}
		}

		return index;
	}

	public static String bestMovieFromBestInitialGroup(ArrayList<Movie> movies) {

		String title = "none";
		double bestAverage = 0;
		double average = 0;

		for (int i = 0; i < movies.size(); i++) {

			String previousTitle = movies.get(i).getTitle();
			char previousChar = Character.toLowerCase(previousTitle.charAt(0));
			double total = movies.get(i).getRating();
			int countSameInitial = 1;
			Movie bestMovie = movies.get(i);

			for (int j = movies.size() - 1; j >= 0; j--) {

				if (i == j) {

					continue;
				}

				String currentTitle = movies.get(j).getTitle();
				char currentChar = Character.toLowerCase(currentTitle.charAt(0));

				if (currentChar == previousChar) {
					countSameInitial++;

					total += movies.get(j).getRating();

					if (movies.get(j).getRating() > bestMovie.getRating()
							|| (movies.get(j).getRating() == bestMovie.getRating()
									&& movies.get(j).getDuration() < bestMovie.getDuration())) {

						bestMovie = movies.get(j);
					}
				}
			}

			if (countSameInitial >= 2) {

				average = total / countSameInitial;

				if (average > bestAverage) {

					bestAverage = average;
					title = bestMovie.getTitle();
				}
			}
		}

		return title;
	}

	public static int rowClosestToGlobalAverage(int[][] numbers) {

		int index = -1;
		double averageAll = 0;
		int totalAll = 0;
		int countAll = 0;

		for (int i = 0; i < numbers.length; i++) {

			for (int j = 0; j < numbers[i].length; j++) {

				totalAll += numbers[i][j];
				countAll++;
			}

		}

		if (countAll == 0) {
			return -1;
		}

		averageAll = (double) totalAll / countAll;
		double betterAverageDistance = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].length == 0) {
				continue;
			}

			int totalRow = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				totalRow += numbers[i][j];
			}

			double averageRow = (double) totalRow / numbers[i].length;
			double currentAverageDistance = Math.abs(averageRow - averageAll);

			if (index == -1 || currentAverageDistance < betterAverageDistance) {
				betterAverageDistance = currentAverageDistance;
				index = i;
			}
		}

		return index;
	}

	public static int indexClosestToAverageValue(ArrayList<String> values) {

		int totalAll = 0;
		int countAll = 0;
		double averageAll = 0;
		double bestDistance = 0;
		int index = -1;

		if (values.size() == 0) {
			return -1;
		}

		for (int i = 0; i < values.size(); i++) {

			if (values.get(i) == null || values.get(i).isBlank()) {
				continue;
			}

			try {
				int number = Integer.parseInt(values.get(i));
				totalAll += number;
				countAll++;

			} catch (NumberFormatException e) {
				continue;
			}
		}

		if (countAll == 0) {
			return -1;
		}

		averageAll = (double) totalAll / countAll;

		for (int i = 0; i < values.size(); i++) {

			if (values.get(i) == null || values.get(i).isBlank()) {
				continue;
			}

			try {
				int number = Integer.parseInt(values.get(i));

				double distance = Math.abs(number - averageAll);

				if (index == -1 || bestDistance > distance) {
					bestDistance = distance;
					index = i;
				}

			} catch (NumberFormatException e) {
				continue;
			}
		}
		return index;
	}

	public static int countDominantMovies(ArrayList<Movie> movies) {

		int count = 0;

		for (int i = 0; i < movies.size(); i++) {

			if (movies.get(i).getTitle() == null || movies.get(i).getTitle().isBlank()) {
				continue;
			}

			Movie movieI = movies.get(i);
			String titleI = movies.get(i).getTitle();
			char charI = Character.toLowerCase(titleI.charAt(0));

			for (int j = 0; j < movies.size(); j++) {

				if (movies.get(j).getTitle() == null || movies.get(j).getTitle().isBlank()) {
					continue;
				}

				if (j == i) {
					continue;
				}

				Movie movieJ = movies.get(j);
				String titleJ = movies.get(j).getTitle();
				char charJ = Character.toLowerCase(titleJ.charAt(0));

				if (charJ == charI && movieJ.getRating() < movieI.getRating()
						&& movieJ.getDuration() > movieI.getDuration()) {
					count++;
					break;
				}
			}

		}

		return count;
	}

	public static int rowWithMostDistinctPositives(int[][] numbers) {

		int bestCount = 0;
		int maxTotal = 0;
		int index = -1;

		for (int i = 0; i < numbers.length; i++) {

			int count = 0;
			int currentTotal = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				int numberJ = numbers[i][j];
				boolean saw = false;

				currentTotal += numberJ;

				if (numberJ <= 0) {
					continue;
				}

				for (int k = 0; k < j; k++) {

					int numberK = numbers[i][k];

					if (numberJ == numberK) {
						saw = true;
						break;
					}
				}

				if (!saw) {
					count++;
				}
			}

			if (index == -1 || count > bestCount || count == bestCount && currentTotal > maxTotal) {
				bestCount = count;
				maxTotal = currentTotal;
				index = i;
			}
		}

		return index;
	}

	public static int columnWithMostDistinctPositives(int[][] numbers) {

		int maxColumns = 0;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].length > maxColumns) {
				maxColumns = numbers[i].length;
			}
		}

		int maxColumn = 0;
		int index = -1;
		int maxCount = 0;

		for (int j = 0; j < maxColumns; j++) {

			int countPositiv = 0;
			int totalColumn = 0;

			for (int i = 0; i < numbers.length; i++) {

				if (j < numbers[i].length) {

					int currentNumber = numbers[i][j];

					totalColumn += numbers[i][j];

					if (currentNumber <= 0) {
						continue;
					}

					boolean saw = false;

					for (int k = 0; k < i; k++) {

						if (j < numbers[k].length) {

							int nextNumber = numbers[k][j];

							if (nextNumber == currentNumber) {
								saw = true;
								break;
							}
						}
					}

					if (!saw) {
						countPositiv++;
					}
				}
			}

			if (index == -1 || countPositiv > maxCount || countPositiv == maxCount && totalColumn > maxColumn) {
				maxColumn = totalColumn;
				maxCount = countPositiv;
				index = j;
			}
		}

		return index;
	}

	public static int rowWithMostLocalPeaks(int[][] numbers) {

		int maxPeaksCount = 0;
		int index = -1;
		int maxTotalRow = 0;

		for (int i = 0; i < numbers.length; i++) {

			int peaksCount = 0;
			int totalRow = 0;

			for (int j = 1; j < numbers[i].length - 1; j++) {

				int previousNumber = numbers[i][j - 1];
				int currentNumber = numbers[i][j];
				int nextNumber = numbers[i][j + 1];

				if (previousNumber < currentNumber && currentNumber > nextNumber) {
					peaksCount++;
				}
			}

			for (int k = 0; k < numbers[i].length; k++) {

				totalRow += numbers[i][k];
			}

			if (index == -1 || peaksCount > maxPeaksCount || peaksCount == maxPeaksCount && totalRow > maxTotalRow) {
				maxPeaksCount = peaksCount;
				maxTotalRow = totalRow;
				index = i;
			}
		}

		return index;
	}

	public static int indexOfMostFrequentValidNumber(ArrayList<String> values) {

		int index = -1;
		int maxCount = 1;

		for (int i = 0; i < values.size(); i++) {

			if (values.get(i) == null || values.get(i).isBlank()) {
				continue;
			}

			int number;

			try {

				number = Integer.parseInt(values.get(i));

			} catch (NumberFormatException e) {
				continue;
			}

			int count = 1;

			for (int j = values.size() - 1; j > i; j--) {

				if (values.get(j) == null || values.get(j).isBlank()) {
					continue;
				}

				try {

					int numberJ = Integer.parseInt(values.get(j));

					if (number == numberJ) {
						count++;
					}

				} catch (NumberFormatException e) {
					continue;
				}

			}

			if (index == -1 || maxCount < count) {
				maxCount = count;
				index = i;
			}
		}

		return index;
	}

	public static int indexOfMostIsolatedNumber(int[] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		if (numbers.length == 1) {
			return 0;
		}

		int index = -1;
		int maxBetterDistance = 0;

		for (int i = 0; i < numbers.length; i++) {

			int testedNumber = numbers[i];
			int betterDistance = -1;

			for (int j = 0; j < numbers.length; j++) {

				if (j == i) {
					continue;
				}

				int number = numbers[j];

				int currentDistance = Math.abs(testedNumber - number);

				if (betterDistance == -1 || currentDistance < betterDistance) {
					betterDistance = currentDistance;
				}
			}

			if (index == -1 || betterDistance > maxBetterDistance) {
				maxBetterDistance = betterDistance;
				index = i;
			}
		}

		return index;
	}

	public static int indexOfBestMovieWithUniqueDuration(ArrayList<Movie> movies) {

		int index = -1;

		for (int i = 0; i < movies.size(); i++) {

			if (movies.get(i).getTitle() == null || movies.get(i).getTitle().isBlank()) {
				continue;
			}

			boolean isValid = true;

			for (int j = 0; j < movies.size(); j++) {

				if (movies.get(j).getTitle() == null || movies.get(j).getTitle().isBlank() || j == i) {
					continue;
				}

				if (movies.get(i).getDuration() == movies.get(j).getDuration()) {
					isValid = false;
					break;
				}

			}
			if (!isValid) {
				continue;
			}

			if (index == -1 || movies.get(i).getRating() > movies.get(index).getRating()) {
				index = i;
			}
		}

		return index;
	}

	public static int rowWithMostRepeatedValues(int[][] numbers) {

		if (numbers.length == 0) {
			return -1;
		}

		if (numbers.length == 1) {
			return 0;
		}

		int maxCountRepeatedValues = 0;
		int maxTotalRow = -1;
		int index = -1;

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i].length == 0) {
				continue;
			}

			int totalRow = 0;
			int count = 0;

			for (int j = 0; j < numbers[i].length; j++) {

				boolean saw = false;
				int number = numbers[i][j];
				int countRepeatedValues = 0;

				totalRow += number;

				for (int k = 0; k < numbers[i].length; k++) {

					if (k == j) {
						continue;
					}

					if (number == numbers[i][k]) {
						countRepeatedValues++;

						if (k < j) {
							saw = true;
						}
					}
				}

				if (!saw && countRepeatedValues > 0) {
					count++;
				}

				if (index == -1 || maxCountRepeatedValues < count
						|| maxCountRepeatedValues == count && totalRow > maxTotalRow) {
					maxTotalRow = totalRow;
					maxCountRepeatedValues = count;
					index = i;
				}
			}

		}

		return index;
	}
}
