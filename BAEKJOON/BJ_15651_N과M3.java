
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15651_N과M3 {
   // static char[] src = {'a', 'b', 'c', 'd'};
	static int[] answer;
	static int N, M, totalCnt;
	static boolean[] isSelected;
	
	static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	M = Integer.parseInt(st.nextToken()); // 4
    	N = Integer.parseInt(st.nextToken()); // 2
    	
        answer = new int[N]; //정답배열
        isSelected = new boolean[M+1]; //방문 여부 표시 
        
        makePermutation(0); //index 0부터 탐색 시작
        
        System.out.println(sb);
    }
    
	///////////////////////////////
	//       순열: mPn           //
	///////////////////////////////
    static void makePermutation(int cnt) {
    	if(cnt == N) { // cnt가 1이면
    		for(int i = 0; i < N; i++) {
    			sb.append(answer[i]).append(" ");
    		}
    		sb.append("\n");
    		return;
    	}
    	for(int i = 1; i <= M; i++) {
    		if(isSelected[i]) continue; //선택 된거면 pass
    		
    		answer[cnt] = i+1;
    		isSelected[i] = true;
    		
    		makePermutation(cnt+1);
    		
    		isSelected[i] = false;
    	}
    }
}