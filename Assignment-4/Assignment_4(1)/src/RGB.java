import java.util.*;

public class RGB extends parent implements Image{
	private static HashMap<String, int[][]> Rimage = new HashMap<>();
	private static HashMap<String, int[][]> Gimage = new HashMap<>();
	private static HashMap<String, int[][]> Bimage = new HashMap<>();
	private Scanner scan = new Scanner(System.in);
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.print("Enter name of image : ");
		String name = scan.nextLine();
		int x=0;
		while(x!=-1) {
			System.out.println("Enter R, G or B : ");
			String s=scan.nextLine();
			System.out.println("Enter i = ");
			int i=Integer.parseInt(scan.nextLine())-1;
			System.out.println("Enter j = ");
			int j=Integer.parseInt(scan.nextLine())-1;
			long value = Integer.parseInt(scan.nextLine());
			String binary=bin(value);
			if(s.equals("R")) {Rimage.get(name)[i][j]=(int)value;print(Rimage.get(name));}
			else if(s.equals("G")) {Gimage.get(name)[i][j]=(int)value;print(Gimage.get(name));}
			else if(s.equals("B")) {Bimage.get(name)[i][j]=(int)value;print(Bimage.get(name));}
			System.out.println("Enter -1 to exit updating the image, else enter any number: ");
			x=Integer.parseInt(scan.nextLine());
		}
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.print("Enter name of image : ");
		String name = scan.nextLine();
		System.out.println("Red part of image : ");
		print(Rimage.get(name));
		System.out.println("Green part of image : ");
		print(Gimage.get(name));
		System.out.println("Blue part of image : ");
		print(Bimage.get(name));
	}
	void create(int m , int n, int[][] arr, String name ) {
		System.out.println("Red part of image: ");
		print(arr);
		System.out.println("Green part of image: ");
		print(arr);
		System.out.println("Blue part of image: ");
		print(arr);
		Rimage.put(name, arr);
		Gimage.put(name, arr);
		Bimage.put(name, arr);
	}
	public HashMap<String, int[][]> getRimage() {
		return Rimage;
	}

	public void setRimage(HashMap<String, int[][]> rimage) {
		Rimage = rimage;
	}

	public HashMap<String, int[][]> getGimage() {
		return Gimage;
	}

	public void setGimage(HashMap<String, int[][]> gimage) {
		Gimage = gimage;
	}

	public HashMap<String, int[][]> getBimage() {
		return Bimage;
	}

	public void setBimage(HashMap<String, int[][]> bimage) {
		Bimage = bimage;
	}

}
