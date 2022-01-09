import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9095_123더하기 {
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			
			int n = Integer.parseInt(br.readLine());
			answer = 0;
			for(int a = 0; a < 12; a++) {
				for(int b = 0; b < 6; b++) {
					for(int c = 0; c < 4; c++) {
						if(n == (a*1 + b*2 + c*3)) {
							func(a, b, c);
						}
					}
				}
			}
			System.out.println(answer);
		}
	}
	
	static void func(int a, int b, int c) {
		// a : 1 개수, b: 2 개수, c: 3 개수
		answer += (fact(a + b + c) / (fact(a) * fact(b) * fact(c)));
//		System.out.println(fact(a + b + c) / (fact(a) * fact(b) * fact(c)));
	}
	
	static int fact(int num) {
		int answ = 1;
		for(int n = 1; n <= num; n++) {
			answ = answ * n;
		}
		return answ;
	}
}
