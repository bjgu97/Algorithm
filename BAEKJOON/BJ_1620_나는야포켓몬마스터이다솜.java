
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_1620_나는야포켓몬마스터이다솜 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		HashMap<String, String> hm = new HashMap<>();
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		String[] MArr = new String[M];
		
		for(int i = 0; i < M; i++) {
			String name = br.readLine();
			hm.put(name, Integer.toString(i+1));
			hm.put(Integer.toString(i+1), name);
		}
		
		for(int i = 0; i < N; i++) {
			System.out.println(hm.get(br.readLine()));
		}

		
		
	}
}
