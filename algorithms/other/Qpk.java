package baitap;

import java.util.Scanner;

public class Qpk {

	private static void maDi(int matrix[][], int x, int y, int n, int m) {
		// TODO Auto-generated method stub
		if (x - 1 > 0 && y + 2 <= m) {
			matrix[x - 1][y + 2] = 2;
		}
		if (x - 1 > 0 && y - 2 > 0) {
			matrix[x - 1][y - 2] = 2;
		}
		if (x + 1 <= n && y - 2 > 0) {
			matrix[x + 1][y - 2] = 2;
		}
		if (x + 1 <= n && y + 2 <= m) {
			matrix[x + 1][y + 2] = 2;
		}
		if (x + 2 <= n && y - 1 > 0) {
			matrix[x + 2][y - 1] = 2;
		}
		if (x + 2 <= n && y + 1 <= m) {
			matrix[x + 2][y + 1] = 2;
		}
		if (x - 2 > 0 && y + 1 <= m) {
			matrix[x - 2][y + 1] = 2;
		}
		if (x - 2 > 0 && y - 1 > 0) {
			matrix[x - 2][y - 1] = 2;
		}

	}

	private static void hauDi(int matrix[][], int x, int y, int n, int m) {
		// TODO Auto-generated method stub
		// sang trai
		int i = x;
		int j = y - 1;
		while (j > 0 && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			j--;
		}
		// sang phai
		i = x;
		j = y + 1;
		while (j <= m && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			j++;
		}

		// len tren
		i = x - 1;
		j = y;
		while (i > 0 && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i--;
		}
		// xuong duoi
		i = x + 1;
		j = y;
		while (i <= n && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i++;
		}

		// di cheo 1
		i = x - 1;
		j = y - 1;
		while (i > 0 && j > 0 && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i--;
			j--;
		}

		// di cheo 2
		i = x + 1;
		j = y + 1;
		while (i <= n && j <= m && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i++;
			j++;
		}
		// di cheo 3
		i = x - 1;
		j = y + 1;
		while (i > 0 && j <= m && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i--;
			j++;
		}
		// di cheo 4
		i = x + 1;
		j = y - 1;
		while (i <= n && j > 0 && matrix[i][j] != 1) {
			matrix[i][j] = 2;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int matrix[][] = new int[n + 1][m + 1];
		int k = sc.nextInt();
		int Hau[][] = new int[k][2];
		for (int i = 0; i < k; i++) {
			int x = Hau[i][0] = sc.nextInt();
			int y = Hau[i][1] = sc.nextInt();
			matrix[x][y] = 1;
		}

		k = sc.nextInt();
		int Ma[][] = new int[k][2];
		for (int i = 0; i < k; i++) {
			int x = Ma[i][0] = sc.nextInt();
			int y = Ma[i][1] = sc.nextInt();
			matrix[x][y] = 1;
		}

		k = sc.nextInt();
		int Tot[][] = new int[k][2];
		for (int i = 0; i < k; i++) {
			int x = Tot[i][0] = sc.nextInt();
			int y = Tot[i][1] = sc.nextInt();
			matrix[x][y] = 1;
		}

		// xu ly
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}

		// hau di
		for (int i = 0; i < Hau.length; i++) {
			int x = Hau[i][0];
			int y = Hau[i][1];
			hauDi(matrix, x, y, n, m);
		}

		// ma di
		for (int i = 0; i < Ma.length; i++) {
			int x = Ma[i][0];
			int y = Ma[i][1];
			maDi(matrix, x, y, n, m);
		}

		System.out.println();
//		for (int i = 1; i <= n; i++) {
//			for (int j = 1; j <= m; j++) {
//				System.out.print(matrix[i][j]);
//			}
//			System.out.println();
//		}

		// dem so 0 trong ma tran
		int res = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (matrix[i][j] == 0) {
					res++;
				}
			}
		}

		// xuat
		System.out.println(res);
	}

}
