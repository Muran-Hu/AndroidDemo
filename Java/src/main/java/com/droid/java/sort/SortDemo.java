package com.droid.java.sort;

/**
 * Created by Muran Hu on 2019-03-12.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class SortDemo {
  private static int[] arr = new int[] {4, 5, 6, 3, 2, 1};
  public static void main(String[] args) {
    System.out.println("Bubble sort: ");
    SortUtils.bubbleSort(arr);

//    System.out.println("Insert sort: ");
//    SortUtils.insertSort(arr);

//    System.out.println("Select sort: ");
//    SortUtils.selectSort(arr);

//    System.out.println("Merge sort: ");
//    SortUtils.mergeSort(arr);

//    System.out.println("Quick sort: ");
//    SortUtils.quickSort(arr);
  }
}
