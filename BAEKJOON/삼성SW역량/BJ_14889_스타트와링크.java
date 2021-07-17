package 삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14889_스타트와링크 {
	static int N;
	static int[][] map;
	static int[] numbers;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		numbers = new int[N/2];
		map = new int[N][N];
		visited = new boolean[N];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		
		System.out.println(min);
	}
	static int min = Integer.MAX_VALUE;
	
	static void comb(int cnt, int start) {
		if(cnt == N/2) { // N/2명 뽑았으면
//			System.out.println(Arrays.toString(numbers)); // 스타트팀
			int[] numbers2 = new int[N/2];
			int idx = 0;
			
			for(int i= 0; i < visited.length; i++) {
				if(!visited[i]) {
					numbers2[idx++] = i;
				}
			}
			
//			System.out.println(Arrays.toString(numbers2));
			
			// 스타트팀 능력치
			int sum1 = 0;
			for(int i= 0; i < numbers.length; i++) {
				for(int j = i; j < numbers.length; j++) {
					sum1 += map[numbers[i]][numbers[j]];
					sum1 += map[numbers[j]][numbers[i]];
				}
			}
			
			int sum2 = 0;
			for(int i= 0; i < numbers2.length; i++) {
				for(int j = i; j < numbers2.length; j++) {
					sum2 += map[numbers2[i]][numbers2[j]];
					sum2 += map[numbers2[j]][numbers2[i]];
				}
			}
			
//			System.out.println("sum1: " + sum1);
//			System.out.println("sum2: " + sum2);
			min = Math.min(min, Math.abs(sum1 - sum2));
			return;
		}
		
		for(int i = start; i < N; i++) {
			numbers[cnt] = i;
			visited[i] = true;
			comb(cnt+1, i+1);
			visited[i] = false;
		}
	}
}
