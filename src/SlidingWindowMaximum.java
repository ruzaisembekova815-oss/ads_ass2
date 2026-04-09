/*Given an array and an integer K, find the maximum for each and 
every contiguous subarray of size K using a Double-Ended Queue (Deque).*/
import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) return new int[0];

        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();   // stores indices

        for (int i = 0; i < n; i++) {

            // 1. Remove elements smaller than current from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            // 2. Add current index to the deque
            deque.offerLast(i);

            // 3. Remove the element which is out of the current window
            if (deque.peekFirst() == i - k) {
                deque.pollFirst();
            }

            // 4. When window size becomes k, store the maximum
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size K: ");
        int k = sc.nextInt();

        // Edge case
        if (k > n) {
            System.out.println("K cannot be greater than array size!");
            sc.close();
            return;
        }

        int[] result = maxSlidingWindow(arr, k);

        System.out.println("\nMaximum in each window of size " + k + ":");
        for (int max : result) {
            System.out.print(max + " ");
        }
        System.out.println();

        sc.close();
    }
}
