package 워밍업;
import java.util.Scanner;

public class BAEKJOON_11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			//숫자의 개수
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();
			
			String str = scan.next();
			int sum = 0;
			for(int n = 0; n < num; n++) {
				sum += str.charAt(n) - '0'; // (char)48 = (int)1
			}
			
			System.out.println(sum);
		}
	}


