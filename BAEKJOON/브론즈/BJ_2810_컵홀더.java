package 브론즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2810_컵홀더 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 좌석의 수
		
		String s = br.readLine();
		char[] arr = s.toCharArray();
		
		int answ = 1; // 왼쪽 끝 컵홀더
		int cnt = 0;
		
		for(int c = 0; c < arr.length; c++) {
			if(arr[c] == 'S') { // 일반좌석 나오면 하나씩 추가
				answ++;
			}
			else if(arr[c] == 'L') {
				answ ++;
				cnt++; // 커플석 각각의 개수
			}
		}
		
		// 전체 컵홀더 개수 - 커플석 개수
		System.out.println(Math.min(N, answ-cnt/2));
		// sysout(answ - cnt/2) 즉 컵홀더의 개수로 했을 때의 예외: 1 S , 2 SS
		
	}
}
