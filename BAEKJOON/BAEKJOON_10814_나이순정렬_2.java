// N은 10만! 


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BAEKJOON_10814_나이순정렬_2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder[] sb = new StringBuilder[201];
		
		for(int i = 0; i < 201; i++) {
			sb[i] = new StringBuilder();
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			sb[age].append(age).append(" ").append(name).append("\n");
		}
		
		StringBuilder s = new StringBuilder();
		
		for(StringBuilder a : sb) {
			s.append(a);
		}
		
		System.out.println(s);
	
		
}
}
