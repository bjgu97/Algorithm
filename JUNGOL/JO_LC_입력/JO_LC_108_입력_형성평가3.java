package JO_LC_입력;

public class JO_LC_108_입력_형성평가3 {

	public static void main(String[] args) {
//		정수형 변수 한 개를 선언하여 50을 대입하고 실수형 변수 한 개를 선언하여 100.12를 대입한 후 다음과 같이 출력되는 프로그램을 작성하시오.
//
//		(결과값은 소수점 이하에서 반올림) 

		int num1 = 50;
		double num2 = 100.12;
		
		System.out.printf("%.2f * %d = %d", num2, num1, (int)(num1*num2));
	}

}
