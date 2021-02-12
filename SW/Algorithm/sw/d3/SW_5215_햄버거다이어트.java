/**
* @since 2021. 2. 8.
* @author bjgu9
* @see https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
* @mem
* @time
* @caution
* 
* 재료에 대한 점수와 칼로리가 주어졌을 때
* 정해진 칼로리 이하의 조합 중 선호하는 햄버거 만들기
* 맛 점수 높은 햄버거 점수 출력
* 
* 방법1: 클래스 만들어서 풀기? (x: 점수, y: 칼로리) 
* 방법2: 완탐(부분집합)
*/


package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_5215_햄버거다이어트 {
	// 사용자정d의 class 만들기. 
	static class Material{
		int sat;
		int cal;
		public Material(int sat, int cal) {
			super();
			this.sat = sat;
			this.cal = cal;
		}
		@Override
		public String toString() {
			return "Material [sat=" + sat + ", cal=" + cal + "]";
		}
		
	}
	
	// 어떤 것들이 뽑혔는지가 아니라 여기까지 뽑혔을 때 만족도와 칼로리가 관심사. 
	static void subSetByPermutation(int toChoose, int[] choosed, int cal, int sat) {
		if(toChoose == 0) {
			// 다 뽑았다. 결과 출력하자. 
			MAX_SAT = Math.max(MAX_SAT, sat);
			return;
		}
		
	}
	static int N;
	static int L;
	static int calSum;
	
	static int[] scoreArr;
	static int[] calArr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 정해진 칼로리 1000
			
			scoreArr = new int[N];
			calArr = new int[N];
			visited = new boolean[N];
			
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				//점수와 칼로리
				int score = Integer.parseInt(st.nextToken());
				int cal = Integer.parseInt(st.nextToken());
				
				scoreArr[n] = score;
				calArr[n] = cal;
				
			}
			/*
			 *  100 200
				300 500
				250 300
				500 1000
				400 400
			 */
			powerSet(N, 0);
//			for(int i = 0; i < N; i++) {
//				for(int j = 0; j < 2; j++) {
//					System.out.print(arr[i][j]);
//				}
//				System.out.println();
//			}
		}
	}
	
	public static void powerSet(int n, int cnt) {

		if(cnt == n) {
			calSum = 0;
			for(int i = 0; i < N; i++) {
				if(visited[i]) {
					System.out.print(calArr[i] + " ");
					calSum += calArr[i];
					
				}
			}
			System.out.println("sum: " + calSum);
			System.out.println();
			return;
		}
		visited[cnt] = true;
		powerSet(n, cnt+1);
		visited[cnt] = false;
		powerSet(n, cnt+1);
		
	}
}
