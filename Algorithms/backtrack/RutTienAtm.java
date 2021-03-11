package Backtracking;

public class RutTienAtm {

	private int[] loaiTien = { 500, 100, 50, 20 };
	private int[] soTo = { 1000, 1000, 1000, 1000 };
	public int a[] = new int[loaiTien.length];

	public RutTienAtm() {
		// TODO Auto-generated constructor stub
	}

	public void solve(int n) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 0;
			while (n >= loaiTien[i] && a[i] < soTo[i]) {
				n = n - loaiTien[i];
				a[i]++;
			}
		}
		show();
	}

	public void show() {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		RutTienAtm atm = new RutTienAtm();
		atm.solve(6050);
	}
}
