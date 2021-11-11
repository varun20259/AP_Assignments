package com.company;

import java.util.HashMap;

public class Symmetric extends Square {
    public HashMap<String, int[][]> getSymmetric_matrix() {
        return Symmetric_matrix;
    }

    public void setSymmetric_matrix(HashMap<String, int[][]> symmetric_matrix) {
        Symmetric_matrix = symmetric_matrix;
    }

    private HashMap<String, int[][]> Symmetric_matrix= new HashMap<>();
    boolean isSymmetric(Square s,int [][]x,int m,int n){
        int y[][]= new int[m][n];
        y=s.transpose(x,m,n);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(y[i][j]!=x[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    int [][] transpose(int [][]x){
        return x;
    }
    int [][] SumOfMatrixAndTranspose(int [][]x, int n){
        int y[][]= new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                y[i][j]=2*x[i][j];
            }
        }
        return y;
    }
    void addSymmetric(int [][]matrix, String name){Symmetric_matrix.put(name,matrix);}
}
