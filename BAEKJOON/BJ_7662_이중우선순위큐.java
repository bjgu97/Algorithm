import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_7662_이중우선순위큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 삭제할때: 우선순위 높은 데이터/낮은 데이터 하나 삭제.
		// 데이터 삽입 & 데이터 삭제 가능
		// 삭제: 우선순위 높은거 & 우선순위 낮은거
		
		//I 1: 삽입
		//D 1: 최댓값 삭제
		// D -1 : 최솟값 삭제
		// Q 비어있는데 D 연산: 무시
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			PriorityQueue<Integer> pq1 = new PriorityQueue<>(); // 최솟값 빼기 용
			PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder()); // 최댓값 빼기용
			
			HashMap<Integer, Integer> hm = new HashMap<>();
			
			int K = Integer.parseInt(br.readLine()); // 연산의 개수
			
			for(int k = 0; k < K; k++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				char command = st.nextToken().charAt(0);
				int num = Integer.parseInt(st.nextToken());
				
//				System.out.println("command, num: " + command + "," + num);
//				System.out.println(hm);
//				System.out.println(pq1);
//				System.out.println(pq2);
				if(command == 'I') {
					pq1.add(num);
					pq2.add(num);
					
					if(hm.containsKey(num)) {
						int val = hm.get(num);
						hm.put(num, val + 1);
					}
					else {
						hm.put(num, 1);
					}
				}
				else if(command == 'D' && num == 1) { // 큰값 삭제
					int key;
//					if(pq2.isEmpty())
//						continue;
					
					while(!pq2.isEmpty()) {
						key = pq2.poll();
						
						if(!hm.containsKey(key)) {
							continue;
						}
						else {
							int val = hm.get(key);
							
							if(val == 1) {
								hm.remove(key);
							}
							else {
								hm.put(key, val-1);
							}
						}
	
						break;
					}
				}
				else if(command == 'D' && num == -1) {
					int key;
//					if(pq1.isEmpty())
//						continue;
					while(!pq1.isEmpty()) {
						key = pq1.poll();
						
						if(!hm.containsKey(key)) {
							continue;
						}
						else {
							int val = hm.get(key);
							
							if(val == 1) {
								hm.remove(key);
							}
							else {
								hm.put(key, val-1);
							}
						}
	
						break;
					}
				}
				
				
			}
			
//			System.out.println(hm);
			
			List<Integer> list = new ArrayList<>();
			for(int i : hm.keySet()) {
				if(hm.get(i) >= 1) {
					list.add(i);
				}
			}

			Collections.sort(list);
//			System.out.println(list);
			
			
			if(list.isEmpty())
				System.out.println("EMPTY");
			else {
				System.out.println(list.get(list.size()-1) + " " + list.get(0));
			}
		}
	}
}
