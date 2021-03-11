package quyhoachdong;

public class Balo2 {

	private static int n;
	private static int weight[];
	private static int sum;

	private static int res[]; // res[i]=k : k cách để được cân i
	/*
	 * thuật toán res[k]=sum( res[k-weight[j]) j:0-n-1
	 */

	private static void creatTable() {
		// TODO Auto-generated method stub
		res = new int[sum + 1];
		res[0] = 1; // khởi tạo ban đầu
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				if (i >= weight[j]) {
					res[i] += res[i - weight[j]];
				}
			}
		}

		// show table
		for (int i = 0; i <= sum; i++) {
			System.out.print(res[i] + "  ");
		}
		System.out.println();
	}

	private static int getResult(int sum) {
		// TODO Auto-generated method stub
		return res[sum];
	}

	public static void main(String[] args) {

		// khởi tạo
		n = 3;
		weight = new int[3];
		for (int i = 0; i < 3; i++) {
			weight[i] = i * 2 + 1;
		}
		sum = 11;
		// tạo bảng
		creatTable();
		// kết quả
		System.out.println(getResult(sum));

	}
}
