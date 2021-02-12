/**
* @since 2021. 2. 8. 숙제
* @author bjgu9
* @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=9229&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
* @mem
* @time
* @caution 
*/
package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_9229_한빈이와SpotMart_재귀 {
	static int[] NArr;
	static int N;
	static int M;
	static int[] answer;
	static int sum;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			max = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			NArr = new int[N];
			answer = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				NArr[n] = Integer.parseInt(st.nextToken());
			}
			
			combination(0,0);
			sb.append("#").append(t+1).append(" ").append(max).append("\n");

		}
		System.out.println(sb);
	}
	
	public static void combination(int cnt, int start) {
		if(cnt == 2) {
			for(int i = 0; i < 2; i++) {
				sum += answer[i];
			}
			
			if(sum <= M ) {
				max = Math.max(sum, max);
			}
			return;
		}
		for(int i = start; i < N; i++) {
			answer[cnt] = NArr[i]; // NArr[i] : 20 20 20  (0 , 0)
			combination(cnt+1, i+1);
		}
	}
}
