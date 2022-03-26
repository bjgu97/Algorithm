import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
	
	static class Student{
		int num; // 학생번호
		List<Integer> friend; // 친구목록
		int r;
		int c;
		
		Student(int num, List<Integer> friend, int r, int c) {
			this.num = num;
			this.friend = friend;
			this.r = r;
			this.c = c;
		}
		
	}
	
	static class Position implements Comparable<Position>{
		int r;
		int c;
		int like;
		int empty;
		
		Position(int r, int c, int like, int empty) {
			this.r = r;
			this.c = c;
			this.like = like;
			this.empty = empty;
		}
		
		@Override
		public String toString() {
			return "Position [r=" + r + ", c=" + c + ", like=" + like + ", empty=" + empty + "]";
		}

		@Override
		public int compareTo(Position o) {
			if(o.like != this.like)
				return o.like - this.like;
			else {
				if(o.empty != this.empty)
					return o.empty - this.empty;
				else {
					if(o.r != this.r)
						return this.r - o.r;
					else {
						if(o.c != this.c) {
							return this.c - o.c;
						}
						else {
							return -1;
						}
					}
				}
			}
		}
		
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 교실은 N*N 크기, 학생수 N*N
		// 1번부터 N^2번까지 번호.
		// (1,1) ~ (N,N)
		// 1 비어있는 칸 중 좋아하는 학생이 인접한 자리에 가장 많은 칸으로.
		// 1이 여러개면, 인접칸중 비어있는 칸이 가장 많은 칸으로
		// 2가 여러개면, 행 번호 가장 작은 칸으로
		// 3이 여러개면, 열 번호 가장 작은 칸으로
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		List<Integer> list = new ArrayList<>();
		List[] arr = new List[N*N+1];
		
		for(int n = 0; n < N*N; n++) {
			arr[n+1] = new ArrayList<>();
		}

		for(int n = 0; n < N*N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int studentNo = Integer.parseInt(st.nextToken());
			list.add(studentNo);
			for(int i = 0; i < 4; i++) {
				int friend = Integer.parseInt(st.nextToken());
				arr[studentNo].add(friend);
			}
		}
		int[][] map = new int[N][N];
		int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		
		for(int no : list) { // 학생 한명씩 담기
			List<Position> positionList = new ArrayList<Position>();
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(map[r][c] == 0) { // 비어있는 자리에 대해서
						int emptyCnt = 0;
						int friendCnt = 0;
						for(int d = 0; d < deltas.length; d++) {
							int nr = r + deltas[d][0];
							int nc = c + deltas[d][1];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;
							
							if(map[nr][nc] == 0) emptyCnt++;
							if(arr[no].contains(map[nr][nc])) friendCnt++;
						}
						Position position = new Position(r, c, friendCnt, emptyCnt);
						positionList.add(position);
					}
				}
			}
//			System.out.println(positionList);
			Collections.sort(positionList);
//			System.out.println();
			
			Position position = positionList.get(0);
			map[position.r][position.c] = no;
			
//			for(int[] a : map)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
		}
		
		int answer = 0;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				int satis = 0;
				int num = map[r][c];
				for(int d = 0; d < deltas.length; d++) {
					int nr = r + deltas[d][0];
					int nc = c + deltas[d][1];
					
					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;
					if(arr[num].contains(map[nr][nc])) {
						satis++;
					}
				}
				if(satis == 1) {
					answer += 1;
				}
				else if(satis == 2)
					answer += 10;
				else if(satis == 3)
					answer += 100;
				else if(satis == 4)
					answer += 1000;
			}
		}
		
		System.out.println(answer);
		
	}

}
