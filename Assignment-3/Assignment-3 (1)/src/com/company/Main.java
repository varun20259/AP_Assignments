package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    void Add2Matrix(ArrayList l1,ArrayList l2,int [][]m1, int [][]m2){
        Main ma = new Main();
        if(m1.length!=m2.length || m1[0].length!=m2[0].length){
            System.out.println("Order of the matrix does not match");
            return;
        }
        if(l1.contains("Null matrix") ){ma.PrintMatrix(m1);return;}
        if(l2.contains("Null matrix") ){ma.PrintMatrix(m2);return;}
        int [][] temp_array = new int[m1.length][m1[0].length];
        for(int u=0;u<m1.length;u++){
            for(int v=0;v<m1[0].length;v++){
                temp_array[u][v]=m1[u][v]+m2[u][v];
            }
        }
        ma.PrintMatrix(temp_array);
    }
    void Sub2Matrix(ArrayList l1,ArrayList l2,int [][]m1, int [][]m2){
        Main ma = new Main();
        if(m1.length!=m2.length || m1[0].length!=m2[0].length){
            System.out.println("Order of the matrix does not match");
            return;
        }
        if(l1.contains("Null matrix") ){ma.PrintMatrix(m1);return;}
        if(l2.contains("Null matrix") ){ma.PrintMatrix(m2);return;}
        int [][] temp_array = new int[m1.length][m1[0].length];
        for(int u=0;u<m1.length;u++){
            for(int v=0;v<m1[0].length;v++){
                temp_array[u][v]=m1[u][v]-m2[u][v];
            }
        }
        ma.PrintMatrix(temp_array);}

    private static HashMap<String,ArrayList<String>> matrices = new HashMap<>();
    int [][] accessmatrix(String name){
        int [][] temp;
        Rectangular r = new Rectangular();
        Square s = new Square();
        HashMap<String , int[][]> rectangular= r.getRectangular_matrix();
        HashMap<String , int[][]> square = s.getSquare_matrix();
        if(rectangular.containsKey(name)){
            return rectangular.get(name);
        }
        else{
            return square.get(name);
        }
    }
    static void multiplyMatrix(int A[][], int B[][])
    {
        Main ma = new Main();
        int i, j, k;
        int m1=A.length;
        int n1=A[0].length;
        int m2=B.length;
        int n2=B[0].length;
        int C[][] = new int[m1][n2];
        for (i = 0; i < m1; i++) {
            for (j = 0; j < n2; j++) {
                for (k = 0; k < m2; k++)
                    C[i][j] += A[i][k] * B[k][j];
            }
        }
        System.out.println("\nResultant Matrix:");
        ma.PrintMatrix(C);
    }
    ArrayList<String> type(String name, int[][]matrix, int m, int n,int count_0, int count_1){
        Square s = new Square();
        ArrayList<String> matrix_type = new ArrayList<>();
        if(s.isSquare(m,n)){
            matrix_type.add("Rectangular matrix");
            matrix_type.add("Square matrix");
            Symmetric s2= new Symmetric();
            Skew_Symmetric s3 = new Skew_Symmetric();
            Triangular t = new Triangular();
            Diagonal d = new Diagonal();
            Identity i = new Identity();
            if(count_0==m*n && m*n!=1 ){
                matrix_type.add("Null matrix");
                matrix_type.add("Symmetric matrix");
                matrix_type.add("Skew matrix");
                matrix_type.add("Upper Triangular matrix");
                matrix_type.add("Lower Triangular matrix");
                matrix_type.add("Singular matrix");
            }
            else if(m*n==1){matrix_type.add("Singleton matrix");matrix_type.add("Diagonal matrix");matrix_type.add("Symmetric matrix");matrix_type.add("Row matrix");matrix_type.add("Column matrix");if(matrix[0][0]==0){matrix_type.add("Null matrix");}}
            else if(i.isIdentity(matrix,m, n)){matrix_type.add("Identity matrix");matrix_type.add("Scalar matrix");matrix_type.add("Diagonal matrix");matrix_type.add("Symmetric matrix");matrix_type.add("Upper Triangular matrix");matrix_type.add("Lower Triangular matrix");}
            else if(count_1==m*n){matrix_type.add("ones matrix");}
            else if(d.isDiagonal(matrix,m,n)){matrix_type.add("Diagonal matrix");matrix_type.add("Symmetric matrix");matrix_type.add("Upper Triangular matrix");matrix_type.add("Lower Triangular matrix");}
            else{
                if(s2.isSymmetric(s,matrix,m, n)){
                    matrix_type.add("Symmetric matrix");
                }
                else if(s3.isSkewSymmetric(s,matrix,m, n)){
                    matrix_type.add("Skew matrix");
                }
                if(t.isUpperTriangular(matrix,m, n)){

                    matrix_type.add("Upper Triangular matrix");
                }
                else if (t.isLowerTriangular(matrix, m, n)){
                    matrix_type.add("Lower Triangular matrix");
                }
                if(s.determinantOfMatrix(matrix,m)==0){
                    matrix_type.add("Singular matrix");
                }
                if(i.isScalar(matrix,m,n)){
                    matrix_type.add("Scalar matrix");
                }
            }

        }
        else{
            matrix_type.add("Rectangular matrix");
            if(m==1){
                matrix_type.add("Row Matrix");
            }
            else if(n==1){
                matrix_type.add("Column Matrix");
            }
        }
        if(!matrices.containsKey(name)){matrices.put(name,matrix_type);addToMatrixType(name,matrix,m,n);}
        return matrix_type;
    }
    void addToMatrixType(String name,int [][] matrix, int m,int n){
        Symmetric s2= new Symmetric();
        Skew_Symmetric s3 = new Skew_Symmetric();
        Triangular t = new Triangular();
        Diagonal d = new Diagonal();
        Identity id = new Identity();
        RC r = new RC();
        Square s = new Square();
        Singular s4 = new Singular();
        Rectangular r1 = new Rectangular();
        Null n2 = new Null();
        System.out.println(matrices.toString());
        ArrayList<String> temp=matrices.get(name);

            for(int j=0;j<temp.size();j++){
        if(temp.get(j).equals("Diagonal matrix")){
            d.addDiagonal(matrix,name,m);
        }
        else if(temp.get(j).equals("Upper Triangular matrix")){
            t.addUpperTriangular(matrix,m,n,name);
        }
        else if(temp.get(j).equals("Lower Triangular matrix")){
            t.addLowerTriangular(matrix,m,n,name);
        }
        else if(temp.get(j).equals("Singular matrix")){
            s4.addSingular(matrix,name);
        }
        else if(temp.get(j).equals("Symmetric matrix")){
            s2.addSymmetric(matrix,name);
        }
        else if(temp.get(j).equals("Skew matrix")){
            s3.addSkewMatrix(matrix,name);
        }
        else if(temp.get(j).equals("Scalar matrix")){
            id.addScalar(matrix,name);
        }
        else if(temp.get(j).equals("Square matrix")){
            s.addSquare(matrix,name);

        }
        else if (temp.get(j).equals("Null matrix")){
            n2.addNullMatrix(name,m, n);
        }
            System.out.println("it came here alse");
            if(temp.get(j).equals("Row matrix")){
                r.addRowMatrix(matrix,name,m,n);
            }
            else if(temp.get(j).equals("Column matrix")){
                r.addColumnMatrix(matrix,name,m,n);
            }
            else if(temp.get(j).equals("Rectangular matrix")){
                System.out.println("it came here");
                r1.addRectangular(matrix,name);
            }

        }
    }
    boolean CheckOrder(int [][]a, int [][]b){
      return true;
    }
    void PrintMatrix(int [][]temp_array){
        for (int[] row : temp_array)
            System.out.println(Arrays.toString(row));

    }

    void operations(){
        System.out.println("1. Input a matrix.\n" +
                "2. Create a matrix.\n" +
                "3. Change the elements of a matrix \n" +
                "4. Display all the matrix-type labels of a requested matrix.\n" +
                "5. Perform addition, subtraction, multiplication & division.\n" +
                "6. Perform element-wise operations.\n" +
                "7. Transpose matrices.\n" +
                "8. Inverse matrices.\n" +
                "9. Compute means: row-wise mean, column-wise mean, mean of all the elements.\n" +
                "10. Compute determinants.\n" +
                "11. Use singleton matrices as scalars, if requested.\n" +
                "12. Compute A+AT\n" +
                "for a matrix A.\n" +
                "13. Compute Eigen vectors and values.\n" +
                "14. Solve sets of linear equations using matrices.\n" +
                "15. Retrieve all the existing matrices (entered or created) having requested matrix-type labels.\n" +
                "-1. Exit");
    }
    public static void main(String[] args) {
        Symmetric s2= new Symmetric();
        Skew_Symmetric s3 = new Skew_Symmetric();
        Triangular t = new Triangular();
        Diagonal d = new Diagonal();
        Identity id = new Identity();
        RC r = new RC();
        Square s = new Square();
        Singular s4 = new Singular();
        Rectangular r1 = new Rectangular();
        Null n2 = new Null();
        Scanner scan = new Scanner(System.in);
        System.out.println("welcome to matrix operator!!");
        Main ma = new Main();
        System.out.println("-----------------------------------------------------------------------------------");
        int a =0;
        while(a!=-1){
            ma.operations();
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("Select Operation:-");
            a= scan.nextInt();
            if(a==1){
                Scanner in = new Scanner(System.in);
                System.out.print("Enter name of matrix:");
                String name = in.nextLine();
                int m,n,i,j;
                System.out.println("Enter the number "
                        + "of rows of the matrix");
                m = Integer.parseInt(in.nextLine());
                System.out.println("Enter the number "
                        + "of columns of the matrix");
                n = Integer.parseInt(in.nextLine());
                int matrix[][] = new int[m][n];
                int count_0=0;
                int count_1=0;
                System.out.println("Enter the elements of the matrix");
                for (i = 0; i < m; i++) {
                    for (j = 0; j < n; j++) {
                        matrix[i][j] = Integer.parseInt(in.next());
                        if(0==matrix[i][j]){count_0++;}
                        if(count_1==matrix[i][j]){count_1++;}
                    }
                }
                ArrayList<String> labels=ma.type(name,matrix,m,n,count_0,count_1);
                for(int k=0;k<labels.size();k++) {
                    System.out.println(labels.get(k));
                }
            }
            if(a!=1) {
                System.out.println("Enter name of the matrix:");
                String name_of_matrix = scan.next();
                ArrayList<String> temp = new ArrayList<>(ma.matrices.get(name_of_matrix));
             if (a == 2) {
                    ma.accessmatrix(name_of_matrix);


                } else if (a == 3) {
                        if(temp.contains("Square matrix")){
                            int [][] matr=s.getSquare_matrix().get(name_of_matrix);
                            int m = matr.length;
                            int n = matr[0].length;
                            int i=0,j=0;
                            System.out.println("enter the modified matrix");
                            int [][] matrix = new int[m][n];
                            int count_0=0, count_1=0;
                            for (i = 0; i < m; i++) {

                                for (j = 0; j < n; j++) {
                                    matrix[i][j] = Integer.parseInt(scan.next());
                                    if(0==matrix[i][j]){count_0++;}
                                    if(count_1==matrix[i][j]){count_1++;}
                                }
                            }
                            ArrayList<String> x = ma.type(name_of_matrix,matrix,m,n,count_0,count_1);
                            ArrayList<String> y = ma.matrices.get(name_of_matrix);
                            int hat=0;
                            if(x.size()!=y.size()){System.out.println("This type of matrix is changing the label");
                                break;}
                            for(int k=0;k<y.size(); k++){
                                if(!x.contains(y.get(k))){
                                    hat=1;
                                    System.out.println("This type of matrix is changing the label");
                                    break;
                                }
                            }
                            if(hat==0){
                                System.out.println("Matrix accepted");
                                ma.addToMatrixType(name_of_matrix,matrix,m,n); /// i used the property of hashmap that it replaces the value of key if duplicates are present.
                            }

                        }


                } else if (a == 4) {
                    for (int j = 0; j < temp.size(); j++) {
                        System.out.println(temp.get(j));
                    }

                }
                 else if (a == 5) {
                 System.out.println("Enter name of matrix:");
                 String name_of_2nd_matrix =scan.next();
                 ArrayList<String> temp2 = ma.matrices.get(name_of_2nd_matrix);
                 System.out.println("Choose operation:");
                 System.out.println("Add." +
                         "Sub." +
                         "Mul." +
                         "Div.");
                    String op = scan.next();
                    int [][]m1=r1.getRectangular_matrix().get(name_of_matrix);
                    int [][]m2=r1.getRectangular_matrix().get(name_of_2nd_matrix);

                 if(op.equals("Add.")) {
                     ma.Add2Matrix(temp,temp2,m1,m2);
                 }
                 else if(op.equals("Sub.")) {
                     ma.Sub2Matrix(temp,temp2,m1,m2);
                 }
                 else if(op.equals("Mul.")){
                     if(temp.contains("Null matrix") ){
                         int [][]temp_array= new int[m1.length][m2[0].length];
                         ma.PrintMatrix(temp_array);
                         break;
                     }
                     if(m1.length!=m2[0].length ){
                         System.out.println("Order of the matrix does not match");
                         break;
                     }
                    ma.multiplyMatrix(m1,m2);

                 }
                 }

                else if (a == 6) {

                }
                else if (a == 7) {
                 Rectangular rr = new Rectangular();
                    if (ma.matrices.get(name_of_matrix).contains("Square matrix")) {
                        HashMap<String, int[][]> hash = s.getSquare_matrix();
                        int[][] temp2 = hash.get(name_of_matrix);

                        System.out.println(temp2.length);
                        System.out.println(temp2[0].length);
                        int[][] temp3 = rr.transpose(temp2, temp2.length, temp2[0].length);
                        for (int[] row : temp3)
                            System.out.println(Arrays.toString(row));

                     }

                } else if (a == 8) {
                 if(temp.contains("Singular matrix") || !temp.contains("Square matrix")){
                     System.out.println("Not possible");
                 }
                 else{
                     int [][] answer=r1.getRectangular_matrix().get(name_of_matrix);
                     ma.PrintMatrix(s.inverse(answer));
                 }
                } else if (a == 9) {
                 System.out.println("Mean: :Row, Column, all");
                 String mean = scan.next();
                 int [][]q=r1.getRectangular_matrix().get(name_of_matrix);

                 int sunm=0;
                 if(mean.equals("Row")){
                     String row = scan.next();
                     int e=Integer.parseInt(row);
                    for(int asd=0;asd<q[0].length;asd++){
                        sunm+=q[asd][e];
                    }
                     System.out.println(sunm/q[0].length);
                 }
                 else if(mean.equals("Column")){
                     String row = scan.next();
                     int e=Integer.parseInt(row);
                     for(int asd=0;asd<q.length;asd++){
                         sunm+=q[e][asd];
                     }
                     System.out.println(sunm/q[0].length);
                 }
                 else{
                     for(int asd=0;asd<q.length;asd++){
                        for(int j=0;j<q[0].length;j++){
                            sunm+=q[j][asd];
                        }
                     }
                     System.out.println(sunm/q[0].length);
                 }

                } else if (a == 10) {
                    if (temp.contains("Square matrix")) {
                        for (int j = 0; j < temp.size(); j++) {
                            if (temp.get(j).equals("Diagonal matrix")) {
                                System.out.println(d.determinantOfMatrix(name_of_matrix));
                                break;
                            } else if (temp.get(j).equals("Null matrix")) {
                                System.out.println(n2.determinantOfMatrix());
                                break;
                            } else if (temp.get(j).equals("Identity matrix")) {
                                System.out.println(id.determinantOfMatrix());
                                break;
                            } else {
                                System.out.println(s.determinantOfMatrix(name_of_matrix));
                                break;
                            }
                        }
                    } else {
                        System.out.println("Determinant of rectangular matrix is not possible");
                    }

                } else if (a == 11) {

                } else if (a == 12) {
                 System.out.println(r1.getRectangular_matrix().toString());
                 int [][] ans=r1.getRectangular_matrix().get(name_of_matrix);
                 ma.PrintMatrix(ans);
                 int [][]ns2=r1.transpose(ans,ans.length,ans[0].length);
                 ma.PrintMatrix(ns2);
                 ArrayList l2=new ArrayList<>();
                 ma.Add2Matrix(temp,l2,ans,ns2);

             } else if (a == 13) {

                } else if (a == 14) {

                } else if (a == 15) {
                 System.out.println("Enter label type:");
                 String stPart=scan.next();
                 String want = stPart+" matrix";
                 for(String name: ma.matrices.keySet()) {
                     ArrayList<String> qwe = ma.matrices.get(name);
                     if(qwe.contains(want)){
                         System.out.println(name);
                     }
                 }
                } else if (a == -1) {
                    break;
                } else {
                    System.out.println("Unknown operation");
                }
                System.out.println("-----------------------------------------------------------------------------------");
            }
        }
    }

    private void PrintMatrix(float[][] inverse) {
        for (float[] row : inverse)
            System.out.println(Arrays.toString(row));}
}

