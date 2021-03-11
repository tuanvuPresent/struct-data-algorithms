/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v_find;

import java.util.Random;

/**
 *
 * @author NguyenTuanVu
 */
public class TestMain {

    public static void main(String[] args) {
        V_Find search = new V_Find();
        // TODO code application logic here
        //Tao mang
        int arr[] = new int[100000000];
        Random rd = new Random();
        for (int i = 0; i < 100000000; i++) {
            int x = rd.nextInt() % 100 + 1;
            arr[i] = i;
        }
        long t1, t2;
        int index;
        System.out.println("So sanh Cac thuat toan tim kiem");

        //Tinh thoi gian linearSearch        
        t1 = System.nanoTime();
        index = search.linearSearch(arr, 100000000, 80000000);
        if (index >= 0) {
            System.out.println("So can tim là: " + arr[index]);
        } else {
            System.out.println("khong tim thay");
        }
        t2 = System.nanoTime();
        System.out.println("Thoi gian cua linearSearch la       : " + Long.toString(t2 - t1) + "ns");

        //Tinh thoi gian binarySearch de quy
        t1 = System.nanoTime();
        index = search.binarySearch(arr, 0, 99999999, 80000000);
        if (index >= 0) {
            System.out.println("So can tim là: " + arr[index]);
        } else {
            System.out.println("khong tim thay");
        }
        t2 = System.nanoTime();
        System.out.println("Thoi gian cua binarySearch de quy la: " + Long.toString(t2 - t1) + "ns");

        //Tinh thoi gian binarySearch 
        t1 = System.nanoTime();
        index = search.binarySearch(arr, 100000000, 80000000);
        if (index >= 0) {
            System.out.println("So can tim là: " + arr[index]);
        } else {
            System.out.println("khong tim thay");
        }
        t2 = System.nanoTime();
        System.out.println("Thoi gian cua binarySearch la       : " + Long.toString(t2 - t1) + "ns");

        //tinh thoi gian interpolationSearch    
        t1 = System.nanoTime();
        index = search.interpolationSearch(arr, 100000000, 80000000);
        if (index >= 0) {
            System.out.println("So can tim là: " + arr[index]);
        } else {
            System.out.println("khong tim thay");
        }
        t2 = System.nanoTime();
        System.out.println("Thoi gian cua interpolationSearch la: " + Long.toString(t2 - t1) + "ns");

    }
}
