/**
* @since 2021. 2. 19.
* @author bjgu9
* @see https://www.acmicpc.net/problem/2178
* @mem 12252KB
* @time 100ms
* @caution 최소 칸 수 구하기 -> BFS
*/
package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2178_미로탐색 {
	
	static int[][] maze;
	static boolean[][] visited;
	
	static int N;
	static int M;
		
	static int cnt = 1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 1. 입력받기
		maze = new int[N][M];
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < M; m++) {
				maze[n][m] = s.charAt(m) - '0';
			}
		}
		
		// 시작위치 : (0, 0) -> 끝 위치 : (N-1, M-1)
		visited = new boolean[N][M];
		
		bfs(0, 0); // 시작위치
		
		System.out.println(maze[N-1][M-1]);
	}
	
	//좌표 저장 위한 Point
	public static class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + "]";
		}
	}
	
	// BFS
	static int[][] deltas = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	static Queue<Point> queue = new LinkedList<>();

	public static void bfs(int x, int y) {
		
		// 첫번째 좌표 삽입
		Point p = new Point(x, y);
		p.x = x;
		p.y = y;
		queue.offer(p);
		
		// 현재 좌표 방문처리
		visited[x][y] = true;
		
		// 다음 좌표 이동?
		while(!queue.isEmpty()) {
			p = queue.poll();
			
			for(int i = 0;i < 4; i++) {
				int nx = p.x + deltas[i][0];
				int ny = p.y + deltas[i][1];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) { // 범위 벗어나면
					continue;
				}
				
				if(maze[nx][ny] == 1) { // 1이고 방문하지 않았다면			
//					p.x = nx;
//					p.y = ny;
					queue.offer(new Point(nx, ny)); // 다음 좌표 삽입
					//visited[nx][ny] = true; // 방문 처리
					maze[nx][ny] = maze[p.x][p.y] + 1; // 몇칸 이동했는지 표시
				}
			}
			for(int[] a : maze)
				System.out.println(Arrays.toString(a));
			System.out.println();

		}
	}
}
