package baitap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {

	private static int sumCol(int arr[][], int n, int col) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i][col];
		}
		return sum;
	}

	private static int sumRow(int arr[][], int n, int row) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[row][i];
		}
		return sum;
	} 

	private static int sumDuongCheoChinh(int arr[][], int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 0;
		while (i < n) {
			sum += arr[i][i];
			i++;
		}
		return sum;

	}

	private static int sumDuongCheoPhu(int arr[][], int n) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 0;
		int j = n - 1;
		while (i < n) {
			sum += arr[i][j];
			i++;
			j--;
		}
		return sum;
	}

	public static void main(String[] args) {
		try {
			System.setIn(new FileInputStream(new File("inputMatrix")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// -----------------------------------------
		Scanner sc = new Scanner(System.in);
		int tCase = 0;
		tCase = sc.nextInt();
		for (int i = 0; i < tCase; i++) {
			// nhap
			int matrix[][] = new int[10][10];
			for (int a = 0; a < 10; a++) {
				for (int b = 0; b < 10; b++) {
					matrix[a][b] = sc.nextInt();
				}
			}
			// tim max
			int max = sumCol(matrix, 10, 0); // default max=tổng cột 0
			// tim max cac cot
			for (int j = 0; j < 10; j++) {
				int temp = sumCol(matrix, 10, j);
				if (max < temp) {
					max = temp;
				}
			}
			// tim max cac hang
			for (int j = 0; j < 10; j++) {
				int temp = sumRow(matrix, 10, j);
				if (max < temp) {
					max = temp;
				}
			}
			// tim max duong cheo
			if (max < sumDuongCheoChinh(matrix, 10))
				max = sumDuongCheoChinh(matrix, 10);
			if (max < sumDuongCheoPhu(matrix, 10))
				max = sumDuongCheoPhu(matrix, 10);
			// show
			System.out.println(max);
		}

	}

}
