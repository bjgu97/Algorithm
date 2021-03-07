package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10815_숫자카드 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//상근이 숫자
		int N = Integer.parseInt(br.readLine());
		int[] NArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int m= 0; m < N; m++) {
			NArr[m] = Integer.parseInt(st.nextToken());
		}
		// 찾고자 하는 숫자
		int M = Integer.parseInt(br.readLine());
		int[] MArr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int m= 0; m < M; m++) {
			MArr[m] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(NArr);
		
		for(int m = 0; m<M; m++) {
			int num = MArr[m];
			int down = 0;
			int top = N-1;
			int mid;
			
			boolean check = false;
			while(top >= down) {
				mid = (top + down) / 2;
				if(num == NArr[mid]) {
					check = true;
					sb.append(1).append(" ");
					break;
				}
				else if(num < NArr[mid]) {
					top = mid-1;
				}
				else if(num > NArr[mid]) {
					down = mid + 1;
				}
			}
			
			if(!check)
				sb.append(0).append(" ");
			
		}
		System.out.println(sb);
		
		
	}
}
