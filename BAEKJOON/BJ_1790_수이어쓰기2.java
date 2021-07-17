import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_1790_수이어쓰기2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long low = 0;
		long high = N;
		long mid = 0;
		boolean flag = false;

		// 문자열 전체 길이가 k가 되는 값(mid) 구하기. 
		while(low <= high) {
			mid = (low + high) / 2;
			
			// val:  mid 까지 숫자 이어붙인 문자열의 길이
			long val = calDigit(mid);
			
			if(val > k) { 
				high = mid-1;
			}
			else {
				low = mid + 1;
			}
			
			// 20 10 -> 10의 첫자리수인 1 
			// 20 11 -> 10의 둘째자리수인 0
			if(val >= k && val < k + (mid + "").length()) { // 10, 11
				flag = true;
				break;
			}
			
//			else if(val < k){
//				low = mid+1;
//			}
//			else  { // 문자열 길이가 k와 같아지면
//				
//				flag = true; 
//				break;
//			}
			
			// N의 자릿수 구하기 
			// Math.log(N) / Math.log(10) + 1;
			// (N+"").length() 
			
		}
		if(flag) {
			String midString = Long.toString(mid);
			int num = (int)(k-calDigit(mid-1));
		
			System.out.println(midString.charAt(num-1));
		}
		
		// k번째 자리 숫자 없는 경우
		else
			System.out.println(-1);
	}
	
	static long calDigit(long num) {
		long[] dp = {0, 0, 1, 21, 321, 4321, 54321, 654321, 7654321, 87654321, 987654321};
		int numLen = Long.toString(num).length();

		return 9*dp[numLen] + (numLen) * (num  - (long)Math.pow(10,  numLen-1) + 1);

		//  0 + 1 * (N - 1 + 1)
		//  9 + 2 * (N - 10 + 1)
		// 189  + 3 * (N - 100 + 1)
	}
	
}
