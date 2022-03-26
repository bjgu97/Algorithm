import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11059_크리문자열 {
	public static void main(String[] args) throws IOException {
		// 숫자로만 이루어진 문자열 S
		// 길이가 짝수이고, 앞 절반합과 뒤 절반 합이 같은 문자열
		// 빈문자열은 아님
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		int L = S.length();
		int answer = 0;
		for(int l = 0; l < L-1; l++) {
//			System.out.println("### l: " + l);
			int sum1 = S.charAt(l) - '0';
			int sum2 = S.charAt(l+1) - '0';
			
//			System.out.println("* sum1: " + sum1);
//			System.out.println("* sum2: " + sum2);
			int i = 1;
			int len = 0;
			while(l - i >= 0 && l + 1 + i < L) {
//				System.out.println("i: " + i);
				sum1 += S.charAt(l- i) - '0';
				sum2 += S.charAt(l + 1 + i) - '0';
				
//				System.out.println("sum1: " + sum1);
//				System.out.println("sum2: " + sum2);
				if(sum1 == sum2) {
					len = 2 * (i+1);
				}
				
//				System.out.println("len: " + len);
				answer = Math.max(answer, len);
				i++;
//				System.out.println();
			}
			
		}
		System.out.println(answer);
	}
}
