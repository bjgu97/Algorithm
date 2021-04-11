package study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_18428_감시 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		char[][] map = new char[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = st.nextToken().charAt(0);
			}
		}
		
		comb(0, map, N);
	}
	static boolean flag;
	static void comb(int cnt, char[][] map, int N) {
		if(cnt == 3) {
			if(find())
				flag = true;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 'X') {
					map[i][j] = 'O';
					comb(cnt+1, map, N);
					map[i][j] = 'X';
				}
			}
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean find() {
		
	}
}
