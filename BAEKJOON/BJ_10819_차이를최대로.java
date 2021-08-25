

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_10819_차이를최대로 {
	static int N;
	static int[] NArr;
	static int[] answer;
	static boolean[] visited;
	
	static int maxAnsw;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		NArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		// 범위: -100 ~ 100
		answer = new int[N];
		visited = new boolean[N];
		permu(0);
		
		System.out.println(maxAnsw);
	}
	
	static void permu(int cnt) {
		if(cnt == N) {
			int answ = 0;
			for(int i= 0; i < answer.length-1; i++) {
				answ += Math.abs(answer[i] - answer[i+1]);
			}
			maxAnsw = Math.max(maxAnsw, answ);
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) 
				continue;
			
			answer[cnt] = NArr[i];
			visited[i] = true;
			permu(cnt + 1);
			visited[i] = false;
		}
	}
	
	static boolean nextPermutation(int[] arr) {
        int len = arr.length;
        int i=len-1;
        while( i>0 && arr[i-1] >= arr[i] )
            --i;
        if(i==0)
            return false;

        int j = len-1;
        while(arr[i-1]>=arr[j]) 
            --j;

        int tmp = arr[i-1];
        arr[i-1] = arr[j];
        arr[j] = tmp;

        int k = len-1;
        while(i<k) {
            tmp=arr[i];
            arr[i++]=arr[k];
            arr[k--]=tmp;
        }
        return true;
    }
}
