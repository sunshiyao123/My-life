package Day1;

import java.util.*;

//寻找第K大
public class Finder {
    public static void main(String[] args) {
        int[] data = {1,3,2,1};

    }
    public int findKth(int[] a, int n, int K) {
        // write code here
        int mid = n/2;
        if (a[mid] == K)
            return mid;
        if (a[mid] < K);
            return 1;
    }
    private static int[] quickSort(int[] data,int low,int high) {
        int key = data[low];
        while (low < high) {
            while (low < high && data[high] <= key)
                high--;
            data[low] = data[high];
            while (low < high && data[low] >= key)
                low++;
            data[high] = data[low];
        }
        return null;
    }
}