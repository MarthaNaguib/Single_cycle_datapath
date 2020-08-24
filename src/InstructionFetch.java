
public class InstructionFetch {

	static InstructionMemory m=new InstructionMemory();
	public static Instruction InstFetch(String PCAddr) throws Exception {
		
		System.out.println("Fetching what is in PC: "+ALU.BinarytoInt(PCAddr));
	m.PC=ALU.BinarytoInt(PCAddr);
	//System.out.println(m.fetch());
	Instruction result=m.fetch();
	ProgCount();
	System.out.println("The fetched instruction  "+result);
	
	return result;
	}
	public static void ProgCount() {
		if(m.PCSrc==0)
			{m.PC+=4;
		System.out.println("PC is now "+m.PC +" in binary :"+ Integer.toBinaryString(m.PC));}
		else {
			m.PC+=4;
			System.out.println("going to branch target" );
		}
			
		
	
	}
	
	public static void main(String[] args) throws Exception {

	while(m.PC!=48) {
		InstructionDecode.InstDecode(InstFetch(Integer.toBinaryString(m.PC)), m.PC);
	}
///Task_[5]_[T]_[10]//FINAL


	}
}
