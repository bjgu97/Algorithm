// N은 10만! 
package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BAEKJOON_10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, String> map = new HashMap<>();

		//O(N)
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			map.put(age, name);
		}
		
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey); //NlogN
		
		
		StringBuilder sb = new StringBuilder();
		for (Entry<Integer, String> entry : map.entrySet()) {
			sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
		}
		
		System.out.println(sb);
	}

}
