import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_21939_문제추천시스템Version1 {
	
	static class ProbHard implements Comparable<ProbHard> {
		int num;
		int lvl;
		
		ProbHard(int num, int lvl) {
			this.num = num;
			this.lvl = lvl;
		}

		@Override
		public String toString() {
			return "Prob [num=" + num + ", lvl=" + lvl + "]";
		}
		
		@Override
		public int compareTo(ProbHard prob) {
			if(prob.lvl != this.lvl)
				return prob.lvl - this.lvl;
			else 
				return prob.num - this.num;
		}
	}
	
	static class ProbEasy implements Comparable<ProbEasy> {
		int num;
		int lvl;
		
		ProbEasy(int num, int lvl) {
			this.num = num;
			this.lvl = lvl;
		}

		@Override
		public String toString() {
			return "Prob [num=" + num + ", lvl=" + lvl + "]";
		}
		
		@Override
		public int compareTo(ProbEasy prob) {
			if(prob.lvl != this.lvl)
				return this.lvl - prob.lvl;
			else 
				return this.num - prob.num;
		}
	}
	
	static int[] flag = new int[100001];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// recommend x : x가 1이면 가장 어려운 문제 (여러개면 문제번호 큰거)
		// add P L : 난이도 L인 문제번호 P 추가
		// solved P : P 제더
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int N = Integer.parseInt(br.readLine());
		
//		HashMap<Integer, Integer> problems = new HashMap<>(); //문제
//		PriorityQueue<HashMap<Integer, Integer>> pq = new PriorityQueue<>();
		PriorityQueue<ProbHard> pqHard = new PriorityQueue<>();
		PriorityQueue<ProbEasy> pqEasy = new PriorityQueue<>();

		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int P = Integer.parseInt(st.nextToken()); // 문제번호
			int L = Integer.parseInt(st.nextToken()); // 난이도
//			HashMap<Integer, Integer> problems = new HashMap<>();
//			problems.put(P, L);
//			pq.add(problems);
			ProbHard p1 = new ProbHard(P, L);
			ProbEasy p2 = new ProbEasy(P, L);
			pqHard.add(p1);
			pqEasy.add(p2);
			
			flag[P] = L;
		}
		
//		while(!pq.isEmpty()) {
//			System.out.println(pq.poll());
//		}
		
		int M = Integer.parseInt(br.readLine()); // 명령 개수
		
		for(int m = 0; m < M; m++) {

			String input = br.readLine();
			
			st = new StringTokenizer(input);
			
			String command = st.nextToken();
			
			System.out.println("command: " + command);
			// recommend 이면
			if(command.equals("recommend") ) {
				int x = Integer.parseInt(st.nextToken());
				
				// x가 1이면
				if(x == 1) {
					while(true) {
						ProbHard answer = pqHard.peek();
						if(flag[answer.num] == answer.lvl) {
							System.out.println(answer.num);
							break;
						}
						
						pqHard.poll();
					}
				}
				else if(x == -1) {
					while(true) {
						ProbEasy answer = pqEasy.peek();
						if(flag[answer.num] == answer.lvl) {
							System.out.println(answer.num);
							break;
						}
						pqEasy.poll();
					}
				}
			}
			else if(command.equals("add")) {
				int P = Integer.parseInt(st.nextToken());
				int L = Integer.parseInt(st.nextToken());
				pqHard.add(new ProbHard(P, L));
				pqEasy.add(new ProbEasy(P, L));
				
				flag[P] = L;
				
			}
			else if(command.equals("solved")) {
				int P = Integer.parseInt(st.nextToken());
				flag[P] = 0;
			}
			
			System.out.println(pqEasy);
			System.out.println(pqHard);
			System.out.println();
		}
	}
}	
