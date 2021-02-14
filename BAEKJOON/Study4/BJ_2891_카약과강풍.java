package Study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2891_카약과강풍 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //팀의 수
		int S = Integer.parseInt(st.nextToken()); //카약이 손상된 팀의 수
		int R = Integer.parseInt(st.nextToken()); //카약을 하나 더 가져온 팀의 수
		
		st = new StringTokenizer(br.readLine());
		int[] sArr= new int[S];        //손상 팀 배열 [2, 4] => [1, 3]번쨰 인덱스
		for(int s = 0; s < S; s++) {
			sArr[s] = Integer.parseInt(st.nextToken())-1;
		}
		
		st = new StringTokenizer(br.readLine());
		int[] rArr = new int[R+1];        //여분 팀 배열 [1, 3, 5] => [0, 2, 4]
		for(int r = 0; r < R; r++) {
			rArr[r] = Integer.parseInt(st.nextToken())-1;
		}
		
		// boolean[] NArr = new boolean[N+2]; // 인덱스 범위를 늘려서. 
		boolean[] NArr = new boolean[N]; 
		for(int n = 0; n < N; n++) {
			NArr[n] = false;                // [ F, F, F, F, F]
		}
		for(int n = 0; n < N; n++) {
			for(int r = 0; r < R; r++) {
				NArr[rArr[r]] = true;
			}
		}                                  // [T, F, T, F, T]
		
//		System.out.println(Arrays.toString(NArr));
		
		
		int answer = 0;
		for(int s = 0; s < S; s++) { 
			int point = sArr[s]; // 1, 3
			//1번일때는 오른쪽 확인
			if(point == 0) {
				if(NArr[1] == true) 
					NArr[1] = false; // 대여 함
				else
					answer++; // 못빌림		
			}
			// 마지막번호일때는 왼쪽 확인
			else if(point == N-1) {
				if(NArr[N-2] == true)
					NArr[N-2] = false; // 대여함
				else
					answer++; // 못빌림
			}
			// 중간 번호일때는 왼쪽->오른쪽 순으로 확인
			else {
				if(NArr[point-1] == true)
					NArr[point-1] = false;
				else if(NArr[point+1] == true)
					NArr[point+1] = false;
				else
					answer++;
			}
//			System.out.println(Arrays.toString(NArr));
		}
		
		System.out.println(answer);
	}
}
