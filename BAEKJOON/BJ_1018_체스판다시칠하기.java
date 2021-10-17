import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1018_체스판다시칠하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[N][M];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			map[n] = s.toCharArray();
		}
		
//		for(char[] m : map)
//			System.out.println(Arrays.toString(m));
		
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;
		
		// 맨 왼쪽 위가 B일 경우
			for(int n = 0; n <= N-8; n++) {
				for(int m = 0; m <= M-8; m++) {
					int cnt = 0;
					for(int i = n; i < n + 8; i++) {
						for(int j = m; j < m + 8; j++) {
								if(((i + j) % 2 == 0) && map[i][j] == 'W') {
									cnt++;
								}
								if(((i + j) % 2 != 0) && map[i][j] == 'B') {
									cnt++;
								}
							}
						}
					min1 = Math.min(min1, cnt);
					}
					
				}
			
		//맨 왼쪽 위가 W일 경우
			for(int n = 0; n <= N-8; n++) {
				for(int m = 0; m <= M-8; m++) {
					int cnt = 0;
					for(int i = n; i < n + 8; i++) {
						for(int j = m; j < m + 8; j++) {
								if(((i + j) % 2 == 0) && map[i][j] == 'B') {
									cnt++;
								}
								if(((i + j) % 2 != 0) && map[i][j] == 'W') {
									cnt++;
								}							
						}
					}
					min2 = Math.min(min2, cnt);
				}
			}

		
		
		System.out.println(Math.min(min1, min2));
	}
}
