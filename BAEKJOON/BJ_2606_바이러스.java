/**
* @since 2021. 2. 19.
* @author bjgu9
* @see https://www.acmicpc.net/problem/2606
* @mem 11660KB
* @time 76ms
* @caution 연결되어있는거 찾기 (최단거리 아닌거는 dfs로)
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_2606_바이러스 {
	static boolean[] visited;
	static int answ;
	
	static int N;
	//static int[][] arr;
	static ArrayList<Integer>[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		int M = Integer.parseInt(br.readLine()); // 컴퓨터 쌍의 수
		arr = new ArrayList[N+1];
		
		//arr = new int[N+1][N+1];
		for(int i = 1; i < N+1; i++) {
			arr[i] = new ArrayList<>();
		}
		
		// 그래프 0으로 초기화
//		for(int m = 1; m <= N; m++) {
//			for(int n = 1; n <= N; n++) {
//				arr[m][n] = 0;
//			}
//		}
		
		// 서로 연결되어있는거 1로
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
//			arr[a][b] = 1;
//			arr[b][a] = 1;
			arr[a].add(b);
			arr[b].add(a);
		}
//		
//		for(int m = 1; m <= M; m++) {
//			for(int n = 1; n <= M; n++) {
//				System.out.print(arr[m][n] + " ");
//			}
//			System.out.println();
//		}
		
		visited = new boolean[N+1];
		dfs(1); //1번부터 시작
		
		System.out.println(answ);
	}
	
	public static void dfs(int start) {
		visited[start] = true; //방문처리
		
//		for(int i= 2; i <= N; i++) {
//			if(arr[start][i] == 1 && visited[i] == false) { // 연결되어있고 방문하지 않았다면
//				answ++; // 연결 컴퓨터 수 + 1
//				dfs(i);
//			}
//			
//			
//			System.out.println(arr);
//		}
		
		for(int i : arr[start]) {
			if(!visited[i]) {
				answ++;
				dfs(i);
			}
		}
	}
}
