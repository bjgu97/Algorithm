package JO_LC_입력;

public class JO_LC_107_입력_형성평가2 {

	public static void main(String[] args) {
//		실수형 변수를 2개 선언한 후 각각에 80.5 22.34를 대입한 후 두 수의 합을 구하여 각각의 숫자를 10칸씩 오른쪽에 맞추어 소수 둘째자리까지 출력하는 프로그램을 작성하시오.

		double num1 = 80.5;
		double num2 = 22.34;
		
		System.out.printf("%10.2f%10.2f%10.2f", num1, num2, num1+num2);
	}

}
