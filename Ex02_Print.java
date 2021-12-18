
class Ssystem{
	//out
	public static final PrintSstream out;
	static {
		out=new PrintSstream();
	}
	
}

class PrintSstream{
	void print(String s) {
		System.out.println(s);
	}
	void print(int i) {
		System.out.println(i);
	}
}


public class Ex02_Print {
	public static void main(String[] args) {
		System.out.println("출력");
		//다시수정
		Ssystem.out.print("출력");
	}
}
