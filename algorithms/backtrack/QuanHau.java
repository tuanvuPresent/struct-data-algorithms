package Backtracking;

public class QuanHau {
	private boolean flag = false;
	static int n = 8;
	int a[] = new int[n + 1];

	public void solve(int i, int n) throws Exception {
		if (i > n) {
			show();
			flag = true;
			return;
		}
		// nếu đặt xong quân hậu thứ n thì xuất ra một kết quả
		for (int j = 1; j <= n; j++) {
			// thử đặt quân hậu vào các cột từ 1 đến n
			if (check(i, j)) {
				// nếu cách đặt này thỏa mãn thì lưu lại vị trí
				a[i] = j;
				solve(i + 1, n);
				a[i] = 0;
			}
			if (flag) {
				return;
			}
		}
	}

	private boolean check(int x2, int y2) {
		// kiểm tra cách đặt có thỏa mãn không
		for (int i = 1; i < x2; i++)
			if (a[i] == y2 || Math.abs(i - x2) == Math.abs(a[i] - y2))
				return false;
		// Nếu kiểm tra hết các trường hợp vẫn không sai thì trả về true
		return true;
	}

	public void show() {
		System.out.println();
		for (int i = 1; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	public static void main(String[] args) {
		QuanHau hau = new QuanHau();
		try {
			hau.solve(1, n);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
