import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1969_DNA {
	public static void main(String[] args) throws IOException {
		// A T G C
		// hamming distance 가장 작은 DNA ㄴ?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int a = 0;
		int c = 0;
		int g = 0;
		int t = 0;
		
		char[][] arr = new char[N][M];
		String s;
		for(int n = 0; n < N; n++) {
			s = br.readLine();
			arr[n] = s.toCharArray();
		}
		
		String ss = "";
		for(int m = 0; m < M; m++) {
			a = 0; c = 0; g = 0; t = 0;
			for(int n= 0; n < N; n++) {
				if(arr[n][m] == 'T') t++;
				if(arr[n][m] == 'C') c++;
				if(arr[n][m] == 'A') a++;
				if(arr[n][m] == 'G') g++;
				
			}
			
			if(Math.max(t, Math.max(c, Math.max(a, g))) == a) {
				ss += "A"; 
			}
			else if(Math.max(t, Math.max(c, Math.max(a, g))) == c) {
				ss += "C"; 
			}
			else if(Math.max(t, Math.max(c, Math.max(a, g))) == g) {
				ss += "G";
			}
			else if(Math.max(t, Math.max(c, Math.max(a, g))) == t) {
				ss += "T"; 
			}
			
		}
		
		char[] tmpArr = ss.toCharArray();
		System.out.println(ss);

		int answer = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(arr[n][m] != tmpArr[m]) {
					answer++;
				}
			}
		}
		
		System.out.println(answer);
	}
}
