import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1592_영식이와친구들 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N];
        int cnt=0;
        int index=0;
        while(true) {
            arr[index]++;
            if(arr[index] == M)
                break;
            
            if(arr[index]%2 == 0) { // 공 받은 횟수 짝수번이면
                if(index + L >= N) { // 사람 수 초과하면 
                    index = L-N+index; // 인덱스 변경
                }else {
                    index+=L; // 반시계방향으로 L번째 있는 사람에게
                }
            }else if(arr[index]%2 ==1){ // 공 받은 횟수 홀수번이면
                if(index-L<0) {
                    index = N-L+index;
                }else
                    index-=L; // 시계방향으로 L번째 이쓴 사람에게
            }
            cnt++;
        }
        System.out.println(cnt);
	}
}
