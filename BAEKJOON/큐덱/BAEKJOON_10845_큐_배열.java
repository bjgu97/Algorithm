package 큐덱;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_10845_큐_배열 {
public static void main(String[] args) {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
	int N = Integer.parseInt(br.readLine());
	int[] queue = new int[N];
	
	int front = 0;
	int end = 0;
	
	for(int i = 0; i < N; i++) {
		String order = br.readLine();
		
		
		switch(order) {
		case "push":
			queue[end] = scan.nextInt(); //배열 마지막에 추가
			end ++; //end 포인터 한칸 이동
			break;
		case "front":
			System.out.println((end == front) ? -1 : queue[front]);
			break;
		case "back":
			System.out.println((end == front) ? -1 : queue[end-1]);
			break;
		case "size":
			System.out.println(end - front);
			break;
		case "empty":
			System.out.println((end == front) ? 1 : 0);
			break;
		case "pop":
			System.out.println((end == front) ? -1 : queue[front]);
			if(front < end)
				front++;
			}
		}
	}

}



