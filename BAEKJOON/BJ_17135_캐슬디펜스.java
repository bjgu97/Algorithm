import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_17135_캐슬디펜스 {
	static int N;
	static int M;
	static int D;
	static int[][] graph;
	static int[] answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 행 수
		M = Integer.parseInt(st.nextToken()); // 열 수
		D = Integer.parseInt(st.nextToken()); // 공격 거리 제한 		
		
		graph = new int[N+1][M];
		
		// 그래프 입력받기
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				graph[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 성 있는 행 추가하기 (2)
		for(int m = 0; m < M; m++) {
			graph[N][m] = 2; 
		}
		
//		for(int[] a : graph) 
//			System.out.println(Arrays.toString(a));
		
		// 궁수 위치 조합
		answer = new int[3];
		comb(0, 0);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == 3) {
//			System.out.println(Arrays.toString(answer));
			find(answer);
			return;
		}
		
		for(int i = start; i < M; i++) {
			answer[cnt] = i;
			comb(cnt+1, i+1);
		}
	}
	
	static List<int[]> list = new ArrayList<int[]>();
	static void find(int[] answer) {
		// 적 위치 찾기
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(graph[n][m] == 1) {
					int[] a = new int[2];
					a[0] = n;
					a[1] = m;
					list.add(a);
				}
					
			}
		}
		HashSet<int[]> set = new HashSet<int[]>(list);
		ArrayList<int[]> newList = new ArrayList<int[]>(set);
		
		for(int[] a : newList)
			System.out.println(Arrays.toString(a));
	}
}
