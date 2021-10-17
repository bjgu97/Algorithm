import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2469_사다리타기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 입력
		int K = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		char[] finalString = br.readLine().toCharArray();
		
		char[][] map = new char[N][K];
		for(int n = 0; n < N; n++) {
			String ss = br.readLine();
			map[n] = ss.toCharArray();
		}
		
		char[] initString = new char[K];
		for(int c = 0; c < K; c++) {
			initString[c] = (char)(c + 65);
		}
		
		// 위 문자열 내리기
		for(int n = 0; n < N; n++) {
			for(int k = 0; k < K-1; k++) {
				if(map[n][k] == '*') {
					continue;
				}
				else if(map[n][k] == '-') {
					char temp = initString[k];
					initString[k] = initString[k+1];
					initString[k+1] = temp;
				}
			}
			if(map[n][0] == '?')
				break;
		}		
		
		System.out.println(Arrays.toString(initString));
		
		// 아래 문자열 올리기
		for(int n = N-1; n >= 0; n--) {
			for(int k = 0; k < K-1; k++) {
				if(map[n][k] == '*') {
					continue;
				}
				else if(map[n][k] == '-') {
					char temp = finalString[k];
					finalString[k] = finalString[k+1];
					finalString[k+1] = temp;
				}
			}
			
			if(map[n][0] == '?')
				break;
		}
		
		System.out.println(Arrays.toString(finalString));
		
		// 비교
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		for(int k = 0; k < K-1; k++) {
			if(initString[k] == finalString[k])
				sb.append('*');
			
			else if(initString[k] == finalString[k+1] && initString[k+1] == finalString[k]) {
				sb.append('-');
				
				char temp = initString[k];
				initString[k] = initString[k+1];
				initString[k+1] = temp;
			}
			
			else {
				flag = false;
				break;
			}
			
		}
		
		if(flag)
			System.out.println(sb);
		else {
			for(int k = 0; k < K-1; k++) {
				System.out.print('x');
			}
		}
			
	}
}
