/**
* @since 2021. 2. 8. 숙제
* @author bjgu9
* @see https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AW8Wj7cqbY0DFAXN&categoryId=AW8Wj7cqbY0DFAXN&categoryType=CODE&problemTitle=9229&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
* @mem
* @time
* @caution 
*/

//들고다닐 수 있는 최대 무게 합
// 과자봉지 총 N개, 각 과자봉지는 a그램
// 최대 M 그램 
package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_9229_한빈이와SpotMart_for {
	static int[] NArr;
	static int N;
	static int M;
	static int[] answer;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			NArr = new int[N];
			answer = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				NArr[n] = Integer.parseInt(st.nextToken());
			}
			
			// NArr : [20, 20, 20]
			// M:45
			
			// 조합!
			// combination(0, 1);
			int max = Integer.MIN_VALUE;
			for(int i = 0; i < N; i++) {
				for(int j = i+1; j < N; j++) {
					if(NArr[i] + NArr[j] <= M) {
						max = Math.max(max, NArr[i] + NArr[j]);
					}
				}
			}
			if(max < 0)
				max = -1;
			
			sb.append("#").append(t+1).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}
}
