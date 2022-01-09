

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BJ_2891_카약과강풍 {
	public static void main(String[] args) throws IOException {
		// 자신 다음이나 전에 카약 빌려줌.
		// 다른팀에게서 받은 카약은 다른팀에게 빌려줄 수 없음
		// 카약 하나 더 가져온 팀의 카약 손상되었으면, 여분 카약으로 출전
		// 이 카약 다른팀에게 빌려줄 수 없음
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N =  Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		int[] team = new int[N];
		Arrays.fill(team, 1);
		
		st = new StringTokenizer(br.readLine());
		for(int s = 0; s < S; s++) {
			int n = Integer.parseInt(st.nextToken());
			team[n-1]--;
		}
		
		st = new StringTokenizer(br.readLine());
		for(int r = 0; r < R; r++) {
			int n = Integer.parseInt(st.nextToken());
			team[n-1]++;
		}
		
//		System.out.println(Arrays.toString(team));
		
		for(int n = 0; n < N; n++) {
			if(team[n] == 0) { // 고장났으면
				if(n != 0 && team[n-1] == 2) {
					team[n-1]--;
					team[n]++;
				}
				else if(n != N-1 && team[n+1] == 2) {
					team[n+1]--;
					team[n]++;
				}
			}
		}
		
//		System.out.println(Arrays.toString(team));
		
		int answer = 0;
		for(int n = 0; n < N; n++) {
			if(team[n] == 0) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}
