package com.droid.java.sort;

/**
 * Created by Muran Hu on 2019-03-12.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class SortUtils {
  public static void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      boolean isSorted = true;
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j-1] > arr[j]) {
          swap(arr, j-1, j);
          isSorted = false;
        }
      }

      if (isSorted) break;
    }

    printAll(arr);
  }

  public static void insertSort(int arr[]) {
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i-1;
      for (; j >= 0; j--) {
        if (arr[j] > value) {
          arr[j+1] = arr[j];
        } else {
          break;
        }
      }

      arr[j+1] = value;
    }

    printAll(arr);
  }

  public static void selectSort(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      if (i != minIndex) {
        swap(arr, i, minIndex);
      }
    }

    printAll(arr);
  }

  public static void bubbleSort1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      boolean isSorted = true;
      for (int j = 1; j < arr.length - i; j++) {
        if (arr[j-1] > arr[j]) {
          swap(arr, j-1, j);
          isSorted = false;
        }
      }

      if (isSorted) break;
    }

    printAll(arr);
  }

  public static void insertSort1(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i-1;
      for (; j >= 0 ; j--) {
        if (arr[j] > value) {
          arr[j+1] = arr[j];
        } else {
          break;
        }
      }

      arr[j+1] = value;
    }

    printAll(arr);
  }

  public static void selectSort1(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      int minIndex = i;
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] < arr[minIndex]) {
          minIndex = j;
        }
      }

      if (minIndex != i) {
        swap(arr, minIndex, i);
      }
    }

    printAll(arr);
  }

  public static void mergeSort(int[] arr) {
    mergeSortInternally(arr, 0, arr.length-1);
    printAll(arr);
  }

  private static void mergeSortInternally(int[] arr, int p, int r) {
    if (p>=r) return;

    int q = p + (r-p)/2;
    mergeSortInternally(arr, p, q);
    mergeSortInternally(arr, q+1, r);

    merge(arr, p, q, r);
  }

  private static void merge(int[] arr, int p, int q, int r) {
    int i = p;
    int j = q+1;
    int k = 0;

    int[] tmp = new int[r-p+1];
    while (i<=q && j<=r) {
      if (arr[i] < arr[j]) {
        tmp[k++] = arr[i++];
      } else {
        tmp[k++] = arr[j++];
      }
    }

    int start = i;
    int end = q;
    if (j<=r) {
      start = j;
      end = r;
    }

    while (start <= end) {
      tmp[k++] = arr[start++];
    }

    for (i = 0; i < tmp.length ; i++) {
      arr[p+i] = tmp[i];
    }
  }

  private static void swap(int arr[], int i, int j) {
    int tmp = arr[i];
    arr[i] = arr[j];
    arr[j] = tmp;
  }

  private static void printAll(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}
