import java.util.Arrays;

public class regFile {
	Instruction inst;
	static String rs;
	static String rt;
	static String rd;
	static boolean write=false;
	static int RegDst;
	static int ALUSRC;
	static int MemToReg;
	static int Branch=0;
	static String ALUop;
	static int registers[]= {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31};


	public regFile(Instruction s) {
		inst=s;
//		for(int i=0;i<32;i++) {
//			
//			registers[i]=i;
//		}
		
	}
public void decode() throws Exception {
	System.out.println("starting to decode ");
	try { String x=inst.toString();}catch (Exception e) {
		throw new Exception("there is NO INSTRUCTION here");
	}
	String x=inst.toString();
	//Chaitanya".substring(2,5) would return "ait"
	String op=x.substring(0, 6);
	String func=x.substring(26, 32);
	if(op.equals("100011")) {
		//lw
		write=true;
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		RegDst=0;
		ALUSRC=1;
		MemToReg=1;
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(true);
		ALUop="00";
		System.out.println("it is lw and rs is: "+rs+" and rt is: "+rt);
	}
	else if (op.equals("101011")) {
		//sw
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		write=false;
		RegDst=0;
		ALUSRC=1;
		Branch=0;
		MemToReg=0;
		ALUop="00";
		DataMemory.setMemWrite(true);
		DataMemory.setMemRead(false);
		System.out.println("it is sw and rs is: "+rs+" and rt is: "+rt);
	}
	else if (op.equals("000000") && func.equals("100000")) {
		//add
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		rd=x.substring(16, 21);
		write=true;
		RegDst=1;
		MemToReg=0;
		ALUSRC=0;
		ALUop="10";
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
		System.out.println("it is add and rs is: "+rs+" and rt is: "+rt+"and rd is: "+rd);
		
	}
	else if (op.equals("000000") && func.equals("100010")) {
		//sub
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		rd=x.substring(16, 21);
		write=true;
		RegDst=1;
		ALUSRC=0;
		MemToReg=0;
		ALUop="10";
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
		System.out.println("it is sub and rs is: "+rs+" and rt is: "+rt+"and rd is: "+rd);
	}
	else if(op.equals("000100")) {
		//beq
		//InstructionMemory.PCSrc=1;
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		RegDst=0;
		ALUSRC=0;
		DataMemory.setMemWrite(false);
		write=false;
		MemToReg=0;
		Branch=1;
		ALUop="01";
		DataMemory.setMemRead(false);
		System.out.println("it is beq and rs is: "+rs+" and rt is: "+rt);
		
	}
	else if(op.equals("000010")){
		//jump instruction
		//InstructionMemory.PCSrc=1;
		System.out.println("it is a jump");
		write=false;
		RegDst=0;
		ALUSRC=0;
		Branch=0;
		MemToReg=0;
		ALUop="xx";//dontcare
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
	}
	else if (op.equals("000000") && func.equals("100100")) {
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		rd=x.substring(16, 21);
		write=true;
		RegDst=1;
		ALUSRC=0;
		MemToReg=0;
		ALUop="10";
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
		System.out.println("it is and and rs is: "+rs+" and rt is: "+rt+"and rd is: "+rd);
	}	else if (op.equals("000000") && func.equals("100101")) {
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		rd=x.substring(16, 21);
		write=true;
		RegDst=1;
		ALUSRC=0;
		MemToReg=0;
		ALUop="10";
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
		System.out.println("it is or and rs is: "+rs+" and rt is: "+rt+"and rd is: "+rd);
	}
	else if (op.equals("000000") && func.equals("101010")) {
		rs=x.substring(6, 11);
		rt=x.substring(11, 16);
		rd=x.substring(16, 21);
		write=true;
		RegDst=1;
		ALUSRC=0;
		MemToReg=0;
		ALUop="10";
		Branch=0;
		DataMemory.setMemWrite(false);
		DataMemory.setMemRead(false);
		System.out.println("it is slt and rs is: "+rs+" and rt is: "+rt+"and rd is: "+rd);
	}
	
	
	
	
	
}
//	public static void main(String[] args) {
////		// TODO Auto-generated method stub
////		Instruction s=new Instruction();
////		regFile r=new regFile(s);
////System.out.println(Arrays.toString(r.registers));
//	}

}

