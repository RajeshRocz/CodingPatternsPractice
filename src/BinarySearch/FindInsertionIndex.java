package BinarySearch;

public class FindInsertionIndex {
    //Return index if value exist, otherwise return index to insert

    public static void main(String[] args) {
        System.out.println("Result:" + getInsertionIndex(new int[]{1, 2, 4, 5, 7, 8, 9}, 6));
    }

    private static int getInsertionIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {

            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
