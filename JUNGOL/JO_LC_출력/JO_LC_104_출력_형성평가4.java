package start_1.JO_LC_출력;

public class JO_LC_104_출력_형성평가4 {

	public static void main(String[] args) {
//		다음 출력 예와 같이 출력되는 프로그램을 작성하시오.
//		합계와 평균은 수식을 이용하세요. 
//		kor 90
//		mat 80
//		eng 100
//		sum 270
//		avg 90
		
		String[] subj = new String[] {"kor", "mat", "eng", "sum", "avg"};
		int kor = 90;
		int mat = 80;
		int eng = 100;
		int sum = kor + mat + eng;
		int avg = (kor + mat + eng) / 3;
				
		System.out.printf("%s %d\n", subj[0], kor);
		System.out.printf("%s %d\n", subj[1], mat);
		System.out.printf("%s %d\n", subj[2], eng);
		System.out.printf("%s %d\n", subj[3], sum);
		System.out.printf("%s %d\n", subj[4], avg);
		
		

	}

}
