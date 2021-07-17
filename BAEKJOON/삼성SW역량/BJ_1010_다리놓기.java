package 삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1010_다리놓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			// M C N
			
			// 분모
			double top = 1;
			for(double n = 0; n < N; n++) {
				top *= (M-n);
			}
			
			double bottom = 1;
			for(double n = 0; n < N; n++) {
				bottom *= (N-n);
			}

			System.out.printf("%.0f", top/bottom);
		}
	}
}
