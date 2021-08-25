

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_9466_텀프로젝트 {
	static boolean[] visited;
	static int N;
	static int[]nArr;
	static int answ;
	static int init; // 초기값
	static boolean[] mem;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테케
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); // 학생 수
			nArr = new int[N+1]; // 1부터 7까지
			mem = new boolean[N+1]; // 그룹 생성 기억용
			answ = 0; // 생성된 그룹 수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int n = 1; n <= N; n++) { 
				nArr[n] = Integer.parseInt(st.nextToken());
			} 
			
			for(int n = 1; n <= N; n++) {
				if(mem[n] == false) { // 그룹 생성되지 않은 n에 대해서만. 
//					System.out.println("===================");
//					System.out.println("n: " + n);
					visited = new boolean[N+1];
					dfs(n);
				}
				
			}
			System.out.println(N - answ);
		}
	}
	/* 
	1	2	3	4	5	6	7
	3	1	3	7	3	4	6
	
	1 -> 3 -> 3   => 그룹, 초기값은 그룹 X
	2 -> 1 -> 3 -> 3
	3 -> 3
	4 -> 7 -> 6 -> 4  => 그룹
	5 -> 3 -> 3
	6 -> 4 -> 7 -> 6  
	7 -> 6 -> 4 -> 7
	
	초기값으로 돌아오면 그룹 생성.
	방문했던 숫자로 돌아와도 그룹 생성. 
	 */
	
	static void dfs(int i) {
		int nextVal = nArr[i]; // 다음 값    // 3
		
//		System.out.println("i: " +i);
		
		
		if(visited[i] == true) { // 방문한 값이 나오면 
//			System.out.println("방문한 값 나옴");
			mem[i] = true; // 방문한 번호 그룹에 추가시켜주기
			answ++; // 그룹 인원수 세기!
		}
		
		if(visited[i] == false) { //방문하지 않은 값이 나오면
//			System.out.println("방문한 값 안나옴");
			visited[i] = true; // 방문 처리
		}
		
		if(mem[nextVal] == true) { // 다음 값에 이미 그룹 생성된 번호 나오면
//			System.out.println("이미 그룹 생성된 번호 나옴");
			return; // 건너뛰기
		}
		
		if(mem[nextVal] == false) { // 다음 값에 그룹 생성되지 않은 번호 나오면
//			System.out.println("그룹 생성되지 않은 번호 나옴");
//			System.out.println("-----------------");
			dfs(nextVal);
		}
	}
	
}
