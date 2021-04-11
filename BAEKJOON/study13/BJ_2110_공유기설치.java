package study13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2110_공유기설치 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 집의 개수
		int C = Integer.parseInt(st.nextToken()); // 공유기 개수
		
		int[] arr = new int[N];
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr);
		
		int left = 1; // 최소 거리
		int right = arr[N-1] - arr[0]; // 최대 거리
		int num = 1; // 공유기 개수
		
//		특정 간격을 기준으로 가능한 위치에 공유기를 설치한다.
//		설치한 후에는 다음과 판단한다.
//		공유기 수가 더 설치되어야 한다면, 간격을 줄인다.
//		공유기 수를 줄여야한다면, 간격을 늘린다.

		while(left <= right) {  // 최대 간격 구하기
			int mid = (left + right) / 2;
			
			for(int i =0; i < N; i++) {
				if(arr[i] - arr[0] >= mid) {
					
				}
			}
			if(num > C) { // 공유기 개수 초과
				// 간격 넓히기
				left = mid + 1;
			}
			else { 
				left = mid - 1;
			}
		}
		// 1 2 4 8 9
	}
}
