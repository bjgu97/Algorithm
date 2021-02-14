package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_2891_카약과강풍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		boolean[] SArr = new boolean[N+2]; //
		for(int s = 0; s < S; s++) {
			SArr[Integer.parseInt(st.nextToken())] = true; //손상팀 true로
		} 
//		System.out.println(Arrays.toString(SArr));
		
		st = new StringTokenizer(br.readLine());
		boolean[] RArr = new boolean[N+2]; // 배열 넉넉히 잡아주고
		for(int r = 0; r < R; r++) {
			RArr[Integer.parseInt(st.nextToken())] = true; //여분팀 true로
		} 
//		System.out.println(Arrays.toString(RArr));
		
		int answ = 0;
		for(int n = 1; n <= N; n++) {
			if(SArr[n]) { // 없는 팀에 대해서. 
				if(RArr[n]) {
					RArr[n] = false;
					continue;
				}
				
				if(RArr[n-1]) { // 왼쪽에 카약 있으면
					RArr[n-1] = false; // 대여
					continue;
				}
				if(RArr[n+1]) { // 오른쪽에 카약 있으면
					RArr[n+1] = false; // 대여
					continue;
				}
				answ++; // 둘다 없으면 answ++
			}
		}
		
		System.out.println(answ);
	}
}
