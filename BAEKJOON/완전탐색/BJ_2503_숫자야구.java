package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2503_숫자야구 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 민혁이가 ㅕㅇ수에게 몇 번 질문했는지
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken()); // 민혁이가 질문한 세 가지 수
			int a = Integer.parseInt(st.nextToken()); // 영수가 답한 스타라이크 수 -> 동일 위치
			int b = Integer.parseInt(st.nextToken()); // 영수가 답한 볼 수 -> 다른 위치
			
			int[] arr = new int[999];
			
			for(int i = 1; i <= 999; i++) {
				arr[i-1] = i;
			}
			
			System.out.println(Arrays.toString(arr));
			
		}
	}
}
