import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2468_안전영역 {
	static int N;
	static int[][] graph;
	static boolean[][] visited;
	static int answ;
	static int maxAnsw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		//입력
		for(int n = 0;n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				graph[n][m] = Integer.parseInt(st.nextToken()); //그래프를 채워주면서
				max = Math.max(max, graph[n][m]); // 영역 높이의 최댓값,
				min = Math.min(min, graph[n][m]); // 영역 높이의 최솟값 저장. 
			}
		}
		
//		for(int[] a : graph)
//			System.out.println(Arrays.toString(a));
		
		for(int n = 0; n <= max; n++) { // n = min부터 -> 예외: 그래프 다 1일때. 
//			System.out.println("n: " + n);
			depth(n);
		}
		
		System.out.println(maxAnsw);
	}
	
	
	// 새 그래프 만들어주기: n에 따라 잠기지 않은 곳 1, 잠기는 곳 0
	static int[][] graph2;
	public static void depth(int depth) {
		answ = 0;
		graph2 = new int[N][N];
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N; m++) {
				if(graph[n][m] > depth) {
					graph2[n][m] = 1; // 잠기지 않은 곳 1로.
				}
			}
		}
		
//		for(int[] a : graph2)
//			System.out.println(Arrays.toString(a));
//		System.out.println();
		
		visited = new boolean[N][N];
		for(int n = 0; n < N; n++) {
			for(int m = 0;m < N; m++) {
				if(graph2[n][m] == 1 && visited[n][m] == false) { // 잠기지 않은 곳 발견하면, (배추문제)
					answ++;
					dfs(n, m);
				}
				
			}
		}
//		System.out.println("answ: " + answ);
		maxAnsw = Math.max(maxAnsw, answ);
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d = 0; d < deltas.length; d++) {
			int nx = x + deltas[d][0];
			int ny = y + deltas[d][1];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N)
				continue;
			
			if(graph2[x][y] ==1 && visited[nx][ny] == false)
				dfs(nx, ny);
		}
	}
}
