import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_19948_음유시인형제 {
	static int[] alpha;
	static int space;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine(); // s: 문장
		
		space = Integer.parseInt(br.readLine()); // space: 남은 spacebar 횟수
		alpha = new int[26]; // alpha: 남은 알파벳 횟수
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 26; i++) {
			alpha[i] = Integer.parseInt(st.nextToken());
		}
		
		String tempString = "";
		
		if(!check(s)) // 키보드 수명 다하면
			System.out.println(-1);
		else { // 키보드 수명 내에 작성 가능하면
			String[] words = s.split("\\s+");
			for(int i = 0; i < words.length; i++) {
//				sb.append(Character.toUpperCase(words[i].charAt(0)));
				char c = Character.toUpperCase(words[i].charAt(0));
				tempString += c;
			}
			if(!check(tempString))
				System.out.println(-1);
			else
				System.out.println(tempString);
		}
	}
	
	static char temp;
	
	static boolean check(String s) {
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(c == temp) // 똑같은게 또 나오면 
				continue; // 건너뛰기
			
			if(c == ' ') { // 띄어쓰기 나오면
				space--;
			}
			else if(Character.isLowerCase(c)){ // 소문자 나오면
				alpha[c-97]--;
			}
			else if(Character.isUpperCase(c)) { // 대문자 나오면
				alpha[c-65]--;
			}
			
			temp = c;
		}
		
		boolean flag = true;
		// 남은 space나 알파벳 음수면 -1 출력
		for(int i = 0; i < 26; i++) {
			if(alpha[i] < 0) {
				flag = false;
			}
		}
		
		if(flag == false || space < 0) 
			return false;
		else
			return true;
	}
}
