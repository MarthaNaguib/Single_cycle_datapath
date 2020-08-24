
public class MemoryAccess {
	
	public static void MemAccess(String readdata2,int addressinmemory) throws Exception {
		if(DataMemory.isMemRead() || DataMemory.isMemWrite()) {
			System.out.println("This result is an address in memory" );
		}
		if(DataMemory.isMemRead()) {
			System.out.println(DataMemory.read(addressinmemory));
			
			int x=ALU.BinarytoInt(regFile.rt);
			System.out.println("stored in regiser: "+ x);
			WriteBack.writeBack(DataMemory.read(addressinmemory),x);
		}else if (DataMemory.isMemWrite()) {
			int x=ALU.BinarytoInt(regFile.rt);
			
			DataMemory.write(addressinmemory, Integer.toBinaryString(regFile.registers[x]));
		}
	}


}
