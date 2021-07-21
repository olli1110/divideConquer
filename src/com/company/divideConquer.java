package com.company;
import java.lang.Math;

public class divideConquer {

// divide and merge a secondary array
   static void merge(int[] sort, int l, int m, int r){
       int len = r - l;
       int[] secArray = new int[len];
       for (int i = 0, ll = l, mm = m; i < len; i++){
           if (ll >= m){
               secArray[i] = sort[mm];
               mm++;
           }
           else if (mm >= r){
               secArray[i] = sort[ll];
               ll++;
           }
           else if (sort[ll] >= sort[mm]){
               secArray[i] = sort[ll];
               ll++;
           }
           else {
               secArray[i] = sort[mm];
               mm++;
           }
       }
       for(int i = 0; i < len; i++){
           sort[l + i] = secArray[i];
       }

   }

// function for sorting the array
    static void mergeSort(int[] sort, int l, int r){
       if (r - l > 1){
           int mid = l + (r - l) / 2;
           mergeSort(sort, l, mid);
           mergeSort(sort, mid, r);
           merge(sort, l, mid, r);
       }
    }


// sorting and giving out the array
    public static void main(String[] args) {
    int[] array = new int[10];
    int max = 50;
    int min = 0;
    int range = max - min;
        for(int i = 0; i < array.length; i++){
            array[i] = (int)(Math.random() * range);
        }
	mergeSort(array, 0, array.length);
    for(int i : array){
        System.out.println(i);
    }
    }
}
