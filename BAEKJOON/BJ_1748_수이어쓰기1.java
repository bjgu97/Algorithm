import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1748_수이어쓰기1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 1부터 N까지 이어쓰면 새로운 하나의 수
		// 새로운 수는 몇자리수?
		
		// 한자리수 : 9개
		// 두자리수 : 90개
		// 세자리수 : 100 ~ 999 900개
		// 네자리수 : 9000개
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long N = Integer.parseInt(br.readLine());
		
		// N 범위는 100000000 (1억)
		long answ = 0;
		for(long n = 1; n <= N; n++) {
			
			answ +=  digitCnt(n);
//			System.out.println(answ);
		}
		System.out.println(answ);
	}
	
	static long digitCnt(long n) {
		// 한자리수이면
		if(n / 10 == 0) {
			return 1;
		}
		else if(n / 100 == 0)
			return 2;
		else if(n / 1000 == 0)
			return 3;
		else if(n / 10000 == 0) return 4;
		else if(n / 100000 == 0) return 5;
		else if(n / 1000000 == 0) return 6;
		else if(n / 10000000 == 0) return 7;
		else if(n / 100000000 == 0) return 8;
		else  return 9;
	}
}
