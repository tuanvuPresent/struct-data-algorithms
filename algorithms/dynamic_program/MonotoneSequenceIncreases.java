public class MonotoneSequenceIncreases {
/*
        Dãy con liên tếp tăng dài nhất
 */
    static int start, end;

    static void monotoneSequence(int arr[]) {
        int n = arr.length;
        start = 0;
        end = 0;
        int s1 = 0, s2 = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) {
                s2++;
            } else {
                s1 = s2 = i;
            }
            if ((s2 - s1) > (end - start)) {
                start = s1;
                end = s2;
            }
        }
    }

    public static void main(String[] args) {
        //input
        int arr[] = new int[]{1, 2, 3, 141, 15, 6, 7, 8, 9, 10};
        //handle
        monotoneSequence(arr);
        //output
        System.out.println(start + " " + end);
    }
}
