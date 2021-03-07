package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

public class BJ_1764_듣보잡 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); //듣도못한사람
		int M = Integer.parseInt(st.nextToken()); //보도못한사람
		
//		List<String> list = new LinkedList<String>();
//		for(int n = 0; n < N; n++) {
//			list.add(br.readLine());
//		}
//		
//		int cnt = 0;
//		List<String> tempList = new LinkedList<>();
//		for(int m = 0; m < M; m++) {
//			String s = br.readLine();
//			if(list.contains(s)) {
//				cnt++;
//				tempList.add(s); // 왜 시간초과?
//			}
//			else {
//				continue;
//			}
//		}
//		
//		Collections.sort(tempList);
//		
//		System.out.println(cnt);
//		
//		for(String s : tempList)
//			System.out.println(s);
		
		HashMap<String, Integer> hm = new HashMap<>();
		int cnt = 0;
		for(int n = 0; n < N; n++) {
			hm.put(br.readLine(), cnt);
		}
		//{ohhenrie=1, baesangwook=1, charlie=0}
		
		for(int m =0; m < M; m++) {
			String s = br.readLine();
			if(hm.containsKey(s))
				hm.put(s, hm.get(s) + 1);
		}
		int answ = 0;
		for( Entry<String, Integer> entry : hm.entrySet() ){
		    if(entry.getValue() > 0) {
		    	answ++;
		    	//sb.append(entry.getKey()).append("\n");
		    }
		}
		System.out.println(answ);

		List<String> list = new LinkedList<>();
		
		for( Entry<String, Integer> entry : hm.entrySet() ){
		    if(entry.getValue() > 0) {
		    	list.add(entry.getKey());
		    }
		}
		
		Collections.sort(list);
		
//		System.out.println(list);
		
		for(String s : list)
			System.out.println(s);
	}
	
				
}

