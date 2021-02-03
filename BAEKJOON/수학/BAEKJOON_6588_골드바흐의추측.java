package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BAEKJOON_6588_골드바흐의추측 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int N;
	while((N = Integer.parseInt(br.readLine())) != 0) {

		List<Integer> list = new ArrayList<Integer>();

		list.add(2);
		for(int i = 3; i < N; i++) { //5 ~ 8
			for(int j = 0; j < list.size(); j++) {
				if(i % list.get(j) == 0) break; // 소수 아니면 pass
				if(j+1 == list.size()) list.add(i);
			}
		}
	
		
		Collections.sort(list);
		list.remove(0);

		boolean aa = true;
		
		for(int i = 0; i < list.size(); i++) {
			for(int j = list.size()-1; j >=0; j--) {
				if(list.get(i) + list.get(j) == N && aa == true) {
					sb.append(N).append(" = ").append(list.get(i)).append(" + ").append(list.get(j)).append("\n");
					aa = false;
					break;
				}

			}
			
		}
		if(aa == true)
			sb.append("Goldbach's conjecture is wrong.");
}
	System.out.println(sb);
}
}
