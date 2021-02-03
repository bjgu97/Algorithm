package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_1978_소수찾기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
m		int cnt = 0;
		
		while(N-- >0) {
			boolean check = true;
			int a = Integer.parseInt(st.nextToken());
			
			if(a == 0 || a == 1)
				check = false;
			
			if(a == 2 || a == 3)
				check = true;
			
			
			for(int i = 2; i <= Math.sqrt(a); i++) {
				if(a % i == 0) {
					check = false;
					break;
				}
			}
		
			
			System.out.println(check);
			if(check)
				cnt++;
		}
		
		System.out.println(cnt);
		//		int[] arr = new int[N];
//		for(int i = 0; i < N; i++) {
//			int a = Integer.parseInt(st.nextToken());
//			arr[i] = a;
//		}
//		
//		
//		int cnt = 0;
//		for(int i = 0; i < N; i++) {
//			boolean is = true;
//			
//			//각 수 arr[i]에 대해 소수인지 판별
//			for(int j = 2; j < Math.sqrt(arr[i]); j++) {
//				if(arr[i] % j == 0) //나누어 떨어지는게 있으면
//					is = false; // 소수 아님!
//			}
//			System.out.println(is);
//			if(is)
//				cnt++;
//		}
//		System.out.println(cnt);
	}
}
