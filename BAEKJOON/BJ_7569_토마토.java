/**
* @since 2021. 2. 19.
* @author bjgu9
* @see
* @mem 120296
* @time 604
* @caution 토마토1이랑 똑같
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569_토마토 {
	// 좌표 객체
	public static class Point {
		int h;
		int r;
		int c;
		
		Point(int h, int r, int c) {
			this.h = h;
			this.r = r;
			this.c = c;
		}

	}
	
	static int M;
	static int N;
	static int H;
	static int[][][] graph;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		graph = new int[H][N][M];
		
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m < M; m++) {
					graph[h][n][m] = Integer.parseInt(st.nextToken());
				}
			}
		}
		
//		for(int h = 0; h < H; h++) {
//			for(int n = 0; n < N; n++) {
//				for(int m = 0; m < M; m++) {
//					System.out.print(graph[h][n][m] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//		}
		
		bfs(graph);
		
		System.out.println(sb);
	}
	
	// 델타: 위아래, 오 왼 상 하
	static int[][] deltas = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
	static boolean check = true;
	static int max;
	
	public static void bfs(int[][][] graph) {
		Queue<Point> queue = new LinkedList<Point>();
		
		for(int h = 0; h < H; ++h) {
			for(int n = 0; n < N; ++n) {
				for(int m = 0; m < M; ++m) {
					if(graph[h][n][m] == 1) {
						queue.add(new Point(h, n, m));
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for(int d = 0; d < deltas.length; d++) {
				int nh = p.h + deltas[d][0];
				int nr = p.r + deltas[d][1];
				int nc = p.c + deltas[d][2];
				
				if(nh < 0 || nc < 0 || nr < 0 || nh >= H || nr >= N || nc >= M)
					continue;
				
				if(graph[nh][nr][nc] != 0)
					continue;
				
				graph[nh][nr][nc] = graph[p.h][p.r][p.c] + 1;
				queue.add(new Point(nh, nr, nc));
			}
		}
		
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				for(int m = 0; m < M; m++) {
					if(graph[h][n][m] == 0)
						check = false;
					max = Math.max(max, graph[h][n][m]);
				}
			}
		}
		
		if(check == false)
			sb.append(-1);
		else
			sb.append(max-1);
		
	}
}
