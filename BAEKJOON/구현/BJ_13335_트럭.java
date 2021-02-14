package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.print.attribute.standard.QueuedJobCount;

import com.sun.org.apache.xml.internal.serializer.utils.StringToIntTable;

public class BJ_13335_트럭 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 다리를 건너는 트럭 수
		int w = Integer.parseInt(st.nextToken()); // 다리의 길이
		int L = Integer.parseInt(st.nextToken()); // 최대 하중
		
		st = new StringTokenizer(br.readLine());
		int[] nArr = new int[n];
		for(int i = 0; i < n; i++) {
			nArr[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int time = 0;
		int weight = 0;
		
		for(int i = 0; i < n; i++) {
			while(true) {
				if(queue.isEmpty()) { // 다리 비어있으면
					queue.offer(nArr[i]); // 트럭 이동
					weight += nArr[i]; // 무게 추가
					time ++; //시간 추가
					break;
				}
				else if(queue.size() == w) { // 다리가 꽉차있으면
					weight = weight - queue.poll();
				}
				else { // 다리에 트럭 있으면
					if(weight + nArr[i] > L) { // 최대 하중보다 커질거같으면
						queue.offer(0);
						time++;
					}
					else { // 다음 트럭도 이동 가능함ㄴ
						queue.offer(nArr[i]);
						time++;
						weight += nArr[i];
						break;
					}
				}
		}
				
	}
		System.out.println(time + w);
		
}
}
