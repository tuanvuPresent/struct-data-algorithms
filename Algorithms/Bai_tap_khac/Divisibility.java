package baitap;

import java.util.Scanner;

public class Divisibility {

	public static void main(String[] args) {
		int tCase;
		int n, x, y;
		Scanner sc = new Scanner(System.in);
		String output[] = new String[2];
		// nhập input
		tCase = sc.nextInt();
		for (int i = 0; i < tCase; i++) {
			n = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			// xử lý
			output[i] = "";
			for (int j = 0; j < n; j++) {
				if (j % x == 0 && j % y != 0)
					// output
					output[i] = output[i] + j + " ";
			}
		}
		// output
		for (int i = 0; i < tCase; i++) {
			System.out.println(output[i]);
		}
	}
}
