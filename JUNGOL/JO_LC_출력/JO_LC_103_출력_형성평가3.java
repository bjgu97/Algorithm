package start_1.JO_LC_출력;

public class JO_LC_103_출력_형성평가3 {

	public static void main(String[] args) {
//		다음 출력 예와 같이 출력되는 프로그램을 작성하시오.
//		TTTTTTTTTT
//		TTTTTTTTTT
//		    TT
//		    TT
//		    TT
		String t10 = "TTTTTTTTTT";
		String t2 = "TT";
		
		System.out.printf("%s\n", t10);
		System.out.printf("%s\n", t10);
		System.out.printf("%6s\n", t2);
		System.out.printf("%6s\n", t2);
		System.out.printf("%6s", t2);
		
	}

}
