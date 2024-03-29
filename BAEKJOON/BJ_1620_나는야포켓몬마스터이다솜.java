
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int n = 1; n <= N; n++) {
			String s = br.readLine();
			map.put(Integer.toString(n), s);
			map.put(s, Integer.toString(n));
		}
		
		for(int m = 0; m < M; m++) {
			String s = br.readLine();
			sb.append(map.get(s)).append("\n");
		}
		
		System.out.println(sb);
	}
}
