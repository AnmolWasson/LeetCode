package GFG;

import java.util.*;

public class june9 {

  int subsequenceCount(String S, String T) {}

  //Maximum Product Subarray

  long maxProduct(int[] arr, int n) {
    return maxProduct_rec(arr, n);
  }

  long maxProduct_rec(int[] arr, int n) {
    long max = -(long) 1e13;

    long crt = (long) 1;

    for (int i = 0; i < n; i++) {
      crt *= (long) arr[i];
      max = Math.max(max, crt);

      if (crt == 0) crt = (long) 1;
    }

    crt = (long) 1;
    for (int i = n - 1; i >= 0; i--) {
      crt *= (long) arr[i];
      max = Math.max(max, crt);

      if (crt == 0) crt = (long) 1;
    }

    return max;
  }

  //Merge Without Extra Space

  // using (space)

  public void merge(int arr1[], int arr2[], int n, int m) {
    int[] arr = new int[n + m];
    int si = 0, ei = 0, idx = 0;
    while (si < n && ei < m) {
      if (arr1[si] > arr2[ei]) {
        arr[idx++] = arr2[ei++];
      } else {
        arr[idx++] = arr1[si++];
      }
    }

    while (si < n) arr[idx++] = arr1[si++];

    while (ei < m) arr[idx++] = arr2[ei++];

    for (int i = 0; i < n; i++) {
      arr1[i] = arr[i];
    }

    for (int i = 0; i < m; i++) {
      arr2[i] = arr[i + n];
    }
  }

  // without  space
  public void merge_01(int arr1[], int arr2[], int n, int m) {
    for (int i = 0; i < n; i++) {
      if (arr1[i] > arr2[0]) {
        //swap
        int temp = arr1[i];

        arr1[i] = arr2[0];
        arr2[0] = temp;
        // Arrays.sort(arr2);// this can be done in O(m) also

        correct(arr2);
      }
    }
  }

  void correct(int[] arr) {
    int n = arr.length;
    int ele = arr[0], idx = 0;
    for (int i = 1; i < n; i++) {
      if (ele > arr[i]) {
        arr[idx] = arr[i];
        arr[i] = ele;
        idx = i;
      }
    }
  }

  // gap method

  public void merge_02(int arr1[], int arr2[], int n, int m) {
    int gap = (int) Math.ceil((n + m) / 2);

    while (gap > 0) {
      int si = 0, ei = si + gap;

      while (si + gap < n + m) {
        if (ei < n) {
          if (arr1[si] > arr1[ei]) {
            int temp = arr1[si];
            arr1[si] = arr1[ei];
            arr1[ei] = temp;
          }

          si++;
          ei++;
        } else {
          if (si < n) {
            if (arr1[si] > arr2[ei - n]) {
              int temp = arr1[si];
              arr1[si] = arr2[ei - n];
              arr2[ei - n] = temp;
            }
          } else {
            if (arr2[si - n] > arr2[ei - n]) {
              int temp = arr2[si - n];
              arr1[si - n] = arr2[ei - n];
              arr2[ei - n] = temp;
            }
          }
          si++;
          ei++;
        }
      }
      gap = (int) Math.ceil(gap / 2);
    }
  }

  // row with max 1s

  int rowWithMax1s(int arr[][], int n, int m) {
    int idx = -1, max = 0;

    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < m; j++) {
        if (arr[i][j] == 1) count++;
      }

      if (count > max) {
        max = count;
        idx = i;
      }
    }

    return idx;
  }

  int rowWithMax1s_01(int arr[][], int n, int m) {
    int max = 0, idx = -1;
    for (int i = 0; i < n; i++) {
      int count = onePos(arr[i]);
      if (count > max) {
        max = count;
        idx = i;
      }
    }

    return idx;
  }

  int onePos(int[] arr) {
    int n = arr.length;

    int lo = 0, hi = n - 1;

    while (lo <= hi) {
      int mid = (lo + hi) / 2;

      if (arr[mid] == 1) {
        if (mid - 1 >= 0 && arr[mid - 1] == 0) return n - mid; else {
          hi--;
        }
      } else {
        lo = mid + 1;
      }
    }
    return n - lo;
  }

//O(n+m)
  int rowWithMax1s_02(int arr[][], int n, int m) {
       
    
}

}
