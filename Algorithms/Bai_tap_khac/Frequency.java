package baitap;

import java.io.IOException;
import java.util.Scanner;

public class Frequency {
	private static int frequen(String s, char key) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == key)
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tCase = sc.nextInt();
		for (int i = 0; i < tCase; i++) {
			sc.nextLine(); // xóa bộ nhớ đệm (khi nhập số sau đó nhập chuỗi)
			String input = sc.nextLine();
			char key = sc.next().charAt(0);
			int count = 0;
			count = frequen(input, key);
			// show
			System.out.println(key);
			System.out.println(input);
			System.out.println("# " + count);
		}
	} 
}
