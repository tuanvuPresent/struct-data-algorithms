package backtrack;

public class ChiaPhanThuong {
	/*
	 * Tìm số cách chia m vật (phần thưởng) cho n đối tượng (học sinh ) có thứ tự.
	 */

	static int part(int m, int n) {
		if ((m == 0) || (n == 0))
			return 1;
		else if (m < n)
			return (part(m, m));
		else
			return (part(m, n - 1) + part(m - n, n));
	}

	public static void main(String[] args) {
		System.out.println(part(1, 1));
	} 
}
