package com.company;

import java.util.HashMap;

public class Singular extends Square{
    private static HashMap<String, int[][]> Singular_matrix = new HashMap<>();
    void addSingular(int [][]matrix,String name){
        Singular_matrix.put(name,matrix);
    }
}
