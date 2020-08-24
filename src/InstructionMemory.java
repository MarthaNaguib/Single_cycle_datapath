

	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Vector;
public class InstructionMemory {



		static ArrayList<Instruction> addresses;
		static int PC;
		static int PCSrc=0;
		
		public InstructionMemory()
		{
			addresses=new ArrayList<Instruction>();
		
//		addresses = new Instruction[size];
			PC=0;
			
			Instruction x=new Instruction();
			int[] lw= {1,0,0,0,1,1 , 0,1,0,1,0 ,0,0,1,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,0 ,0,0,0,1};
			x.bits=lw;
			addresses.add(x);
			
			
			
			Instruction y=new Instruction();
			//int [] sw= {1,0,1,0,1,1, 0,1,0,0,1 ,0,1,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,1,1, 0,0,0,0};
			int []sw= {1,0,1,0, 1,1,1,0, 0,0,1,1, 0,0,1,0, 0,0,0,0, 0,0,0,0, 0,0,0,0 ,0,0,0,0};
			y.bits=sw;
			addresses.add(y);
			//1010 1110 0011 0010 0000 0000 0000 0000
			

			Instruction z=new Instruction();
			int []add= {0,0,0,0,0,0, 1,0,0,1,0, 0,1,0,0,0, 0,1,0,0,0, 0,0,0,0,0, 1,0,0,0,0,0};
			z.bits=add;
			addresses.add(z);
			
			Instruction a=new Instruction();
			int []sub= {0,0,0,0,0,0, 1,0,0,1,0, 0,1,0,0,0, 0,0,0,1,0, 0,0,0,0,0, 1,0,0,0,1,0};
			a.bits=sub;
			addresses.add(a);
			
			Instruction b=new Instruction();
			int []beq= {0,0,0,1,0,0, 0,1,0,0,0, 0,0,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,1,1};
			b.bits=beq;
			addresses.add(b);
			
			
//			Instruction c=new Instruction();
//			int []j= {0,0,0,0,1,0 ,0,0,0,0,0, 1,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0, 0,0,0,0,0,1};
//			c.bits=j;
//			addresses.add(c);
			
			
			Instruction and=new Instruction();
			int []andarr= {0,0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0};
			and.bits=andarr;
			addresses.add(and);
			
			
			Instruction y1=new Instruction();
			int [] sw1= {1,0,1,0, 1,1,1,0, 0,0,1,1, 0,0,1,0, 0,0,0,0, 0,0,0,0, 0,0,0,0 ,0,0,0,0};
			y1.bits=sw1;
			addresses.add(y1);
			Instruction x1=new Instruction();
			int[] lw1= {1,0,0,0,1,1 , 0,0,0,0,1, 0,0,0,0,0, 0,0,0,0, 0,0,0,0, 0,0,0,1,0,0,0,0};
			x1.bits=lw1;
			addresses.add(x1);
			
			Instruction or=new Instruction();
			int []orarr= {0,0,0,0, 0,0,0,1, 1,0,1,0 ,1,1,1,0 ,0,1,1,1 ,1,0,0,0, 0,0,1,0, 0,1,0,1};
			or.bits=orarr;
			addresses.add(or);
			
			Instruction slt=new Instruction();
			int []slt1= {0,0,0,0,0,0,0,1,0,1,0,0,1,0,1,1,0,1,0,0,1,0,0,0,0,0,1,0,1,0,1,0};
			slt.bits=slt1;
			addresses.add(slt);
			
			//
			
			Instruction b1=new Instruction();
			int []beq1= {0,0,0,1,0,0, 0,1,0,0,0, 0,1,0,0,0, 0,0,0,0,0,0,0,0,0,0, 0,0,0,0,0,1};
			b1.bits=beq1;
			addresses.add(b1);
			
			
			
			
			
			

		}
		
//		public void fetch() {
//			if(PC/4 >=addresses.length) {
//				System.out.println("There is nothing more in the memory");
//			return;	
//			}
//			Instruction x=addresses[PC/4];
//			PC=PC+4;
//			System.out.println(x);
//			
//		}
		public static Instruction fetch() {
			System.out.println("FETCHING THE INSTRUCTION FROM Instruction MEMORY");

		if(PC/4>=addresses.size())
			return null;
		Instruction x=addresses.get(PC/4);
		//System.out.println(x);
		//////////////////PC=PC+4;
		
		
		System.out.println("INCREMENTING PROGRAM COUNTER");
		return x;
			
			
			
			
		}
		public static int getPC() {
			return PC;
		}

		public static void setPC(int pC) {
			PC = pC;
		}

		public static void passToRegFile(Instruction s) throws Exception {
			System.out.println("PASSING THE INSTRUCTION TO REGISTER");
			regFile r=new regFile(s);
			r.decode();
		}
		
		
//
//		public static void main(String[] args) throws Exception {
//			InstructionMemory m=new InstructionMemory();
//		for(int i=0;i<m.addresses.size();i++) {
//			passToRegFile(m.fetch());
//		}
//
//
//
//
//		}

	

}
