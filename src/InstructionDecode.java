
public class InstructionDecode {
	static int op1;
	static int op2;
	
	public static void InstDecode(Instruction inst,int PC) throws Exception {
		InstructionMemory.passToRegFile(inst);
		String x=inst.toString();
		//Chaitanya".substring(2,5) would return "ait"
		String op=x.substring(0, 6);
	ContUnit(op);
			//	 +"the PCSrc "+InstructionMemory.PCSrc+" ");
		if(!regFile.ALUop.equals("xx")) {
			System.out.println("Read data 1 ="+regFile.registers[ALU.BinarytoInt(regFile.rs)]+" Read data 2= "+regFile.registers[ALU.BinarytoInt(regFile.rt)]);
			op1=regFile.registers[ALU.BinarytoInt(regFile.rs)];
			op2=+regFile.registers[ALU.BinarytoInt(regFile.rt)];
		}
		System.out.println("The new PC is "+InstructionMemory.PC );
		
		SignExtend(inst);
		Execute.Execute(regFile.ALUop);
	
	}
	
	
	public static String SignExtend(Instruction inst) {
		String x=inst.toString();
		String toExtend=x.substring(16, 32);
		if(toExtend.charAt(0)=='1') {
			while(toExtend.length()!=32) {
				toExtend='1'+toExtend;
			}
		}
		else {
			while(toExtend.length()!=32) {
				toExtend='0'+toExtend;
			}
		}
		Execute.fromSignExtend=toExtend;
		return toExtend;
		
	}
	public static void ContUnit(String opcode) throws Exception {
		int write=(regFile.write) ?1:0;
		int mread=(DataMemory.isMemRead())?1:0;
		int mwrite=(DataMemory.isMemWrite())?1:0;
		System.out.println("Control Signals: The RegDst is "+regFile.RegDst+" The branch signal is: "+regFile.Branch+" MemRead: "+mread);
		System.out.println(" MemtoReg "+regFile.MemToReg+" ALUop: "+regFile.ALUop+""+" MemWrite: "+mwrite);
		System.out.println("ALUSrc : "+regFile.ALUSRC+" regWrite: "+ write);
		//Execute.Execute(regFile.ALUop);
		
	}



//	public static void main(String[] args) throws Exception {
//	
//		//InstDecode(InstructionFetch.InstFetch(Integer.toBinaryString(0)), 0);
//	
//		//InstDecode(InstructionFetch.InstFetch(Integer.toBinaryString(0)), 0);
//		
//
//	}

}
