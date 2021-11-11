package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Triangular extends Square{
    private static HashMap<String, int[][]> UTriangular_matrix= new HashMap<>();
    private static HashMap<String, int[][]> LTriangular_matrix= new HashMap<>();
    public HashMap<String, int[][]> getUTriangular_matrix() {
        return UTriangular_matrix;
    }

    public void setUTriangular_matrix(HashMap<String, int[][]> UTriangular_matrix) {
        this.UTriangular_matrix = UTriangular_matrix;
    }


    public HashMap<String, int[][]> getLTriangular_matrix() {
        return LTriangular_matrix;
    }

    public void setLTriangular_matrix(HashMap<String, int[][]> LTriangular_matrix) {
        this.LTriangular_matrix = LTriangular_matrix;
    }

    boolean isUpperTriangular(int [][]x, int m, int n){
        int i,j, flag=0;
        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (x[i][j] != 0)
                    flag = 0;
                else
                    flag = 1;
            }

        }
        if (flag == 1)
            return true;
        else
            return false;
    }
    boolean isLowerTriangular(int [][]x, int m, int n){
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < n; j++) {
                if (x[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
    void addUpperTriangular(int [][]matrix, int m, int n, String name) {
        HashMap<String, int[][]> temp=new HashMap<>(getUTriangular_matrix());
        temp.put(name, matrix);
        setUTriangular_matrix(temp);
    }
    void addLowerTriangular(int [][]matrix, int m, int n, String name) {
        HashMap<String, int[][]> temp=new HashMap<>(getLTriangular_matrix());
        temp.put(name, matrix);
        setLTriangular_matrix(temp);
    }
}
