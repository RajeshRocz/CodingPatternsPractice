package HashMapsAndSets;

import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

public class ZeroStripping {
    public static void main(String[] args) {

        int[][] matrix=new int[][]{
                {1,2,3,4,5},
                {6,0,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,0}
        };
       // doZeroStripping(matrix1);
        doZeroStrippingWithoutHashSet(matrix);
        System.out.println("Matrix:"+matrix);


    }

    private static void doZeroStripping(int[][] matrix){
        if(isNull(matrix) || isNull(matrix[0])){
            return;
        }

        int m=matrix.length;
        int n=matrix[0].length;
        Set<Integer> rowSet=new HashSet<>();
        Set<Integer> colSet=new HashSet<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(rowSet.contains(i)||colSet.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
    }

    private static void doZeroStrippingWithoutHashSet(int[][] matrix){
        if(isNull(matrix) || isNull(matrix[0])){
            return;
        }


        int m=matrix.length;
        int n=matrix[0].length;
        boolean isFirstRowWithZero = false;
        boolean isFirstColumnWithZero = false;
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                isFirstRowWithZero=true;
                break;
            }
        }

        for(int j=0;j<m;j++){
            if(matrix[j][0]==0){
                isFirstColumnWithZero=true;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                   matrix[0][j]=0;
                   matrix[i][0]=0;
                }
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if((matrix[0][j]==0) || (matrix[i][0]==0)){
                    matrix[i][j]=0;
                }
            }
        }

        if(isFirstRowWithZero){
            for(int i=0;i<n;i++){
              matrix[0][i]=0;
            }
        }

        if(isFirstColumnWithZero){
            for(int j=0;j<m;j++){
                matrix[j][0]=0;
            }
        }
    }
}
