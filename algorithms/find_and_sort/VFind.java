/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Random;

/**
 *
 * @author NguyenTuanVu
 */
public class VFind {

    public int linearSearch(int arr[], int length, int x) {
        for (int i = 0; i < length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int binarySearch(int arr[], int left, int right, int x) {
        if (right >= left && arr[left] <= x && x <= arr[right]) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, left, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, right, x);
        }
        return -1;
    }

    public int binarySearch(int arr[], int length, int x) {
        int left = 0;
        int right = length - 1;
        while (left <= right && arr[left] <= x && x <= arr[right]) {
            int mid = left + (right - left) / 2;
            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int interpolationSearch(int arr[], int length, int x) {
        int left = 0;
        int right = length - 1;
        while (left <= right && arr[left] <= x && x <= arr[right]) {
            int mid = left + ((right - left) / (arr[right] - arr[left])) * (x - arr[left]);
            if (x == arr[mid]) {
                return mid;
            } else if (x > arr[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    /*   
     => Linear   O =     1 tỷ.
     => Binary   O =     log2(1 tỷ) xấp xỉ =  30
     => Nội suy  O =     log2(log2(1 tỷ)) < 5
     */

    public int twoNumberSearch(int arr[], int length) {
        int sum = length * (length - 1) / 2;
        int sumArr = 0;
        for (int i = 0; i < length; i++) {
            sumArr = sumArr + arr[i];
        }
        System.out.println("" + sum);
        System.out.println("" + sumArr);
        return sumArr - sum;
    }

    public int max(int arr[], int length) {
        int max = arr[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public int min(int arr[], int length) {
        int min = arr[0];
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    public int second(int arr[], int length) {
        if (length < 2) {
            return -1;
        }
        int second, max, indexSecond, indexMax;
        if (arr[1] < arr[0]) {
            second = arr[1];
            indexSecond = 1;
            max = arr[0];
            indexMax = 0;
        } else {
            second = arr[0];
            indexSecond = 0;
            max = arr[1];
            indexMax = 1;
        }
        for (int i = 2; i < length; i++) {
            if (arr[i] > max) {
                second = max;
                indexSecond = indexMax;
                max = arr[i];
                indexMax = i;
            } else if (arr[i] > second && arr[i] < max) {
                second = arr[i];
                indexSecond = i;
            }
        }
        return indexSecond;
    }

    public int comp(int a, int b) {
        return (a > b) ? a : b;
    }

    public void frequency(int arr[], int length) {
        int temp[] = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = 1;
        }
        int count;
        for (int i = 0; i < length; i++) {
            if (temp[i] == 1) {
                count = 1;
                for (int j = i + 1; j < length; j++) {
                    if (arr[i] == arr[j]) {
                        count++;
                        temp[j] = 0;
                    }
                }
                System.out.println("So lan xuat hien: " + arr[i] + " la: " + count);
            }
        }
    }

    public int frequencyMax(int arr[], int length) {
        int temp[] = new int[length];
        for (int i = 0; i < length; i++) {
            temp[i] = 1;
            for (int j = i + 1; j < length; j++) {
                if (arr[i] == arr[j]) {
                    temp[i]++;
                }
            }
        }
        VFind v = new VFind();
        return v.max(temp, length);
    }

    public static void main(String[] args) {
        VFind find = new VFind();
        int arr[] = {1, 4, 51111, 6, 1117, 1, 2, 5, 1, 111};

        int number = find.frequencyMax(arr, 10);
        if (number >= 0) {
            System.out.println("" + arr[number]);
        } else {
            System.out.println("khong xd");
        }
    }
}
