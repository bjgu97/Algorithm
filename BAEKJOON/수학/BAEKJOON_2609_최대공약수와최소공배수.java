package 수학;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2609_최대공약수와최소공배수 {

	public static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0)
			return b;
		else 
			return gcd(b, r);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		/* 방법2: 유클리드 호제법? */
		//X를 Y로 나눈 나머지의 값을 R이라 했을 때,

		
		// 최대공약수
		int gcdNum = gcd(A, B);
		sb.append(gcdNum).append("\n");
		
		//최소공배수
		int lcdNum = gcdNum * A/gcdNum * B/gcdNum;
		sb.append(lcdNum);
		
		System.out.println(sb);
		
		
		/* 방법1: 왜 안되지? */
//		int min = Math.min(A,  B);
//		
//		//최대공약수
//		int maxInt = 0;
//		if(A == 1 || B == 1)
//			maxInt = Math.min(A, B);
//		else {
//			for(int i = 1; i < min; i++) {
//				if(A % i == 0 && B % i == 0)
//					maxInt = Math.max(i,  maxInt);
//			}
//		}
//		sb.append(maxInt).append("\n");
//		
//		
//		//최소공배수
//		int minInt = A * B;
//		for(int j = min; j < A*B; j++) {
//			if(j % A == 0 && j % B == 0)
//				minInt = Math.min(j,  minInt);
//		}
//		sb.append(minInt);
//		
//		System.out.println(sb);
	}

}
