package test;

public class GreaterThanK {
    public static void main(String[] args) {
        int arr[]=new int[]{2,3,5,6,6,7};
        System.out.println(getCount(arr, 6));
        System.out.println(getCountUsingBinarySearch(arr, 8));

    }

    private static int getCount(int arr[], int k){
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(arr[i]>k){
                count++;
            }
        }
        return count;
    }

    private static int getCountUsingBinarySearch(int arr[], int k){
        int l=0;
        int h=arr.length;
        while(l<h){
            int m=l+((h-l)/2);

            if(arr[m]<k){
                l=m+1;
            }else{
                h=m;
            }
        }
        return h-l;
    }

    private static boolean isEqual(String[] word1, String[] word2){
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb1.append(word1[i]);
        }

        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<word1.length;i++){
            sb2.append(word2[i]);
        }

        return sb2.compareTo(sb1) == 0;
    }
}
