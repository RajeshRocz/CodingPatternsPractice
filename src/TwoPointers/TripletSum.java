package TwoPointers;

import java.util.*;

public class TripletSum {

    public static void main(String[] args) {
        System.out.println(getTripletSumEqualsZeroTwoPointerApproach(new int[]{0, 0, 1, -1, 1, -1}));
    }

    private static List<List<Integer>> getTripletSumEqualsZeroTwoPointerApproach(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> resultList=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(nums[i]>0) {break;}
            if(i>0 && nums[i]==nums[i-1]){continue;}
            List<List<Integer>> pairList=pairSum(nums, i+1,-nums[i]);

            for(List<Integer> l:pairList){
                l.add(nums[i]);
                resultList.add(l);
            }

        }

        return resultList;

    }

    private static List<List<Integer>> pairSum(int[] nums, int start,int target){
        List<List<Integer>> pairList=new ArrayList<>();
        int left= start; int right=nums.length-1;
        while(left<right){
            int sumValue=nums[left]+nums[right];
            if(sumValue==target){
                pairList.add(new ArrayList<>(List.of(nums[left],nums[right])));
                left++;
                if(left<right && nums[left]==nums[left-1]){left++;}
            } else if (sumValue>target) {
                right--;
            } else{
                left++;
            }
        }
        return pairList;
    }

    private static List<List<Integer>> getTripletSumEqualsZeroBruteForce(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplets = new ArrayList<>(List.of(nums[i], nums[j], nums[k]));
                        Collections.sort(triplets);
                        resultSet.add(triplets);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }
}
