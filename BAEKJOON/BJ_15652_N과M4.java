// 중복조합



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15652_N과M4 {
	static int[] answer; // 출력 배열 ex) (1, 1), (1, 2), ...
	static boolean[] choosed; // 방문 여부 표시 배열
	static int N; // 고를 수
	static int M; // 고르는 대상
	
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		answer = new int[N];
		choosed = new boolean[M+1];
		
		// 조합은 자기 위치 전으로 이동하지 않으니까. 
		combinationDup(0, 1); // 0은 처음 시작 인덱스, 현재 위치?
		
		System.out.println(sb);
		
	}
	
	  static void combinationDup(int cnt, int start) {
	    	if(cnt == N) {
	    		for(int i= 0; i < N; i++) {
	    			sb.append(answer[i]).append(" ");
	    		}
	    		sb.append("\n");
	    		return;
	    	}
	    	for(int i = start; i <= M; i++) {
	    		answer[cnt] = i;
	    		combinationDup(cnt+1, i);
	    	}
	    }
	    
}
