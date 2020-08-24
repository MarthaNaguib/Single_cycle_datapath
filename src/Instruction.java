

public class Instruction {
	int[] bits=new int [32];
	
	public String toString() {
		String x="";
		for(int i=0;i<this.bits.length;i++) {
			x=x+bits[i];
		}
		return x;
	}

}

