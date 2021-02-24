package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_13300_방배정 {
	public static void main(String[] args) throws IOException {
		// 1. 학년별로 나누고
		// 2. 성별별로 나누고
		// 3. 최소인원 초과하면 방 추가해주기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 학생 수
		int K = Integer.parseInt(st.nextToken()); // 최대 인원 수
		
		int[][] arr = new int[6][2]; // 반 X 성별 배열
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken()); // 성별
			int Y = Integer.parseInt(st.nextToken()); // 반
			arr[Y-1][S]++;
		}
		
//		for(int[] a : arr)
//			System.out.println(a[0] + "," + a[1]);
		int answ = 0;
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 2; j++) {
				if(arr[i][j] != 0) { // 방이 필요한 경우에 대해서
					if(arr[i][j] > K) { // 최대 인원을 넘어가면
						answ += Math.ceil((double)arr[i][j]/K);
					}
					else {
						answ++;
					}
				}
			}
		}
		
		System.out.println(answ);
	}
}
