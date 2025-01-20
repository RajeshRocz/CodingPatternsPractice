package BinarySearch;

public class FindTargetInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println("Result:"+findTargetPosition(new int[]{8,9,1,2,3,4,5,6,7},2));
    }

    private static int findTargetPosition(int[] nums, int k){

        int left=0;
        int right=nums.length;

        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]==k){
                return mid;
            }else if(nums[left]<=nums[mid]){
                if(nums[left]<=k && k<nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            } else{
                if( k>nums[mid] && nums[right]<=k){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return nums[left]==k?left:-1;
    }
}
