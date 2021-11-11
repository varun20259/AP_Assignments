package com.company;

import java.util.HashMap;

class Skew_Symmetric extends Square {
    private static HashMap<String, int[][]> getSkew_Symmetric_matrix() {
        return Skew_Symmetric_matrix;
    }

     void setSkew_Symmetric_matrix(HashMap<String, int[][]> skew_Symmetric_matrix) {
        Skew_Symmetric_matrix = skew_Symmetric_matrix;
    }

    private static HashMap<String, int[][]> Skew_Symmetric_matrix= new HashMap<>();
    boolean isSkewSymmetric(Square s,int [][]x,int m,int n){
        int y[][]= new int[m][n];
        y=s.transpose(x,m,n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(y[i][j]!=-x[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    int [][] SumOfMatrixAndTranspose(int [][]x, int n){
        int y[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                y[i][j]=0;
            }
        }
        return y;
    }
    void addSkewMatrix(int[][] matrix,String name){
        HashMap<String, int[][]> temp=new HashMap<>(getSkew_Symmetric_matrix());
        temp.put(name, matrix);
        setSkew_Symmetric_matrix(temp);
    }
}
