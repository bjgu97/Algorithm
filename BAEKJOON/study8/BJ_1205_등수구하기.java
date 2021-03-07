package study8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1205_등수구하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 주어진 점수
		BigInteger S = BigInteger.valueOf(Long.parseLong(st.nextToken())); // 새 점수
		BigInteger P = BigInteger.valueOf(Long.parseLong(st.nextToken())); // 랭킹 리스트에 올라갈 수 있는 점수의 개수
		
		st = new StringTokenizer(br.readLine());
		List<BigInteger> list = new LinkedList<BigInteger>();
		for(int n = 0; n < N; n++) {
			list.add(BigInteger.valueOf(Long.parseLong(st.nextToken())));
		}
		
		for(int n = 0; n < N; n++) {
			if(S.compareTo(list.get(n)) == -1) { // list.get(n) > S
				if(list.get(n).equals(S) && S == P) {
					boolean flag = true;
					
					for(int t = n+1; n < N; n++) {
						if(list.get(t).compareTo(list.get(n)) == -1) {
							flag = false;
							break;
						}
					}
				}
				
				if(flag) {
					System.out.println(-1);
					return;
				}
				
			}
		}
			
	}
}


/*


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int N = Integer.parseInt(sc.next());
        int X = Integer.parseInt(sc.next());
        int P = Integer.parseInt(sc.next());
        
        int[] rankList = new int[P];
        
        for(int i=0; i<N; i++) {
            rankList[i] = Integer.parseInt(sc.next());
        }
        
        // 애초에 랭킹 리스트에 점수가 없었던 경우
        if(N == 0) {
            System.out.println("1");
            return;
        }
        
        for(int i=0; i<N; i++) {
               if (rankList[i] <= X) {
                
      
                if(rankList[i] == X && N == P) {
                    
                    boolean flag = true;
                 
                    for(int temp = i+1; temp < N; temp++) {
                        if(rankList[i] > rankList[temp]) {
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag) { // Test Case 2번 같은 경우도 이에 해당된다.
                        System.out.println("-1");
                        return;
                    }
                    
                }
                System.out.println(i+1);
                return;
            }
            
        }
        // 꽉찬 리스트가 아닌 기존 리스트에 (중간)진입하지 못한 경우
        // 맨 마지막 랭킹 점수가 된다.
        if(N < P) {
            System.out.println(N+1);
            return;
        }
        // 그 외의 경우는 어떤 이유든 랭킹 진입에 실패한 경우
        System.out.println("-1");
    }

*/