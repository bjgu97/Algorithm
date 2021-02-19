/**
* @since 2021. 2. 19.
* @author bjgu9
* @see https://www.acmicpc.net/problem/1012
* @mem 13452KB
* @time 112ms
* @caution 서로 모여있는 배추 찾기, DFS
*/
package DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1012_유기농배추 {
	static int[][] graph;
	static int N;
	static int M;
	
	static boolean[][] visited;
	
	static int[][] deltas = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	static int answ;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		
		for(int t = 0; t < T; t++) {
			answ = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로 길이
			N = Integer.parseInt(st.nextToken()); // 세로 길이
			int K = Integer.parseInt(st.nextToken()); //배추 위치 개수
			
			graph = new int[M][N];
			visited = new boolean[M][N];
			
			// 그래프 만들기(배추 위치는 1로 표시)
			for(int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				
				graph[X][Y] = 1;
			}
			
//			for(int[] a : graph) {
//				System.out.println(Arrays.toString(a));
//			}
			for(int m = 0; m < M; m++) {
				for(int n = 0; n < N; n++) {
					if(graph[m][n] == 1 && visited[m][n] == false) { // 1이고 방문하지 않은 지점 발견하면
						answ++;
						dfs(m, n); // dfs ( 주변 방문처리)
					}
				}
			}
			
			System.out.println(answ);
		}
	}

	public static void dfs(int x, int y) {
		
		visited[x][y] = true; // 방문처리 해주고
		
		for(int i = 0; i < deltas.length; i++) { // 주변 탐색
			int nx = x + deltas[i][0];
			int ny = y + deltas[i][1];
			
			if(nx < 0 ||nx >= M || ny < 0 || ny >= N) // 범위 벗어나면
				continue;
			
			if(graph[nx][ny] == 1 && visited[nx][ny] == false) { // 주변에 1 있고 방문 안했으면
				dfs(nx, ny); 
//				System.out.println("nx, ny: " + nx + "," + ny);
//				for(boolean a[] : visited)
//					System.out.println(Arrays.toString(a));
			}
			
		}
	}

}
