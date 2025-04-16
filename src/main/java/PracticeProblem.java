public class PracticeProblem {

	public static int searchMazeMoves(String[][] array) {
		int row = array.length - 1;
		int column = 0;
		int numOfSteps = 0;

		return searchMazeMovesHelper(row, column, array, numOfSteps);


	}

	private static int searchMazeMovesHelper(int row, int column, String[][] arr, int moves) {
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[row].length) {
			return -1;
		}
		if (arr[row][column].equals("F")) {
			return moves;
		}

		int right = searchMazeMovesHelper(row, column + 1, arr, moves + 1);
		int up = searchMazeMovesHelper(row - 1, column, arr, moves + 1);

		if (right != -1 && up != -1) {
			return Math.min(right, up);
		}
		else if (right == -1) {
			return up;
		}
		else {
			return right;
		}
	}

	public static int noOfPaths(String[][] arr) {
		int row = arr.length - 1;
		int column = 0;

		return noOfPathsHelper(arr, row, column);
	}

	private static int noOfPathsHelper(String[][] arr, int row, int column) {
		if (row < 0 || row >= arr.length || column < 0 || column >= arr[row].length) {
			return -1;
		}

		if (arr[row][column].equals("F")) {
			return 1;
		}

		int right = noOfPathsHelper(arr, row, column + 1);
		int up = noOfPathsHelper(arr, row - 1, column);

		if (right == -1) {
			right = 0;
		}
		if (up == -1) {
			up = 0;
		}

		return right + up;
	}

	public static void main(String args[]) {
		String[][] maze = {
			{"", "", "", "F"}, 
			{"", "", "", ""}, 
			{"", "", "", ""},
			{"S", "", "", ""}
		};

		int result = searchMazeMoves(maze);
		System.out.println(result);

		int result2 = noOfPaths(maze);
		System.out.println(result2);

		}

		
	}

	


