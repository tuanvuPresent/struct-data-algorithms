package baitap;

import java.util.Scanner;

public class Street {

	static int Stack[] = new int[1000];
	static int top = -1;

	private static int pop() {
		// TODO Auto-generated method stub
		int temp = Stack[top];
		top--;
		return temp;
	}

	private static void add(int x) {
		// TODO Auto-generated method stub
		top++;
		Stack[top] = x;
	}

	private static int pick() {
		// TODO Auto-generated method stub
		return Stack[top];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// nhap
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		// xu ly
		top = -1;
		// tim lan luot trong mang neu !=x thi cho vao stack
		int x = 1;
		for (int i = 0; i < n; i++) {
			if (x == arr[i]) {
				x++;
			} else if (top != -1) {
				if (x == pick()) { // có trong stack thì lấy ra
					pop();
					x++;
				} else { // thêm vào stack
					add(arr[i]);
				}
			} else {
				add(arr[i]);
			}
		}
		// xep not xe con lai trong stack
		while (top != -1) {
			if (x == pick()) {
				pop();
				x++;
			} else {
				break;
			}
		}
		// xuat
		if (top != -1) {
			System.out.println("false");
		} else {
			System.out.println("true");
		}
	}

}
