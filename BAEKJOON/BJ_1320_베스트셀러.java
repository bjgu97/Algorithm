import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BJ_1320_베스트셀러 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			if(hm.containsKey(s)) {
				hm.put(s, hm.get(s) + 1);
			}
			else {
				hm.put(s, 1);
			}
		}
		int max = 0;
		String maxBook = "";
		List<String> list = new ArrayList<>();
		for(String s : hm.keySet()) {
			if(hm.get(s) > max) {
				max = hm.get(s);
			}
			list.add(s);
		}
		
		Collections.sort(list);

		for(String s : list) {
			if(hm.get(s) == max) {
				System.out.println(s);
			break;
			}
		}
	}
}
