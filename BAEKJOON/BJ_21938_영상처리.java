import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_21938_영상처리 {
	static int N;
	static int M;
	static int[][] newMap;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		// 세로길이 N
		// 가로길이 M
		// (i,j) : R, G, B
		// 세 색상 평균내어 T보다 크거나 같으면 255, 작으면 0
		// 255 상하좌우 인접해있으면 같은 물체로.
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		int[][] map = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			for(int m = 0; m < M; m++) {
				int r = Integer.parseInt(st.nextToken());
				int g = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[n][m] = (r + g + b) / 3;

			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		newMap = new int[N][M];
		visited = new boolean[N][M];
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] >= T) {
					newMap[n][m] = 255;
				}
				else
					newMap[n][m] = 0;
			}
		}
		

		int answer = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(newMap[n][m] == 255 && !visited[n][m]) {
					bfs(n, m);
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs(int n, int m) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(n, m));
		visited[n][m] = true;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) {
					continue;
				}
				if(visited[nr][nc])
					continue;
				if(newMap[nr][nc] == 0)
					continue;
				
				visited[nr][nc] = true;
				queue.add(new Point(nr, nc));
				
			}
			
//			System.out.println(queue);
		}
	}
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
		
		
	}
}
