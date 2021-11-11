package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Identity {
    private static HashMap<String, int[][]> ScalarMatrices = new HashMap<>();
    private static HashMap<String, int[][]> IdentityMatrices = new HashMap<>();
    boolean isIdentity(int[][] x, int m, int n) {
        boolean flag = true;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j && x[i][j] != 1) {
                        flag = false;
                        break;
                    }
                    if (i != j && x[i][j] != 0) {
                        flag = false;
                        break;
                    }
                }
            }

    return flag;
    }
    int determinantOfMatrix(){return 1;}
    boolean isScalar(int[][] x, int m, int n) {
        boolean flag = true;
        ArrayList<Integer> array = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        array.add(x[i][j]);
                    }
                    if (i != j && x[i][j] != 0) {
                        flag = false;
                        break;
                    }
                }
            }
            if(flag==false){
                return false;
            }
            else{
                for(int i=0;i<array.size()-1;i++) {
                    if(array.get(i)!=array.get(i+1)){
                        return false;
                    }
                }
                return true;
            }
    }
    void addIdentity(int[][] matrix, String name){
        IdentityMatrices.put(name, matrix);
    }
    void addScalar(int [][]matrix, String name){ScalarMatrices.put(name,matrix);}
}
