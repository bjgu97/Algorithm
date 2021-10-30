

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2511_카드놀이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// A, B 각각 0, 1, 2, ... 9
		// 각 라운드에서 공개된 숫자가 더 큰 사람이 승
		// 승하면 3점
		// 비기면 1점
		// 10라운드까지 진행 후 총 승점 큰 사람이 승
		// 승점 같으면 마지막 이긴사람이 승
		// 모든 라운드에서 비기면 비김.
		StringBuilder sb = new StringBuilder();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] A = new int[10];
		int[] B = new int[10];
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 10; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] AScoreArr = new int[10];
		int[] BScoreArr = new int[10];
		
		int AScore = 0;
		int BScore = 0;
		for(int i = 0; i < 10; i++) {
			if(A[i] > B[i]) {
				AScoreArr[i] = 3;
				BScoreArr[i] = 0;
				AScore+=3;
			}
			else if(B[i] > A[i]) {
				AScoreArr[i] = 0;
				BScoreArr[i] = 3;
				BScore += 3;
			}
			else if(A[i] == B[i]) {
				AScoreArr[i] = 1;
				BScoreArr[i] = 1;
				AScore += 1;
				BScore += 1;
			}
		}
		
		sb.append(AScore).append(" ").append(BScore).append("\n");
		if(AScore > BScore) {
			sb.append("A");
		}
		else if(BScore > AScore) {
			sb.append("B");
		}
		else {
			boolean check = false;
			for(int i = 9; i >= 0;i--) {
				if(AScoreArr[i] > BScoreArr[i]) {
					sb.append("A");
					check = true;
					break;
				}
				else if(AScoreArr[i] < BScoreArr[i]) {
					sb.append("B");
					check = true;
					break;
				}
			}
			
			if(!check) {
				sb.append("D");
			}
		}
		
		System.out.println(sb);
	}

}
