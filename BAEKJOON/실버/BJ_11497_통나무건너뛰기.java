package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11497_통나무건너뛰기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] NArr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				NArr[n] = Integer.parseInt(st.nextToken());
			}
			// 1. 인접한 통나무 높이 차 최소가 되도록
			Arrays.sort(NArr); // 2 4 5 7 9
			int[] MArr = new int[N];
			
			int j =0;
			int k = 0;
			
			boolean state = true;
			
			for(int i = 0; i < N; i++) {
				if(state) { // 앞에서부터 삽입
					MArr[j] = NArr[i];
					state = false;
					j++;
				}
				else { // 뒤에서부터 삽입
					MArr[N-1-k] = NArr[i];
					state = true;
					k++;
				}
				
			}
			
			// 2. 최소 난이도
			int minLevel = 0;
			for(int i= 1; i < N; i++) {
				minLevel = Math.max(minLevel, Math.abs(MArr[i] - MArr[i-1]));
			}
			
			// 배열 시작값과 끝값 차이와도 한번 더 비교
			minLevel = Math.max(minLevel, Math.abs(MArr[N-1] - MArr[0]));
			System.out.println(minLevel);
		}
		
	}
}
