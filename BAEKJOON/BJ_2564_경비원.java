

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2564_경비원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken()); // 가로 길이
		int H = Integer.parseInt(st.nextToken()); // 세로 길이
		
		int N = Integer.parseInt(br.readLine()); // 상점의 개수
		
		int[][] NArr = new int[N][2];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			NArr[n][0] = Integer.parseInt(st.nextToken());
			NArr[n][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] Dong = new int[1][2];
		st = new StringTokenizer(br.readLine());
		Dong[0][0] = Integer.parseInt(st.nextToken());
		Dong[0][1] = Integer.parseInt(st.nextToken());
		
		for(int[] a : NArr)
			System.out.println(Arrays.toString(a));
		
		// 동근과 위치가 같다면 그냥 좌표 빼기
		
		// 동근과 위치가 다르다면 
			// 동근이 
	}
}
