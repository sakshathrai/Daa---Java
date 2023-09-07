import java.util.*;

public class MergeSort {
    void merge(int[] a, int[] b, int[] c) {
        int n1 = b.length;
        int n2 = c.length;
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n1 && j < n2) {
            if (b[i] <= c[j]) {
                a[k++] = b[i++];
            } else {
                a[k++] = c[j++];
            }
        }
        while (i < n1) {
            a[k++] = b[i++];
        }
        while (j < n2) {
            a[k++] = c[j++];
        }
    }

    void merge_sort(int[] a) {
        int n = a.length;
        if (n > 1) {
            int[] b = new int[(n + 1) / 2];
            int[] c = new int[n - (n + 1) / 2];
            int i = 0;
            while (i < (n + 1) / 2) {
                b[i] = a[i++];
            }
            int j = 0;
            while (i < n) {
                c[j++] = a[i++];
            }
            MergeSort mergeSort = new MergeSort();
            mergeSort.merge_sort(b);
            mergeSort.merge_sort(c);
            merge(a, b, c);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int n = s.nextInt();
        int[] arr = new int[n];
      Random random = new Random();
        for (int i = 0; i < n; i++)
            arr[i] = random.nextInt(50000);
        MergeSort mergeSort = new MergeSort();
        long startTime = System.nanoTime();
        mergeSort.merge_sort(arr);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nTime taken to sort array is: " + elapsedTime + " nanoseconds");
    }
}
