import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_17779_게리맨더링2 {
	static int N;
	static int[][] map;
	static int[][] visited;
	static int answer = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		
		map = new int[N+1][N+1];
	
		
		for(int n = 1; n < N+1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 1; m < N+1; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int r = 1; r <= N; r++) {
			for(int c = 1; c <= N; c++) {
				for(int d1 = 1; d1 <=N; d1++) {
					for(int d2 = 1; d2 <=N; d2++) {
						if(isIn(r+d1+d2) && isIn(c - d1 + d2) && isIn(r + d1) && isIn(c - d1) && isIn(r + d2) && isIn(c + d2)) {
							visited = new int[N+1][N+1];
							for(int n = 0; n <= N; n++) {
								visited[0][n] = -1;
							}
							for(int k = 0; k <= N; k++) {
								visited[k][0] = -1;
							}
							
//							for(int[] a : visited)
//								System.out.println(Arrays.toString(a));
//							System.out.println();
							
							// 1의 개수
							int one = 0;
							for(int i = 1; i <= r-1; i++) {
								for(int j = 1; j <= c; j++) {
									one += map[i][j];
									visited[i][j] = 1;
								}
							}
							int yy = c-1;
							for(int i = r; i <= r+d1-1; i++) {
								for(int j = 1; j <= yy; j++) {
									one += map[i][j];
									visited[i][j] = 1;
								}
								yy--;
							}
							
//							for(int[] a : visited)
//								System.out.println(Arrays.toString(a));
//							System.out.println();
//							
							// 2의 개수
							int two = 0;
							for(int i = 1; i <= r-1;  i++) {
								for(int  j = c+1; j <= N; j++) {
									two += map[i][j];
									visited[i][j] = 2;
								}
							}
							
							yy = c+1;
							
							for(int i = r; i <= r+d2; i++) {
								for(int j = yy; j <= N; j++) {
									
									two += map[i][j];
									visited[i][j] = 2;
								}
								yy++;
							}
							
////							for(boolean[] a : visited)
////								System.out.println(Arrays.toString(a));
////							System.out.println();
//							
							// 3의 개수
							int three = 0;
							for(int i = r+d1+d2+1; i <= N; i++) {
								for(int j = 1; j <= c-d1+d2-1; j++) {
									three+= map[i][j];
									visited[i][j] = 3;
								}
							}
							
							yy = c-d1-1;
							for(int i = r+d1; i <= r+d1+d2; i++) {
								for(int j = 1; j <= yy; j++) {
									three += map[i][j];
									visited[i][j] = 3;
								}
								yy++;
							}
							
//							for(boolean[] a : visited)
//								System.out.println(Arrays.toString(a));
//							System.out.println();
							
							// 4의 개수
							int four = 0;
							for(int i = r+d1+d2+1; i <= N; i++) {
								for(int j = c-d1+d2; j <= N; j++) {
									four += map[i][j];
									visited[i][j] = 4;
								}
							}
							
							yy = c+d2;

							for(int i = r + d2 + 1; i <= r+d1+d2; i++) {
								for(int j = yy; j <= N; j++) {
									four += map[i][j];
									visited[i][j] = 4;
								}
								yy--;
							}
							
//							for(boolean[] a : visited)
//								System.out.println(Arrays.toString(a));
//							System.out.println();
							
							// 5의 개수
							int  five = 0;
							for(int i = 1; i <= N; i++) {
								for(int j = 1; j <= N; j++) {
									if(visited[i][j] == 0) {
										five += map[i][j];
									}
								}
							}
							
							List<Integer> list = new ArrayList<>();
							list.add(one);
							list.add(two);
							list.add(three);
							list.add(four);
							list.add(five);
							Collections.sort(list);
							int min = list.get(0);
							int max = list.get(4);
							if(list.get(0) != 0)
								answer = Math.min(answer, max - min);
							
						}
						
						
					}
				}
			}
		}
		System.out.println(answer);
	}
	static boolean isIn(int n) {
		if(n >= 1 && n <= N)
			return true;
		else
			return false;
	}
}
