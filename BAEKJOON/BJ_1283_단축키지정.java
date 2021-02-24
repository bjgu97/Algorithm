

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1283_단축키지정 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuffer sbf = new StringBuffer();
		
		char[][] arr = new char[N][];
		// check: 지정된 단축키 담는 배열
		boolean[] check = new boolean[25];
		
		for(int n = 0; n < N; n++) {
			String s= br.readLine();
			arr[n] = s.toCharArray();
			
			// 첫글자 검사 - 단축키 지정 안되어있다면
			if(check[arr[n][0]] == false) {
				check[arr[n][0]] = true; // 지정 한다.
				sbf.insert(0, '[');
				sbf.insert(offset, b)
				continue;
			}
			// 첫글자 단축키 지
			else {
				
			}
		}
	}
}
