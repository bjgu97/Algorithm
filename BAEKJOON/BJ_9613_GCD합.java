import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import sun.java2d.pipe.BufferedBufImgOps;

public class BJ_9613_GCD합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케 수
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			long sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					sum += gcd(arr[i], arr[j]);
				}
			}
			System.out.println(sum);
			
		}
	}
	
	static int gcd(int n1, int n2) {
		if(n2 == 0)
			return n1;
		else {
			return gcd(n2, n1 % n2);
		}
	}
}
