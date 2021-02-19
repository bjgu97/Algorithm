/**
* @since 2021. 2. 19.
* @author bjgu9
* @see
* @mem 120296KB
* @time 604ms
* @caution 토마토가 익는 최소 일수 -> BFS
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7576_토마토 {
	static int M;
	static int N;
	static int[][] graph;
	
	// 좌표 객체
	public static class Point {
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
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		graph = new int[N][M];
		
		// 그래프 입력받기
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				graph[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(graph);
		
		System.out.println(sb);
	}
	
	static int[][] deltas = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
	static int answ;
	static boolean check = true;
	static int max;
	public static void bfs(int[][] graph) {
		Queue<Point> queue = new LinkedList<Point>();
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(graph[n][m] == 1) { // 토마토 발견하면
					queue.add(new Point(n, m)); // 큐에 추가
				}
			}
		}
		
//		System.out.println(queue); //(3, 5)
		
		while(!queue.isEmpty()) { //반복반복
			Point p = queue.poll(); //(3,5)
			
			for(int d = 0; d < deltas.length; d++) { // 토마토 주변 탐색
				int nr = p.r + deltas[d][0];
				int nc = p.c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M) // 범위 벗어나면 건너뛰기
					continue;
				
//				if(graph[nr][nc] == -1 || graph[nr][nc] == 1) // 주변에 안익은 토마토 없으면 건너뛰기
//					continue;
				if(graph[nr][nc] !=0) // 주변에 안익은 토마토 없으면 건너뛰기
					continue;
				
				graph[nr][nc] = graph[p.r][p.c]+1; // 안익은 토마토 있으면 익히고 (몇일쨰에 익었는지 추가)
				queue.add(new Point(nr, nc)); //큐에 추가
				
			}
//
			for(int[] a : graph)
				System.out.println(Arrays.toString(a));
			System.out.println();		

		}
		
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(graph[n][m] == 0)
					check = false; // 다 안익은 토마토 존재하면 -1 출력
				max = Math.max(max, graph[n][m]); // 익은 토마토 존재하면 몇일째에 토마토가 다 익는지!(일수 최댓값)
			}
		}
		
		if(check == false)
			sb.append(-1);
		else
			sb.append(max-1); // 첫 토마토 = 1일로 계산 했으므로, -1

	}
}
