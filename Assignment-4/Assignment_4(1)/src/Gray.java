import java.util.*;

public class Gray extends parent implements Image  {
	private static HashMap<String,int[][]> Gimage= new HashMap<>();
	Scanner scan = new Scanner(System.in);
	@Override
	public void update() {
		// TODO Auto-generated method stub
		System.out.print("Enter name of image : ");
		String name = scan.nextLine();
		int x=0;
		while(x!=-1) {
			System.out.println("Enter i = ");
			int i=Integer.parseInt(scan.nextLine());
			System.out.println("Enter j = ");
			int j=Integer.parseInt(scan.nextLine());
			long value = Integer.parseInt(scan.nextLine());
			String binary=bin(value);
			Gimage.get(name)[i-1][j-1]=(int)value;		
			System.out.println("Updated image : ");
			print(Gimage.get(name));
			System.out.println("Enter -1 to exit updating the image, else enter any number: ");
			x=Integer.parseInt(scan.nextLine());
		}	
	}

	@Override
	public void display() {
		System.out.print("Enter name of image : ");
		String name = scan.nextLine();
		print(Gimage.get(name));
		// TODO Auto-generated method stub
		
	}
	void create(int m, int n, int[][]arr, String name) {
		print(arr);
		Gimage.put(name, arr);

		
	}
	public HashMap<String,int[][]> getGimage() {
		return Gimage;
	}

	public void setGimage(HashMap<String,int[][]> gimage) {
		Gimage = gimage;
	}

}
