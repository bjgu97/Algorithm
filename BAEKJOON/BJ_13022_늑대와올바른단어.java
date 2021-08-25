import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public class BJ_13022_늑대와올바른단어 {
	public static void main(String[] args) throws IOException {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String s = br.readLine();
	
	if(checkString(s))
		System.out.println(1);
	else
		System.out.println(0);	
	}
	
	static boolean checkString(String string) {
		
		// w, o, l, f 사이에 문자 추가
		List<Character> list = new LinkedList<Character>();
		String w = "";
		String o = "";
		String l = "";
		String f = "";
		
		boolean flag = true;

		if(string.length() < 4) {
			flag = false;
		}
		else { // 길이 4 이상 문자만. 
			list.add(string.charAt(0));
			for(int c = 1; c < string.length(); c++) {
				if(string.charAt(c) != string.charAt(c-1))
					list.add(',');
				list.add(string.charAt(c));
			}
			String listString = "";
			for(Character c : list)
				listString += c;
			
			// 문자 나누기
			String[] arr = listString.split(",");
			
			for(int i = 0; i < arr.length; i++) {
				// w, o, l, f 순서 검사
				String s = arr[i];
				if(i % 4 == 0) {
					if(s.contains("o") || s.contains("l") || s.contains("f")) {
						flag = false;
						break;
					}
				}
				if(i % 4 == 1) {
					if(s.contains("w") || s.contains("l") || s.contains("f")) {
						flag = false;
						break;
					}
				}
				if(i % 4 == 2) {
					if(s.contains("w") || s.contains("o") || s.contains("f")) {
						flag = false;
						break;
					}
				}
				if(i % 4 == 3) {
					if(s.contains("w") || s.contains("o") || s.contains("l")) {
						flag = false;
						break;
					}
				}
				
				// w o l f 개수검사
				if(i % 4 == 3) {
					if(arr[i].length() != arr[i-1].length() || arr[i-1].length() != arr[i-2].length() || arr[i-2].length() != arr[i-3].length())
						flag = false;
				}

			}
		}		
		return flag;
	}
}
