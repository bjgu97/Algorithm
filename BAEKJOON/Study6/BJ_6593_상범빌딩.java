package Study6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593_상범빌딩 {
	static Queue<Point> queue;
	static int L;
	static int R;
	static int C;
	static char[][][] graph;
	static boolean[][][] visited;
	static int cnt;
	static boolean check;
	static StringBuilder sb = new StringBuilder();
	
	static  class Point {
		int l;
		int r;
		int c;
		int cnt;
		
		Point(int l, int r, int c, int cnt) {
			this.l = l;
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [l=" + l + ", r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			if(L == 0 && R == 0 && C == 0)
				break;
			
			graph = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			queue = new LinkedList<Point>();
			
			for(int l = 0; l < L; l++ ) {
				for(int r = 0; r < R; r++) {
					String s = br.readLine();
					for(int c = 0; c < C; c++) {
						graph[l][r][c] = s.charAt(c);
						if(graph[l][r][c] == 'S') { // 시작 위치이면
							queue.add(new Point(l, r, c, 0));
							visited[l][r][c] = true;
						}
					}
				}
				String s = br.readLine();
			}
			
			// 입력 확인
//			for(int l = 0; l < L; l++ ) {
//				for(int r = 0; r < R; r++) {
//					for(int c = 0; c < C; c++) {
//						System.out.print(graph[l][r][c]);
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
			
			check = false;
			bfs();
			
			if(!check)
				System.out.println("Trapped!");

		}
	}
	
	static int[][] deltas = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {-1, 0, 0}, {0, -1, 0},  {0, 0, -1}};
	
	static void bfs() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int l = p.l;
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			
			for(int d = 0; d < deltas.length; d++) {
				int nl = l + deltas[d][0];
				int nr = r + deltas[d][1];
				int nc = c + deltas[d][2];
				
				if(nl < 0 || nr < 0 || nc < 0 || nl >= L || nr >= R || nc >= C) {
					continue;
				}
				
				//갈수있는 지점이고, 방문하지 않았다면
				if(graph[nl][nr][nc] == '.' && visited[nl][nr][nc] == false) { 
					visited[nl][nr][nc] = true;
					queue.add(new Point(nl, nr, nc, cnt+1));
				}
				
				// 출구 도착 하면
				if(graph[nl][nr][nc] == 'E') {
					System.out.println("Escaped in " + (cnt+1) + " minute(s).");
					check = true;
					queue.clear();
					break;
				}
			}
		}
	}
}
