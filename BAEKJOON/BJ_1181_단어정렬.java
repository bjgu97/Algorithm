import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class BJ_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		
		for(int n = 0; n < N; n++) {
			words[n] = br.readLine();
		}
		
		Arrays.sort(words, (o1, o2) -> {
			if(o1.toString().length() == o2.toString().length())
				return o1.compareTo(o2); // 사전순
			else
				return o1.toString().length() - o2.toString().length();
		});
		
		sb.append(words[0]).append("\n");
		for(int i = 1; i < words.length; i++) {
			if(!words[i].equals(words[i-1]))
				sb.append(words[i]).append("\n");
		}
		System.out.println(sb);
	}
}
