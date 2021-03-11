package v_sort;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NguyenTuanVu
 */
public class v_sort {

	public void bubbleSort(int arr[]) {
		// doi cho 2 vi tri gan nhau
		int n = arr.length;
		boolean flag = true;
		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					arr[j] = arr[j] + arr[j + 1];
					arr[j + 1] = arr[j] - arr[j + 1];
					arr[j] = arr[j] - arr[j + 1];
					flag = true;
				}
			}
			if (!flag) {
				break;
			}
		}
	}

	public void insertionSort(int arr[]) {
		// so sanh voi phan tu truoc neu nho hon thi chen vao
		int key, j;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			key = arr[i];
			j = i - 1;
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	public void selectionSort(int arr[]) { // tim min roi` doi cho len dau
		int n = arr.length;
		int index_min;
		for (int i = 0; i < n - 1; i++) {
			index_min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[index_min]) {
					index_min = j;
				}
			}
			// swap
			int temp = arr[index_min];
			arr[index_min] = arr[i];
			arr[i] = temp;
		}
	}

	public void interchangeSort(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}

	private void merge(int arr[], int left, int mid, int right) {
		int i = left, j = mid + 1, k = 0;
		int n = right - left + 1;
		int B[] = new int[n];
		while ((i < mid + 1) && (j < right + 1)) {
			if (arr[i] < arr[j]) {
				B[k] = arr[i];
				k++;
				i++;
			} else {
				B[k] = arr[j];
				k++;
				j++;
			}
		}
		while (i < mid + 1) {
			B[k] = arr[i];
			k++;
			i++;
		}
		while (j < right + 1) {
			B[k] = arr[j];
			k++;
			j++;
		}
		i = left;
		for (k = 0; k < n; k++) {
			arr[i] = B[k];
			i++;
		}
	}

	public void mergeSort(int arr[], int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	public void quickSort(int arr[], int left, int right) {
		int i = left, j = right;
		int mid = i + (j - i) / 2;
		int key = arr[mid];

		while (i <= j) {
			while (arr[i] < key) {
				i++;
			}
			while (arr[j] > key) {
				j--;
			}
			if (i <= j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (j > left) {
			quickSort(arr, left, j);
		}
		if (i < right) {
			quickSort(arr, i, right);
		}
	}

	public void timSort(int arr[]) {

	}

	public void heapSort(int arr[]) {

	}

	static void helo(int n) {
		if(n==0)return;
		System.out.println("hello");
		helo(n-1);
	}
	public static void main(String[] args) {
		// 3 9 1 8 6 2 3 5 4 7
//		int arr[] = { 3, 9, 1, 8, 6, 2, 3, 5, 4, 7 };
		int arr[] = { 5, 1, 2, 8, 3, 7, 4, 6, 10, 15 };
		v_sort s = new v_sort();
		s.quickSort(arr, 0, 9);

		for (int a : arr) {
			System.out.print(a + " ");
		}
	}
}
