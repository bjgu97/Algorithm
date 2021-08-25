

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_14891_톱니바퀴 {
	static char[][] wheel = new char[4][8];
	static char[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i <4; i++) {
			wheel[i] = br.readLine().toCharArray();
		}

		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		
		
		for(int k = 0; k < K; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int id = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			
			step(id-1, dir); // 각 단계 수행
			

		}
		
		
		int answer = 0;
		if(wheel[0][0] == '1') answer += 1;

		if(wheel[1][0] == '1') answer += 2;
		
		if(wheel[2][0] == '1') answer += 4;
		if(wheel[3][0] == '1') answer += 8;
		
		System.out.println(answer);

	}
	
	static void step(int id, int dir) {
		if(id == 0) { // 첫번쨰 톱니바퀴 회전시킨다면
			if(wheel[0][2] != wheel[1][6]) { // 1 - 2 다르면
				if(wheel[1][2] != wheel[2][6]) { // 2 - 3 다르면
					if(wheel[2][2] != wheel[3][6]) { // 3 - 4 다르면
						if(dir == 1) { // 1가 시계방향이었으면
							rotateCounterClock(wheel[3]);
							rotateClock(wheel[2]);
							rotateCounterClock(wheel[1]);
							rotateClock(wheel[0]);
						}
						else {
							rotateClock(wheel[3]);
							rotateCounterClock(wheel[2]);
							rotateClock(wheel[1]);
							rotateCounterClock(wheel[0]);
						}
					}
					else { // 3-4 같으면 3만 회전
						if(dir == 1) { // 1가 시계방향이었으면
							rotateClock(wheel[2]);
							rotateCounterClock(wheel[1]);
							rotateClock(wheel[0]);
						}
						else {
							rotateCounterClock(wheel[2]);
							rotateClock(wheel[1]);
							rotateCounterClock(wheel[0]);
						}
					}
				}
				else { // 2-3 같으면 2만 회전
					if(dir == 1) {
						rotateCounterClock(wheel[1]);
						rotateClock(wheel[0]);
					}
					else {
						rotateClock(wheel[1]);
						rotateCounterClock(wheel[0]);
					}
				}
			}
			else {
				if(dir == 1) {
					rotateClock(wheel[0]);
				}
				else
					rotateCounterClock(wheel[0]);
			}
		}
		
		else if(id == 1) {
			if(wheel[0][2] != wheel[1][6]) {
				if(dir == 1) {
					rotateCounterClock(wheel[0]);
				}
				else {
					rotateClock(wheel[0]);
				}
			}
			
			if(wheel[2][6] != wheel[1][2]) {
				if(wheel[2][2] != wheel[3][6]) {
					if(dir == 1) {
						rotateClock(wheel[3]);
						rotateCounterClock(wheel[2]);
					}
					else {
						rotateCounterClock(wheel[3]);
						rotateClock(wheel[2]);
					}
				}
				else {
					if(dir == 1) {
						rotateCounterClock(wheel[2]);
					}
					else {
						rotateClock(wheel[2]);
					}
				}
			}
			
			if(dir == 1)
				rotateClock(wheel[1]);
			else
				rotateCounterClock(wheel[1]);
		}
		
		else if(id == 2) {
			if(wheel[2][2] != wheel[3][6]) {
				if(dir == 1) {
					rotateCounterClock(wheel[3]);
				}
				else {
					rotateClock(wheel[3]);
				}
			}
			
			if(wheel[2][6] != wheel[1][2]) {
				if(wheel[0][2] != wheel[1][6]) {
					if(dir == 1) {
						rotateClock(wheel[0]);
						rotateCounterClock(wheel[1]);
					}
					else {
						rotateCounterClock(wheel[0]);
						rotateClock(wheel[1]);
					}
				}
				else {
					if(dir == 1) {
						rotateCounterClock(wheel[1]);
					}
					else {
						rotateClock(wheel[1]);
					}
				}
			}
			
			if(dir == 1)
				rotateClock(wheel[2]);
			else
				rotateCounterClock(wheel[2]);
		}
		
		else if(id == 3) {
			if(wheel[3][6] != wheel[2][2]) {
				if(wheel[2][6] != wheel[1][2]) {
					if(wheel[1][6] != wheel[0][2]) {
						if(dir == 1) {
							rotateClock(wheel[3]);
							rotateCounterClock(wheel[2]);
							rotateClock(wheel[1]);
							rotateCounterClock(wheel[0]);
						}
						else {
							rotateCounterClock(wheel[3]);
							rotateClock(wheel[2]);
							rotateCounterClock(wheel[1]);
							rotateClock(wheel[0]);
						}
					}
					else {
						if(dir == 1) {
							rotateClock(wheel[3]);
							rotateCounterClock(wheel[2]);
							rotateClock(wheel[1]);
						}
						else {
							rotateCounterClock(wheel[1]);
							rotateClock(wheel[2]);
							rotateCounterClock(wheel[3]);
						}
					}
				}
				else {
					if(dir == 1) {
						rotateClock(wheel[3]);
						rotateCounterClock(wheel[2]);
					}
					else {
						rotateClock(wheel[2]);
						rotateCounterClock(wheel[3]);
					}
				}
			}
			else {
				if(dir == 1)
					rotateClock(wheel[3]);
				else
					rotateCounterClock(wheel[3]);
			}
		}
	}
	
	static void rotateCounterClock(char[] arr) {
		char temp = arr[0];
		for(int i = 0; i < arr.length-1; i++) {
			arr[i] = arr[i+1];
		}
		arr[7] = temp;
	}
	
	static void rotateClock(char[] arr) {
		char temp = arr[7];
		for(int i = 6; i >=0; i--) {
			arr[i+1] = arr[i];
		}
		arr[0] = temp;
	}
	
}
