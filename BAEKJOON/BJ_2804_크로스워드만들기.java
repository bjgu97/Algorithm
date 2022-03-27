import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2804_크로스워드만들기 {
	public static void main(String[] args) throws IOException {
		// A는 가로로
		// B는 세로로
		// 두 단어 교차 (한 글자 고유)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		
		int ALen = A.length(); 
		int BLen = B.length();
		
		outer:for(int a = 0; a < ALen; a++) {
			for(int b = 0; b < BLen; b++) {
				if(A.charAt(a) == B.charAt(b)) {
					printMap(A, B, a, b, ALen, BLen);
					break outer;
				}
			}
		}
	}
	
	static void printMap(String A, String B, int a, int b, int ALen, int BLen) {
		char[][] map = new char[BLen+1][ALen+1];
		
		// . 로 채우기
		for(char[] m : map)
			Arrays.fill(m, '.');
		
		// A 단어 입력
		map[b] = A.toCharArray();
		
		// B 단어 입력
		for(int i = 0; i < BLen; i++) {
			map[i][a] = B.charAt(i); 
		}

		//출력
		for(int i = 0; i < BLen; i++) {
			for(int j = 0; j < ALen; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}
}
