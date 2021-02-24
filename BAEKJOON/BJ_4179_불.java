import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_4179_불 {
	static int R;
	static int C;
	static char[][] graph;
	static Queue<Point> queue;
	static int[][] visited;
	
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
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 행의 개수
		C = Integer.parseInt(st.nextToken()); //열의 개수
		
		queue = new LinkedList<Point>();
		graph = new char[R][C];
		visited = new int[R][C];
		
		// 큐에 불 추가
		for(int r= 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				graph[r][c] = s.charAt(c);
				if(graph[r][c] == 'F') {
					queue.add(new Point(r, c));
				}
			}
			
		}
		// 큐에 지훈 좌표 추가
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(graph[r][c] == 'J') {
					queue.add(new Point(r, c));
					visited[r][c] = 1;

				}
			}
		}
		
		/*
		 *#: 벽
	    .: 지나갈 수 있는 공간
		J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
		F: 불이 난 공간
		 */
		int answ = bfs();
		if(answ == -1)
			System.out.println("IMPOSSIBLE");
		else {
			System.out.println(answ);
		}
	}
	
	static int[][] deltas = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	
	static int bfs() {		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			for(int d= 0; d < deltas.length; d++) {
				// 지훈이 좌표 발견하면
				if(graph[p.r][p.c]== 'J') {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C) {
						return visited[p.r][p.c];
					}
					
					if(graph[nr][nc] == '.' && visited[nr][nc] == 0) {
						visited[nr][nc] = visited[p.r][p.c] + 1;
						queue.offer(new Point(nr, nc));
						graph[nr][nc] = 'J';
					}
				}
				
				// 다음은 불 좌표
				if(graph[p.r][p.c] == 'F') {
					int nr = p.r + deltas[d][0];
					int nc = p.c + deltas[d][1];
					
					if(nr < 0 || nc < 0 || nr >= R || nc >= C)
						continue;
					
					if(graph[nr][nc] == '.') {
						queue.offer(new Point(nr, nc));
						graph[nr][nc] = 'F';
					}
					
				}
//				for(char[] a : graph)
//					System.out.println(Arrays.toString(a));
//				System.out.println();
//				for(int[] a : visited)
//					System.out.println(Arrays.toString(a));
//				System.out.println();
			}
		}
		return -1;
	}
}
