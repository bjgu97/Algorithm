import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_2204_도비의난독증테스트 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			String[] arr = new String[N];
			HashMap<String, String> map = new HashMap<>();
			for(int n = 0; n < N; n++) {
				String s = br.readLine();
				String lowS = s.toLowerCase();
				map.put(lowS, s);
				arr[n] = lowS;
			}
			Arrays.sort(arr);
			
			System.out.println(map.get(arr[0]));
		}
	}
}
