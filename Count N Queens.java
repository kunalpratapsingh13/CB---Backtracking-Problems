//You are given an empty chess board of size N*N. Find the number of ways to place N queens on the board, 
//such that no two queens can kill each other in one move. A queen can move vertically, horizontally and diagonally.

import java.util.*;
public class Main
{
    public static int countNQueens(boolean [][] board, int row){
        if (row==board.length){
            return 1;
        }
        
        int count = 0;
        for (int col=0;col<board[row].length;col++){
            if (isItSafe(board,row,col)){
                board[row][col] = true;
                count = count + countNQueens(board,row+1);
                board[row][col] = false;
            }
        } 
        return count;
    }
    
    private static boolean isItSafe(boolean [][] board, int row, int col){
        for (int i=row; i>=0;i--){
            if (board[i][col]){
                return false;
            }
        }
        
        for (int i=row, j=col; i>=0 && j>=0; i--,j--){
            if (board[i][j]){
                return false;
            }
        }
        
        for(int i=row,j=col; i>=0 && j<board.length; i--,j++){
            if (board[i][j]){
                return false;
            }
        }
        
        return true;
    }
    
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    boolean [][] board = new boolean[n][n];
	    System.out.println(countNQueens(board,0));
	}
}
