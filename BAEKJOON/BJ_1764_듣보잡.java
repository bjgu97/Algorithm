import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_1764_듣보잡 {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//  듣도못한 사람
		Map<String, Integer> map = new HashMap<>();
		for(int n = 0; n < N; n++) {
			map.put(br.readLine(),n);
		}
		
		//  보도 못한 사람
		int cnt = 0;
		List<String> list = new ArrayList<>();
		for(int m = 0; m < M; m++) {
			String s = br.readLine();
			if(map.containsKey(s)) {
				list.add(s);
				cnt++;
			}
		}
		
		Collections.sort(list);
		
		System.out.println(cnt);
		for(String s : list)
			System.out.println(s);
	}
}
