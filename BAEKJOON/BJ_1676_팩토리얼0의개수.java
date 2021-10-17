import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1676_팩토리얼0의개수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 10 있으면 +1
		// 2랑 5 있으면 +1

		// 40 = 2^3 * 5
		
		
		int two = 0;
		int five = 0;
		for(int n = 1; n <= N; n++) {
			int num = n;
			if( n % 2 == 0) {
				while(num % 2 == 0) {
					two++;
					num /= 2;
				}
			}
			
			if(n % 5 == 0) {
				while(num % 5 == 0) {
					five++;
					num /= 5;
				}
			}
			
		}
		System.out.println(Math.min(two,  five));
		
	}
	

}
