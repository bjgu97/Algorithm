package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_6485_삼성시의버스노선 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine()); 
		
		for(int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine()); // N: 버스 노선 수
			
			int[][] NArr = new int[N][2]; // N개의 버스 저장, 각 버스는 노선 번호가 A ~ B
			for(int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				NArr[n][0] = Integer.parseInt(st.nextToken()) - 1; // A1
				NArr[n][1] = Integer.parseInt(st.nextToken()) - 1; // B1
			}
			
			int P = Integer.parseInt(br.readLine());  // P: 버스 정류장 개수
			int[] PArr = new int[P];
			
			for(int p = 0; p < P; p++) {
				PArr[p] = Integer.parseInt(br.readLine()); // PArr : 버스 정류장 저장
			}
			
			// 입력받기 끝.

			
			int[] newPArr = new int[P];
			for(int p = 0; p < P; p++) {
				newPArr[p] = 0; //0으로 초기화
			}
			
			for(int n = 0; n < N; n++) {
				for(int i = NArr[n][0]; i <= NArr[n][1]; i++) {
					newPArr[i]++;
				}
			}
			
			sb.append("#").append(tc+1).append(" ");
			
			for(int i : newPArr) {
				sb.append(i).append(" ");
			}
			System.out.println(sb);			
		}
	}
}
