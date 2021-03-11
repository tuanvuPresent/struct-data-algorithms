package quyhoachdong;

public class Balo1 {

	private static int n;
	private static int weight[];
	private static int sum;

	private static int res[]; // res[i]=k : ít nhất k lần để được cân i
	/*
	 * chon it nhất de duoc can nang sum thuật toán res[k]=min( res[k-weight[j])+1
	 * j:0-n-1
	 */

	private static void creatTable() {
		// TODO Auto-generated method stub
		res = new int[sum + 1];
		res[0] = 0;
		// tìm lần lượt từng cột một
		for (int i = 1; i <= sum; i++) {
			int min;
			if (i - weight[0] < 0) {
				min = 1000000007; // default min = vô cùng
			} else {
				min = res[i - weight[0]];
			}

			for (int j = 1; j < n; j++) {
				if (i >= weight[j]) {
					min = min < res[i - weight[j]] ? min : res[i - weight[j]];
				}
				if (i == sum) {
				}
			}
			min++;
			res[i] = min;
		}

		// show table
//		for (int i = 0; i <= sum; i++) {
//			System.out.print(res[i] + "  ");
//		}
//		System.out.println();
	}

	private static int getResult(int sum) {
		// TODO Auto-generated method stub
		return res[sum];
	}

	public static void main(String[] args) {

		// khởi tạo
		n = 3;
		weight = new int[] { 1, 56, 90 };
		sum = 112;
		// tạo bảng
		creatTable();
		// kết quả
		System.out.println(getResult(sum));
		System.out.println(getResult(56));
	}
}
