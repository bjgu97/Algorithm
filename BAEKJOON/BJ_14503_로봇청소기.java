import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기 {
	static int N;
	static int M;
	static int[][] map;
	static int answer = 1;
	static boolean[][] visited;
	static int r, c, d;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 세로 크기  N
		M = Integer.parseInt(st.nextToken()); // 가로 크기 M
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()); // x 좌표
		c = Integer.parseInt(st.nextToken()); // y 좌표
		d = Integer.parseInt(st.nextToken()); // 방향 d
		
		// 입력받기
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		clean();

		System.out.println(answer);
	}
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	static void clean() {
		visited[r][c] = true;
		int dCnt = 0;
		
		while(true) {
			int nr = r + deltas[(d+3)%4][0];
			int nc = c + deltas[(d+3)%4][1];

			// 왼쪽 청소하지 않는 공간 존재
			if(!isIn(nr, nc)) continue;
			
			if(map[nr][nc] == 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				answer++;
				r = nr;
				c = nc;
			}
			else {
				d = (d+3) % 4;
				dCnt++;
				
				if(dCnt > 4) {
					if(d == 0 || d == 2) {
						nr = r + deltas[d][0];
						nc = c + deltas[d][1];
					}
					else {
						if(d == 1) {
							nr = r + deltas[3][0];
							nc = c + deltas[3][1];
						}
						else if (d == 3) {
							nr = r + deltas[1][0];
							nc = c + deltas[1][1];
						}
					}
					
					if(isIn(nr, nc)) {
						r = nr;
						c = nc;
					}
					else {
						break;
					}
							}
			}
			

		}
	}
	
	static boolean isIn(int r, int c) {
		if(r >= 0 && c >= 0 && r < N && c < M)
			return true;
		else
			return false;
	}
}
