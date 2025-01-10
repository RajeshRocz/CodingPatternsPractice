package TwoPointers;

public class LargestContainer {

    public static void main(String[] args) {
        System.out.println("Brute Force Approach: Max Capacity=" + getLargestContainerBruteForce(new int[]{2, 7, 4, 3, 7, 6}));
        System.out.println("Two Pointer Approach: Max Capacity=" + getMaxCapacityTwoPointers(new int[]{2, 7, 4, 3, 7, 6}));

    }

    private static int getLargestContainerBruteForce(int[] heights) {
        int length = heights.length;
        int maxCapacity = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                int capacity = Math.min(heights[i], heights[j]) * (j - i);
                maxCapacity = Math.max(maxCapacity, capacity);
            }
        }

        return maxCapacity;
    }

    private static int getMaxCapacityTwoPointers(int[] heights) {
        int maxCapacity = 0;
        int left = 0, right = heights.length - 1;

        while (left < right) {
            int capacity = Math.min(heights[left], heights[right]) * (right - left);
            maxCapacity = Math.max(maxCapacity, capacity);

            if (heights[left] < heights[right]) {
                left++;
            } else if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
                right--;
            }
        }

        return maxCapacity;
    }

}
