package HashMapsAndSets;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;

public class PairSumUnsorted {
    public static void main(String[] args) {
        System.out.println("getPairSumTwoPassesMethod:"+getPairSumTwoPassesMethod(new int[]{-1,3,4,2},3));
        System.out.println("getPairSumSinglePassMethod:"+getPairSumSinglePassMethod(new int[]{-1,3,4,2},3));

    }
//two passes
    private static List<Integer> getPairSumTwoPassesMethod(int[] nums, int target){
        int length=nums.length;
        Map<Integer, Integer> indexMap=new HashMap<>();
        for(int i=0;i<length;i++){
            indexMap.put(nums[i],i);
        }

        for(int i=0;i<length;i++){
            Integer index=indexMap.get(target-nums[i]);
            if(nonNull(index) && 1!=index){
                return List.of(i,index);
            }

        }
        return List.of();
    }

    private static List<Integer> getPairSumSinglePassMethod(int[] nums, int target) {

        Map<Integer, Integer> indexMap=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            Integer index=indexMap.get(target-nums[i]);

            if(nonNull(index)){
                return List.of(index,i);
            }else {
                indexMap.put(nums[i],i);
            }
        }
        return List.of();
    }

    }
