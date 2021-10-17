

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW4__4014_활주로건설 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 가로줄 다 검사
			boolean check = true;
			for(int i= 0; i < N; i++) {
				check = true;
				for(int j = 0; j < N-1; j++) {
					
				}
			}
			// 세로줄 다 검사
		}
		
	}
}
