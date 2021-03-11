package quyhoachdong;

import java.util.Scanner;

public class Balo3 {

	private static long res[][]; // res[i][n-1]=k : k cách để được cân i
	/*
	 * thuật toán res[k][j]= res[k-weight[j][j] (j:0->n-1) + res[k][j-1] (j:0->n-2)
	 */

	private static void creatTable(int weight[], int n, int sum) {
		// TODO Auto-generated method stub
		res = new long[sum + 1][n];
		// khởi tạo ban đầu
		for (int i = 0; i < n; i++) {
			res[0][i] = 1;
		}
		// bắt đầu tạo bảng
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				long x = i >= weight[j] ? res[i - weight[j]][j] : 0;
				long y = j >= 1 ? res[i][j - 1] : 0;
				res[i][j] = x + y;

			}
		}

		// show table
		for (int i = 0; i <= sum; i++) {
			System.out.print(res[i][n - 1] + "  ");
		}
		System.out.println();
	}

	private static long getResult(int sum, int n) {
		// TODO Auto-generated method stub
		return res[sum][n - 1];
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		// input
//		int sum = sc.nextInt();
//		int n = sc.nextInt();
//		int weight[] = new int[n];
//		for (int i = 0; i < n; i++) {
//			weight[i] = sc.nextInt();
//		}
		// initial
		int n = 4;
//		int weight[] = { 5, 37, 8, 39, 33, 17, 22, 32, 13, 7, 10, 35, 40, 2, 43, 49, 46, 19, 41, 1, 12, 11, 28 };
		int weight[] = { 5, 2, 4, 3 };
		int sum = 10;
		// 523, 22222,2233,433,442,4222,55
		// creat table
		creatTable(weight, n, sum);

		// show result
		System.out.println(getResult(sum, n));
	}
}
