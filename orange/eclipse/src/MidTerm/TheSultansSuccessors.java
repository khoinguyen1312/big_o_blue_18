package MidTerm;

import java.util.Scanner;

public class TheSultansSuccessors {
	public static int MAX_BOARD = 0;
	
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);
		
		int k = argumentScanner.nextInt();
		
		for (int chessCounter = 0; chessCounter < k; chessCounter++) {
			MAX_BOARD = 0;
			boolean[][] boardChecker = new boolean[8][8];
			int[][] board = new int[8][8];
			
			for (int i = 0; i < boardChecker.length; i++) {
				for (int j = 0; j < boardChecker.length; j++) {
					boardChecker[i][j] = false;
					board[i][j] = argumentScanner.nextInt();
				}
			}
			queen(board, boardChecker, 0);
			
			System.out.println(MAX_BOARD);
		}
		
		argumentScanner.close();
	}
	
	
	
	private static boolean check(boolean[][] boardChecker, int row, int col) {
		for (int i = 0; i < row; i++) {
			if (boardChecker[i][col]) {
				return false;
			}
		}
		
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (boardChecker[i][j]) {
				return false;
			}
		}

		
		for (int i = row, j = col; i >= 0 && j < boardChecker.length; i--, j++) {
			if (boardChecker[i][j]) {
				return false;
			}
		}
		
		return true;
	}
	
	private static void queen(int[][] board, boolean[][] boardChecker, int row) {
		if (row == board.length) {
			calculateMax(board, boardChecker);
			return;
		}
		
		for (int j = 0; j < board.length; j++) {
			if (check(boardChecker, row, j)) {
				boardChecker[row][j] = true;
				queen(board, boardChecker, row + 1);
				boardChecker[row][j] = false;
			}
		}		
	}



	private static void calculateMax(int[][] board, boolean[][] boardChecker) {
		int currentMax = 0;
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (boardChecker[i][j]) {
					currentMax += board[i][j];
				}
			}
		}
		
		if (currentMax >= MAX_BOARD) {
			MAX_BOARD = currentMax;
		}
	}
}
