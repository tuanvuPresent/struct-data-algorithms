package baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SubMatrix {

	private static int sum(int matrix[][], int n, int s) {
		// TODO Auto-generated method stub
		int m = matrix.length;
		int sum = 0;
		for (int i = 0; i <= m - n; i += s) { // chạy theo hàng
			for (int j = 0; j <= m -n; j += s) { // chạy theo cột
				System.out.println(i+" "+j);
				// tìm max trong ma trận chạy nxn
				int max = matrix[i][j];
				for (int row = i; row < i + n; row++) {
					for (int col = j; col < j + n; col++) {
						if (max < matrix[row][col]) {
							max = matrix[row][col];
						}
					}
				}
				// tính tổng
				System.out.println(max);
				sum += max;
			}
		}
		return sum;
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("matrix.txt"));
		// nhap
		Scanner sc = new Scanner(System.in);
		int s = sc.nextInt();// bước chạy
		int m = sc.nextInt();// kích thước ma trận ban đầu
		int n = sc.nextInt();// kích thước ma trận chạy
		int matrix[][] = new int[m][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		// tính tổng
		int sum = sum(matrix, n, s);
		System.out.println("# " + sum);
	}
}
