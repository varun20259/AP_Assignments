package com.company;

import java.util.HashMap;

public class Rectangular implements Matrix_operations{
    public  HashMap<String, int[][]> getRectangular_matrix() {
        return Rectangular_matrix;
    }

    public void setRectangular_matrix(HashMap<String, int[][]> rectangular_matrix) {
        Rectangular_matrix = rectangular_matrix;
    }

    private static HashMap<String,int[][]> Rectangular_matrix = new HashMap<>();
    @Override
    public int[][] transpose(int [][]x,int m, int n) {
        int[][] transpose = new int[m][n];

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {
                transpose[j][i] = x[i][j];
            }
        }
        return transpose;
    }

    void addRectangular(int [][]matrix,String name){Rectangular_matrix.put(name,matrix);}
}
