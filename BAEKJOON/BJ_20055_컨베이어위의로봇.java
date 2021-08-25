

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_20055_컨베이어위의로봇 {
	static int N, K;
	static int[] belt;
	static boolean[] robot;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		belt = new int[2*N];
		robot = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < 2*N; n++) {
			belt[n] = Integer.parseInt(st.nextToken());
		}
		
	
		int answ = 1;
		
		while(move()) {
			answ++;

		}
		
		System.out.println(answ);
	}
	

	static boolean move() {
		// 1-1. 벨트 한 칸 회전
		int size = 2*N;
		
		int temp1 = belt[size-1];	
		
		for(int n = 0; n < size-1; n++) {
			belt[size-1-n] = belt[(size-1-n) -1];
		}
		
		for(int n = 0; n < N-1; n++) {
			robot[N-1-n] = robot[(N-1-n)-1];
		}
		
		belt[0] = temp1;
		robot[0] = false;
			
		// 1-2. 내리는 위치에 있는 로봇은 내린다.
		if(robot[N-1] == true) {
			robot[N-1] = false;
		}
		
		
		// 2. 로봇을 벨트가 회전하는 방향으로 한 칸 이동
		for(int n = N-2; n >=0 ; n--) { // 먼저 올라간 로봇부터 검사
			if(robot[n] == true && robot[n+1] == false && belt[n+1] >= 1) { 
				robot[n] = false;
				robot[n+1] = true; // 다음칸으로 로봇 이동
				belt[n+1]--; // 내구도 하나 떨어트림
			}
		}
		

		
		
		// 3. 올리는 위치의 칸의 내구도가 0 아니면 로봇 올린다.
		if(belt[0] > 0) {
			robot[0] = true;
			belt[0]--;
		}


		
		// 4. 내구도 0인 칸 개수 K 개 이상이면 종료
		int cnt = 0;
		for(int n = 0; n < 2*N; n++) {
			if(belt[n] == 0)
				cnt++;
		}
		
		
		if(cnt >= K)
			return false;
		
		
		return true;
	}
}
