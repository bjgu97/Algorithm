package 재귀;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
public class BJ_15651_N과M3 {
	
	public static int[] arr;
	public static boolean[] checked;
	public static int N, M;
	public static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		StringTokenizer st = new StringTokenizer(br.readLine());
 
		// 입력받는다.
		// N : 전체 수 목록
		// M : 몇 개 뽑을건지
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
 
		// arr : 결과 저장할 배열 
		arr = new int[M];
		
		//checked : 확인했는지 저장할 배열
		checked = new boolean[N+1];
		dfs(0);
		
		System.out.println(sb);
	}
 
	public static void dfs(int depth) {
		//다 뽑았으면
		if (depth == M) { //2 
			//순열 생성 완료!
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(' ');
			}
			sb.append('\n');
			return;
		}
		else {
			for (int i = depth+1; i <= N; i++) { //0+1 ~ 4
				if(checked[i] == true) continue;
				arr[depth] = i;
				checked[i] = true;
				dfs(depth + 1);
				checked[i] = false;
			}
		}
	}
 
}