import java.util.Scanner;

public class LongestIncreasingSubsequence {
/*
        Dãy con không liên tiếp tăng dài nhất
 */
    static int output[];
    static int fron[];     //danh dau

    static void subsequence(int arr[]) {
        //initial
        int n = arr.length;
        output = new int[n];
        fron = new int[n];

        output[0] = 1;
        fron[0] = -1;
        for (int i = 1; i < n; i++) {
            //find max
            int indexMax = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {              //cac lon hon
                    if (indexMax == -1)
                        indexMax = j;
                    else
                        indexMax = (output[indexMax] > output[j]) ? indexMax : j;
                }
            }
            //result
            if (indexMax == -1) {
                output[i] = 1;
                fron[i] = -1;
            } else {
                output[i] = output[indexMax] + 1;
                fron[i] = indexMax;
            }
        }
    }

    static int getResult() {
        return output[getPosMax()];
    }

    static int getPosMax() {
        int indexMax = 0;
        int n = output.length;
        for (int i = 1; i < n; i++) {
            indexMax = (output[indexMax] > output[i]) ? indexMax : i;
        }

        //show output
//        for (int i = 0; i < n; i++) {
//            System.out.print(output[i] + " ");
//        }
//        System.out.println();

        return indexMax;
    }

    public static void main(String[] args) {
        //input
        int arr[] = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
//        1 2 2 3 2 3 3 4 2 4 3 5 3 5 4 6
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int arr[] = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println();
        //handle
        subsequence(arr);
        int res = getPosMax();
        //output
        System.out.println((output[res]));
        int pos = getPosMax();
        while (pos != -1) {
            System.out.print(arr[pos] + " ");
            pos = fron[pos];
        }
    }
}