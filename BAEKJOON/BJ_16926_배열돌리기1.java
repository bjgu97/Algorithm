/**
* @since 2021. 2. 10.
* @author bjgu9
* @see
* @mem
* @time
* @caution
*
*  꼭 다시 풀어보기.... 도움 없이. 
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16926_배열돌리기1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, R;
    static int[][] map;
    static int[][] deltas = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } }; // 우 하 좌 상 (시계방향)
    //static int[][] deltas2 = {  { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }; // 
    
    static int T;
    
    static int nr, nc;
    static int tmp;
    
    public static void main(String[] args) throws IOException {

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M]; 
        
        T = Math.min(N, M)/2; // 2번 반복?
        // map 입력받기
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        rotate();

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
//        //map 출력하기
//        for(int i = 0;i < N; i++) {
//        	for(int j = 0; j < M; j++) {
//        		System.out.print(map[i][j] + " ");
//        	}
//        	System.out.println();
//        }
    }


    public static void rotate() {
    	for(int t = 0; t < T; t++) { // T번 반복(바깥 , 안)
    		
    		int r = t, c = t; // t=0이 바깥인 경우( (0,0) )
            for(int rr = 0; rr < R; rr++){ // R번 회전
                tmp = map[t][t]; // 첫번째 값 저장 1

	            for (int d = 0; d < 4; d++) { // 4가지 방향으로 회전
	            	while(true) { // 각 방향 끝 도착할떄까지 반복
		                nr = r + deltas[d][0]; // 0 -> 0
		                nc = c + deltas[d][1]; // 0 -> 1
		                // (r,c) = (0,0) / (nr, nc) = (0,1)
		                
		                //System.out.println("nr: " + nr + ", nc: " + nc);
		                if(!(t <= nr && t <= nc && nr < N-t && nc < M-t))
		                	break;
		                
	                    // 값 이동
		                System.out.println("r: " + r + ", c: " + c);
		                System.out.println("nr: " + nr + ", nc: " + nc);
	                    //map[r][c] = map[nr][nc];
		                map[nr][nc] = map[r][c];
	                    // 좌표 이동
	                    r = nr; 
	                    c = nc;
	            	}

	            }
            	map[t+1][t] = tmp; // (2,0) 위치에 (1,0) 값 대입


            }
        	 
        }
       
    }


}
