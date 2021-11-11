package com.company;

import java.util.HashMap;

 class Scalar {
    public HashMap<String, int[][]> getScalar_matrix() {
        return Scalar_matrix;
    }

    public void setScalar_matrix(HashMap<String, int[][]> scalar_matrix) {
        Scalar_matrix = scalar_matrix;
    }

    private HashMap<String, int[][]> Scalar_matrix= new HashMap<>();

}
