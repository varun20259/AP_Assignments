package com.company;

import java.util.HashMap;

public class Square extends Rectangular {
    public HashMap<String, int[][]> getSquare_matrix() {
        return Square_matrix;
    }

    public void setSquare_matrix(HashMap<String, int[][]> square_matrix) {
        Square_matrix = square_matrix;
    }

    private static HashMap<String, int[][]> Square_matrix = new HashMap<>();

    void addSquare(int[][] matrix, String name) {
        Square_matrix.put(name, matrix);
    }

    boolean isSquare(int m, int n) {
        if (m == n) {
            return true;
        }
        return false;
    }

    static final int N = 2;

    static void getCofactor(int mat[][], int temp[][],
                            int p, int q, int n) {
        int i = 0, j = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (row != p && col != q) {
                    temp[i][j++] = mat[row][col];
                    if (j == n - 1) {
                        j = 0;
                        i++;
                    }
                }
            }
        }
    }

    int determinantOfMatrix(String name) {
        int[][] temp = Square_matrix.get(name);
        int a = determinantOfMatrix(temp, temp[0].length);
        return a;
    }

    int determinantOfMatrix(int mat[][], int n) {
        int D = 0;
        if (n == 1)
            return mat[0][0];
        int temp[][] = new int[N][N];
        int sign = 1;
        for (int f = 0; f < n; f++) {
            getCofactor(mat, temp, 0, f, n);
            D += sign * mat[0][f]
                    * determinantOfMatrix(temp, n - 1);
            sign = -sign;
        }
        return D;
    }


     void adjoint(int A[][],int [][]adj)
    {
        if (N == 1)
        {
            adj[0][0] = 1;
            return;
        }
        int sign = 1;
        int [][]temp = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                getCofactor(A, temp, i, j, N);
                sign = ((i + j) % 2 == 0)? 1: -1;
                adj[j][i] = (sign)*(determinantOfMatrix(temp, N-1));
            }
        }
    }
     float [][]inverse(int[][] A){
        float [][]inverse= new float[A.length][A[0].length];
        int det = determinantOfMatrix(A, A.length);
        int [][]adj = new int[A.length][A.length];
        adjoint(A, adj);
        for (int i = 0; i < A.length; i++)
            for (int j = 0; j < A.length; j++)
                inverse[i][j] = adj[i][j]/(float)det;
        return inverse;
    }

}

