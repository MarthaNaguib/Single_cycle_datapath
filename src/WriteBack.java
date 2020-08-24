import java.util.Arrays;

public class WriteBack {

	public static void writeBack(String string, int x) throws Exception {
		System.out.println("The position where I am going to store the write back value is in reg no "+x);
	regFile.registers[x]=ALU.BinarytoInt(string);
	System.out.println("the string is to be written back "+string+" this is :"+ALU.BinarytoInt(string));
	System.out.println("what should be in registers now "+Arrays.toString(regFile.registers));
		
	}


}
