package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2512_예산 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 지방의 수
		int[] NArr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int summ = 0;
		int maxx = 0;
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
			summ += NArr[n];
		}
		
		int M = Integer.parseInt(br.readLine()); // 총 예산
		
		Arrays.sort(NArr);
		
		int top = 100000;
		int down = 0;
		int mid = 0;
		boolean check = false;
//		int sum = 0;
		
		if(summ <=M)
			System.out.println(NArr[N-1]);
		else {
			while(down <= top) {
				int sum = 0;
				mid = (top + down) / 2;
	//			System.out.println("mid: " + mid);
				for(int i = 0; i < N; i++) {
					if(NArr[i] > mid) {
						sum += mid;
					}
					else
						sum += NArr[i];
				}
	//			System.out.println("sum: " + sum);
				if(sum > M) { // 총 예산을 넘어가면
					top = top -1;
				}
				else if(sum < M) { // 총예산보다 적으면
					down = down + 1;
				}
				else if(sum == M) {
					check = true;
					break;
				}
				
	//			System.out.println("down, mid, top: " + down + "," + mid + "," + top);
			}
			
			if(check)
				System.out.println(mid);
			else
				System.out.println(mid-1);
		}
		

	}
}

/*
100
384 387 278 416 294 336 387 493 150 422 363 28 191 60 264 427 41 427 173 237 212 369 68 430 283 31 363 124 68 136 430 303 23 59 70 168 394 457 12 43 230 374 422 420 285 38 199 325 316 371 414 27 92 481 457 374 363 171 497 282 306 426 85 328 337 6 347 230 314 358 125 396 83 46 315 368 435 365 44 251 88 309 277 179 289 85 404 152 255 400 433 61 177 369 240 13 227 87 95 40 
50000
 */
