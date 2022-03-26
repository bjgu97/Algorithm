import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_14503_로봇청소기_1 {
	static int N;
	static int M;
	static int[][] map;
	static int answer = 1;
	static boolean[][] visited;
	static int r, c, d;
	
	static class Robot {
		int r;
		int c;
		int d;
		int cnt;
		
		Robot(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Robot [r=" + r + ", c=" + c + ", d=" + d + ", cnt=" + cnt + "]";
		}
		
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		Robot initRobot = new Robot(r, c, d, 0);
		
		visited = new boolean[N][M];
		map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		Queue<Robot> queue = new LinkedList<>();
		queue.add(initRobot);
		
		
		func(queue);

		System.out.println(answer);
	}
	
	static int[][] deltas = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	static void func(Queue<Robot> queue) {
		int idx = 0;
		while(true) {
			// 현재 위치
			Robot robot = queue.poll();
			int r = robot.r;
			int c = robot.c;
			int d = robot.d;
			int cnt = robot.cnt;
			visited[r][c] = true;
			
			// 왼쪽으로 이동된 위치
			int nr = r + deltas[(d+3)%4][0];
			int nc = c + deltas[(d+3)%4][1];
			int nd = (d+3)%4;
			
			// 왼쪽으로 이동 가능하면
			if(isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 1) {
				answer++;
				idx = 0;
				queue.add(new Robot(nr, nc, nd, cnt+1));
			}
			// 왼쪽으로 이동 불가능하면 회전
			else {
				idx++;
				// 후진 시도
				if(idx >= 5) {
					// 후진 가능하면
					nd = (d+2) % 4;
					nr = r + deltas[nd][0];
					nc = c + deltas[nd][1];
					
					if(isIn(nr, nc) && map[nr][nc] == 1) {
						break;
						
					}
					else  if(isIn(nr, nc) && map[nr][nc] != 1){
						queue.add(new Robot(nr, nc, d, cnt+1));
						idx = 0;
						if(!visited[nr][nc])
							answer++;
						continue;					}
				}
				queue.add(new Robot(r, c, nd, cnt));
				
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
