
public class Execute {
	static String fromSignExtend;
	public static void Execute(String Op) throws Exception {
		String fourbit="";
		int Operand1=InstructionDecode.op1;
		int Operand2=InstructionDecode.op2;
		String result1=Integer.toBinaryString(Operand1);
		String result2=Integer.toBinaryString(Operand2);
		if(Operand1<0) {
			while(result1.length()!=32) {
				result1='1'+result1;
			}
		}
		else {
			while(result1.length()!=32) {
				result1='0'+result1;
			}
		}
		
		if(Operand2<0) {
			while(result2.length()!=32) {
				result2='1'+result2;
			}
		}
		else {
			while(result2.length()!=32) {
				result2='0'+result2;
			}
		}
		
		
		if(Op.equals("00")) {
			fourbit="0010";
			result2=fromSignExtend;
			System.out.println("The sign extend: "+fromSignExtend);
			
		
		}
		else if (Op.equals("01")) {
			fourbit="0110";
			System.out.println("The branch address is "+fromSignExtend);
			
		}else if (Op.equals("10")) {
			//rtype
			String func=fromSignExtend.substring(26, 32);
			if(func.equals("100000"))
				fourbit="0010";
			else if (func.equals("100010")) {
				fourbit="0110";
			}else if (func.equals("100100")) {
				fourbit="0000";
			}else if (func.equals("100101")) {
				fourbit="0001";
			}else if (func.equals("101010")) {
				fourbit="0111";
			}
			else {
				
			}
			
			
			
		}else {
			System.out.println("we dont really deal with jumps for now");
		}
		ALU.ALUEvaluator(fourbit, result1, result2);
		
	}
	

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

}
