package Backtracking;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Sudoku extends Thread {
	public int output[][] = new int[9][9];

	public int input[][] = new int[9][9];
	public String pathFile;
	private boolean flag = false;

	public Sudoku(String path) {
		this.pathFile = path;
		if (pathFile == null)
			return;
		// TODO Auto-generated constructor stub
		// mở file
		File file = new File(pathFile);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// đọc file
		int k = 0, k2 = 0;
		while (sc.hasNextInt()) {
			input[k][k2] = sc.nextInt();
			output[k][k2] = input[k][k2];
			if (k2 == 8) {
				k++;
				k2 = 0;
			} else
				k2++;
		}
	}

	public boolean check(int key, int x, int y) {
		// kiểm tra hàng
		for (int j = 0; j < 9; j++) {
			if (output[x][j] == key && j != y)
				return false;
		}
		// kiểm tra cột
		for (int i = 0; i < 9; i++) {
			if (output[i][y] == key && i != x)
				return false;
		}
		// kiểm tra vùng 3x3
		int a = x / 3;
		int b = y / 3;
		for (int i = 3 * a; i < 3 * a + 3; i++) {
			for (int j = 3 * b; j < 3 * b + 3; j++) {
				if (output[i][j] == key && (i != x || j != y))
					return false;
			}
		}
		return true;
	}

	public void solveSudoku(int x, int y) {
		int k = 0;
		if (y == 9) {
			if (x == 8) {
				flag = true;
				show();
				return;
			} else {
				solveSudoku(x + 1, 0);
			}
		} else {
			if (output[x][y] == 0) {
				for (k = 1; k <= 9; k++) {
					if (check(k, x, y)) {
						output[x][y] = k;
						solveSudoku(x, y + 1);
					}
					if (flag)
						return;
				}
				output[x][y] = 0;
			} else {
				solveSudoku(x, y + 1);
			}
		}
	}

	public void next(int row, int col) throws Exception {
		if (col < 8)
			solve(row, col + 1);
		else
			solve(row + 1, 0);
	}

	public void solve(int row, int col) throws Exception {
		if (row > 8)
			return;

		if (output[row][col] != 0)
			next(row, col);
		else {
			for (int num = 1; num < 10; num++) {
				if (check(num, row, col)) {
					sleep(100);
					output[row][col] = num;

					next(row, col);
				}
			}

			// No valid number was found, clean up and return to caller
			output[row][col] = 0;
		}
	}

	public void show() {
		System.out.println("Sudoku la:");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				System.out.print(output[i][j] + " ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ViewSudoku sudoku = new ViewSudoku();
	}
}
