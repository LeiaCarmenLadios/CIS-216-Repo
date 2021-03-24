package matrixlab;

import java.util.Scanner;

public class Matrix {

	private int[][] first;
	private int rows, cols;
	
	public Matrix(int[][] arr) {
		this.first = arr;
		rows = first.length;
		cols = first[0].length;
	}
	
	public Matrix(int rows, int cols) {
		
		this.first = new int[rows][cols];
		this.rows = rows;
		this.cols = cols;

	}
	
	public int getRows() {
		return rows;
	}
	
	public int getCols() {
		return cols;
	}
	public Matrix add(Matrix mat) {
		
		if(mat.getRows() != this.getRows() || mat.getCols() != this.getCols()) {
			return null; 
		}
		
		int[][] addedMatrix = new int[mat.getRows()][mat.getCols()];
		for(int i = 0; i < mat.getRows(); i++) {
			for(int j = 0; j < mat.getCols(); j++) {
				addedMatrix[i][j] = this.first[i][j] + mat.first[i][j]; 
			}
		}
		return new Matrix(addedMatrix);
	}
	
	public Matrix multiply(Matrix mat) {  
		if(this.getCols() != mat.getRows() ) {
			return null; 
		}
		
		int[][] multipliedMatrix = new int[this.getRows()][mat.getCols()];
		for(int i = 0; i < this.getRows(); i++) {
			for(int k = 0; k < mat.getCols(); k++) {
				for(int m = 0; m < mat.getRows(); m++) {
					multipliedMatrix[i][k] += (this.first[i][m] * mat.first[m][k]); 
				}
			}
		}
		return new Matrix(multipliedMatrix);
	}
	
	public void getInput() {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the values you would like to have in your matrix: ");
		
		for(int i = 0; i < this.getRows(); i++) {
			for(int j = 0; j < this.getCols(); j++) {
				first[i][j] = in.nextInt();
			}
		}
	}
	
	public String toString() {
		String buildString = "";
		for(int i = 0; i < first.length; i++) {
			buildString += "{ ";
			for(int j = 0; j < first[0].length; j++) {
				buildString += first[i][j] + " " ;
			}
			buildString += "}";
			buildString += "\n";
		}
		return buildString;
	}
}
