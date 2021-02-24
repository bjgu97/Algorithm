package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2477_참외밭 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine()); // 참외의 개수
		int[][] KArr = new int[K][2];
		for(int k = 0; k < 6; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			KArr[k][0] = Integer.parseInt(st.nextToken());
			KArr[k][1] = Integer.parseInt(st.nextToken());
		}
		
		// 가로 최대 길이 X 세로 최대 길이 = 직사각형 넓이
		int maxWidth = 0;
		int maxHeight = 0;
		for(int k = 0; k < 6; k++) {
			if(KArr[k][0] == 1 || KArr[k][0] == 2) {
				maxWidth = Math.max(maxWidth, KArr[k][1]);
				
			}
			else if(KArr[k][0] == 3 || KArr[k][0] == 4) {
				maxHeight = Math.max(maxHeight, KArr[k][1]);
			}
		}
		
		// 전체 넓이
		System.out.println(maxWidth * maxHeight);
		
		// 빼야하는 넓이
		// 방향 중복해서 나온 숫자 있으면,, 중복되는 수자 두개 고르고
		// 순서대로 스택에 넣기. 그럼 스택에 숫자 4개 쌓임
		// 그 중 가운데 두개에 해당되는 방향의 길이들의 곱 구하기
		int[] dir = new int[5];
		for(int k = 0; k < 6; k++) {
			dir[KArr[k][0]]++;
		}
		System.out.println(Arrays.toString(dir));
		int[] dirNum = new int[2];
		int idx = 0;
		for(int i = 1; i <= 4; i++) {
			if(dir[i] == 2)
				dirNum[idx++] = i;
		}
		
		System.out.println(Arrays.toString(dirNum)); 
		
		
	}
}
