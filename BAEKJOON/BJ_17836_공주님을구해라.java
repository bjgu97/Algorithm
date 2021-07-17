import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ_17836_공주님을구해라 {
	static int N;
	static int M;
	static int T;
	static int[][] map;
	static boolean flag;
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static int answer;
	
	static class Point {
		int r;
		int c;
		int t; // 시간
		int s; // 검(0: 무, 1: 유)
		
		Point(int r, int c, int t, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.t = t;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", t=" + t + ", s=" + s + "]";
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken()); 
		 M = Integer.parseInt(st.nextToken());
		 T = Integer.parseInt(st.nextToken());
		
		 map = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		
		// 답 출력
		if(flag) { // 시간내에 도착하면
			System.out.println(answer);
		} else { // 시간내에 도착하지 못하면
			System.out.println("Fail");
		}
	}
	
	
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[N][M][2]; // 검 있을때, 없을 때

		queue.add(new Point(0, 0, 0, 0));
		visited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int t = p.t;
			int s = p.s;
			
			if((r == N-1 && c == M-1) && t <= T) { // 시간 내에 도착 하면
				flag = true;
				answer = t;
				break;
			}
			
			for(int d =0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) // 범위 벗어나면
					continue;
				
				if(visited[nr][nc][s] == true) // 방문 했으면
					continue;
				
				if(s == 0) { // 검이 없는데
					if(map[nr][nc] == 2) { // 검 발견한다면
						visited[nr][nc][1] = true;
						queue.add(new Point(nr, nc, t+1, 1));
					}
					else if(map[nr][nc] == 0) { // 검 발견 못하면
						visited[nr][nc][0] = true;
						queue.add(new Point(nr, nc, t+1, 0)); // 그냥 이동
					}
				}
				else if(s == 1) { // 검이 있다면
					if(map[nr][nc] == 1 || map[nr][nc] == 0) { // 벽부수고 다 이동
						visited[nr][nc][1] = true;
						queue.add(new Point(nr, nc, t+1, 1));
					}
				}
			}
		}
	}
}
