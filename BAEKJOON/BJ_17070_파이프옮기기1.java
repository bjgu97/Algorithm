

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17070_파이프옮기기1 {
	static int N;
	static int[][] map;
	static int answ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N  = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		move(0, 1, 0);
		
		System.out.println(answ);
	}
	
	static void move(int r, int c, int dir) {
		if( r == N-1 && c == N-1) {
			answ++;
			return;
		}
		
		if(dir == 0) {
			if(isIn(r, c+1) && (map[r][c+1] == 0)) 
				move(r, c+1, 0); // 가로방향
				
			if(isIn(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c+1] == 0 && map[r+1][c] == 0)
				move(r+1, c+1, 2); // 대각선방향
		}
		
		else if(dir == 1) {
			if(isIn(r+1, c) && (map[r+1][c] == 0))
				move(r+1, c, 1);
			if(isIn(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0) 
				move(r+1, c+1, 2);
		}
		
		else if(dir == 2) {
			if(isIn(r, c+1) && map[r][c+1] == 0)
				move(r, c+1, 0);
			
			if(isIn(r+1, c) && map[r+1][c] == 0)
				move(r+1, c, 1);
			if(isIn(r+1, c+1) && map[r][c+1] == 0 && map[r+1][c] == 0 && map[r+1][c+1] == 0)
				move(r+1, c+1, 2);
		}
		
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 && c >= 0 && r < N && c < N;
	}
}
