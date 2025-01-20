package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class FirstLastOccurrencesOfNumber {
    public static void main(String[] args) {
        System.out.println("Result:"+getIndices(new int[]{1,2,3,4,4,4,4,5,6,7,8,9,10,11},4));
    }

    private static List<Integer> getIndices(int[] nums, int target){
        int lowerIndex= getLowerIndexBinarySearch(nums,target);
        int upperIndex=getUpperIndexBinarySearch(nums, target);

        return List.of(lowerIndex, upperIndex);
    }

    private static int getLowerIndexBinarySearch(int[] nums,int target){

        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }

        return nums[left]==target?left:-1;

    }

    private static int getUpperIndexBinarySearch(int[] nums, int target){

        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=(left+right)/2 +1;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else {
                left=mid;
            }
        }

        return nums[right]==target?right:-1;
    }
}
