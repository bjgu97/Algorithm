

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1934_최소공배수 {
	
	public static int gcd(int a, int b) {
		int r = a % b;
		if(r == 0)
			return b;
		else
			return gcd(b, r);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st;
	StringBuilder sb = new StringBuilder();
	int T = Integer.parseInt(br.readLine());
	
	for(int t = 0; t < T; t++) {
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		// 최대공약수부터 찾자
		int G = gcd(A, B);
		
		//그다음 최소공배수
		int L = G * A/G * B/G;
		
		sb.append(L).append("\n");
	}
	
	System.out.println(sb);
	
	
	
	
}
}
