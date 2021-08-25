

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BJ_2407_조합 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // n 개 중
		int M = Integer.parseInt(st.nextToken()); // m 개 고르기
		
		// BigInteger로 바꿔주기
		BigInteger BN = BigInteger.valueOf(N);
		BigInteger BM = BigInteger.valueOf(M);
		
		
		// N 처리
		BigInteger[] NArr = new BigInteger[M];
		
		// 배열에 담아주고
		for(int i = 0; i < M; i++) { 
			NArr[i] = BigInteger.valueOf(N - i);
		}
		
		// 하나씩 꺼내서 곱해준다.
		BigInteger a = BigInteger.ONE;
		for(int i = 0; i < M; i++) {
			a = a.multiply(NArr[i]);
		}
		
		
		// M 처리 -> factorial
		BigInteger b = factorial(BM);
		
		System.out.println(a.divide(b));
	}
	
	static BigInteger factorial(BigInteger M) {
		if(M.equals(BigInteger.ONE))
			return M;
		else
			return M.multiply(factorial(M.subtract(BigInteger.valueOf(1))));
	}
}
