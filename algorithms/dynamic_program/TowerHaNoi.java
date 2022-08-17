import java.util.Scanner;
import java.util.Stack;

public class TowerHaNoi {
	public TowerHaNoi() {
		// TODO Auto-generated constructor stub
	}

	public static void move(int n, Stack a, Stack b) {
		int temp = (int) a.pop();
		b.add(temp);
	}

	private static void show(Stack a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

	public static void towerHaNoi(int n, Stack a, Stack b, Stack c) {
		/*
		 * Thuật toán chuyển n-1 khối từ a sang b chuyển 1 khối a sang c chuyển n-1 khối
		 * từ b sang c
		 */
		if (n == 1) {
			move(1, a, c);
		} else {
			towerHaNoi(n - 1, a, c, b);
			move(n, a, c);
			towerHaNoi(n - 1, b, a, c);
		}

	}

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("Nhập vào số nguyên: ");
		int n = input.nextInt();
		input.close();
		Stack a = new Stack();
		Stack b = new Stack();
		Stack c = new Stack();
		for (int i = 0; i < n; i++) {
			a.add(i);
		}
		towerHaNoi(n, a, b, c);
		show(c);

	}

}
