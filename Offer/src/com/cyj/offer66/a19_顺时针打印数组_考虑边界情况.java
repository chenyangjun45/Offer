package com.cyj.offer66;

import java.util.ArrayList;

public class a19_顺时针打印数组_考虑边界情况 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]array={{1,2,3,4},{5,6,7,8}
						,{9,10,11,12}
						,{13,14,15,16}};
		ArrayList<Integer> intList = printMatrix(array);
		for(Integer it: intList){
			System.out.println(it);
		}
	}
	 public static ArrayList<Integer> printMatrix(int[][] matrix) {
	        ArrayList<Integer> result = new ArrayList<Integer>() ;
	        if(matrix==null || matrix.length==0) { return result ; }
	 
	        printMatrixClockWisely(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, result);
	 
	        return result ;
	    }
	     
    public static  void printMatrixClockWisely(int[][] matrix, int startRow, int startCol, int endRow, int endCol, ArrayList<Integer> result) {
        if(startRow<endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }   //Right
            for(int i=startRow+1; i<=endRow-1; i++) { result.add(matrix[i][endCol]) ; }     //Down
            for(int j=endCol; j>=startCol; j--) { result.add(matrix[endRow][j]) ; }     //Left
            for(int i=endRow-1; i>=startRow+1; i--) { result.add(matrix[i][startCol]) ; }   //Up
            printMatrixClockWisely(matrix, startRow + 1, startCol + 1, endRow - 1, endCol - 1, result) ;
        }else if(startRow==endRow && startCol<endCol) {
            for(int j=startCol; j<=endCol; j++) { result.add(matrix[startRow][j]) ; }
        }else if(startRow<endRow && startCol==endCol) {
            for(int i=startRow; i<=endRow; i++) { result.add(matrix[i][endCol]) ; }
        }else if(startRow==endRow && startCol==endCol) {
            result.add(matrix[startRow][startCol]) ;
        }else {
            return ;
        }
    }
}
