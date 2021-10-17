import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_17219_비밀번호찾기 {
	public static void main(String[] args) throws IOException {
		// 메모장에서 비밀번호를 찾는 프로그램
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int m = 0; m < M; m++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}
