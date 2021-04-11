package study12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9342_염색체 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean check = true;
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			char[] arr = s.toCharArray();
			
			// [1] 문자열은 A, B, C, D, E, F 중 0개 또는 1개로 시작하지 않으면
			if(arr[0] != 'A' && arr[0] != 'B' && arr[0] != 'C' && arr[0] != 'D' && arr[0] != 'E' && arr[0] != 'F')
				check = false;
			
			// [5] 마지막엔 A, B, C, D, E< F 중 0개 또는 한개가 아니라면
			int lastIdx = s.length()-1;
			if(arr[lastIdx] != 'A' && arr[lastIdx] != 'B' && arr[lastIdx] != 'C' && arr[lastIdx] != 'D' && arr[lastIdx] != 'E' && arr[lastIdx] != 'F') {
				check = false;
			}
			
			if(check == false) {
				System.out.println("Good");
				continue;
			}
			
//			System.out.println("check: " + check);
			// 맨앞, 맨뒤 없애기
			s = s.substring(1, lastIdx);
//			System.out.println("s: " + s);
			
			int AIdxFirst = s.indexOf('A');
			int FIdxFirst = s.indexOf('F');
			int CIdxFirst = s.indexOf('C');
			
			int AIdxLast = s.lastIndexOf('A');
			int FIdxLast = s.lastIndexOf('F');
			int CIdxLast = s.lastIndexOf('C');

			
			if(AIdxLast < FIdxFirst && FIdxLast < CIdxFirst && check == true) {
				System.out.println("Infected!");
			}
			else
				System.out.println("Good");
		}
		
		
		
	}
}
