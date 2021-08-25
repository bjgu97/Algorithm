

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class BJ_11286_절댓값힙 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(br.readLine());
		}
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
			if(Math.abs(o1) > Math.abs(o2)) { // 절댓값 작은순
				System.out.println("int compare: " + Integer.compare(Math.abs(o1), Math.abs(o2)));
				return Integer.compare(Math.abs(o1),Math.abs(o2));
			}
			else if(Math.abs(o1) < Math.abs(o2)) {
				System.out.println("int compare: " + Integer.compare(Math.abs(o2), Math.abs(o1)));
				return Integer.compare(Math.abs(o1), Math.abs(o2));
			}
			else
				return Integer.compare(o1, o2);
		
		});
		
		List<Integer> list = new ArrayList<Integer>();
		for(int n = 0; n < N; n++) {
			if(NArr[n] != 0) {
				pq.add(NArr[n]);
			}
			else if(NArr[n] == 0) {
				if(pq.isEmpty())
					System.out.println(0);
				else
					System.out.println(pq.poll());;
			}
		}
		
	}
}
