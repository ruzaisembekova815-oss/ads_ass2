/*Kadane's Algorithm. Find the contiguous subarray within an array (containing at least one number) 
which has the largest sum, and return the sum.*/
import java.util.*;

public class KadaneAlghoritm {
    public static int maxSubArraySum(ArrayList<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }

        int maxCurrent = list.get(0);
        int maxGlobal = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            maxCurrent = Math.max(list.get(i), maxCurrent + list.get(i));
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Enter " + n + " integers:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int result = maxSubArraySum(list);
        System.out.println("Maximum contiguous subarray sum = " + result);

        sc.close();

    }
}
