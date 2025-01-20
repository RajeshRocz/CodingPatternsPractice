package BinarySearch;

public class CuttingWood {

    public static void main(String[] args) {
        System.out.println("Result:" + getHeight(new int[]{2, 6, 3, 8}, 7));
    }

    //Return maximum height to cut atleast k wood
    private static int getHeight(int[] heights, int k) {


/* Normal solution
        int maxHeight=0;
        for(int h:heights){
            maxHeight=Math.max(maxHeight, h);
        }
        for(int i=0;i<maxHeight;i++){
           if(!isEnoughWood(i, heights, k)){
               return i-1;
           }
        }

        return maxHeight;

 */
//Using binary search
        int left = 0;
        int right = heights.length;
        while (left < right) {
            int mid = ((left + right) / 2) + 1;
            if (isEnoughWood(mid, heights, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right; //or can return left
    }

    private static boolean isEnoughWood(int h, int[] heights, int k) {
        int woodSize = 0;

        for (int n : heights) {
            if (n > h) {
                woodSize += n - h;
            }
        }

        return woodSize >= k;
    }
}
