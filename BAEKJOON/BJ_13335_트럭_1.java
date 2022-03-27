import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_13335_트럭_1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 트럭 수
		int W = Integer.parseInt(st.nextToken()); // 다리 길이
		int L = Integer.parseInt(st.nextToken()); // 최대 하중
		
		int[] trucks = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			trucks[n] = Integer.parseInt(st.nextToken());
		}
		
		Queue<Integer> queue = new LinkedList<>(); // 다리
		int weight = 0; // 무게
		int time = 0; // 시간
		
		for(int truck : trucks) {
			while(true) {
				// 1. 다리 비어있으면
				if(queue.isEmpty()) {
					// 트럭 들어옴
					queue.add(truck);
					weight += truck;
					time ++;
					break;
				}
				else {
					// 2. 다리 꽉차있으면
					if(queue.size() == W) {
						// 트럭 나감
						weight -= queue.poll();
					}
					else {
						// 3. 다음 트럭 들어오면 무게 초과
						if(weight + truck > L) {
							queue.offer(0);
							time++;
						}
						else {
							// 4. 다음 트럭 들어오기 가능
							queue.offer(truck);
							weight += truck;
							time++;
							break;
						}
					}
				}
			}
		}

		// 마지막 트럭까지 빠져나오기
		time = time + W;
		
		System.out.println(time);
	}
}
