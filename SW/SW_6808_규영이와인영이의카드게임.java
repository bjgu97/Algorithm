

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SW_6808_규영이와인영이의카드게임 {
	static boolean[] choosed;
	static int[] answer;
	
	static int[] arr1;
	static int[] arr2;
	
	static int score1;
	static int score2;
	
	static int win;
	static int loose;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		//boolean[] arr = new boolean[19];
		
		arr1 = new int[9];
		arr2 = new int[9];
		
		for(int tc = 0; tc < TC; tc++) {
			boolean[] arr = new boolean[19];

			st = new StringTokenizer(br.readLine());
			
			// 규영 카드 저장 (arr1)
			for(int i = 0; i < 9; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
				arr[arr1[i]] = true;
			}
			
			// 인영 카드 저장 (arr2)
			int j = 0;
			for(int i = 1; i <= 18; i++) {
				if(!arr[i]) //boolean 배열에서 true인거 제외한 나머지
					arr2[j++] = i; 
			}

			choosed = new boolean[9];
			answer = new int[9];
			
			// 초기화
			win = 0;
			loose = 0;
			
			permutation(0);
			
			sb.append("#").append(tc+1).append(" ").append(win).append(" ").append(loose).append("\n");

		}
		System.out.println(sb);
				
	}
	
	public static void permutation(int cnt) {
		if(cnt == 9) {
			score1 = 0;
			score2 = 0;

			for(int i = 0; i < 9; i++) {
				if(arr1[i] > answer[i]) {
					score1 += (arr1[i] + answer[i]); // 규영 점수
				}
				else if(arr1[i] < answer[i])
					score2 += (arr1[i] + answer[i]); // 인영 점수
			}

			if(score1 > score2)
				win++;
			else if(score1 < score2)
				loose++;
			return;
		}
		
		for(int i= 0; i < 9; i++) {
			if(choosed[i]) continue;
			answer[cnt] = arr2[i];
			choosed[i] = true;
			permutation(cnt+1);
			choosed[i] = false;
		}
	}
}
