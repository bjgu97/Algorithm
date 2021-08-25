

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1920_수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		int[] MArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			MArr[m] = Integer.parseInt(st.nextToken());
		}
		
		// 이진탐색 시작
		
		// 우선 정렬
		Arrays.sort(NArr);
		
		// 탐색 (NArr에서 MArr 찾기)
		for(int m = 0; m < M; m++) {
			int down = 0;
			int top = N-1;
			int mid = (down + top) / 2;
			
			int toFind = MArr[m];
			boolean flag = false;
			while(down <= top) {
				mid = (down + top) / 2;
				
				// 찾고자 하는 값이 중앙값이면 [1, 2, 3, 4, 5]
				if(NArr[mid] == toFind) {
					flag = true;
					System.out.println(1);
					break;
				}
				
				// 찾고자 하는 값이 중앙값보다 크면
				else if(toFind > NArr[mid]) {
					down = mid + 1;
				}
				
				// 찾고자 하는 값이 중앙값보다 작으면
				else if(toFind < NArr[mid]) {
					top = mid -1;
				}
			}
			if(!flag)
				System.out.println(0);
		}
	}
}
