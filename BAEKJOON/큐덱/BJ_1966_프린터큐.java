package 큐덱;

import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_1966_프린터큐 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//10개의 테케
		// 테케 길이
		//테케
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		Queue<Integer> index = new LinkedList<Integer>();
		
		for(int t = 0; t < T; t++) {
			//문서의 개수 N, 궁금한 문서 위치 M
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(queue n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			System.out.println(queue);
			
			if(queue.size() == 1)
				sb.append(1).append("\n");
			else {
				//알고리즘
				
			}
			queue.clear();
		}
	}
}
