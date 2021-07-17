import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1120_문자열 {
	public static void main(String[] args) throws IOException {
		// A 앞에 아무거나 추가
		// A 뒤에 아무거나 추가
		// A와 B 길이 같으면서, A와 B 차이 최소로 하게
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String A = st.nextToken();
		String B = st.nextToken();
		int answ = 50;
		for(int i = 0; i <= B.length() - A.length(); i++) {
			int cnt = 0;
			for(int j = 0; j < A.length(); j++) {
				if(B.charAt(j+i) == A.charAt(j)) {
					cnt++;
				}
			}
			answ = Math.min(answ, A.length()-cnt);
		}
		
		System.out.println(answ);
}
}
