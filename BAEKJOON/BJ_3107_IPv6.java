import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_3107_IPv6 {
	public static void main(String[] args) throws IOException {
		// : 다음 0 생략 가능 (전체 아님 일부)
		// 0:00 같이 연속된 0 그룹은 생략 가능 -> 한번만 사용 가능
		
		/// 길이 4짜리 배열 8개 [ [] [] [] [] [] [] [] []]
		// 각 배열 길이 4 미만이면, 앞에 0 채우기
		// :: 나오면 전체 배열 길이 32 될때까지 0 배열 추가해주기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		StringBuilder sb = new StringBuilder();
		for(int s = 0; s < S.length(); s++) {
			if(S.charAt(s) == ':') {
//				System.out.println("sb: " + sb);
				String ss = sb.toString();
				char[] arr = new char[4];
				
				while(ss.length() < 4)
					ss = "0" + ss;
				
				System.out.println("ss: " + ss);
				for(int a = 0; a < 4; a++) {
					arr[a] = ss.charAt(a);
				}
				
				System.out.println(Arrays.toString(arr));
				sb = new StringBuilder();
				continue;
			}
			sb.append(S.charAt(s));
		}
	}
}
