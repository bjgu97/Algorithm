import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4991_로봇청소기 {
	static class Point {
		int r;
		int c;
		int cnt; // 이동 횟수
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
		
		
	}
	
	static int W;
	static int H;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			if(W == 0)
				break;
			
			H = Integer.parseInt(st.nextToken());
		
			map = new char[H][W];
			for(int h = 0; h < H; h++) {
				String s = br.readLine();
				for(int w = 0; w < W; w++) {
					map[h][w] = s.charAt(w);
				}
			}
			
//			for(char[] a : map)
//				System.out.println(Arrays.toString(a));
			for(int h = 0; h < H; h++) {
				for(int w = 0; w < W; w++) {
					if(map[h][w] == 'o') {
						bfs(new Point(h, w, 0));
					}
				}
			}
			
		}
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static void bfs(Point p) {
		Queue<Point> queue = new LinkedList<>();
		queue.add(p);
		
		while(!queue.isEmpty()) {
			Point point = queue.poll();
			int r = point.r;
			int c = point.c;
			int cnt = point.cnt;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				
				if(map[nr][nc] == '*') { // 더러운 칸이면
					map[nr][nc] = '.';
					queue.add(new Point(nr, nc, cnt+1));
					
				}
				else if(map[nr][nc] == 'x')
					continue;
				else {
					queue.add(new Point(nr, nc, cnt+1));
				}
			}
			
			System.out.println(queue);
		}
	}
}
