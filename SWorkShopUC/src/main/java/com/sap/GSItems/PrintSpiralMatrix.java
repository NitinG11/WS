package com.sap.GSItems;

public class PrintSpiralMatrix {

	public static void main(String[] args) {
		int [][]a = {{1,2,3},{4,5,6},{7,8,9}} ;
		printSpiral(a);
	}
	
	static void printSpiral(int [][]a) {
		int rowNum =0;
		int colNum =0;
		int numRows =a.length;
		int numCols =a[0].length;
		
		while(rowNum == colNum){
			for(int i=0;i<numCols;i++) {
				System.out.println(a[rowNum][i]);
				colNum++;
			}
			rowNum++;
			colNum--;
			for(int j=rowNum;j<numRows;j++) {
				System.out.println(a[j][colNum]);
				rowNum++;
			}
			
			colNum--;
			rowNum--;
			for(int i = colNum; i>=0;i--) {
				System.out.println(a[rowNum][i]);
			}
			rowNum--;
			colNum--;
			
			for(int j=rowNum;j>0;j--) {
				System.out.println(a[j][colNum]);
			}
			
			rowNum--;
			
		}
		
		
	}
}
