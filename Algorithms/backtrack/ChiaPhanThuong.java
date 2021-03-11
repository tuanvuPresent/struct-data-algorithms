package Backtracking;

public class ChiaPhanThuong {
	/*
	 * Tìm số cách chia m vật (phần thưởng) cho n đối tượng (học sinh ) có thứ tự.
	 */

	static int PART(int m, int n) {
		if ((m == 0) || (n == 0))
			return 1;
		else if (m < n)
			return (PART(m, m));
		else
			return (PART(m, n - 1) + PART(m - n, n));
	}

	public static void main(String[] args) {
		System.out.println(PART(1, 1));
	} 
}
