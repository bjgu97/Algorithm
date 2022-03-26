import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BJ_1174_줄어드는수 {
	static List<Long> list = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N번째로 작은 줄어드는 수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 0 1 2 3 4 5 6 7 8 9
		// 10
		// 20 21
		// 30 31 32
		// 9876543210
		
		for(long i = 0; i < 10; i++) {
//			dfs(i);
			list.add(i);
		}
		
		Collections.sort(list);
		if(list.size() < N)
			System.out.println(-1);
		else
			System.out.println(list.get(N-1));
		
		
	}
	
	static void dfs(long num) {
//		if(idx > 10)
//			return;
		
		list.add(num);
		
		for(int i = 0; i < num % 10; i++) {
			dfs((num * 10) + i);
		}
	}
}
