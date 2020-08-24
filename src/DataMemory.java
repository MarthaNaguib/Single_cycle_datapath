

	import java.util.Arrays;
import java.util.Scanner;
public class DataMemory {


	
		//static String[] arr = new String[1024];
	static String[] arr = {"hello","hi","hey","heythere","howyoudoin","seeya","whatchadoin","youthere","okcool","11","010101","101","hi","hey","heythere","howyoudoin","seeya","000011"};
		static boolean MemRead=false;
		static boolean MemWrite=false;
	//assuming data is 1 bit and each data is stored in a single index


		public static void write(int add,String data) 
		{
			MemWrite=true;
			MemRead=false;
			arr[add]=data;
			System.out.println("Memory is writing "+data+" in address "+add);
			System.out.println("the data memory now: "+Arrays.toString(arr));
		}
		
		public static boolean isMemRead() {
			return MemRead;
		}

		public static void setMemRead(boolean memRead) {
			MemRead = memRead;
		}

		public static boolean isMemWrite() {
			return MemWrite;
		}

		public static void setMemWrite(boolean memWrite) {
			MemWrite = memWrite;
		}

		public static String read(int add)
		{
			MemRead=true;
			MemWrite=false;
			String data;
			data=arr[add];
			System.out.println("Memory is reading from position "+add);
			return data;

		}
		
//		public static void main(String[] args) 
//		{
////			Scanner sc = new Scanner(System.in);
////			int x = sc.nextInt();
////			String y = sc.next();
////			write(x,y);
////			int z = sc.nextInt();
////			System.out.println(read(z));
////			sc.close();
//		}
	
}
