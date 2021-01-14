package JO_LC_선택제어문;

import java.util.Scanner;

public class JO_LC_533_선택제어문_자가진단6 {

	public static void main(String[] args) {
		/*
		 * 남자는 'M' 여자는 'F'로 나타내기로 하고 18세 이상을 성인이라고 하자.
		 * 성별('M', 'F')과 나이를 입력받아 "MAN"(성인남자), "WOMAN"(성인여자), "BOY"(미성년남자), "GIRL"(미성년여자)을 구분하여 출력하는 프로그램을 작성하시오.
		 */

		//성별과 나이 입력받기
		Scanner scan = new Scanner(System.in);
		char sex = scan.next().charAt(0);
		int age = scan.nextInt();
		
		//출력
		if(age >= 18) {
			if(sex == 'M') {
				System.out.println("MAN");
			}
			else if(sex == 'F') {
				System.out.println("WOMAN");
			}
		}
		else {
			if(sex == 'M') {
				System.out.println("BOY");
			}
			else if(sex == 'F') {
				System.out.println("GIRL");
			}
		}
	}

}
