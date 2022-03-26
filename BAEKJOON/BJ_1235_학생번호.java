import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BJ_1235_학생번호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		List<String> list = new ArrayList<>();
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			list.add(s);
		}
		
		int L = list.get(0).length();
		
		for(int l = 1; l <= L; l++) {
			HashSet<String> set = new HashSet<>();
			for(String s : list) {
				set.add(s.substring(L-l, L));
			}
			if(set.size() == N) {
				System.out.println(l);
				break;
			}
		}
	}
}
