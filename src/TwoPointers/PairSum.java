package TwoPointers;

import java.util.Arrays;

public class PairSum {
    public static void main(String[] args) {
        int[] result = getPairSumOfTarget(new int[]{-3,-2,-1}, -5);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] getPairSumOfTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int total = nums[start] + nums[end];
            if (total == target) {
                return new int[]{start, end};
            } else if (total < target) {
                start++;
            } else {
                end--;
            }

        }
        return new int[]{};
    }
}
