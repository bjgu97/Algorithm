import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BJ_17609_회문 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int t = 0; t < T; t++) {
			String s = br.readLine();
			char[] sArr = s.toCharArray();
			
			int left = 0;
			int right = sArr.length-1;
			
			// 먼저 펠린드롬 체크
			boolean check = CheckPalindrome(left, right, sArr);
			
			if(check) 
				sb.append(0).append("\n");
			else { // 펠린드롬 아니면
				boolean check2 = CheckPalindrome2(sArr);
				if(check2) {
					sb.append(1).append("\n");
				}
				else
					sb.append(2).append("\n");
			}
			
//			if(check) { // 그 자체로 회문이면
//				sb.append(0);
//			}
//			else {
//				int cnt = 0;
//				int idx = 0;
//				for(int c = 0; c < sArr.length; c++) {
//					char[] sArr2 = new char[s.length()];
//					if(c == cnt)
//						continue;
//					sArr2[idx] = sArr[c];
//					idx++;
//				}
//			}
		}
		
		System.out.println(sb);

	}
	static boolean CheckPalindrome(int left, int right, char[] sArr) {
		
		while(left < right) {
			if(sArr[left] != sArr[right]) { // 다르면
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
	
	static boolean CheckPalindrome2(char[] sArr) {
		int left = 0;
		int right = sArr.length-1;
		
		while(left < right) {
			if(sArr[left] != sArr[right]) { // 다르면
				// 한 문자 삭제 -> 건너뛰기
				if(CheckPalindrome(left+1, right, sArr)) { 
					return true;
				}
				else if(CheckPalindrome(left, right-1, sArr)) { 
					return true;
				}
				else
					return false;
			}
			
			left++;
			right--;
		}
		
		return true; 
	}
}
