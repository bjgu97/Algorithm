package study10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15683_감시 {
	static class Point{
		int r;
		int c;
		int num; // CCTV 번호
		
		Point(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}
	}

	static List<Point> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		list = new ArrayList<>();
		
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
				if(arr[n][m] != 0 && arr[n][m] != 6)
					list.add(new Point(n, m, arr[n][m])); // CCTV 위치 & 번호 추가
			}
		}
		
		// 모든 CCTV 조합 만들어준다 -> 완탐
		numbers = new int[list.size()];
		comb(0, 0, list.size()); // [1, 2, 3, 4] 에서 중복 허용해서 list.size만큼 뽑기. 
		
	}
	
	static int[] numbers;
	
	static void comb(int cnt, int start, int size) {
		if(cnt == size) {
			System.out.println(Arrays.toString(numbers));
			search(numbers);
			return;
		}
		
		for(int i = start; i < 4; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i, size);
		}
	}
	
	static void search(int[] numbers) {
		for(int i = 0; i < list.size(); i++) { // 0 0 0
			int num = list.get(i).num; // CCTV 번호
			
			switch(numbers[i]) {
			case 0: // 방향이 0이면
				if(num == 1) {
					
				}
				bfs(0, list.get(i).num); // 방향 + CCTV번호
			case 1:  // 방향이 1이면
				bfs(1, list.get(i).num);
			case 2: // 방향이 2이면
				bfs(2, list.get(i).num);
			case 3: // 방향이 3이면
				bfs(3, list.get(i).num);
			}
		}
	}
	

}

//if(depth == output.length){
//    for(int i = 0 ; i < n; i++)
//        copymap[i] = map[i].clone();
//    zero = zeroCnt; // 원본의 0 개수
//    findMinLand(); // 남는 0 개수 세기 
//    return;
//}
//for(int i = 0; i < 4; i++){
//    output[depth] = i;
//    findrotate(depth + 1);
//}

