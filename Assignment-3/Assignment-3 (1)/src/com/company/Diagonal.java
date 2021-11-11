package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Diagonal extends Square{
    private HashMap<String, ArrayList<Integer>> Diagonal_matrix= new HashMap<>();
    boolean isDiagonal(int [][]x, int m , int n){
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i!=j){
                    if(x[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
    int determinantOfMatrix(String name){
        ArrayList<Integer> temp=Diagonal_matrix.get(name);
        int determinant=1;
        for(int i=0;i<temp.size();i++){
           determinant*=temp.get(i);
        }
    return determinant;
    }
    void addDiagonal(int [][]x, String name,int m){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    temp.add(x[i][j]);
                }
            }
        }
    Diagonal_matrix.put(name,temp);
    }

}
