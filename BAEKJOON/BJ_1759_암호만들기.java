

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1759_암호만들기 {
	static int L;
	static int C;
	
	static char[] CArr;
	static char[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		CArr = new char[C];
		for(int c = 0; c < C; c++) {
			CArr[c] = st.nextToken().charAt(0);
		}
				
		Arrays.sort(CArr);
				
		// 최소 두개의 자음, 최소 한개의 모음
		answer = new char[L];
		comb(0, 0);
		
	}
	// 6개 중.. 모음 1개 -> 자음 5개
	//              모음 4개        <-  자음 2개
	static void comb(int cnt, int start) {
		if(cnt == L) {
			// 최소 두개의 자음, 최소 한개의 모음
			int num = 0;
			for(int i = 0; i < answer.length; i++) {
				if(answer[i] == 'a' || answer[i] == 'o' || answer[i] == 'e' || answer[i] == 'i' || answer[i] == 'u') {
					num++;
				}
			}
			
			if(num >= 1 && num <= (L-2)){ // 모음이 한개 이상 존재한다면
				for(int i = 0; i < answer.length; i++) {
					System.out.print(answer[i]);
				}
				System.out.println();
				return;				
			}
			return;
		}
		
		for(int i = start; i < C; i++) {
			answer[cnt] = CArr[i];
			comb(cnt+1, i+1);
		}
	}
}
