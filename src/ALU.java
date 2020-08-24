
import java.io.InputStream;
import java.util.Scanner;

public class ALU {
	static int Z;
	
	
	public static void ALUEvaluator(String Op, String Operand1 , String Operand2 ) throws Exception {

		String result="";
		if(Op.equals("0000")) {
			System.out.println("Operation Name : AND");
			result=ANDOp(Operand1, Operand2);
		
		}
		else if (Op.equals("0001")) {
			System.out.println("Operation Name : OR");
			result=OROp(Operand1, Operand2);
			
		}else if (Op.equals("0010")) {
			System.out.println("Operation Name : ADD");
			result=addOp(Operand1, Operand2);
			
		}else if (Op.equals("0110")) {
			System.out.println("Operation Name : SUB");
			result=subOp(Operand1, Operand2);
			
		}else if (Op.equals("0111")) {
			System.out.println("Operation Name : SLT");
			result=sltOp(Operand1, Operand2);
			
		}else if (Op.equals("1100")) {
			System.out.println("Operation Name : NOR");
			result=NOR(Operand1, Operand2);
			
		}
		else {
			System.out.println("This input is incorrect");
			return;
		}

		System.out.println("1st Operand :"+Operand1);
		System.out.println("2nd Operand :"+Operand2);
		System.out.println("Output : "+result+ "in int"+BinarytoInt(result));
		System.out.println("Z-Flag Value : "+Z);
		if(regFile.ALUop.equals("00")) {
			MemoryAccess.MemAccess(Operand2,BinarytoInt(result));
		}else if (regFile.write==true && regFile.MemToReg==0) {
			int x=ALU.BinarytoInt(regFile.rd);
			WriteBack.writeBack(result,x);
		}else if (Z==1 && regFile.Branch==1) {
			InstructionFetch.m.PC=4*BinarytoInt(Execute.fromSignExtend)+InstructionFetch.m.PC;
			System.out.println("the new pc is "+InstructionFetch.m.PC+" since they are equal");
			InstructionFetch.m.PCSrc=1;
			
		}else if (Z==0 && regFile.Branch==1) {
			
			System.out.println("the new pc is "+InstructionFetch.m.PC+" since they are not equal");
			
		}
	}
	
	
	public static String ANDOp(String x,String y) throws Exception{
		String result="";
		if(x.length()!=y.length()) {
			throw new Exception("THE TWO SHOULD BE THE SAME LENGTH");
		}
		
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)=='1' && y.charAt(i)=='1')
				result=result+'1';
			else {
				result=result+'0';
			}
	
		}
		if(BinarytoInt(result)==0) {
			Z=1;
		}
		else {
			Z=0;
		}
		return result;
		
	}
	
	
	public static String OROp(String x,String y) throws Exception{
		String result="";
		if(x.length()!=y.length()) {
			throw new Exception("THE TWO SHOULD BE THE SAME LENGTH");
		}
		
		for(int i=0;i<x.length();i++) {
			if(x.charAt(i)=='0' && y.charAt(i)=='0')
				result=result+'0';
			else {
				result=result+'1';
			}
	
		}
		if(BinarytoInt(result)==0) {
			Z=1;
		}
		else {
			Z=0;
		}
		return result;
		
	}
	public static String NOR(String x,String y) throws Exception{
		String oring=OROp(x, y);
		String resulString="";
		for(int i=0;i<oring.length();i++) {
			if(oring.charAt(i)=='1') {
				resulString=resulString+"0";
			}else {
				resulString=resulString+"1";
			}
		}
		if(BinarytoInt(resulString)==0) {
			Z=1;
		}
		else {
			Z=0;
		}
		return resulString;
		
	}
	public static String sltOp(String x,String y) throws Exception {
		int a=BinarytoInt(x);
		//System.out.println(a);
		int b=BinarytoInt(y);
		//System.out.println(b);
		if(a<b) {
			Z=0;

			return "01111111111111111111111111111111";
		}
		else {
			Z=1;
			return "00000000000000000000000000000000";
		}
	}
	public static String addOp(String x,String y) throws Exception {
		String result="";
		int a=BinarytoInt(x);
		int b=BinarytoInt(y);
		int sum=a+b;
		result=Integer.toBinaryString(sum);
		if(sum==0) {
			Z=1;
		}
		else {
			Z=0;
		}
		if(sum<0) {
			while(result.length()!=32) {
				result='1'+result;
			}
		}
		else {
			while(result.length()!=32) {
				result='0'+result;
			}
		}
		return result;
	}
	
	public static String subOp(String x,String y) throws Exception {
		String result="";
		int a=BinarytoInt(x);
		int b=BinarytoInt(y);
		int sum=a-b;
		result=Integer.toBinaryString(sum);
		if(sum==0) {
			Z=1;
		}
		else {
			Z=0;
		}
		if(sum<0) {
			while(result.length()!=32) {
				result='1'+result;
			}
		}
		else {
			while(result.length()!=32) {
				result='0'+result;
			}
		}
		return result;
	}
	
public static int BinarytoInt(String x) throws Exception {
	int num=0;
	//int power=0;
	int base = 1; 
	try {
		int zz=x.length();
	} catch (java.lang.NullPointerException e) {
		System.out.println("There is nothing here");
		throw new Exception("its okay");
	}
	for(int i=x.length()-1;i>=0;i--) {
	
		if(x.charAt(i)=='1') {
			
			//num= num+(int)(Math.pow(2, power));
			num=num+base;
			
		}
		base = base * 2; 
			
	}
	return num;
	
	
}





//	public static void main(String[] args) throws Exception {
////Scanner sc=new Scanner(System.in);
////String op="";
////System.out.println("1st Operand : ");
////String op1=sc.next();
////System.out.println("2nd Operand : ");
////String op2=sc.next();
////op=sc.nextLine();
////while(op.length()!=4) {
////System.out.println("Operation : ");
////op=sc.nextLine();}
////ALUEvaluator(op, op1, op2);
////sc.close();
////New after correction 3rd time
//		
//	}

}
