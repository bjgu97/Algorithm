

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_5607_조합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			

		}
		
		System.out.println(sb);
	}
	
//	static long comb(int n, int r) {
//		long nn = n;
//		long rr = r;
//		for(int i = 1; i < r; i++) {
//			nn = nn * (n-i);
//		}
//		for(int i = 1; i < r; i++) {
//			rr = rr * (r-i);
//		}
//		return nn / rr;
//	}
}
