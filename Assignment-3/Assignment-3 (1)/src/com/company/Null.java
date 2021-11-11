package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Null {
    private static HashMap<String,ArrayList<Integer>> null_matrix = new HashMap<>();
    void addNullMatrix(String name,int m, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(m);
        temp.add(n);
        null_matrix.put(name,temp);
    }

    int determinantOfMatrix(){
        return 0;
    }
}
