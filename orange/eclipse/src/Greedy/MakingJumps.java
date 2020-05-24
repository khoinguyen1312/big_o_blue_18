package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MakingJumps {
	public static int NOT_ALLOWED = -1;
	public static int UNMOVED = 0;
	public static int MOVED = 1;
	
	public static void main(String[] args) {
		Scanner argumentScanner = new Scanner(System.in);

		int numberOfCustomInput = argumentScanner.nextInt();
		int problemCounter = 1;
		
		while (numberOfCustomInput != 0) {
			
			int[][] chessBoard = new int[10][10];
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					chessBoard[i][j] = NOT_ALLOWED;
				}
			}
			
			for (int i = 0; i < numberOfCustomInput; i++) {
				int firstOffSet = argumentScanner.nextInt();
				int numberOfColumn = argumentScanner.nextInt();
				
				for (int j = firstOffSet; j < firstOffSet + numberOfColumn; j++) {
					chessBoard[i][j] = UNMOVED;
				}
			}
	
			Move initLocation = null;
			
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (chessBoard[i][j] == UNMOVED) {
						initLocation = new Move(i, j);
						break;
					}
				}
				if (initLocation != null) {
					break;
				}
			}
			
			Solution solution = new Solution();
			
			int minUntouchSquare = solution.getMinUntouchSquare(chessBoard, initLocation);
			
			System.out.println(
					String.format("Case %d, %s %s can not be reached.", problemCounter, minUntouchSquare,
							minUntouchSquare == 1 ? "square" : "squares")
					);

			numberOfCustomInput = argumentScanner.nextInt();
			problemCounter++;
		}
		
		argumentScanner.close();
	}
}

class Solution {
	
	int minUntouchSquare = 10 * 10;
	
	public int getMinUntouchSquare(int[][] chessBoard, Move currentLocation) {
		minUntouchSquare = 10 * 10;
		
		this.dfsUntouchSquare(chessBoard, currentLocation);
		
		return minUntouchSquare;
	}

	public void dfsUntouchSquare(int[][] chessBoard, Move currentLocation) {
		chessBoard[currentLocation.x][currentLocation.y] = MakingJumps.MOVED;
		List<Move> nextMoves = currentLocation.nextMoves(chessBoard);
		
		if (nextMoves.size() == 0) {
			minUntouchSquare = Math.min(findUntouchSquare(chessBoard), minUntouchSquare);
		}
		
		for (Move nextMove : nextMoves) {
			dfsUntouchSquare(chessBoard, nextMove);
		}

		chessBoard[currentLocation.x][currentLocation.y] = MakingJumps.UNMOVED;
	}
	
	public int findUntouchSquare(int[][] movedTracker) {
		int untouchedCounter = 0;

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (movedTracker[i][j] == MakingJumps.UNMOVED) {
					untouchedCounter++;
				}
			}
		}
		
		return untouchedCounter;
	}
}

class Move {
	int x;
	int y;
	
	Move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	List<Move> nextMoves(int[][] chessBoard) {
		List<Move> moves = new ArrayList<>();
		
		moves.add(new Move(this.x - 2, this.y - 1));
		moves.add(new Move(this.x - 2, this.y + 1));
		moves.add(new Move(this.x - 1, this.y - 2));
		moves.add(new Move(this.x - 1, this.y + 2));
		moves.add(new Move(this.x + 1, this.y - 2));
		moves.add(new Move(this.x + 1, this.y + 2));
		moves.add(new Move(this.x + 2, this.y - 1));
		moves.add(new Move(this.x + 2, this.y + 1));
		
		List<Move> result = new ArrayList<>();
		
		for (Move move : moves) {
			if (move.x >= 0 && move.x < 10 && move.y >= 0 && move.y < 10 
					&& chessBoard[move.x][move.y] == MakingJumps.UNMOVED) {
				result.add(move);
			}
		}
		
		return result;
	}
}
