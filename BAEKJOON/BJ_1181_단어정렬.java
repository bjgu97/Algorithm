

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class BJ_1181_단어정렬 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = br.readLine();
		}
		
		Arrays.sort(arr, (o1, o2) -> {
			if(o1.length() != o2.length()) {
				return o1.length() - o2.length();
			}
			else
				return o1.compareTo(o2);
			});
		
		
		// 단어 중복 제거?
//		List<String> list = new ArrayList<String>();
//		for(int n = 0; n < N; n++) {
//			if(list.contains(arr[n]) == false) { // 리스트가 요소 가지고 있지 않다면
//				list.add(arr[n]);
//			}
//		}
//		
//		for(int i= 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		TreeSet<String> hashset = new TreeSet<>();
		
		for(int n = 0; n < N; n++) {
			hashset.add(arr[n]);
		}
		
		System.out.println(hashset);
	}
}
