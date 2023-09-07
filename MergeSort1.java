import java.util.Random;
import java.util.Scanner;

public class MergeSort1 {
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] leftHalf = new int[mid];
            int[] rightHalf = new int[arr.length - mid];

            // Copy data to left and right subarrays
            for (int i = 0; i < mid; i++) {
                leftHalf[i] = arr[i];
            }
            for (int i = mid; i < arr.length; i++) {
                rightHalf[i - mid] = arr[i];
            }

            // Recursively sort the left and right subarrays
            mergeSort(leftHalf);
            mergeSort(rightHalf);

            int i = 0, j = 0, k = 0;

            // Merge the left and right subarrays
            while (i < leftHalf.length && j < rightHalf.length) {
                if (leftHalf[i] < rightHalf[j]) {
                    arr[k++] = leftHalf[i++];
                } else {
                    arr[k++] = rightHalf[j++];
                }
            }

            // Copy the remaining elements of leftHalf
            while (i < leftHalf.length) {
                arr[k++] = leftHalf[i++];
            }

            // Copy the remaining elements of rightHalf
            while (j < rightHalf.length) {
                arr[k++] = rightHalf[j++];
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the size: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        Random random = new Random();
        System.out.println("Randomly generated elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(50000);
            System.out.print(arr[i] + " ");
        }
        MergeSort1 mergeSort = new MergeSort1();
        long startTime = System.nanoTime();
        mergeSort.mergeSort(arr);
        long stopTime = System.nanoTime();
        long elapsedTime = stopTime - startTime;
        System.out.println("\nSorted elements:");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("\nTime taken to sort array is: " + elapsedTime + " nanoseconds");
    }
}
