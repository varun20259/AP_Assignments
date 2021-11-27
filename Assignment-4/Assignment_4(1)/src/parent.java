import java.util.*;

public class parent {
	private Scanner scan = new Scanner(System.in);
	String bin(long n)
	  {
	    long i;
	    String out="";
	    System.out.print("0");
	    for (i = 1 << 8; i > 0; i = i / 2)
	    {
	      if((n & i) != 0){
	        out+=("1");
	      }
	      else{
	        out+=("0");
	      }
	    }
	    return out;
	  }
	void print(int [][] mat) {
		for(int [] row: mat) {
			for(int j: row) {
				String a =bin(j);
				System.out.print(a+" ");
			}
			System.out.println("");
		}
	}
	void create(int m, int n, int t) {
		Gray g= new Gray();
		RGB r = new RGB();
		System.out.print("Enter name of image = ");
		String name = scan.nextLine();
		int arr[][]= new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j]=0;
			}
		}
		if(t==1) {
			g.create(m, n,arr,name);
		}
		else {
			r.create(m,n,arr,name);
		}
	}
	 int [][] input(int m, int n){
		 int arr[][]= new int[m][n];
		 for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					arr[i][j]=Integer.parseInt(scan.next());
				}
			}
		 return arr;
	 }
	 int [][] negatives(int arr[][]) {
		 int m = arr.length;
		 int n =arr[0].length;
		 for(int i=0;i<m;i++) {
			 for(int j=0;j<n;j++) {
				 arr[i][j]=255-arr[i][j];
			 }
		 }
		 return arr;
	 }
	 void negative(int t, Gray g, RGB r) {
		 System.out.println("Enter name of image : ");
		 String name = scan.nextLine();
		 if(t==1) {
			 System.out.println("GRay image : ");
			 HashMap<String, int[][]> temp = g.getGimage();
			 int array[][]= temp.get(name);
			 int update[][]=negatives(array);
			 temp.put(name, update);
			 print(update);
		 }
		 else {
			 System.out.println("Green part of image : ");
			 HashMap<String, int[][]> temp = r.getGimage();
			 int array[][]= temp.get(name);
			 int update[][]=negatives(array);
			 temp.put(name, update);
			 print(update);
			 System.out.println("Blue part of image : ");
			 HashMap<String, int[][]> temp1 = r.getBimage();
			 int array1[][]= temp1.get(name);
			 int update1[][]=negatives(array1);
			 temp.put(name, update1);
			 print(update1);
			 System.out.println("Red part of image : ");
			 HashMap<String, int[][]> temp2 = r.getRimage();
			 int array2[][]= temp2.get(name);
			 int update2[][]=negatives(array2);
			 temp.put(name, update2);
			 print(update2);
		 }
	 }
	 void input(int m, int n, int t, Gray g, RGB r) {
		// TODO Auto-generated method stub
		String name = scan.nextLine();
		if(t==1) {
			System.out.println("Gray image : ");
			int array[][]=input(m,n);
			print(array);
			g.getGimage().put(name, array);
		}
		else {
			System.out.println("Red part of image : ");
			int array[][]=input(m,n);
			print(array);
			HashMap<String, int[][]> rtemp = r.getRimage();
			rtemp.put(name, array);
			r.setRimage(rtemp);
			System.out.println("Green part of image : ");
			int array1[][]=input(m,n);
			print(array1);
			HashMap<String, int[][]> gtemp = r.getGimage();
			gtemp.put(name, array1);
			r.setGimage(gtemp);
			System.out.println("Blue part of image : ");
			int array2[][]=input(m,n);
			print(array2);
			HashMap<String, int[][]> btemp = r.getBimage();
			btemp.put(name, array2);
			r.setBimage(rtemp);	
		}
	}

}
