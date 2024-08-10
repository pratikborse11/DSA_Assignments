package Backtracking_4;
/*
Q5. The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each
other.Given an integer n, return the number of distinct solutions to the n-queens puzzle.
Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Input: n = 1
Output: 1
 */

import java.util.*;
public class Q5 {
    public static int totalNQueens(int n) {
        char board[][] = new char[n][n];
        for(char i[] : board)
            Arrays.fill(i, '.');
        return go(0, board);
    }
    public static int go(int col, char board[][]){
        if(col == board.length) return 1;
        int count = 0;
        for(int row = 0; row < board.length; row++){
            if(isSafe(board, row, col)){
                board[row][col] = 'Q';
                count += go(col + 1, board);
                board[row][col] = '.';
            }
        }
        return count;
    }
    public static boolean isSafe(char board[][], int row, int col){
        int dupRow = row;
        int dupCol = col;

        while(row >= 0 && col >= 0){
            if(board[row][col] == 'Q') return false;
            row--;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while(col >= 0){
            if(board[row][col] == 'Q') return false;
            col--;
        }

        row = dupRow;
        col = dupCol;
        while(col >= 0 && row < board.length){
            if(board[row][col] == 'Q') return false;
            row++;
            col--;
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println("The desired answer is : " + totalNQueens(n));
    }
}

