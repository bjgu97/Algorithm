package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_3234_준환이의양팔저울 {
	static int N;
	static int[] NArr;
	static int[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			// 부분집합..?
			N = Integer.parseInt(br.readLine()); // 추의 개수
			NArr = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				NArr[n] = Integer.parseInt(st.nextToken());
			}
			
			for(int n = 1; n <= N; n++) {
				answer = new int[n];
				left = new int[N-n-1];
				comb(0, 0, n);
			}
		}
	}
	
	
	static int[] left;
	public static void comb(int cnt, int start, int n) {
		if(cnt == n) {
			System.out.println(Arrays.toString(answer));
			//compare(answer);
			return;
		}
		
		for(int i= start; i <N; i++) {
			answer[cnt] = i;
			lef
			comb(cnt+1, i+1, n);
		}
	}
	
	public static void compare(int[] left) {
		// NArr 중 answer에 없는 요소는 right 배열에 추가
		for(int i= 0; i < NArr.length; i++) {
			
		}
		int sum1 = 0;
		int sum2 = 0;
		
		for(int i = 0; i < answer.length; i++) {
			sum1 += answer[i];
		}
		
		for(int i= 0; i < left.length; i++) {
			sum2 += left[i];
		}
	}
}
