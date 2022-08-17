package baitap;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Partition {
	private static void sort(int arr[]) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] < arr[j]) {
					// đổi chỗ
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("partition.txt"));

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			// nhap
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = sc.nextInt();
			}
			// xu ly
			sort(arr);
			int sum = 0;
			for (int j = 0; j < arr.length - 1; j++) {
				sum += arr[j] * (j + 1);
			}
			sum += arr[n - 1] * (n - 1);
			// xuat
			System.out.println("#" + i + " " + sum);
		}
	}
}
