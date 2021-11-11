package com.company;

import java.util.HashMap;

public class RC {
    public HashMap<String, int[][]> getRow_matrix() {
        return Row_matrix;
    }

    public void setRow_matrix(HashMap<String, int[][]> row_matrix) {
        Row_matrix = row_matrix;
    }

    private static HashMap<String, int[][]> Row_matrix = new HashMap<>();

    public HashMap<String, int[][]> getColumn_matrix() {
        return Column_matrix;
    }

    public void setColumn_matrix(HashMap<String, int[][]> column_matrix) {
        Column_matrix = column_matrix;
    }

    private HashMap<String, int[][]> Column_matrix = new HashMap<>();
    void addRowMatrix(int [][]x, String name,int m,int n){
        Row_matrix.put(name,x);
    }
    void addColumnMatrix(int [][]x, String name,int m,int n){
        Column_matrix.put(name,x);
    }
}
