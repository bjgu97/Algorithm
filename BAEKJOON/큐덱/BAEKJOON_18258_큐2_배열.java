package 큐덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEKJOON_18258_큐2_배열 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	int N = Integer.parseInt(st.nextToken());
	
	int[] queue = new int[N];
	int front = 0;
	int end = 0;
	
	for(int i = 0; i < N; i++) {
		st = new StringTokenizer(br.readLine());
		String order =  st.nextToken();
		
		switch(order) {
		case "push":
			queue[end] = Integer.parseInt(st.nextToken());
			end ++;
			break;
			
		case "front":
			bw.write((end == front) ? -1 : queue[front]);
			break;
			
		case "back":
			bw.write((end == front) ? -1 : queue[end-1]);
			break;
			
		case "size":
			bw.write(end - front);
			break;
			
		case "empty":
			bw.write((end == front) ? 1 : 0);
			break;
			
		case "pop":
			bw.write((end == front) ? -1 : queue[front]);
			if(front != end)
				front++;
			}
		}
	bw.flush();
	}

}
