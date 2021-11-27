import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
		private int n;
		private int m;
		private int k;
		private HashMap<Integer,String> title = new HashMap<>();
		private HashMap<Integer,Integer> ISBN = new HashMap<>();
		private HashMap<Integer,Integer> barcode = new HashMap<>();
		private int[] my_array= new int[n];
	Main(){
		System.out.println("Constructor called");
		Scanner scan = new Scanner(System.in); 	
		System.out.print("Enter the number of books :- ");
		n=scan.nextInt();
		System.out.print("Enter the number of racks :- ");
		m=scan.nextInt();
		k=n/m;
		
	}
	
	void sortBooks()
    {
		int books[]= new int[n];
		for(int i=0;i<n;i++) {
			books[i]=i;
		}
		for(int k=0;k<books.length;k++) {
			for(int t=k+1;t<books.length;t++) {
				if(!title.get(k).toLowerCase().equals(title.get(t).toLowerCase())) {
					if ((title.get(books[k]).toLowerCase()).compareToIgnoreCase(title.get(books[t]).toLowerCase())
		                    > 0) {
							int temp = books[k];
		                    books[k] = books[t];
		                    books[t] = temp;
		                }
				}
				else if(!(ISBN.get(books[k])==(ISBN.get(books[t])))) {
					int ISBN_book1=ISBN.get(books[k]);
					int ISBN_book2=ISBN.get(books[t]);
					if (ISBN_book1>ISBN_book2) {
							int temp = books[k];
		                    books[k] = books[t];
		                    books[t] = temp;
		                }
				}
				else {
					int bar_book1=barcode.get(books[k]);
					int bar_book2=barcode.get(books[t]);
					if (bar_book1>bar_book2) {
							int temp = books[k];
		                    books[k] = books[t];
		                    books[t] = temp;
		                }
				}
			}
		}
		my_array=books;
		System.out.println(title.toString());
		System.out.println(ISBN.toString());
		System.out.println(barcode.toString());
		System.out.println(Arrays.toString(books));
    }
	int [] Stack(String title, int ISBN, int Barcode, Main m ) {
		for(int j=0;j<n;j++) {
			if(barcode.get(j)==Barcode) {
				for(int o=0;o<n;o++) {
					if(my_array[o]==j) {
						int rack=o/m.m;
						int position = m.k-rack*m.m;
						int arr[]= {rack,position};
						return arr;
					}
				}
			}
		}
		return null;
	}
	/*int rack=(int)count/m.m;
						int position = m.k-rack*m.m;
						int arr[]= {rack,position};
						return arr;*/
	boolean checkBarcode(int Barcode,Main m) {
		for(int j: m.barcode.values()) {
			if(j==Barcode) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		System.out.println("main is running .....");
		Scanner scan = new Scanner(System.in);
		Main m = new Main();
		int it=m.n;
		for(int i=0;i<it;i++) 
		{
			System.out.print("Enter title of book of book "+(i+1)+" :- ");
			String title =scan.nextLine();
			System.out.print("Enter ISBN number of book "+(i+1)+":- ");
			String ISBN = scan.nextLine();
			int ISBN_no= Integer.parseInt(ISBN);
			System.out.print("Enter barcode of book "+(i+1)+":- ");
			String Barcode = scan.nextLine();
			int Barcode_no= Integer.parseInt(Barcode);
			while(!m.checkBarcode(Barcode_no, m)) {
				System.out.print("Enter unique barcode of book "+(i+1)+":- ");
				Barcode = scan.nextLine();
				Barcode_no= Integer.parseInt(Barcode);
			}
			m.title.put(i, title);
			m.ISBN.put(i, ISBN_no);
			m.barcode.put(i, Barcode_no);
			
		}
		m.sortBooks();		
		System.out.println("To find the place of your book: ");
		int x=0;
		while(x!=-1) {
		System.out.print("Enter title of book : ");
		String title_ih = scan.nextLine();
		System.out.print("Enter ISBN of book : ");
		String ISBN_ih=scan.nextLine();
		System.out.print("Enter Barcode of book : ");
		String Barcode_ih=scan.nextLine();
		int arr[]= m.Stack(title_ih, it, x, m);
		System.out.println("rack no = "+arr[0]);
		System.out.println("position = "+arr[1]);
		System.out.println("Enter -1 when you want to exit else enter any number");
		String s=scan.nextLine();
		x=Integer.parseInt(s);
		}
	}
}
