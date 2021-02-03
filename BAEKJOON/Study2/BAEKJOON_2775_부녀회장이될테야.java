package Study2;

/**
* @since 2021. 1. 26.
* @author bjgu9
* @see
* @mem 11464
* @time 72ms
* @caution
*/

// 1 ≤ k, n ≤ 14 => 시간복잡도 신경 노 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_2775_부녀회장이될테야 {
	static int sum = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 일단 시간복잡도 고려 노
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		// 배열로.
		StringBuilder sb = new StringBuilder();
		int[][] Arr = new int[15][15];
		
		for(int i = 0; i < T; i++) {
			//k 입력: 층
			int k = Integer.parseInt(br.readLine());
			//n 입력: 호
			int n = Integer.parseInt(br.readLine());
								
			//0층 초기화 ( 0층의 i호에는 i명)
			for(int p = 1; p < 15; p++) {
				Arr[p][0] =p;
			}
			
			//1호 초기화
			for(int q= 1; q < 15; q++) {
				Arr[1][q] = 1;
			}
			
			//하나씩 채워나가기 : 왼쪽집 + 아래층 집 값으로 채워가기
			for(int p = 2; p < 15; p++) {
				for(int q = 1; q < 15; q++) {
					Arr[p][q] = Arr[p-1][q] + Arr[p][q-1];
				}
			}
			
			sb.append(Arr[n][k]).append("\n");
			
		}
		System.out.println(sb);
		
	}
}