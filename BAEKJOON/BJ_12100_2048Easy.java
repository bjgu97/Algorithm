import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_12100_2048Easy {
	static int N;
	static int answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, map); // tmpMap : 
		
		System.out.println(answer);
	}
	
	static int[][] deltas = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	
	static void dfs(int idx, int[][] map) {
		if(idx == 5) {
			answer = Math.max(findAnswer(0, map), answer);
			return;
		}
		
		for(int d = 0; d < deltas.length; d++) {
			
			boolean[][] combined = new boolean[N][N];
			int[][] tmp = new int[N][N];
			
			// 복사
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					tmp[r][c] = map[r][c];
				}
			}
			
			// 우, 하 로 움직일 경우
			if(d == 0 || d == 1) {
				// 전체 블록 이동
				for(int r = N-1; r >= 0; r--) {
					for(int c = N-1; c >= 0; c--) {
						tmp = moveBlock(r, c, d, tmp, combined);
//						System.out.println("r, c: " + r + "," + c);
					}
				}
			}
			
			else if(d == 2 || d == 3) {
				for(int r = 0; r < N; r++) {
					for(int c = 0; c < N; c++) {
						tmp = moveBlock(r, c, d, tmp, combined);
//						System.out.println("r, c: " + r + "," + c);
					}
				}
			}
			
			dfs(idx+1, tmp);

		}
	}
	
	static int[][] moveBlock(int r, int c, int d, int[][] map, boolean[][] combined) {
		// 현대 좌표 r, c
		
		// 이동할 다음 좌표
		int nr = r + deltas[d][0];
		int nc = c + deltas[d][1];
		
		// 범위 벗어나면
		if(!isIn(nr, nc)) return map;
		
		while(true) {
			// 이동 가능하면
			if(map[nr][nc] == 0) {
				map[nr][nc] = map[r][c];
				map[r][c] = 0;
				
				r = nr;
				c = nc;
				
				nr += deltas[d][0];
				nc += deltas[d][1];
				
				if(!isIn(nr, nc)) break;
			}
			// 동일한 값 만나면
			else if(map[nr][nc] == map[r][c]) {
				if(!combined[nr][nc]) {
					map[nr][nc] = 2 * map[r][c];
					map[r][c] = 0;
					combined[nr][nc] = true;
				}
				break;
			}
			else {
				break;
			}
		}	
		
		return map;
	}
	
	static boolean isIn(int r, int c) {
		if(r >= 0 && c >= 0 && r < N && c < N) return true;
		return false;
	}
	
	static int findAnswer(int max, int[][] map) {
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		return max;
	}
}
