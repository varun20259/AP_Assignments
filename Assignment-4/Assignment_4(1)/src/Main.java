import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a =0;
		while(a!=-1) {
			Scanner scan = new Scanner(System.in);
			System.out.println("Choose operation: ");
			System.out.println("1. Create Gray image\n"
					+ "2. Create RGB image\n"
					+ "3. Input Gray image\n"
					+ "4. Input RGB image\n"
					+ "5. Update image\n"
					+ "6. Display image\n"
					+ "7. Find negatives\n"
					+ "-1. Exit\n");
			System.out.print("Enter op. from above -- ");
			a=scan.nextInt();
			Gray g = new Gray();
			RGB r = new RGB();
			if(a==1) {
				System.out.print("Enter order of image( m ) = ");
				int m = scan.nextInt();
				System.out.print("Enter order of image( n ) = ");
				int n = scan.nextInt();
				g.create(m, n, 1);
				System.out.println(g.getGimage());
			}
			else if(a==2) {
				System.out.print("Enter order of image( m ) = ");
				int m = scan.nextInt();
				System.out.print("Enter order of image( n ) = ");
				int n = scan.nextInt();
				g.create(m, n, 0);
			}
			else if(a==3) {
				System.out.print("Enter order of image( m ) = ");
				int m = scan.nextInt();
				System.out.print("Enter order of image( n ) = ");
				int n = scan.nextInt();
				g.input(m, n, 1,g,r);
			}
			else if(a==4) {
				System.out.print("Enter order of image( m ) = ");
				int m = scan.nextInt();
				System.out.print("Enter order of image( n ) = ");
				int n = scan.nextInt();
				r.input(m, n, 0,g,r);
			}
			else if(a==5) {
				System.out.println("1. Update gray image\n"
						+ "2. Update RGB image\n");
				int x = scan.nextInt();
				if(x==1) {
					g.update();
				}
				else {
					r.update();
				}
			}
			else if(a==6) {
				System.out.println("1. Display gray image\n"
						+ "2. Display RGB image\n");
				int x = scan.nextInt();
				if(x==1) {
					g.display();
				}
				else {
					r.display();
				}
			}
			else if(a==7) {
				System.out.println("1. Display gray image\n"
						+ "2. Display RGB image\n");
				int x = scan.nextInt();
				parent p = new parent();
				p.negative(x, g, r);
				}
			
			else {
				break;
			}
		}

	}

}
