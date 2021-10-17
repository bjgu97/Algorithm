import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BJ_11723_집합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<>();
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String command = st.nextToken();
			
			if(command.equals("all")) {
				set.clear();
				for(int i = 1; i <= 20; i++) {
					set.add(i);
				}
			}
			else if(command.equals("empty")) {
				set.clear();
			}
			else {
				int num = Integer.parseInt(st.nextToken());
				
				if(command.equals("add")) {
					set.add(num);
				}
				else if(command.equals("check")) {
					if(set.contains(num))
						sb.append(1).append("\n");
					else
						sb.append(0).append("\n");
				}
				else if(command.equals("remove")) {
					set.remove(num);
				}
				else if(command.equals("toggle")) {
					if(set.contains(num))
						set.remove(num);
					else
						set.add(num);
				}
			}
		}
		System.out.println(sb);
	}
}
